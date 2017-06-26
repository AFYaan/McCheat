package net.minecraft.afyaan.clickgui.windows;

import net.minecraft.afyaan.McCheatClient;
import net.minecraft.afyaan.clickgui.Window;
import net.minecraft.afyaan.modulebase.EnumMouleType;
import net.minecraft.afyaan.modulebase.Module;

public class WindowPlayer extends Window{
	
	public WindowPlayer(){
		super("Player", 2, 2);
	}
	
	public Window init(){
		for(Module m : McCheatClient.getModuleManager().moduleList){
			if(m.getModuleType() == EnumMouleType.PLAYER){
				addButton(m);
			}
		}
		return this;
	}
}
