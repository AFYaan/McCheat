package net.minecraft.afyaan.clickgui.windows;

import net.minecraft.afyaan.McCheatClient;
import net.minecraft.afyaan.clickgui.Window;
import net.minecraft.afyaan.modulebase.EnumMouleType;
import net.minecraft.afyaan.modulebase.Module;

public class WindowMovement extends Window{
	public WindowMovement(){
		super("Movement", 2, 38);
	}
	
	public Window init(){
		for(Module m : McCheatClient.getModuleManager().moduleList){
			if(m.getModuleType() == EnumMouleType.MOVEMENT){
				addButton(m);
			}
		}
		return this;
	}
}
