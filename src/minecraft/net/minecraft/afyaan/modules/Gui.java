package net.minecraft.afyaan.modules;

import java.awt.Dialog.ModalityType;

import org.lwjgl.input.Keyboard;

import net.minecraft.afyaan.McCheatClient;
import net.minecraft.afyaan.modulebase.EnumMouleType;
import net.minecraft.afyaan.modulebase.Module;

public class Gui extends Module{
	public Gui(){
		super("Gui", Keyboard.KEY_GRAVE, EnumMouleType.NONE);
	}

	@Override
	public void onToggle() {
		mc.displayGuiScreen(McCheatClient.getGui());
	}
	
	
}
