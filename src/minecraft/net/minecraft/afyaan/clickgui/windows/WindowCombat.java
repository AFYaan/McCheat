package net.minecraft.afyaan.clickgui.windows;

import net.minecraft.afyaan.McCheatClient;
import net.minecraft.afyaan.clickgui.Window;
import net.minecraft.afyaan.modulebase.EnumMouleType;
import net.minecraft.afyaan.modulebase.Module;

public class WindowCombat extends Window{

	public WindowCombat(){
		super("Combat", 2, 26);
	}
	
	public Window init(){
		for(Module m : McCheatClient.getModuleManager().moduleList){
			if(m.getModuleType() == EnumMouleType.COMBAT){
				addButton(m);
			}
		}
		return this;
	}
	
}
