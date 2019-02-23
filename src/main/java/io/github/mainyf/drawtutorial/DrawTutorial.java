package io.github.mainyf.drawtutorial;

import io.github.mainyf.drawtutorial.client.hud.HudRender;
import io.github.mainyf.drawtutorial.utils.Reference;
import net.minecraftforge.client.event.GuiOpenEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod(modid = Reference.MODID, name = Reference.NAME, version = Reference.VERSION)
public class DrawTutorial {

    @Mod.EventHandler
    public void init(FMLPreInitializationEvent event) {
        MinecraftForge.EVENT_BUS.register(this);
        MinecraftForge.EVENT_BUS.register(new HudRender());
    }

    @SubscribeEvent
    public void onOpenGui(GuiOpenEvent event) {
//        if(event.getGui() instanceof GuiMainMenu) {
//            event.setGui(new GuiDemoScreen2());
//        }
    }
}