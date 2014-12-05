package net.shadowfacts.enfusion.machine.furnace;

import net.minecraft.block.Block;
import net.minecraft.block.BlockFurnace;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemHoe;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.item.ItemTool;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;
import net.shadowfacts.enfusion.EnFusion;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class TileEntityFluxFurnace extends TileEntity implements ISidedInventory {
	
	public static final String name = "tileEntityFluxFurnace";
	public static final String TEId = EnFusion.modId + ":" + name;
	
    private static final int[] slotsTop = { 0 };
    private static final int[] slotsBottom = { 2, 1 };
    private static final int[] slotsSides = { 1 };
    private ItemStack[] furnaceItemStacks = new ItemStack[3];
    public int furnaceBurnTime;
    public int currentItemBurnTime;
    public int furnaceCookTime;
    
    private String furnaceName;
    
    public void furnaceName(String name) {
    	this.furnaceName = name;
    }
    
    public int getSizeInventory()
    {
        return this.furnaceItemStacks.length;
    }
    
    public ItemStack getStackInSlot(int slot)
    {
    	return this.furnaceItemStacks[slot];
    }
    
    public ItemStack decrStackSize(int slot, int taken)
    {
        if (this.furnaceItemStacks[slot] != null)
        {
            if (this.furnaceItemStacks[slot].stackSize <= taken)
            {
                ItemStack itemstack = this.furnaceItemStacks[slot];
                this.furnaceItemStacks[slot] = null;
                return itemstack;
            }
            ItemStack itemstack = this.furnaceItemStacks[slot].splitStack(taken);
            if (this.furnaceItemStacks[slot].stackSize == 0) {
                this.furnaceItemStacks[slot] = null;
            }
            return itemstack;
        }
        return null;
    }
    
    public ItemStack getStackInSlotOnClosing(int slot)
    {
        if (this.furnaceItemStacks[slot] != null)
        {
            ItemStack itemstack = this.furnaceItemStacks[slot];
            this.furnaceItemStacks[slot] = null;
            return itemstack;
        }
        return null;
    }
    
    public void setInventorySlotContents(int slot, ItemStack stack)
    {
        this.furnaceItemStacks[slot] = stack;
        if ((stack!= null) && (stack.stackSize > getInventoryStackLimit())) {
            stack.stackSize = getInventoryStackLimit();
        }
    }
    
    public String getInventoryName()
    {
        return hasCustomInventoryName() ? this.furnaceName : "Flux Furnace";
    }
    
    public boolean hasCustomInventoryName()
    {
        return (this.furnaceName != null) && (this.furnaceName.length() > 0);
    }
    
    public void readFromNBT(NBTTagCompound tagCompound)
    {
        super.readFromNBT(tagCompound);
        NBTTagList nbttaglist = tagCompound.getTagList("Items", 10);
        this.furnaceItemStacks = new ItemStack[getSizeInventory()];
        for (int i = 0; i < nbttaglist.tagCount(); i++)
        {
            NBTTagCompound nbttagcompound1 = nbttaglist.getCompoundTagAt(i);
            byte b0 = nbttagcompound1.getByte("Slot");
            if ((b0 >= 0) && (b0 < this.furnaceItemStacks.length)) {
                this.furnaceItemStacks[b0] = ItemStack.loadItemStackFromNBT(nbttagcompound1);
            }
        }
        this.furnaceBurnTime = tagCompound.getShort("BurnTime");
        this.furnaceCookTime = tagCompound.getShort("CookTime");
        this.currentItemBurnTime = getItemBurnTime(this.furnaceItemStacks[1]);
        if (tagCompound.hasKey("CustomName", 8)) {
            this.furnaceName = tagCompound.getString("CustomName");
        }
    }
    
    public void writeToNBT(NBTTagCompound tagCompound)
    {
        super.writeToNBT(tagCompound);
        tagCompound.setShort("BurnTime", (short)this.furnaceBurnTime);
        tagCompound.setShort("CookTime", (short)this.furnaceCookTime);
        NBTTagList nbttaglist = new NBTTagList();
        for (int i = 0; i < this.furnaceItemStacks.length; i++) {
            if (this.furnaceItemStacks[i] != null)
            {
                NBTTagCompound nbttagcompound1 = new NBTTagCompound();
                nbttagcompound1.setByte("Slot", (byte)i);
                this.furnaceItemStacks[i].writeToNBT(nbttagcompound1);
                nbttaglist.appendTag(nbttagcompound1);
            }
        }
        tagCompound.setTag("Items", nbttaglist);
        if (hasCustomInventoryName()) {
        	tagCompound.setString("CustomName", this.furnaceName);
        }
    }
    
    public int getInventoryStackLimit()
    {
        return 64;
    }
    
    @SideOnly(Side.CLIENT)
    public int getCookProgressScaled(int par1)
    {
        return this.furnaceCookTime * par1 / 200;
    }
    
    @SideOnly(Side.CLIENT)
    public int getBurnTimeRemainingScaled(int par1)
    {
        if (this.currentItemBurnTime == 0) {
            this.currentItemBurnTime = 200;
        }
        return this.furnaceBurnTime * par1 / this.currentItemBurnTime;
    }
    
    public boolean isBurning()
    {
        return this.furnaceBurnTime > 0;
    }
    
    public void updateEntity()
    {
        boolean flag = this.furnaceBurnTime > 0;
        boolean flag1 = false;
        if (this.furnaceBurnTime > 0) {
            this.furnaceBurnTime -= 1;
        }
        if (!this.worldObj.isRemote)
        {
            if ((this.furnaceBurnTime != 0) || ((this.furnaceItemStacks[1] != null) && (this.furnaceItemStacks[0] != null)))
            {
                if ((this.furnaceBurnTime == 0) && (canSmelt()))
                {
                    this.currentItemBurnTime = (this.furnaceBurnTime = getItemBurnTime(this.furnaceItemStacks[1]));
                    if (this.furnaceBurnTime > 0)
                    {
                        flag1 = true;
                        if (this.furnaceItemStacks[1] != null)
                        {
                            this.furnaceItemStacks[1].stackSize -= 1;
                            if (this.furnaceItemStacks[1].stackSize == 0) {
                                this.furnaceItemStacks[1] = this.furnaceItemStacks[1].getItem().getContainerItem(this.furnaceItemStacks[1]);
                            }
                        }
                    }
                }
                if ((isBurning()) && (canSmelt()))
                {
                    this.furnaceCookTime += 1;
                    if (this.furnaceCookTime == 200)
                    {
                        this.furnaceCookTime = 0;
                        smeltItem();
                        flag1 = true;
                    }
                }
                else
                {
                    this.furnaceCookTime = 0;
                }
            }
            if (flag != this.furnaceBurnTime > 0)
            {
                flag1 = true;
                BlockFurnace.updateFurnaceBlockState(this.furnaceBurnTime > 0, this.worldObj, this.xCoord, this.yCoord, this.zCoord);
            }
        }
        if (flag1) {
            markDirty();
        }
    }
    
    private boolean canSmelt()
    {
        if (this.furnaceItemStacks[0] == null) {
            return false;
        }
        ItemStack itemstack = FurnaceRecipes.smelting().getSmeltingResult(this.furnaceItemStacks[0]);
        if (itemstack == null) {
            return false;
        }
        if (this.furnaceItemStacks[2] == null) {
            return true;
        }
        if (!this.furnaceItemStacks[2].isItemEqual(itemstack)) {
            return false;
        }
        int result = this.furnaceItemStacks[2].stackSize + itemstack.stackSize;
        return (result <= getInventoryStackLimit()) && (result <= this.furnaceItemStacks[2].getMaxStackSize());
    }
    
    public void smeltItem()
    {
        if (canSmelt())
        {
            ItemStack itemstack = FurnaceRecipes.smelting().getSmeltingResult(this.furnaceItemStacks[0]);
            if (this.furnaceItemStacks[2] == null) {
                this.furnaceItemStacks[2] = itemstack.copy();
            } else if (this.furnaceItemStacks[2].getItem() == itemstack.getItem()) {
                this.furnaceItemStacks[2].stackSize += itemstack.stackSize;
            }
            this.furnaceItemStacks[0].stackSize -= 1;
            if (this.furnaceItemStacks[0].stackSize <= 0) {
                this.furnaceItemStacks[0] = null;
            }
        }
    }
    
    public static int getItemBurnTime(ItemStack stack)
    {
        if (stack == null) {
            return 0;
        }
        Item item = stack.getItem();
        if (((item instanceof ItemBlock)) && (Block.getBlockFromItem(item) != Blocks.air))
        {
            Block block = Block.getBlockFromItem(item);
            if (block == Blocks.wooden_slab) {
                return 150;
            }
            if (block.getMaterial() == Material.wood) {
                return 300;
            }
            if (block == Blocks.coal_block) {
                return 16000;
            }
        }
        if (((item instanceof ItemTool)) && (((ItemTool)item).getToolMaterialName().equals("WOOD"))) {
            return 200;
        }
        if (((item instanceof ItemSword)) && (((ItemSword)item).getToolMaterialName().equals("WOOD"))) {
            return 200;
        }
        if (((item instanceof ItemHoe)) && (((ItemHoe)item).getToolMaterialName().equals("WOOD"))) {
            return 200;
        }
        if (item == Items.stick) {
            return 100;
        }
        if (item == Items.coal) {
            return 1600;
        }
        if (item == Items.lava_bucket) {
            return 20000;
        }
        if (item == Item.getItemFromBlock(Blocks.sapling)) {
            return 100;
        }
        if (item == Items.blaze_rod) {
            return 2400;
        }
        return GameRegistry.getFuelValue(stack);
    }
    
    public static boolean isItemFuel(ItemStack stack)
    {
        return getItemBurnTime(stack) > 0;
    }
    
    public boolean isUseableByPlayer(EntityPlayer player)
    {
        return this.worldObj.getTileEntity(this.xCoord, this.yCoord, this.zCoord) == this;
    }
    
    public void openInventory() {}
    
    public void closeInventory() {}
    
    public boolean isItemValidForSlot(int slot, ItemStack stack)
    {
        return slot != 2;
    }
    
    public int[] getAccessibleSlotsFromSide(int par1)
    {
        return par1 == 1 ? slotsTop : par1 == 0 ? slotsBottom : slotsSides;
    }
    
    public boolean canInsertItem(int par1, ItemStack par2ItemStack, int par3)
    {
        return isItemValidForSlot(par1, par2ItemStack);
    }
    
    public boolean canExtractItem(int par1, ItemStack par2ItemStack, int par3)
    {
        return (par3 != 0) || (par1 != 1) || (par2ItemStack.getItem() == Items.bucket);
    }
}
