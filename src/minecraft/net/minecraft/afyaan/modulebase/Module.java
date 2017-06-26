
package net.minecraft.afyaan.modulebase;

import net.minecraft.afyaan.McCheatClient;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;

public class Module {
	protected Minecraft mc = McCheatClient.getMinecraft();
	private String modulename;
	private int keybind;
	private EnumMouleType moduleType;
	private boolean isEnabled;
	public float color;
	protected MethodInvoker invoker = McCheatClient.getInstance().getInvoker();
	
	public Module(String modulename, int keybind, EnumMouleType moduleType){
		this.modulename = modulename;
		this.keybind = keybind;
		this.moduleType = moduleType;
	}
	
	public void preMotionUpdate(){}
	
	public void onTick(){}
	
	public void onEnable(){}
	
	public void onDisable(){}
	
	public void onToggle(){}
	
	public void onRender(){}
	
	public void onAttackEntity(EntityPlayer entityPlayer, Entity entity){}
	
	public void onClickBlock(int i, int k, int l){}
	
	public String getModuleName(){
		return this.modulename;
	}
	
	public EnumMouleType getModuleType(){
		return this.moduleType;
	}
	
	public int getKeybind(){
		return this.keybind;
	}
	
	public boolean isEnabled(){
		return this.isEnabled;
	}
	
	public final void setState(boolean flag){
		this.isEnabled = flag;
		if(isEnabled()){
			this.onEnable();
		}else{
			this.onDisable();
		}
	}
	
	public final void toogle(){
		this.setState(!isEnabled);
		this.onToggle();
	}
}
