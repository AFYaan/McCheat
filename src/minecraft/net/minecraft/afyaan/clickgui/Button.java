package net.minecraft.afyaan.clickgui;

import org.lwjgl.input.Mouse;

import net.minecraft.afyaan.modulebase.Module;
import net.minecraft.client.Minecraft;

public class Button {
	private Window window;
    private Module mod;
    private int xPos;
    private int yPos;
   
    public boolean isOverButton;
   
    public Button(Window window, Module mod, int xPos, int yPos) {
            this.window = window;
            this.mod = mod;
            this.xPos = xPos;
            this.yPos = yPos;
    }
   
    public void draw() {
            GuiUtils.drawGradientBorderedRect(getX() + 0.5 + window.dragX, getY() + 0.5 + window.dragY, getX() + 22 + window.dragX + 63, getY() + 9.5 + window.dragY, 0.5F, 0xff000000, mod.isEnabled() ? 0xff0a72b9 : 0xff2b2c2b, mod.isEnabled() ? 0xff0a0fb8 : 0xff090b09);
            if(Mouse.isButtonDown(0) && isOverButton) {
                    GuiUtils.drawGradientBorderedRect(getX() + 0.5 + window.dragX, getY() + 0.5 + window.dragY, getX() + 22 + window.dragX + 63, getY() + 9.5 + window.dragY, 0.5F, mod.isEnabled() ? 0xFF3073D6 : 0xFF666666, mod.isEnabled() ? 0xFF4488FF : 0xFF666666, mod.isEnabled() ? 0xFF0044FF : 0xFF444444);
            }
           
            if(isOverButton){
                    GuiUtils.drawGradientBorderedRect(getX() + 0.5 + window.dragX, getY() + 0.5 + window.dragY, getX() + 22 + window.dragX + 63, getY() + 9.5 + window.dragY, 0.5F, mod.isEnabled() ? 0xFF3073D6 : 0xFF666666, mod.isEnabled() ? 0xFF4488FF : 0xFF666666, mod.isEnabled() ? 0xFF0044FF : 0xFF444444);
            }
            Minecraft.getMinecraft().fontRenderer.drawString(mod.getModuleName(), ((getX() + window.dragX)-(getX() + 85 + window.dragX) - Minecraft.getMinecraft().fontRenderer.getStringWidth(mod.getModuleName()) / 2) + 127 + getX() + window.dragX, getY() + 2 + window.dragY, mod.isEnabled() ? 0xFFFFFF : 0xDDDDDD);
    }
   
    public void mouseClicked(int x, int y, int button) {
            if(x >= getX() + window.dragX && y >= getY() + window.dragY && x <= getX() + 22 + window.dragX + 63 && y <= getY() + 9 + window.dragY && button == 0 && window.isOpen() && window.isExtended()) {
                    GuiClick.sendPanelToFront(window);
                    //Minecraft.getMinecraft().sndManager.playSoundFX("random.click", 1.0F, 1.0F);;
                    mod.toogle();
            }
    }

    public int getX() {
            return xPos;
    }

    public int getY() {
            return yPos;
    }
}
