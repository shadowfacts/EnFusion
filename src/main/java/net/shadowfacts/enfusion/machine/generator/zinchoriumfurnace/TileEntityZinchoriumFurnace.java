package net.shadowfacts.enfusion.machine.generator.zinchoriumfurnace;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.ItemStack;

import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntityFurnace;
import net.minecraftforge.common.util.ForgeDirection;
import net.shadowfacts.shadowcore.tileentity.BaseModTileEntity;

/**
 * TileEntity for the Zinchorium Furnace.
 * @author shadowfacts
 */
public class TileEntityZinchoriumFurnace extends BaseModTileEntity implements ISidedInventory {

	// Slots accessible from sides
	private static final int[] slotsTop = {0};
	private static final int[] slotsBottom = {2, 1};
	private static final int[] slotsSide = {1};

	// The Inventory, oooh
	private ItemStack[] furnaceItemStacks = new ItemStack[3];

	public int burnTime;
	public int currentItemBurnTime;
	public int cookTime;

	// Furnace Configuration
	public final float furnaceSpeedMuiltiplier = 1.0f;


	// IInventory
	public int getSizeInventory() {
		return this.furnaceItemStacks.length;
	}

	public ItemStack getStackInSlot(int slot) {
		return this.furnaceItemStacks[slot];
	}

	public ItemStack decrStackSize(int slot, int amount) {
		if (this.furnaceItemStacks[slot] != null) {
			if (this.furnaceItemStacks[slot].stackSize <= amount) {
				ItemStack stack = this.furnaceItemStacks[slot];
				this.furnaceItemStacks[slot] = null;
				return stack;
			} else {
				ItemStack stack = this.furnaceItemStacks[slot].splitStack(amount);
				if (this.furnaceItemStacks[slot].stackSize == 0) {
					this.furnaceItemStacks[slot] = null;
				}
				return stack;
			}
		}
		return null;
	}

	public ItemStack getStackInSlotOnClosing(int slot) {
		if (this.furnaceItemStacks[slot] != null) {
			ItemStack stack = this.furnaceItemStacks[slot];
			this.furnaceItemStacks[slot] = null;
			return stack;
		}
		return null;
	}

	public void setInventorySlotContents(int slot, ItemStack stack) {
		this.furnaceItemStacks[slot] = stack;
		if ((stack != null) && (stack.stackSize > getInventoryStackLimit())) {
			stack.stackSize = getInventoryStackLimit();
		}
	}

	public String getInventoryName() {
		return "Zinchorium Furnace"; // TODO: localization
	}

	public boolean hasCustomInventoryName() {
		return false;
	}

	// NBT
	@Override
	public void loadDataFromNBT(NBTTagCompound nbt) {
		NBTTagList tagList = nbt.getTagList("items", 10);
		this.furnaceItemStacks = new ItemStack[getSizeInventory()];
		for (int i = 0; i < tagList.tagCount(); i++) {
			NBTTagCompound tagCompound = tagList.getCompoundTagAt(i);
			int slot = tagCompound.getInteger("Slot");
			if ((slot >= 0) && (slot < this.furnaceItemStacks.length)) {
				this.furnaceItemStacks[slot] = ItemStack.loadItemStackFromNBT(tagCompound);
			}
		}
		this.burnTime = nbt.getInteger("BurnTime");
		this.cookTime = nbt.getInteger("CookTime");
		this.currentItemBurnTime = getItemBurnTime(this.furnaceItemStacks[1]);
	}

	@Override
	public void addDataToNBT(NBTTagCompound nbt) {
		nbt.setInteger("BurnTime", this.burnTime);
		nbt.setInteger("CookTime", this.cookTime);
		NBTTagList tagList = new NBTTagList();
		for (int i = 0; i < this.furnaceItemStacks.length; i++) {
			if (this.furnaceItemStacks[i] != null) {
				NBTTagCompound tagCompound = new NBTTagCompound();
				tagCompound.setInteger("Slot", i);
				this.furnaceItemStacks[i].writeToNBT(tagCompound);
				tagList.appendTag(tagCompound);
			}
		}
		nbt.setTag("Items", tagList);
	}

	public int getInventoryStackLimit() {
		return 64;
	}

	@SideOnly(Side.CLIENT)
	public int getCookProgressScaled(int par1) {
		return this.cookTime * par1 / 200;
	}

