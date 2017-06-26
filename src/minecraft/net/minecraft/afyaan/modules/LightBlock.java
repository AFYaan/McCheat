package net.minecraft.afyaan.modules;

import org.lwjgl.input.Keyboard;

import net.minecraft.afyaan.modulebase.EnumMouleType;
import net.minecraft.afyaan.modulebase.Module;

public class LightBlock extends Module{

	public LightBlock() {
		super("LightBlock", Keyboard.KEY_NUMPAD7, EnumMouleType.RENDER);
	}

}
