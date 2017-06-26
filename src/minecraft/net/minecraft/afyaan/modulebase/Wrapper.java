package net.minecraft.afyaan.modulebase;

import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityClientPlayerMP;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.multiplayer.PlayerControllerMP;
import net.minecraft.client.multiplayer.WorldClient;
import net.minecraft.client.renderer.EntityRenderer;
import net.minecraft.client.settings.GameSettings;
import net.minecraft.util.Session;

public class Wrapper {
	public Minecraft getMinecraft()
	  {
	    return Minecraft.getMinecraft();
	  }
	  
	  public FontRenderer getFontRenderer()
	  {
	    return getMinecraft().fontRenderer;
	  }
	  
	  public Session getSession()
	  {
	    return getMinecraft().session;
	  }
	  
	  public PlayerControllerMP getPlayerController()
	  {
	    return getMinecraft().playerController;
	  }
	  
	  public EntityClientPlayerMP getPlayer()
	  {
	    return getMinecraft().thePlayer;
	  }
	  
	  public WorldClient getWorld()
	  {
	    return getMinecraft().theWorld;
	  }
	  
	  public GameSettings getGameSettings()
	  {
	    return getMinecraft().gameSettings;
	  }
	  
	  public EntityRenderer getEntityRenderer()
	  {
	    return getMinecraft().entityRenderer;
	  }
}
