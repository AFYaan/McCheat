package net.minecraft.afyaan.modules;

import org.lwjgl.input.Keyboard;

import net.minecraft.afyaan.modulebase.EnumMouleType;
import net.minecraft.afyaan.modulebase.Module;

public class AutoMine extends Module{
	public AutoMine(){
		super("AutoMine", Keyboard.KEY_K, EnumMouleType.PLAYER);
	}
	
	public void onTick(){
		if((isEnabled()) && (mc.gameSettings != null) && (mc.thePlayer != null)){
			mc.gameSettings.keyBindAttack.pressed = true;
		}
	}
	
	public void onDisable(){
		mc.gameSettings.keyBindAttack.pressed = false;
	}
}
