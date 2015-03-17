package net.shadowfacts.enfusion.item.tool;

import net.minecraft.block.Block;
import net.minecraft.block.BlockBush;
import net.minecraft.block.BlockLeavesBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChunkCoordinates;
import net.minecraft.world.World;
import net.shadowfacts.enfusion.energy.EFItemEnergyContainer;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Based on code from Botania by Lizbeth Rika (Vazkii).
 * See the source code here: https://github.com/vazkii/botania
 * @author shadowfacts
 */
public class ItemLeafBlower extends EFItemEnergyContainer {

	public ItemLeafBlower() {
		super(16000, 32, 0);
		this.setMaxStackSize(1);
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
		this.extractEnergy(stack, 16, false);
		if (time != getMaxItemUseDuration(stack) && time % 5 == 0) {
			breakGrass(player.worldObj, stack.getItemDamage(), (int)player.posX, (int)player.posY, (int)player.posZ);
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
