package net.minecraft.afyaan.utils;

import net.minecraft.afyaan.McCheatClient;
import net.minecraft.afyaan.modulebase.MethodInvoker;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class InventoryUtils {
private MethodInvoker mi = McCheatClient.getInstance().getInvoker();
	
	public int getSlotOfHotbarItem(int itemId){
		for(int i =0; i < 9; i++){
			ItemStack is = this.mi.getItemAtSlotHotbar(i);
			if((is != null) && (this.mi.getIdFromItem(is.getItem()) == itemId)){
				return i;
			}
		}
		return -1;
	}
	
	public int getSlotOfInvItem(int itemId)
	{
		for (int i = 9; i < 36; i++)
	    {
	      ItemStack is = this.mi.getItemAtSlot(i);
	      if ((is != null) && (this.mi.getIdFromItem(is.getItem()) == itemId)) {
	        return i;
	      }
	    }
	    return -1;
	}
	
	public int getFreeSlotInHotbar(int itemId)
	  {
	    for (int i = 0; i < 9; i++)
	    {
	      if (this.mi.getItemAtSlot(i) == null) {
	        return i;
	      }
	      if (this.mi.getItemAtSlot(i) != null)
	      {
	        ItemStack itemAtSlot = this.mi.getItemAtSlotHotbar(itemId);
	        Item item = this.mi.getItemById(itemId);
	        int idInSlot = this.mi.getIdFromItem(itemAtSlot.getItem());
	        if ((itemAtSlot != null) && (itemAtSlot != null) && (idInSlot == itemId) && (itemAtSlot.stackSize < item.getItemStackLimit())) {
	          return i;
	        }
	      }
	      else
	      {
	        return i;
	      }
	    }
	    return -1;
	  }
	
	public int getFreeSlotInInv(int itemId)
	{
	    for (int i = 36; i < 45; i++)
	    {
	      if (this.mi.getItemAtSlot(i) == null) {
	        return i;
	      }
	      if (this.mi.getItemAtSlot(i) != null)
	      {
	        ItemStack itemAtSlot = null;
	        itemAtSlot = this.mi.getItemAtSlot(i);
	        if (itemAtSlot != null)
	        {
	          Item item = this.mi.getItemById(itemId);
	          int idInSlot = this.mi.getIdFromItem(itemAtSlot.getItem());
	          if ((itemAtSlot != null) && (item != null) && (idInSlot == itemId) && (itemAtSlot.stackSize < item.getItemStackLimit())) {
	            return i;
	          }
	        }
	      }
	    }
	    return -1;
	}
	
	public void click(int slot, int mode)
	{
	    this.mi.clickWindow(slot, mode, 0, McCheatClient.getInstance().getWrapper().getPlayer());
	}
	
	public void sendItemUse(ItemStack itemStack)
	{
		this.mi.sendUseItem(itemStack, McCheatClient.getInstance().getWrapper().getPlayer());
	}
}
