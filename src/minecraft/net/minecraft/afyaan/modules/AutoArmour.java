package net.minecraft.afyaan.modules;

import org.lwjgl.input.Keyboard;

import net.minecraft.afyaan.McCheatClient;
import net.minecraft.afyaan.modulebase.EnumMouleType;
import net.minecraft.afyaan.modulebase.MethodInvoker;
import net.minecraft.afyaan.modulebase.Module;
import net.minecraft.afyaan.modulebase.Timer;
import net.minecraft.afyaan.utils.InventoryUtils;

public class AutoArmour extends Module{

	public AutoArmour() {
		super("AutoArmor", Keyboard.KEY_NUMPAD1, EnumMouleType.PLAYER);	
	}
	
	int[] ids = { 298, 299, 300, 301, 314, 315, 316, 317, 302, 303, 304, 305, 306, 307, 308, 309, 310, 311, 312, 313 };
	int[] bootIds = { 313, 309, 305, 317, 301 };
	int[] pantIds = { 312, 308, 304, 316, 300 };
	int[] chestIds = { 311, 307, 303, 315, 299 };
	int[] helmIds = { 310, 306, 302, 314, 298 };
	private int prevSlot = -1;
	private Timer timer = new Timer();
	protected MethodInvoker invoker = McCheatClient.getInstance().getInvoker();
	private InventoryUtils utils = new InventoryUtils();
	
	public void onTick(){
		if(!isEnabled()){
			return;
		}
		
		if(!this.timer.hasTimePassed(170L)){
			return;
		}
		
		this.timer.reset();
		if(this.prevSlot != -1){
			this.invoker.setInvSlot(this.prevSlot);
			this.prevSlot = -1;
		}
		boolean boots = true;
		boolean pants = true;
		boolean shirt = true;
		boolean helm = true;
		for(int i = 0; i < this.invoker.getArmourInventory().length; i++){
			if((i == 0) && (this.invoker.getArmourInventory()[i] == null)){
				boots = false;
			}
			if((i == 1) && (this.invoker.getArmourInventory()[i] == null)){
				pants = false;
			}
			if((i == 2) && (this.invoker.getArmourInventory()[i] == null)){
				shirt = false;
			}
			if((i == 3) && (this.invoker.getArmourInventory()[i] == null)){
				helm = false;
			}
		}
		
		int[] arrayOfInt;
		int j;
		int i;
		if (!boots)
	    {
	      boolean hot = false;
	      boolean inv = false;
	      
	      int slot = -1;
	      j = (arrayOfInt = this.bootIds).length;
	      for (i = 0; i < j; i++)
	      {
	        int id = arrayOfInt[i];
	        int invSlot = this.utils.getSlotOfInvItem(id);
	        if (invSlot != -1)
	        {
	          inv = true;
	          slot = invSlot;
	          break;
	        }
	        int newSlot = this.utils.getSlotOfHotbarItem(id);
	        if (newSlot != -1)
	        {
	          hot = true;
	          slot = newSlot;
	          break;
	        }
	      }
	      if ((slot != -1) && (inv))
	      {
	        this.utils.click(slot, 1);
	      }
	      else if ((slot != -1) && (hot))
	      {
	        this.prevSlot = this.invoker.getCurInvSlot();
	        
	        this.invoker.setInvSlot(slot);
	        this.invoker.sendUseItem(this.invoker.getCurrentItem(), McCheatClient.getInstance().getWrapper().getPlayer());
	      }
	    }
		
		 if (!pants)
		    {
		      boolean hot = false;
		      boolean inv = false;
		      
		      int slot = -1;
		      j = (arrayOfInt = this.pantIds).length;
		      for (i = 0; i < j; i++)
		      {
		        int id = arrayOfInt[i];
		        int invSlot = this.utils.getSlotOfInvItem(id);
		        if (invSlot != -1)
		        {
		          inv = true;
		          slot = invSlot;
		          break;
		        }
		        int newSlot = this.utils.getSlotOfHotbarItem(id);
		        if (newSlot != -1)
		        {
		          hot = true;
		          slot = newSlot;
		          break;
		        }
		      }
		      if ((slot != -1) && (inv))
		      {
		        this.utils.click(slot, 1);
		      }
		      else if ((slot != -1) && (hot))
		      {
		        this.prevSlot = this.invoker.getCurInvSlot();
		        
		        this.invoker.setInvSlot(slot);
		        this.invoker.sendUseItem(this.invoker.getCurrentItem(), McCheatClient.getInstance().getWrapper().getPlayer());
		      }
		    }
		    if (!shirt)
		    {
		      boolean hot = false;
		      boolean inv = false;
		      
		      int slot = -1;
		      j = (arrayOfInt = this.chestIds).length;
		      for (i = 0; i < j; i++)
		      {
		        int id = arrayOfInt[i];
		        int invSlot = this.utils.getSlotOfInvItem(id);
		        if (invSlot != -1)
		        {
		          inv = true;
		          slot = invSlot;
		          break;
		        }
		        int newSlot = this.utils.getSlotOfHotbarItem(id);
		        if (newSlot != -1)
		        {
		          hot = true;
		          slot = newSlot;
		          break;
		        }
		      }
		      if ((slot != -1) && (inv))
		      {
		        this.utils.click(slot, 1);
		      }
		      else if ((slot != -1) && (hot))
		      {
		        this.prevSlot = this.invoker.getCurInvSlot();
		        
		        this.invoker.setInvSlot(slot);
		        this.invoker.sendUseItem(this.invoker.getCurrentItem(), McCheatClient.getInstance().getWrapper().getPlayer());
		      }
		    }
		    if (!helm)
		    {
		      boolean hot = false;
		      boolean inv = false;
		      
		      int slot = -1;
		      j = (arrayOfInt = this.helmIds).length;
		      for (i = 0; i < j; i++)
		      {
		        int id = arrayOfInt[i];
		        int invSlot = this.utils.getSlotOfInvItem(id);
		        if (invSlot != -1)
		        {
		          inv = true;
		          slot = invSlot;
		          break;
		        }
		        int newSlot = this.utils.getSlotOfHotbarItem(id);
		        if (newSlot != -1)
		        {
		          hot = true;
		          slot = newSlot;
		          break;
		        }
		      }
		      if ((slot != -1) && (inv))
		      {
		        this.utils.click(slot, 1);
		      }
		      else if ((slot != -1) && (hot))
		      {
		        this.prevSlot = this.invoker.getCurInvSlot();
		        
		        this.invoker.setInvSlot(slot);
		        this.invoker.sendUseItem(this.invoker.getCurrentItem(), McCheatClient.getInstance().getWrapper().getPlayer());
		      }
	    }
	}	
	
}
