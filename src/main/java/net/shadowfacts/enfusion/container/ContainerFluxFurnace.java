package net.shadowfacts.enfusion.container;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ICrafting;
import net.minecraft.inventory.Slot;
import net.minecraft.inventory.SlotFurnace;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.tileentity.TileEntityFurnace;
import net.shadowfacts.enfusion.tileentity.TileEntityFluxFurnace;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ContainerFluxFurnace extends Container
{
  private TileEntityFluxFurnace tileFluxFurnace;
  private int lastCookTime;
  private int lastBurnTime;
  private int lastItemBurnTime;
  
  public ContainerFluxFurnace(InventoryPlayer p_i1812_1_, TileEntityFluxFurnace p_i1812_2_)
  {
    this.tileFluxFurnace = p_i1812_2_;
    
    addSlotToContainer(new Slot(p_i1812_2_, 0, 56, 17));
    addSlotToContainer(new Slot(p_i1812_2_, 1, 56, 53));
    addSlotToContainer(new SlotFurnace(p_i1812_1_.player, p_i1812_2_, 2, 116, 35));
    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 9; j++) {
        addSlotToContainer(new Slot(p_i1812_1_, j + i * 9 + 9, 8 + j * 18, 84 + i * 18));
      }
    }
    for (int i = 0; i < 9; i++) {
      addSlotToContainer(new Slot(p_i1812_1_, i, 8 + i * 18, 142));
    }
  }
  
  public void addCraftingToCrafters(ICrafting p_addCraftingToCrafters_1_)
  {
    super.addCraftingToCrafters(p_addCraftingToCrafters_1_);
    p_addCraftingToCrafters_1_.sendProgressBarUpdate(this, 0, this.tileFluxFurnace.furnaceCookTime);
    p_addCraftingToCrafters_1_.sendProgressBarUpdate(this, 1, this.tileFluxFurnace.furnaceBurnTime);
    p_addCraftingToCrafters_1_.sendProgressBarUpdate(this, 2, this.tileFluxFurnace.currentItemBurnTime);
  }
  
  public void detectAndSendChanges()
  {	
    super.detectAndSendChanges();
    for (int i = 0; i < this.crafters.size(); i++)
    {
      ICrafting localICrafting = (ICrafting)this.crafters.get(i);
      if (this.lastCookTime != this.tileFluxFurnace.furnaceCookTime) {
        localICrafting.sendProgressBarUpdate(this, 0, this.tileFluxFurnace.furnaceCookTime);
      }
      if (this.lastBurnTime != this.tileFluxFurnace.furnaceBurnTime) {
        localICrafting.sendProgressBarUpdate(this, 1, this.tileFluxFurnace.furnaceBurnTime);
      }
      if (this.lastItemBurnTime != this.tileFluxFurnace.currentItemBurnTime) {
        localICrafting.sendProgressBarUpdate(this, 2, this.tileFluxFurnace.currentItemBurnTime);
      }
    }
    this.lastCookTime = this.tileFluxFurnace.furnaceCookTime;
    this.lastBurnTime = this.tileFluxFurnace.furnaceBurnTime;
    this.lastItemBurnTime = this.tileFluxFurnace.currentItemBurnTime;
  }
  
  @SideOnly(Side.CLIENT)
  public void updateProgressBar(int p_updateProgressBar_1_, int p_updateProgressBar_2_)
  {
    if (p_updateProgressBar_1_ == 0) {
      this.tileFluxFurnace.furnaceCookTime = p_updateProgressBar_2_;
    }
    if (p_updateProgressBar_1_ == 1) {
      this.tileFluxFurnace.furnaceBurnTime = p_updateProgressBar_2_;
    }
    if (p_updateProgressBar_1_ == 2) {
      this.tileFluxFurnace.currentItemBurnTime = p_updateProgressBar_2_;
    }
  }
  
  public boolean canInteractWith(EntityPlayer p_canInteractWith_1_)
  {
    return this.tileFluxFurnace.isUseableByPlayer(p_canInteractWith_1_);
  }
  
  public ItemStack transferStackInSlot(EntityPlayer p_transferStackInSlot_1_, int p_transferStackInSlot_2_)
  {
    ItemStack localItemStack1 = null;
    Slot localSlot = (Slot)this.inventorySlots.get(p_transferStackInSlot_2_);
    if ((localSlot != null) && (localSlot.getHasStack()))
    {
      ItemStack localItemStack2 = localSlot.getStack();
      localItemStack1 = localItemStack2.copy();
      if (p_transferStackInSlot_2_ == 2)
      {
        if (!mergeItemStack(localItemStack2, 3, 39, true)) {
          return null;
        }
        localSlot.onSlotChange(localItemStack2, localItemStack1);
      }
      else if ((p_transferStackInSlot_2_ == 1) || (p_transferStackInSlot_2_ == 0))
      {
        if (!mergeItemStack(localItemStack2, 3, 39, false)) {
          return null;
        }
      }
      else if (FurnaceRecipes.smelting().getSmeltingResult(localItemStack2) != null)
      {
        if (!mergeItemStack(localItemStack2, 0, 1, false)) {
          return null;
        }
      }
      else if (TileEntityFurnace.isItemFuel(localItemStack2))
      {
        if (!mergeItemStack(localItemStack2, 1, 2, false)) {
          return null;
        }
      }
      else if ((p_transferStackInSlot_2_ >= 3) && (p_transferStackInSlot_2_ < 30))
      {
        if (!mergeItemStack(localItemStack2, 30, 39, false)) {
          return null;
        }
      }
      else if ((p_transferStackInSlot_2_ >= 30) && (p_transferStackInSlot_2_ < 39) && 
        (!mergeItemStack(localItemStack2, 3, 30, false)))
      {
        return null;
      }
      if (localItemStack2.stackSize == 0) {
        localSlot.putStack(null);
      } else {
        localSlot.onSlotChanged();
      }
      if (localItemStack2.stackSize == localItemStack1.stackSize) {
        return null;
      }
      localSlot.onPickupFromSlot(p_transferStackInSlot_1_, localItemStack2);
    }
    return localItemStack1;
  }
}
