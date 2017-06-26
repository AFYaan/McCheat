package net.minecraft.afyaan.override;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.GL11;

import net.minecraft.afyaan.McCheatClient;
import net.minecraft.afyaan.clickgui.GuiClick;
import net.minecraft.afyaan.clickgui.GuiUtils;
import net.minecraft.afyaan.clickgui.Window;
import net.minecraft.afyaan.modulebase.Module;
import net.minecraft.afyaan.modulebase.ModuleManager;
import net.minecraft.afyaan.utils.ColorUtils;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityClientPlayerMP;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiIngame;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagList;

public class GuiInGameHook extends GuiIngame{
	private boolean keyStates[];
	Minecraft mc = Minecraft.getMinecraft();
	private Block block = Block.getBlockFromName("Bedrock");
	private FontRenderer fr = mc.fontRenderer;
	public static boolean gui = false;
	boolean on = false;
	public RenderItem ri = new RenderItem();
	public float col = 0.0f;
	public GuiInGameHook(Minecraft minecraft){
		super(minecraft);
		keyStates = new boolean[256];
	}
	
	public boolean checkKey(int i){
		if(on == false){
			return false;
		}
		if(mc.currentScreen != null){
			return false;
		}
		if(Keyboard.isKeyDown(i) != keyStates[i]){
			return keyStates[i] = !keyStates[i];
		}else{
			return false;
		}
	}
	
	public boolean checkKey2(int i){
		if(mc.currentScreen != null){
			return false;
		}
		if(Keyboard.isKeyDown(i) != keyStates[i]){
			return keyStates[i] = !keyStates[i];
		}else{
			return false;
		}
	}
	
	public String getTeamToString(EntityLivingBase par1){
		try{
			return par1.getTeam().getRegisteredName();
		}catch(Exception ex){}
		return "Brak";
	}
	
	public String getLastActiveItemDamage(EntityPlayer par1, int par2){
		if(par1.getLastActiveItems()[par2] != null){
			ItemStack a = par1.getLastActiveItems()[par2];
			return String.valueOf(a.getMaxDamage() - a.getItemDamage());
		 }else{
			 return "Brak";
		 }
	}
	
	public List getLoadedPlayer(){
		List<EntityPlayer> list = new ArrayList<EntityPlayer>();
		for(Object o : mc.theWorld.loadedEntityList){
			if(o instanceof EntityPlayer){
				EntityPlayer ep = (EntityPlayer)o;
				list.add(ep);
			}
		}
		return list;
	}
	
