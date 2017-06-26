package net.minecraft.afyaan.modulebase;

import java.util.Arrays;
import java.util.List;

import net.minecraft.afyaan.modules.*;

public class ModuleManager {
	public static List<Module> moduleList = Arrays.asList(new Module[]{
			new AutoArmour(),
			new AutoMine(),
			new BicieZ6(),
			new CentrumPvpMode(),
			new ChestESP(),
			new Gamma(),
			new Gui(),
			new MniejszyKnockBack(),
			new NameTag(),
			//new Nuker(),
			//new SpeedMine(),
			new Nuker(),
			new Sprint(),
			new Tracers(),
	});
	
	public static Module getModByClassName(String name){
		for(Module mod : moduleList){
			if(mod.getClass().getSimpleName().toLowerCase().trim().equals(name.toLowerCase().trim())){
				return mod;
			}
		}
		return null;
	}
	
	public static Module getModByName(String name){
		for(Module mod : moduleList){
			if(mod.getModuleName().trim().equalsIgnoreCase(name.trim()) || mod.toString().trim().equalsIgnoreCase(name.trim())){
				return mod;
			}
		}
		return null;
	}
	
	public static Module findMod(Class<?extends Module> clazz){
		for(Module mod : moduleList){
			if(mod.getClass() == clazz){
				return mod;
			}
		}
		return null;
	}
	
	public static Module findMod(String name){
		Module mod = getModByName(name);
		if(mod != null){
			return mod;
		}
		mod = getModByClassName(name);
		return mod;
	}
}
