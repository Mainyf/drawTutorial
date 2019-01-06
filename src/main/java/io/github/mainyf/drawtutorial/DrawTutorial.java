package io.github.mainyf.drawtutorial;

import io.github.mainyf.drawtutorial.client.gui.GuiDemoScreen;
import io.github.mainyf.drawtutorial.utils.Reference;
import net.minecraft.client.gui.GuiMainMenu;
import net.minecraftforge.client.event.GuiOpenEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod(modid = Reference.MODID, name = Reference.NAME, version = Reference.VERSION)
public class DrawTutorial {

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        MinecraftForge.EVENT_BUS.register(this);
    }

    @SubscribeEvent
    public void onOpenGui(GuiOpenEvent event) {
        if(event.getGui() instanceof GuiMainMenu) {
            event.setGui(new GuiDemoScreen());
        }
    }
}