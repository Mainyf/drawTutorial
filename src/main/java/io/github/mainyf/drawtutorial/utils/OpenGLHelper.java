package io.github.mainyf.drawtutorial.utils;

import net.minecraft.client.renderer.GlStateManager;

public class OpenGLHelper {

    public static void color(int color) {
        RGBAColor rgbaColor = toRGBAColor(color);
        GlStateManager.color(rgbaColor.getRed(), rgbaColor.getGreen(), rgbaColor.getBlue(), rgbaColor.getAlpha());
    }

    public static RGBAColor toRGBAColor(int color) {
        return new RGBAColor(
            (float)(color >> 16 & 255) / 255.0F,
            (float)(color >> 8 & 255) / 255.0F,
            (float)(color & 255) / 255.0F,
            (float)(color >> 24 & 255) / 255.0F
        );
    }

}
