package net.minecraft.afyaan.modules;

import org.lwjgl.input.Keyboard;

import net.minecraft.afyaan.modulebase.EnumMouleType;
import net.minecraft.afyaan.modulebase.Module;

public class MniejszyKnockBack extends Module{

	public MniejszyKnockBack() {
		super("Velocity", Keyboard.KEY_N, EnumMouleType.MOVEMENT);
	}

}
