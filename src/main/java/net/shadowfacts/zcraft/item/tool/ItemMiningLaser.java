//package net.shadowfacts.zcraft.item.tool;
//
//import net.minecraft.entity.player.EntityPlayer;
//import net.minecraft.item.Item;
//import net.minecraft.item.ItemStack;
//import net.minecraft.world.World;
//import net.shadowfacts.zcraft.entity.EntityLaserBolt;
//import net.shadowfacts.zcraft.entity.EntityMiningLaser;
//
//public class ItemMiningLaser extends Item {
//
//	public ItemMiningLaser(int par1) {
//		super(par1);
//		this.setMaxStackSize(1);
//		this.setMaxDamage(1024);
//	}
//	
//	@Override
//	public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer player) {
//		itemStack.damageItem(1, player);
//		world.playSoundAtEntity(player, "random.bow", 0.5f, 0.4f / (itemRand.nextFloat() * 0.4f + 0.8f));
//		if (!world.isRemote) {
//			world.spawnEntityInWorld(new EntityMiningLaser(world, player));
////			player.is
//		}
//		
//		return itemStack;
//	}
//
//}
