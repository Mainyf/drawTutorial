package io.github.mainyf.drawtutorial.client.gui;

import io.github.mainyf.drawtutorial.utils.Reference;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.util.ResourceLocation;

import java.io.IOException;

public class GuiDemoScreen2 extends GuiScreen {

    private static final ResourceLocation PLACEHOLDER_TEXTURES = new ResourceLocation(Reference.MODID, "textures/gui/placeholder_image.png");
    private static final ResourceLocation PLACEHOLDER_CUSTOM_TEXTURES = new ResourceLocation(Reference.MODID, "textures/gui/placeholder_image_custom.png");

    private GuiInput guiInput;

    @Override
    public void initGui() {
//        this.guiInput = new GuiInput(0, fontRenderer, 30, 30);
    }

    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks) {
//        mc.renderEngine.bindTexture(PLACEHOLDER_TEXTURES);

//        mc.renderEngine.bindTexture(PLACEHOLDER_CUSTOM_TEXTURES);

//        drawTexturedModalRect(0, 0, 0, 0, 256, 256);



//        drawScaledCustomSizeModalRect(0, 0, 0, 0, 1000, 1000, 100, 100, 1000, 1000);

        super.drawScreen(mouseX, mouseY, partialTicks);
//        OpenGLHelper.color(0xFFFFFF);
//        this.guiInput.drawComponent();
    }

    @Override
    protected void keyTyped(char typedChar, int keyCode) throws IOException {
//        System.out.println(typedChar);
//        System.out.println(keyCode);
//        guiInput.handleKeyboardInput(typedChar, keyCode);
        super.keyTyped(typedChar, keyCode);
    }
}
