package net.minecraft.afyaan.utils;

import net.minecraft.entity.EntityLivingBase;

public class FriendUser {
	public String nick = "";
	
	public FriendUser(EntityLivingBase elb){
		this.nick = elb.func_145748_c_().getFormattedText();
	}
	
	public FriendUser(String name){
		this.nick = name;
	}
}
