package net.shadowfacts.zcraft.item.tool;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.shadowfacts.zcraft.entity.EntityLaserBolt;
import net.shadowfacts.zcraft.item.ZItems;

public class ItemLaserPistol extends Item {

	public ItemLaserPistol() {
		super();
		this.setMaxStackSize(1);
		this.setMaxDamage(512);
	}
	
	@Override
	public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer player) {
		itemStack.damageItem(1, player);
		world.playSoundAtEntity(player, "random.bow", 0.5f, 0.4f / (itemRand.nextFloat() * 0.4f + 0.8f));
		if (!world.isRemote) {
			world.spawnEntityInWorld(new EntityLaserBolt(world, player));
		}
		
		return itemStack;
	}

}