	@SideOnly(Side.CLIENT)
	public int getBurnTimeRemainingScaled(int par1) {
		if (this.currentItemBurnTime == 0) {
			this.currentItemBurnTime = 200;
		}
		return this.burnTime * par1 / this.currentItemBurnTime;
	}

	public boolean isBurning() {
		return this.burnTime > 0;
	}

	public void updateEntity() {
		boolean flag = this.burnTime > 0;
		boolean flag1 = false;
		if (this.burnTime > 0) {
			this.burnTime -= 1;
		}
		if (!this.worldObj.isRemote) {
			if ((this.burnTime != 0) || (this.furnaceItemStacks[1] != null) && (this.furnaceItemStacks[0] != null)) {
				if ((this.burnTime == 0) && canSmelt()) {
					this.currentItemBurnTime = (this.burnTime = getItemBurnTime(this.furnaceItemStacks[1]));
					if (this.burnTime > 0) {
						flag1 = true;
						if (this.furnaceItemStacks[1] != null) {
							this.furnaceItemStacks[1].stackSize -= 1;
							if (this.furnaceItemStacks[1].stackSize == 0) {
								this.furnaceItemStacks[1] = this.furnaceItemStacks[1].getItem().getContainerItem(this.furnaceItemStacks[1]);
							}
						}
					}
				}
				if (isBurning() && canSmelt()) {
					this.cookTime += 1;
					if (this.cookTime == 200) {
						this.cookTime = 0;
						smeltItem();
						flag1 = true;
					}
				} else {
					this.cookTime = 0;
				}
			}
			if (flag != this.burnTime > 0) {
				flag1 = true;
				BlockZinchoriumFurnace furnace = (BlockZinchoriumFurnace)this.worldObj.getBlock(xCoord, yCoord, zCoord);
				if (furnace != null) {
					furnace.setActive(this.burnTime > 0);
				}
			}
		}
		if (flag1) {
			markDirty();
		}
	}

	private boolean canSmelt() {
		if (this.furnaceItemStacks[0] == null) {
			return false;
		}
		ItemStack stack = FurnaceRecipes.smelting().getSmeltingResult(this.furnaceItemStacks[0]);
		if (stack == null) {
			return false;
		}
		if (this.furnaceItemStacks[2] == null) {
			return true;
		}
		if (!this.furnaceItemStacks[2].isItemEqual(stack)) {
			return false;
		}
		int result = this.furnaceItemStacks[2].stackSize + stack.stackSize;
		return (result <= getInventoryStackLimit()) && (result <= this.furnaceItemStacks[2].getMaxStackSize());
	}

	public void smeltItem() {
		if (canSmelt()) {
			ItemStack stack = FurnaceRecipes.smelting().getSmeltingResult(this.furnaceItemStacks[0]);
			if (this.furnaceItemStacks[2] == null) {
				this.furnaceItemStacks[2] = stack.copy();
			} else if (this.furnaceItemStacks[2].isItemEqual(stack)) {
				this.furnaceItemStacks[2].stackSize += stack.stackSize;
			}
			this.furnaceItemStacks[0].stackSize -= 1;
			if (this.furnaceItemStacks[0].stackSize <= 0) {
				this.furnaceItemStacks[0] = null;
			}
		}
	}

	public static int getItemBurnTime(ItemStack stack) {
		return TileEntityFurnace.getItemBurnTime(stack);
	}

	public static boolean isItemFuel(ItemStack stack) {
		return getItemBurnTime(stack) > 0;
	}

	public boolean isUseableByPlayer(EntityPlayer player) {
		return this.worldObj.getTileEntity(this.xCoord, this.yCoord, this.zCoord) == this;
	}

	public void openInventory() {

	}

	public void closeInventory() {

	}

	public boolean isItemValidForSlot(int slot, ItemStack stack) {
		return slot != 2; // TODO: Check if item can be used as fuel or as smelting ingredient
	}

	public int[] getAccessibleSlotsFromSide(int side) {
		if (ForgeDirection.getOrientation(side) == ForgeDirection.UP) {
			return slotsTop;
		} else if (ForgeDirection.getOrientation(side) == ForgeDirection.DOWN) {
			return slotsBottom;
		} else {
			return slotsSide;
		}
	}

	public boolean canInsertItem(int slot, ItemStack stack, int par3) {
		return isItemValidForSlot(slot, stack);
	}

	public boolean canExtractItem(int slot, ItemStack stack, int par3) {
		return (par3 != 0) || (slot != 1) || (stack.getItem() == Items.bucket);
	}

}
