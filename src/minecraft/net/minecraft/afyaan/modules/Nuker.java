package net.minecraft.afyaan.modules;

import org.lwjgl.input.Keyboard;

import net.minecraft.afyaan.modulebase.EnumMouleType;
import net.minecraft.afyaan.modulebase.Module;
import net.minecraft.block.Block;
import net.minecraft.network.play.client.C07PacketPlayerDigging;

public class Nuker extends Module{

	public Nuker(){
		super("Nuker", Keyboard.KEY_Y, EnumMouleType.PLAYER);
	}

	@Override
	public void preMotionUpdate() {
		if(!isEnabled()){
			return;
		}
		int distance = 5;
		//System.out.println("s");
		for(int y = (int) 3; y>=(int) -3; y--){
			for(int z = (int) -distance; z<= (int) distance; z++){
				for(int x = (int) -distance; x <= (int) distance; x++){
					int xPos = (int)Math.floor(mc.thePlayer.posX + x);
					int yPos = (int)Math.floor(mc.thePlayer.posY + y);
					int zPos = (int)Math.floor(mc.thePlayer.posZ + z);
					//Block block = mc.theWorld.getBlock(xPos, yPos, zPos);
					
					mc.thePlayer.sendQueue.addToSendQueue(new C07PacketPlayerDigging(0, xPos, yPos, zPos, 1));
					if(!mc.thePlayer.capabilities.isCreativeMode){
						mc.thePlayer.sendQueue.addToSendQueue(new C07PacketPlayerDigging(2, xPos, yPos, zPos, 1));
					}
				}
			}
		}
		
	}
	
	
	
}
