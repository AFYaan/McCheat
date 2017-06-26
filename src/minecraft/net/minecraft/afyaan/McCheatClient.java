package net.minecraft.afyaan;

import net.minecraft.afyaan.clickgui.GuiClick;
import net.minecraft.afyaan.modulebase.MethodInvoker;
import net.minecraft.afyaan.modulebase.Module;
import net.minecraft.afyaan.modulebase.ModuleManager;
import net.minecraft.afyaan.modulebase.Wrapper;
import net.minecraft.afyaan.utils.FriendsUtils;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;

public class McCheatClient {
	public static String userattack = null;
	public static Entity userattackEntity;
	public static Minecraft mc = Minecraft.getMinecraft();
	public static McCheatClient instance = null;
	private static Wrapper wrapper = null;
	private MethodInvoker invoker = null;
	private String block = "";
	private static ModuleManager modulemanager;
	private static GuiClick guiclick;
	
	public static McCheatClient getInstance(){
		if(instance == null){
			instance = new McCheatClient();
		}
		return instance;
	}
	
	public MethodInvoker getInvoker(){
		if(this.invoker == null){
			this.invoker = new MethodInvoker();
		}
		return this.invoker;
	}
	
	public Wrapper getWrapper(){
		if(this.wrapper == null){
			this.wrapper = new Wrapper();
		}
		return this.wrapper;
	}
	
	public static String getClientName(){
		return "McCheat 1.7.10 Nick: " + wrapper.getSession().getUsername() + " ";
	}
	
	public static ModuleManager getModuleManager(){
		return modulemanager;
	}
	
	public static void startUp(){
		try{
			int color = 0;
			for(Module m : ModuleManager.moduleList){
				m.color = color;
				color += 2f;
			}
			FriendsUtils.Update();
			modulemanager = new ModuleManager();
			guiclick = new GuiClick();
		}catch(Exception ex){}
		
	}
	
	public static GuiClick getGui(){
		if(guiclick == null) guiclick = new GuiClick();
		return guiclick;
	}
	
	public static Minecraft getMinecraft(){
		if(mc == null)mc = Minecraft.getMinecraft();
		return mc;
	}
}
