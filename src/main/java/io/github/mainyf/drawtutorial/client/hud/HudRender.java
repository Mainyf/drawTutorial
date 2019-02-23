package io.github.mainyf.drawtutorial.client.hud;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.Gui;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.util.Iterator;


public class HudRender {

    public Minecraft mc = Minecraft.getMinecraft();

    @SubscribeEvent
    public void onRender(RenderGameOverlayEvent event) {
        if (event.getType() == RenderGameOverlayEvent.ElementType.ALL) {
            return;
        }
        drawEquipmentAndArmor(20);
        mc.renderEngine.bindTexture(Gui.ICONS);
    }

    /**
     * 绘制装备和主副手的物品以及耐久
     * @param offset 偏移量
     */
    private void drawEquipmentAndArmor(int offset) {
        FontRenderer fontRenderer = mc.fontRenderer;

        // 获得装备+主副手的可迭代对象
        Iterable<ItemStack> equipment = mc.player.getEquipmentAndArmor();

        // 获取到装备中耐久文字最长的
        //=================================================
        Iterator<ItemStack> itEq = equipment.iterator();

        int xPosition = 0;

        while (itEq.hasNext()) {
            ItemStack item = itEq.next();
            int length = fontRenderer.getStringWidth(getItemDamageText(item));
            if (length > xPosition) {
                xPosition = length;
            }
        }
        //=================================================

        Iterator<ItemStack> itEquipment = equipment.iterator();

        for (int i = 0; itEquipment.hasNext(); ) {
            ItemStack item = itEquipment.next();

            // 过滤掉空物品和空气
            if (item.getItem() != ItemStack.EMPTY.getItem() && item.getItem() != Items.AIR) {

                String damageText = getItemDamageText(item);
                int length = fontRenderer.getStringWidth(damageText);

                int itemDamage = item.getMaxDamage() - item.getItemDamage();

                // 绘制物品
                mc.getRenderItem().renderItemAndEffectIntoGUI(
                    item,
                    (xPosition - 17) / 2,
                    (i * offset) + (i * fontRenderer.FONT_HEIGHT)
                );

                int fontPositionX = (xPosition - 17) / 2 - ((length - 17) / 2);
                int fontPositionY = (int) ((i * offset) + (i * fontRenderer.FONT_HEIGHT) + 17.5);

                // 绘制剩余耐久
                fontRenderer.drawString(
                    String.valueOf(itemDamage),
                    fontPositionX,
                    fontPositionY,
                    itemDamage < 10 ? 0xFFFF0000 : 0xFFFFFFFF
                );

                // 绘制分割线和总耐久
                fontRenderer.drawString(
                    "/" + item.getMaxDamage(),
                    fontPositionX + fontRenderer.getStringWidth(String.valueOf(itemDamage)),
                    fontPositionY,
                    0xFFFFFFFF
                );

                i++;
            }
        }
    }

    private String getItemDamageText(ItemStack item) {
        int maxDamage = item.getMaxDamage();
        return (maxDamage - item.getItemDamage()) + "/" + maxDamage;
    }

}
