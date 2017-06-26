package net.minecraft.afyaan.clickgui.windows;

import net.minecraft.afyaan.McCheatClient;
import net.minecraft.afyaan.clickgui.Window;
import net.minecraft.afyaan.modulebase.EnumMouleType;
import net.minecraft.afyaan.modulebase.Module;

public class WindowRender extends Window{
	public WindowRender(){
		super("Render", 2, 14);
	}
	
	public Window init(){
		for(Module m : McCheatClient.getModuleManager().moduleList){
			if(m.getModuleType() == EnumMouleType.RENDER){
				addButton(m);
			}
		}
		return this;
	}
}
