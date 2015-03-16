package net.shadowfacts.enfusion.entity;

import cpw.mods.fml.common.registry.EntityRegistry;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;
import net.shadowfacts.enfusion.EnFusion;
import net.shadowfacts.enfusion.config.EFConfig;

import java.util.ArrayList;

public class EntityMiningLaser extends EntityThrowable {
	
	public static void initialize() {
		EntityRegistry.registerModEntity(EntityMiningLaser.class, "MiningLaser", EFConfig.miningLaserEntityID, EnFusion.instance, 120, 3, true);
	}

	public EntityMiningLaser(World par1World) {
		super(par1World);
		this.motionX *= 8;
		this.motionY *= 8;
		this.motionZ *= 8;
	}
	
	public EntityMiningLaser(World par1World, EntityLivingBase par2EntityLivingBase) {
		super(par1World, par2EntityLivingBase);
		this.motionX *= 8;
		this.motionY *= 8;
		this.motionZ *= 8;
	}
	
	public EntityMiningLaser(World par1World, double par2, double par4, double par6) {
		super(par1World, par2, par4, par6);
		this.motionX *= 8;
		this.motionY *= 8;
		this.motionZ *= 8;
	}

	@Override
	public void onImpact(MovingObjectPosition pos) {
		if (!this.worldObj.isRemote) {
			if (this.worldObj.getBlock(pos.blockX, pos.blockY, pos.blockZ) != Blocks.bedrock) {
				int metadata = this.worldObj.getBlockMetadata(pos.blockX, pos.blockY, pos.blockZ);
				ArrayList<ItemStack> dropList = this.worldObj.getBlock(pos.blockX, pos.blockY, pos.blockZ).getDrops(this.worldObj, pos.blockX, pos.blockY, pos.blockZ, metadata, 0);

				for (ItemStack stack : dropList) {
					EntityItem item = new EntityItem(this.worldObj, (double) pos.blockX, (double) pos.blockY, (double) pos.blockZ, stack);
					this.worldObj.spawnEntityInWorld(item);
				}

				this.worldObj.setBlockToAir(pos.blockX, pos.blockY, pos.blockZ);
			}
		}
	}

	@Override
	public float getGravityVelocity() {
		return 0;
	}
	
}



