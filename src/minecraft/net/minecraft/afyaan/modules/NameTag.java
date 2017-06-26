package net.minecraft.afyaan.modules;

import org.lwjgl.input.Keyboard;

import net.minecraft.afyaan.modulebase.EnumMouleType;
import net.minecraft.afyaan.modulebase.Module;

public class NameTag extends Module{

	public NameTag(){
		super("Name tag", Keyboard.KEY_P, EnumMouleType.RENDER);
	}
	
}
