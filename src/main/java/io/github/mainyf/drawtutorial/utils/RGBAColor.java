package io.github.mainyf.drawtutorial.utils;

import java.util.Objects;

public class RGBAColor {

    private float red;

    private float green;

    private float blue;

    private float alpha;

    public RGBAColor(float red, float green, float blue, float alpha) {
        this.red = red;
        this.green = green;
        this.blue = blue;
        this.alpha = alpha;
    }

    public float getRed() {
        return red;
    }

    public void setRed(float red) {
        this.red = red;
    }

    public float getGreen() {
        return green;
    }

    public void setGreen(float green) {
        this.green = green;
    }

    public float getBlue() {
        return blue;
    }

    public void setBlue(float blue) {
        this.blue = blue;
    }

    public float getAlpha() {
        return alpha;
    }

    public void setAlpha(float alpha) {
        this.alpha = alpha;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RGBAColor rgbaColor = (RGBAColor) o;
        return Float.compare(rgbaColor.red, red) == 0 &&
            Float.compare(rgbaColor.green, green) == 0 &&
            Float.compare(rgbaColor.blue, blue) == 0 &&
            Float.compare(rgbaColor.alpha, alpha) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(red, green, blue, alpha);
    }

    @Override
    public String toString() {
        return "RGBAColor{" +
            "red=" + red +
            ", green=" + green +
            ", blue=" + blue +
            ", alpha=" + alpha +
            '}';
    }
}