	public String getEnchantments(EntityClientPlayerMP entity){
		try{
			NBTTagList var1 = entity.getCurrentEquippedItem().getEnchantmentTagList();
			ArrayList var2 = new ArrayList();
			
			if(var1 != null){
				for(int var3 = 0; var3 < var1.tagCount(); ++var3){
					short var4 = var1.getCompoundTagAt(var3).getShort("id");
					short var5 = var1.getCompoundTagAt(var3).getShort("lvl");
					
					if(Enchantment.enchantmentsList[var4] != null){
						var2.add(Enchantment.enchantmentsList[var4].getTranslatedName(var5));
					}
				}
				return var2.toString();
			}else{
				return "BRAK";
			}
		}catch(Exception ex){
			return "BRAK";
		}
	}
	
	
	@Override
	public void renderGameOverlay(float par1, boolean par2, int par3, int par4){
		super.renderGameOverlay(par1, par2, par3, par4);
		ScaledResolution sr = new ScaledResolution(mc, mc.displayWidth, mc.displayHeight);
		//
		int color = Integer.parseInt(ColorUtils.hsvToRgb(col, 86, 100), 16);
		
		int windowWidth = sr.getScaledWidth();
		int windowHeight = sr.getScaledHeight();
		int width1 = 266;
		int height1 = 10;
		//int x1 = (windowWidth / 2) + width / 2;
		//int y1 = (windowHeight / 2) + height / 2;
		int x1 = 1 + width1;
		int y1 = 3 + height1;
		
		int width = sr.getScaledWidth();
		int height = sr.getScaledHeight();
		int number = 0;
		int number2 = 0;
		int number3 = 0;
		
		if(col >= 360){
			col = 0;
		}else{
			col += 0.09;
		}
		
		try{
			
			if(gui){
				int loadedplayers = getLoadedPlayer().size() -1;
				
				
				if(McCheatClient.userattackEntity != null){
					EntityLivingBase p = (EntityLivingBase)McCheatClient.userattackEntity;
					EntityPlayer pl = (EntityPlayer)McCheatClient.userattackEntity;
					InventoryPlayer ip = new InventoryPlayer(pl);
					
					try{
						List<String> playerList = Arrays.asList(new String[]{
								"§aPlayer info:",
								"Nick: " + pl.func_145748_c_().getFormattedText() + " | " + p.getEntityId(),
								"HP: " + (int)p.getHealth() + "/" + pl.getMaxHealth(),
								//"Food Level: " + pl.getFoodStats().getFoodLevel() + "/" + "20",
								"----------",
								"Distance: " + (int)p.getDistance(mc.thePlayer.posX, mc.thePlayer.posY, mc.thePlayer.posZ),
								"X: " + (int)pl.getPlayerCoordinates().posX,
								"Y: " + (int)pl.getPlayerCoordinates().posY,
								"Z: " + (int)pl.getPlayerCoordinates().posZ,
								"----------",
								"TAG: " + getTeamToString(p),	
								"----------",
								"Helmet: " + getLastActiveItemDamage(pl, 3),
								"Chestplate: " + getLastActiveItemDamage(pl, 2),
								"Leggings: " + getLastActiveItemDamage(pl, 1),
								"Boots: " + getLastActiveItemDamage(pl, 0),
								"----------",
								//"Score: " + pl.getScore(),
								//"UUID: " + pl.getUniqueID(), 
						});
						
						if(mc.gameSettings.player_info){
							for(String m : playerList){
								ip = new InventoryPlayer(pl);
								int y = (10 * number2);
								String reverse = new StringBuffer(m.toString()).toString();
								
								fr.drawStringWithShadow(reverse, width - fr.getStringWidth(reverse) - 1, y + 2, 0xcc0033);
								number2++;
							}
						}
						
					}catch (Exception e) {
						System.out.println(e.getMessage());
					}
				}
				EntityClientPlayerMP tp = mc.thePlayer;
				Block block = Block.getBlockFromName("Bedrock");
				
				if(Minecraft.getMinecraft().objectMouseOver != null){
					int xm = Minecraft.getMinecraft().objectMouseOver.blockX;
					int ym = Minecraft.getMinecraft().objectMouseOver.blockY;
					int zm = Minecraft.getMinecraft().objectMouseOver.blockZ;
					block = mc.thePlayer.worldObj.getBlock(xm, ym, zm);
				}
				boolean a = mc.thePlayer.onGround;
				
				Minecraft.getMinecraft().thePlayer.moveForward = 2F;
				List<String> theplayerList = Arrays.asList(new String[]{
						"§5§lThe player info",
						"Nick: " + tp.func_145748_c_().getFormattedText(),
						"HP: " + (int)tp.getHealth() + "/" + tp.getMaxHealth(),
						//"Food Level: " + tp.getFoodStats().getFoodLevel() + "/" + "20",
						//"----------",
						"CurrentItem: " + getEnchantments(tp) ,
						"----------",
						"X: " + (int)tp.getPlayerCoordinates().posX,
						"Y: " + (int)tp.getPlayerCoordinates().posY,
						"Z: " + (int)tp.getPlayerCoordinates().posZ,	
						"----------",
						"Helmet: " + getLastActiveItemDamage(tp, 3),
						"Chestplate: " + getLastActiveItemDamage(tp, 2),
						"Leggings: " + getLastActiveItemDamage(tp, 1),
						"Boots: " + getLastActiveItemDamage(tp, 0),
						"----------",
						//"Score: " + tp.getScore(),
						//"UUDI: " + tp.getUniqueID(),
						"Block: " + block.getLocalizedName(),
				});
				int tpsize = theplayerList.size() -1;
				if(mc.gameSettings.the_player_info){
					for(int i = tpsize; i >= 0; i--){
						int y = height - (10 * number3);
						String reverse = new StringBuffer("§f" + theplayerList.get(i).toString()).toString();
						fr.drawStringWithShadow(reverse, width - fr.getStringWidth(reverse), y - 10, 0xC8FF52);
						number3++;
					}
				}
				int x = 2;
				int y = (10 * number);
				float speed = 0.7f;
				//McCheatClient.startUp();
				if(mc.gameSettings.showDebugInfo == false){
					fr.drawStringWithShadow(McCheatClient.getClientName() + "§4Loaded players: §6" + loadedplayers, 2, 2, color);
					for(Module m: McCheatClient.getModuleManager().moduleList){
						y = (10 * number);
						
						try{
							if(m.color >= 360){
								m.color = 0;
							}else{
								m.color += speed;
							}
							width1 = fr.getStringWidth(m.getModuleName()) + fr.getStringWidth(Keyboard.getKeyName(m.getKeybind())) + 16;
							x1 = (1) + width1;
							y1 += (10);
							GuiUtils.drawRect(((x1)), ((y1)), ((x1) - width1), ((y1) - height1), 0xaa33363a);
							fr.drawStringWithShadow(m.getModuleName() + " - " + Keyboard.getKeyName(m.getKeybind()), x, y + 14, m.isEnabled() ? Integer.parseInt(ColorUtils.hsvToRgb(m.color, 86, 100), 16) : 0x1099dd);
							
							
							
							number++;
						}catch (Exception ex) {}
					}
					y = (10 * (number + 1));
					
					fr.drawStringWithShadow("FPS: " + mc.debugFPS, x, y + 14, 0xff9823);
					y = (10 * (number + 3));
					fr.drawStringWithShadow("X: " + (int)mc.thePlayer.posX, x, y + 14, 0xff9823);
					y = (10 * (number + 4));
					fr.drawStringWithShadow("Y: " + (int)mc.thePlayer.posY, x, y + 14, 0xff9823);
					y = (10 * (number + 5));
					fr.drawStringWithShadow("Z: " + (int)mc.thePlayer.posZ, x, y + 14, 0xff9823);
				}
			}
			if(on){
				if(checkKey(Keyboard.KEY_UP)){
					gui = !gui;
				}
			}
			if(checkKey2(Keyboard.KEY_RIGHT)){
				on = !on;
			}
			
			for(Window w : GuiClick.windows){
				if(w.isPinned() && !(mc.currentScreen instanceof GuiClick)){
					w.draw(0, 0);
				}
			}
			for(Module m : McCheatClient.getModuleManager().moduleList){
				if(checkKey(m.getKeybind())){
					m.toogle();
				}
			}
			
			
			
		}catch(Exception ex){}
	}

	
	
