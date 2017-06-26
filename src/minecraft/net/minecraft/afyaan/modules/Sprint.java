package net.minecraft.afyaan.modules;

import org.lwjgl.input.Keyboard;

import net.minecraft.afyaan.modulebase.EnumMouleType;
import net.minecraft.afyaan.modulebase.Module;

public class Sprint extends Module{
	
	public Sprint(){
		super("Sprint", Keyboard.KEY_C, EnumMouleType.MOVEMENT);
	}
	
	public void onTick(){
		if((isEnabled()) && (!this.mc.thePlayer.isCollidedHorizontally) && (this.mc.thePlayer.moveForward != 0.0F)){
			this.mc.thePlayer.setSprinting(true);
		}
	}
	
	public void onDisable(){
		mc.thePlayer.setSprinting(false);
	}

}
