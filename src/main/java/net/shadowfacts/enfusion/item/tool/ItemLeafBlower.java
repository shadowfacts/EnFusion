package net.shadowfacts.enfusion.item.tool;

import cofh.api.energy.IEnergyContainerItem;
import net.minecraft.block.Block;
import net.minecraft.block.BlockBush;
import net.minecraft.block.BlockLeavesBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ChunkCoordinates;
import net.minecraft.world.World;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author shadowfacts
 */
public class ItemLeafBlower extends Item implements IEnergyContainerItem {

	protected int capacity;
	protected int maxReceive;
	protected int maxExtract;

	public ItemLeafBlower() {
		super();
		this.setMaxStackSize(1);
	}

	public ItemLeafBlower(int capacity) {
		this(capacity, capacity, capacity);
	}

	public ItemLeafBlower(int capacity, int maxTransfer) {
		this(capacity, maxTransfer, maxTransfer);
	}

	public ItemLeafBlower(int capacity, int maxReceive, int maxExtract) {
		super();
		this.capacity = capacity;
		this.maxReceive = maxReceive;
		this.maxExtract = maxExtract;
		this.setMaxStackSize(1);
	}

	@Override
	public String getUnlocalizedName() {
		return "enfusion." + super.getUnlocalizedName();
	}

	@Override
	public String getUnlocalizedName(ItemStack stack) {
		return this.getUnlocalizedName();
	}

	@Override
	public int receiveEnergy(ItemStack container, int maxReceive, boolean simulate) {
		if (container.stackTagCompound == null) {
			container.stackTagCompound = new NBTTagCompound();
		}
		int energy = container.stackTagCompound.getInteger("Energy");
		int energyReceieved = Math.min(capacity - energy, Math.min(this.maxReceive, maxReceive));

		if (!simulate) {
			container.stackTagCompound.setInteger("Energy", energy + energyReceieved);
		}

		return energyReceieved;
	}

	@Override
	public int extractEnergy(ItemStack container, int maxExtract, boolean simulate) {
		return 0;
	}

	@Override
	public int getEnergyStored(ItemStack container) {
		if (container.stackTagCompound == null || !container.stackTagCompound.hasKey("Energy")) {
			return 0;
		}
		return container.stackTagCompound.getInteger("Energy");
	}

	@Override
	public int getMaxEnergyStored(ItemStack container) {
		return capacity;
	}

	@Override
	public EnumAction getItemUseAction(ItemStack stack) {
		return EnumAction.bow;
	}

	@Override
	public int getMaxItemUseDuration(ItemStack stack) {
		return 72000;
	}

	@Override
	public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player) {
		player.setItemInUse(stack, getMaxItemUseDuration(stack));
		return stack;
	}

	@Override
	public void onUsingTick(ItemStack stack, EntityPlayer player, int time) {
		if (time != getMaxItemUseDuration(stack) && time % 5 == 0) {
			breakGrass(player.worldObj, stack.getItemDamage(), (int)player.posX, (int)player.posY, (int)player.posZ);
			int energy = stack.stackTagCompound.getInteger("Energy");
			stack.stackTagCompound.setInteger("Energy", energy - 1);
		}
	}

	public static void breakGrass(World world, int damage, int srcX, int srcY, int srcZ) {
		Random random = new Random(srcX ^ srcY ^ srcZ);
		int range = 12 - damage * 3;
		int rangeY = 3 + damage * 2;
		List<ChunkCoordinates> coords = new ArrayList();

		for (int i = -range; i < range; i++) {
			for (int j = -range; j < range + 1; j++) {
				for (int k = -rangeY; k < rangeY; k++) {
					int x = srcX + i;
					int y = srcY + j;
					int z = srcZ + k;

					Block block = world.getBlock(x, y, z);
					if ((damage == 0 && block instanceof BlockBush) || (damage == 1 && block instanceof BlockLeavesBase)) {
						coords.add(new ChunkCoordinates(x, y, z));
					}
				}
			}
		}

		int count = Math.min(coords.size(), 32 + damage * 16);
		for (int i = 0; i < count; i++) {
			ChunkCoordinates c = coords.get(i);
			List<ItemStack> items = new ArrayList();
			Block block = world.getBlock(c.posX, c.posY, c.posZ);
			int meta = world.getBlockMetadata(c.posX, c.posY, c.posZ);
			items.addAll(block.getDrops(world, c.posX, c.posY, c.posZ, meta, 0));

			if (!world.isRemote) {
				world.setBlockToAir(c.posX, c.posY, c.posZ);
				for (ItemStack stack : items) {
					EntityItem item = new EntityItem(world, c.posX + 0.5, c.posY + 0.5, c.posZ + 0.5, stack);
					world.spawnEntityInWorld(item);
				}
			}

		}
	}

}
