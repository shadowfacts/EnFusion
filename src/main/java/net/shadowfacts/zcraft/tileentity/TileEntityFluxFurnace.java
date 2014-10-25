//package net.shadowfacts.zcraft.tileentity;
//
//import cpw.mods.fml.relauncher.Side;
//import net.minecraft.entity.player.EntityPlayer;
//import net.minecraft.inventory.ISidedInventory;
//import net.minecraft.item.ItemStack;
//import net.minecraft.nbt.NBTTagCompound;
//import net.minecraft.nbt.NBTTagList;
//import net.minecraft.tileentity.TileEntity;
//import net.shadowfacts.zcraft.ZCraft;
//
//public class TileEntityFluxFurnace extends TileEntity implements ISidedInventory {
//	
//	private static final String name = "tileEntityFluxFurnace";
//	public static final String TEId = ZCraft.modId + ":" + name;
//	
//	private static final int[] slotsTop = new int[]{ 0 };
//	private static final int[] slotsBottom = new int[]{ 2, 1 };
//	private static final int[] slotsSide = new int[]{ 1 };
//	
//	private ItemStack[] furnaceItemStacks = new ItemStack[3];
//	
//	public int furnaceBurnTime; // How long the furnace burns for (ticks)
//	public int currentBurnTime; // Current burn time of the furnace
//	public int furnaceCookTime; // Hoe long the current item has been in the furnace
//	
//	private String furnaceName; // The name of the furnace that is displayed in the GUI
//	
//	
//	public void furnaceName(String name) {
//		this.furnaceName = name;
//	}
//	
//	
//	
//	@Override
//	public int getSizeInventory() {
//		return this.furnaceItemStacks.length;
//	}
//
//	@Override
//	public ItemStack getStackInSlot(int slot) {
//		return this.furnaceItemStacks[slot];
//	}
//
//	@Override
//	public ItemStack decrStackSize(int slot, int taken) {
//		if (this.furnaceItemStacks[slot] != null) {
//			ItemStack itemStack;
//			
//			if (this.furnaceItemStacks[slot].stackSize <= taken) {
//				itemStack = this.furnaceItemStacks[slot];
//				this.furnaceItemStacks[slot] = null;
//				return itemStack;
//			} else {
//				itemStack = this.furnaceItemStacks[slot].splitStack(taken);
//				if (this.furnaceItemStacks[slot].stackSize == 0) {
//					this.furnaceItemStacks[slot] = null;
//				}
//			}
//		}
//		return null;
//	}
//
//	@Override
//	public ItemStack getStackInSlotOnClosing(int slot) {
//		if (this.furnaceItemStacks[slot] != null) {
//			ItemStack itemStack = this.furnaceItemStacks[slot];
//			return itemStack;
//		} else {
//			return null;
//		}
//	}
//
//	@Override
//	public void setInventorySlotContents(int slot, ItemStack itemStack) {
//		this.furnaceItemStacks[slot] = itemStack;
//		
//		if (itemStack != null && itemStack.stackSize > this.getInventoryStackLimit()) {
//			itemStack.stackSize = this.getInventoryStackLimit();
//		}
//	}
//
//	@Override
//	public String getInventoryName() {
//		if (this.hasCustomInventoryName()) {
//			return this.furnaceName;
//		} else {
//			return "Flux Furnace";
//		}
//	}
//
//	@Override
//	public boolean hasCustomInventoryName() {
//		return this.furnaceName != null && this.furnaceName.length() > 0;
//	}
//
//	@Override
//	public int getInventoryStackLimit() {
//		return 64;
//	}
//
//	@Override
//	public boolean isUseableByPlayer(EntityPlayer p_70300_1_) {
//		// TODO Auto-generated method stub
//		return false;
//	}
//
//	@Override
//	public void openInventory() {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public void closeInventory() {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public boolean isItemValidForSlot(int p_94041_1_, ItemStack p_94041_2_) {
//		// TODO Auto-generated method stub
//		return false;
//	}
//
//	@Override
//	public int[] getAccessibleSlotsFromSide(int p_94128_1_) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public boolean canInsertItem(int p_102007_1_, ItemStack p_102007_2_,
//			int p_102007_3_) {
//		// TODO Auto-generated method stub
//		return false;
//	}
//
//	@Override
//	public boolean canExtractItem(int p_102008_1_, ItemStack p_102008_2_,
//			int p_102008_3_) {
//		// TODO Auto-generated method stub
//		return false;
//	}
//	
//	// NBT stuff
//	
//	public void readFromNBT(NBTTagCompound tagCompound) {
//		super.readFromNBT(tagCompound);
//		NBTTagList tagList = tagCompound.getTagList("items", 10);
//		this.furnaceItemStacks = new ItemStack[this.getSizeInventory()];
//		
//		for (int i = 0; i < tagList.tagCount(); ++i) { // Update the ItemStacks in the various slots from the NBT data
//			NBTTagCompound itemStackCompound = tagList.getCompoundTagAt(i);
//			byte byte0 = itemStackCompound.getByte("Slot");
//			
//			if (byte0 >= 0 && byte0 < this.furnaceItemStacks.length) {
//				this.furnaceItemStacks[byte0] = ItemStack.loadItemStackFromNBT(itemStackCompound);
//			}
//		}
//		
//		this.furnaceBurnTime = tagCompound.getShort("BurnTime"); // the burn time
//		this.furnaceCookTime = tagCompound.getShort("CookTime"); // the cook time
//		this.currentBurnTime = getItemBurnTime(this.furnaceItemStacks[1]);
//		
//		if (tagCompound.hasKey("CustomName", 8))) {
//			this.furnaceName = tagCompound.getString("CustomName");
//		}
//	}
//	
//	public void writeToNBT(NBTTagCompound tagCompound) {
//		super.writeToNBT(tagCompound);
//		
//		tagCompound.setShort("BurnTime", (short)this.furnaceBurnTime);
//		tagCompound.setShort("CookTime", (short)this.furnaceCookTime);
//		
//		NBTTagList tagList = new NBTTagList();
//		
//		for (int i = 0; i < this.furnaceItemStacks.length; ++i) {
//			if (this.furnaceItemStacks[i] != null) {
//				NBTTagCompound itemStackCompound = tagList.getCompoundTagAt(i);
//				tagCompound.setByte("Slot", (byte)i);
//				this.furnaceItemStacks[i].writeToNBT(itemStackCompound);
//				tagList.appendTag(itemStackCompound);
//			}
//		}
//		
//		tagCompound.setTag("items", tagList);
//		
//		if (this.hasCustomInventoryName()) {
//			tagCompound.setString("CustomName", this.furnaceName);
//		}
//	}
//	
//	@SideOnly(Side.CLIENT)
//	public int getCookProgressScaled() {
//		
//	}
//	
//	
//}
//
//
//
//
