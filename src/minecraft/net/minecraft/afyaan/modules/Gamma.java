package net.minecraft.afyaan.modules;

import org.lwjgl.input.Keyboard;

import net.minecraft.afyaan.modulebase.EnumMouleType;
import net.minecraft.afyaan.modulebase.Module;

public class Gamma extends Module{

	public Gamma() {
		super("Gamma", Keyboard.KEY_G, EnumMouleType.RENDER);
	}
	
	@Override
	public void onEnable(){
		mc.gameSettings.gammaSetting = 10;
	}
	
	@Override
	public void onDisable(){
		mc.gameSettings.gammaSetting = 0;
	}

}
