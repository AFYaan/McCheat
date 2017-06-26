package net.minecraft.afyaan.clickgui;

import java.util.ArrayList;

import net.minecraft.afyaan.clickgui.windows.*;
import net.minecraft.client.gui.GuiScreen;

public class GuiClick extends GuiScreen{
	public static ArrayList<Window> windows = new ArrayList<Window>();
    public static ArrayList<Window> unFocusedWindows = new ArrayList<Window>();
   
    public Window player = new WindowPlayer().init();
    public Window render = new WindowRender().init();
    public Window movement = new WindowMovement().init();
    public Window combat = new WindowCombat().init();
    public Window misc = new WindowMisc().init();
   
    public void initGui()
    {
            player.setOpen(true);
            render.setOpen(true);
            movement.setOpen(true);
            combat.setOpen(true);
            misc.setOpen(true);
    }

    public static void sendPanelToFront(Window window)
    {
            if(windows.contains(window))
            {
                    int panelIndex = windows.indexOf(window);
                    windows.remove(panelIndex);
                    windows.add(windows.size(), window);
            }
    }
   
    public static Window getFocusedPanel()
    {
            return windows.get(windows.size() - 1);
    }
   
    public void drawScreen(int x, int y, float f)
    {
            for(Window window: windows)
            {
                    window.draw(x, y);
            }
           
    }
   
    public void mouseClicked(int x, int y, int button)
    {
            try
            {
                    for(Window window: windows)
                    {
                            window.mouseClicked(x, y, button);
                    }
            }catch(Exception e) {}
    }
   
    public void mouseMovedOrUp(int x, int y, int button)
    {
            for(Window window: windows)
            {
                    window.mouseMovedOrUp(x, y, button);
            }
    }
   
    public boolean doesGuiPauseGame()
    {
            return false;
    }
}
