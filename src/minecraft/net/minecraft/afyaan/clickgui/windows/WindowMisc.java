package net.minecraft.afyaan.clickgui.windows;

import net.minecraft.afyaan.McCheatClient;
import net.minecraft.afyaan.clickgui.Window;
import net.minecraft.afyaan.modulebase.EnumMouleType;
import net.minecraft.afyaan.modulebase.Module;

public class WindowMisc extends Window{

	public WindowMisc(){
		super("Misc", 2, 50);
	}
	
	public Window init(){
		for(Module m : McCheatClient.getModuleManager().moduleList){
			if(m.getModuleType() == EnumMouleType.MISC){
				addButton(m);
			}
		}
		return this;
	}
}
