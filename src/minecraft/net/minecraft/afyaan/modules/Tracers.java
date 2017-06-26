package net.minecraft.afyaan.modules;

import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.GL11;

import net.minecraft.afyaan.modulebase.EnumMouleType;
import net.minecraft.afyaan.modulebase.Module;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;

public class Tracers extends Module{

	public Tracers(){
		super("Tracers", Keyboard.KEY_B, EnumMouleType.RENDER);
	}
	
	@Override
	public void onRender(){
		if(isEnabled()){
			renderTracers();
		}
	}
	
	public void renderTracers(){
		try{
			GL11.glPushMatrix();
			GL11.glEnable(GL11.GL_LINE_SMOOTH);
            GL11.glDisable(GL11.GL_DEPTH_TEST);
            GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
            GL11.glDisable(GL11.GL_TEXTURE_2D);
            GL11.glDepthMask(false);
            GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
            GL11.glEnable(GL11.GL_BLEND);
            GL11.glLineWidth(1.5F);
			for(Object entities : mc.theWorld.loadedEntityList){
				if(entities != mc.thePlayer && entities != null){
					if((entities instanceof EntityPlayer)){
						Entity entity = (Entity)entities;
						float distance = mc.renderViewEntity.getDistanceToEntity(entity);
						double posX = ((entity.lastTickPosX + (entity.posX - entity.lastTickPosX) - RenderManager.instance.renderPosX));
						double posY = ((entity.lastTickPosY + 1.4 + (entity.posY - entity.lastTickPosY) - RenderManager.instance.renderPosY));
						double posZ = ((entity.lastTickPosZ + (entity.posZ - entity.lastTickPosZ) - RenderManager.instance.renderPosZ));
						int dis = (int)entity.getDistance(mc.thePlayer.posX, mc.thePlayer.posY, mc.thePlayer.posZ);
						
						if(dis > 0){
							GL11.glColor3d(0.72941176, 0.00392157, 0.00392157);
						}
						if(dis > 15){
							GL11.glColor3d(0.9372549, 0.24705882, 0.0);
						}
						if(dis > 25){
							GL11.glColor3d(1.0, 0.75294118, 0.35686275);
						}
						if(dis > 35){
							GL11.glColor3d(0.96078431, 0.97647059, 0.22745098);
						}
						if(dis > 50){
							GL11.glColor3d(0.6, 0.97647059, 0.22745098);
						}
						if(dis > 60){
							GL11.glColor3d(0.76078431, 0.97647059, 0.22745098);
						}
						
						//DO NAPRAWY
						/*EntityLivingBase elb = (EntityLivingBase)entity;
				    	String nick = elb.func_145748_c_().getFormattedText().replaceAll("§r", "");
				    	if(ModuleManager.findMod(NameTag.class).isEnabled()){
				    		if(FriendsUtils.friendsList.size() > 0){
				    			for(FriendUser fu : FriendsUtils.friendsList){
				    				if(nick.equalsIgnoreCase(fu.nick) == true){
				    					GL11.glColor3f(0.0F, 67.0F, 1.0F);
										
										
										GL11.glBegin(GL11.GL_LINE_LOOP);
										GL11.glVertex3d(0, 0, 0);
										GL11.glVertex3d(posX, posY, posZ);
										GL11.glEnd();
				    				}else{
				    					GL11.glColor3f(0.5F, 0.0F, 1.0F);
										
										
										GL11.glBegin(GL11.GL_LINE_LOOP);
										GL11.glVertex3d(0, 0, 0);
										GL11.glVertex3d(posX, posY, posZ);
										GL11.glEnd();
				    				}
				        		}
				    			
				    		}else{
				    			
				    		}
				    	}else{
				    		
				    	}*/
						
						
						GL11.glBegin(GL11.GL_LINE_LOOP);
						GL11.glVertex3d(0, 0, 0);
						GL11.glVertex3d(posX, posY, posZ);
						GL11.glEnd();
					}
				}
			}
			GL11.glDisable(GL11.GL_BLEND);
            GL11.glDepthMask(true);
            GL11.glEnable(GL11.GL_TEXTURE_2D);
            GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
            GL11.glEnable(GL11.GL_DEPTH_TEST);
            GL11.glDisable(GL11.GL_LINE_SMOOTH);
            
            GL11.glPopMatrix();
		}catch (Exception e) {}
	}

}
