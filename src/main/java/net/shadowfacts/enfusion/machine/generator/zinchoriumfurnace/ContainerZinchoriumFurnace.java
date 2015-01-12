package net.shadowfacts.enfusion.machine.generator.zinchoriumfurnace;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ICrafting;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;

/**
 * Container for the Zinchorium Furnace.
 * @author shadowfacts
 */
public class ContainerZinchoriumFurnace extends Container {

	private TileEntityZinchoriumFurnace te;

	public int lastBurnTime;
	public int lastCurrentItemBurnTime;
	public int lastCookTime;

	public ContainerZinchoriumFurnace(InventoryPlayer inventory, TileEntityZinchoriumFurnace te) {
		this.te = te;

		this.addSlotToContainer(new Slot(te, 0, 56, 17));
		this.addSlotToContainer(new Slot(te, 1, 56, 53));
		this.addSlotToContainer(new Slot(te, 2, 116, 35));

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 9; j++) {
				this.addSlotToContainer(new Slot(inventory, j + i * 9 + 9, 8 + j * 18, 84 + i * 18));
			}
		}
		for (int i = 0; i < 9; i++) {
			this.addSlotToContainer(new Slot(inventory, i, 8 + i * 18, 142));
		}
	}

	public void addCraftingToCrafters(ICrafting iCrafting) {
		super.addCraftingToCrafters(iCrafting);
		iCrafting.sendProgressBarUpdate(this, 0, this.te.cookTime);
		iCrafting.sendProgressBarUpdate(this, 1, this.te.burnTime);
		iCrafting.sendProgressBarUpdate(this, 2, this.te.currentItemBurnTime);
	}

	public void detectAndSendChanges() {
		super.detectAndSendChanges();
		for (int i = 0; i < this.crafters.size(); i++) {
			ICrafting iCrafting = (ICrafting)this.crafters.get(i);

			if (this.lastCookTime != this.te.cookTime) {
				iCrafting.sendProgressBarUpdate(this, 0, this.te.cookTime);
			}
			if (this.lastBurnTime != this.te.burnTime) {
				iCrafting.sendProgressBarUpdate(this, 1, this.te.burnTime);
			}
			if (this.lastCurrentItemBurnTime != this.te.currentItemBurnTime) {
				iCrafting.sendProgressBarUpdate(this, 2, this.te.currentItemBurnTime);
			}
		}
		this.lastCookTime = this.te.cookTime;
		this.lastBurnTime = this.te.burnTime;
		this.lastCurrentItemBurnTime = this.te.currentItemBurnTime;
	}

	@SideOnly(Side.CLIENT)
	public void updateProgressBar(int par1, int par2) {
		if (par1 == 0) {
			this.te.cookTime = par2;
		}
		if (par1 == 1) {
			this.te.burnTime = par2;
		}
		if (par1 == 2) {
			this.te.currentItemBurnTime = par2;
		}
	}

	public ItemStack transferStackInSlot(EntityPlayer par1EntityPlayer, int par2) {
		ItemStack stack = null;
		Slot slot = (Slot) this.inventorySlots.get(par2);

		if (slot != null && slot.getHasStack()) {
			ItemStack stack1 = slot.getStack();
			stack = stack1.copy();

			if (par2 == 2) {
				if (!this.mergeItemStack(stack, 3, 39, true)) {
					return null;
				}

				slot.onSlotChange(stack1, stack);
			} else if (par2 != 1 && par2 != 0) {
				if (FurnaceRecipes.smelting().getSmeltingResult(stack1) != null) {
					if (!this.mergeItemStack(stack1, 0, 1, false)) {
						return null;
					}
				} else if (TileEntityZinchoriumFurnace.isItemFuel(stack1)) {
					if (!this.mergeItemStack(stack1, 1, 2, false)) {
						return null;
					}
				} else if (par2 >= 3 && par2 < 30) {
					if (!this.mergeItemStack(stack1, 30, 39, false)) {
						return null;
					}
				} else if (par2 >= 30 && par2 < 39
						&& !this.mergeItemStack(stack1, 3, 30, false)) {
					return null;
				}
			} else if (!this.mergeItemStack(stack1, 3, 39, false)) {
				return null;
			}

			if (stack1.stackSize == 0) {
				slot.putStack(null);
			} else {
				slot.onSlotChanged();
			}

			if (stack1.stackSize == stack.stackSize) {
				return null;
			}

			slot.onPickupFromSlot(par1EntityPlayer, stack1);
		}

		return stack;
	}

	public boolean canInteractWith(EntityPlayer player) {
		return true;
	}

}
