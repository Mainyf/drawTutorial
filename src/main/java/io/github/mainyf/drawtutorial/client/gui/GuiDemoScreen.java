package io.github.mainyf.drawtutorial.client.gui;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiLabel;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiTextField;

import java.io.IOException;

public class GuiDemoScreen extends GuiScreen {

    private GuiTextField textField;
    private int id = 0;

    @Override
    public void initGui() {
        this.buttonList.add(new GuiButton(id, 0, 0, "Test Button"));

        GuiLabel label = new GuiLabel(mc.fontRenderer, ++id, 0, 50,50, 0, 0xFFFFFF);
        label.addLine("Test line 1");
        label.addLine("Test line 2");
        label.addLine("Test line 3");
        this.labelList.add(label);

        this.textField = new GuiTextField(++id, mc.fontRenderer, 20, 100, 100, mc.fontRenderer.FONT_HEIGHT + 8);
        this.textField.setMaxStringLength(16);
    }

    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks) {
        this.textField.drawTextBox();
        super.drawScreen(mouseX, mouseY, partialTicks);
    }

    @Override
    protected void keyTyped(char typedChar, int keyCode) throws IOException {
        this.textField.textboxKeyTyped(typedChar, keyCode);
        super.keyTyped(typedChar, keyCode);
    }

    @Override
    protected void mouseClicked(int mouseX, int mouseY, int mouseButton) throws IOException {
        this.textField.mouseClicked(mouseX, mouseY, mouseButton);
        super.mouseClicked(mouseX, mouseY, mouseButton);
    }

    @Override
    protected void actionPerformed(GuiButton button) {
        if(0 == button.id) {
            System.out.println("text: " + this.textField.getText());
            System.out.println("selectedText: " + this.textField.getSelectedText());
        }
    }
}
