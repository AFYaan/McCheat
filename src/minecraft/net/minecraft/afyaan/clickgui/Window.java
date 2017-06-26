package net.minecraft.afyaan.clickgui;

import java.util.ArrayList;

import net.minecraft.afyaan.modulebase.Module;
import net.minecraft.client.Minecraft;

public class Window {
	private String title;
    private int xPos;
    private int yPos;
   
    private boolean isOpen;
    private boolean isExtended;
    private boolean isPinned;
   
    public int dragX;
    public int dragY;
    public int lastDragX;
    public int lastDragY;
    protected boolean dragging;
   
    public ArrayList<Button> buttons = new ArrayList<Button>();
   
    public Window(String title, int x, int y)
    {
            this.title = title;
            this.xPos = x;
            this.yPos = y;
            GuiClick.windows.add(this);
            GuiClick.unFocusedWindows.add(this);
    }
   
    public void windowDragged(int x, int y) {
            dragX = x - lastDragX;
            dragY = y - lastDragY;
    }
   
    private int buttonCount = 0, sliderCount = 0;
   
    public void addButton(Module mod) {
            buttons.add(new Button(this, mod, xPos + 2, yPos + (11 * buttons.size()) + 16));
    }
   
   
    public void draw(int x, int y)
    {
            if(isOpen)
            {
                    if(dragging)
                    {
                            windowDragged(x, y);
                    }
                   
                    if(!isExtended){
                            GuiUtils.drawBorderedRect(xPos + dragX, yPos + dragY, xPos + 62 + dragX, yPos + 12 + dragY, 0xff000000, 0x70070707);
                    }else{
                            GuiUtils.drawBorderedRect(xPos + dragX, yPos + dragY, xPos + 62 + dragX, yPos + 12 + dragY, 0xff000000, 0x70070707);
                            GuiUtils.drawBorderedRect(xPos + dragX, yPos + dragY + 14, xPos + 90 + dragX, yPos + (11 * buttons.size() + 17) + dragY, 0.5F, 0xff000000, 0x50000000);
                    }
                   
                    Minecraft.getMinecraft().fontRenderer.drawString(title, xPos + 2 + dragX, yPos + dragY + 3, 0xFFFFFFFF);
                   
                    GuiUtils.drawBorderedRect(xPos + 64 + dragX, yPos + dragY, xPos + 76 + dragX, yPos + 12 + dragY, isPinned ? 0xFF000000 : 0xFF000000, isPinned ? 0xC8070707 : 0x70070707);
                    GuiUtils.drawBorderedRect(xPos + 78 + dragX, yPos + dragY, xPos + 90 + dragX, yPos + 12 + dragY, isExtended ? 0xFF000000 : 0xFF000000, isExtended ? 0xC8070707 : 0x70070707);
                   
                    if(isExtended)
                    {
                            for(Button button: buttons)
                            {
                                    button.draw();
                                    if(x >= button.getX() + dragX && y >= button.getY() + 1 + dragY && x <= button.getX() + 23 + dragX + 63 && y <= button.getY() + 10 + dragY)
                                    {
                                            button.isOverButton = true;
                                    }else
                                    {
                                            button.isOverButton = false;
                                    }
                            }
                    }
            }
    }
   
    public void mouseClicked(int x, int y, int button)
    {
            for(Button xButton: buttons)
            {
                    xButton.mouseClicked(x, y, button);
            }
            //GuiUtils.drawBorderedRect(xPos + 64 + dragX, yPos + dragY, xPos + 76 + dragX, yPos + 12 + dragY, isPinned ? 0xFF000000 : 0xFF000000, isPinned ? 0xC8070707 : 0x70070707);
            //GuiUtils.drawBorderedRect(xPos + 78 + dragX, yPos + dragY, xPos + 90 + dragX, yPos + 12 + dragY, isExtended ? 0xFF000000 : 0xFF000000, isExtended ? 0xC8070707 : 0x70070707);
           
            if(x >= xPos + 78 + dragX && y >= yPos + dragY && x <= xPos + 90 + dragX && y <= yPos + 12 + dragY)
            {
                    //Minecraft.getMinecraft().sndManager.playSoundFX("random.click", 1.0F, 1.0F);
                    isExtended = !isExtended;
            }
            if(x >= xPos + 64 + dragX && y >= yPos + dragY && x <= xPos + 76 + dragX && y <= yPos + 12 + dragY)
            {
                    //Minecraft.getMinecraft().sndManager.playSoundFX("random.click", 1.0F, 1.0F);
                    isPinned = !isPinned;
            }
            if(x >= xPos + dragX && y >= yPos + dragY && x <= xPos + 69 + dragX && y <= yPos + 12 + dragY)
            {
                    GuiClick.sendPanelToFront(this);
                    dragging = true;
                    lastDragX = x - dragX;
                    lastDragY = y - dragY;
            }
    }
   
    public void mouseMovedOrUp(int x, int y, int b)
    {
            if(b == 0) {
                    dragging = false;
            }
    }
   
    public final String getTitle()
    {
            return this.title;
    }
   
    public final int getX()
    {
            return this.xPos;
    }
   
    public final int getY()
    {
            return this.yPos;
    }
   
    public boolean isExtended()
    {
            return isExtended;
    }
   
    public boolean isOpen()
    {
            return isOpen;
    }
   
    public boolean isPinned()
    {
            return isPinned;
    }
   
    public void setOpen(boolean flag)
    {
            this.isOpen = flag;
    }
   
    public void setExtended(boolean flag)
    {
            this.isExtended = flag;
    }
   
    public void setPinned(boolean flag)
    {
            this.isPinned = flag;
    }
}