	@Override
	public void renderInventorySlot(int p_73832_1_, int p_73832_2_, int p_73832_3_, float p_73832_4_) {
		super.renderInventorySlot(p_73832_1_, p_73832_2_, p_73832_3_, p_73832_4_);
		EntityClientPlayerMP tp = mc.thePlayer;
		ScaledResolution var500 = new ScaledResolution(this.mc, this.mc.displayWidth, this.mc.displayHeight);
		
		
		if(GuiInGameHook.gui){
			ScaledResolution sr = new ScaledResolution(mc, mc.displayWidth, mc.displayHeight);
        	int windowWidth = var500.getScaledWidth();
            int windowHeight = var500.getScaledHeight();

            int varM;
            int varx;
            int vary;
            
    		renderRamka(0x203f0f0f, 0x39c41159);
            for (varM = 0; varM < 4; ++varM)
            {
            	varx = windowWidth / 2 - 90 - varM * 20 + 111;
                vary = windowHeight -75;
                if(tp.getLastActiveItems()[varM] != null){
                	int width;
                	
                	ItemStack item = tp.getLastActiveItems()[varM];
                	//ri.renderItemIntoGUI(this.mc.fontRenderer, this.mc.getTextureManager(), new ItemStack(Item.getItemById(2267)), varx, vary);
                    ri.renderItemAndEffectIntoGUI(this.mc.fontRenderer, this.mc.getTextureManager(), item, varx, vary);
                    ri.renderItemOverlayIntoGUI(this.mc.fontRenderer, this.mc.getTextureManager(), item, varx, vary);
                    int color = 0x002A00;
                    String text = String.valueOf(item.getMaxDamage() - item.getItemDamage());
                    //text = "pl";
                    fr.drawStringWithShadow(text, varx, vary - 7, 0xfffffF);
                    
                }
                
            }
        }
	}
	
	private void renderRamka(int color, int ramkaColor){
		ScaledResolution sr = new ScaledResolution(mc, mc.displayWidth, mc.displayHeight);
		ScaledResolution var500 = new ScaledResolution(this.mc, this.mc.displayWidth, this.mc.displayHeight);
    	int windowWidth = var500.getScaledWidth();
        int windowHeight = var500.getScaledHeight();
		int width1 = 82;
		int height1 = 27;
		int x1;
		int y1;
		x1 = windowWidth / 2 + width1 / 2;
        y1 = windowHeight -58;
		GuiUtils.drawRect(((x1)), ((y1)), ((x1) - width1), ((y1) - height1), color);
		//right1
		width1 = 2;
        height1 = 29;   
		x1 = windowWidth / 2 + width1 / 2 + 42;
        y1 = windowHeight -57;
		
		GuiUtils.drawRect(((x1)), ((y1)), ((x1) - width1), ((y1) - height1), ramkaColor);
		//down1
		width1 = 84;
		height1 = 2;
		x1 = windowWidth / 2 + width1 / 2;
        y1 = windowHeight -56;
		
		GuiUtils.drawRect(((x1)), ((y1)), ((x1) - width1), ((y1) - height1), ramkaColor);
		//up1
		width1 = 84;
		height1 = 2;
		x1 = windowWidth / 2 + width1 / 2;
        y1 = windowHeight -85;
		
		GuiUtils.drawRect(((x1)), ((y1)), ((x1) - width1), ((y1) - height1), ramkaColor);
		//left
		width1 = 2;
		height1 = 29;
		x1 = windowWidth / 2 + width1 / 2 - 42;
        y1 = windowHeight -57;
		
		GuiUtils.drawRect(((x1)), ((y1)), ((x1) - width1), ((y1) - height1), ramkaColor);
	}
}
