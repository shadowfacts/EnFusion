//package net.shadowfacts.zcraft.entity;
//
//import net.minecraft.block.Block;
//import net.minecraft.entity.EntityLivingBase;
//import net.minecraft.entity.player.EntityPlayer;
//import net.minecraft.entity.projectile.EntityThrowable;
//import net.minecraft.init.Blocks;
//import net.minecraft.util.MovingObjectPosition;
//import net.minecraft.world.World;
//import net.shadowfacts.zcraft.ZCraft;
//import net.shadowfacts.zcraft.config.Configurator;
//import cpw.mods.fml.common.registry.EntityRegistry;
//
//public class EntityMiningLaser extends EntityThrowable {
//	
//	public static void initialize() {
//		EntityRegistry.registerModEntity(EntityMiningLaser.class, "MiningLaser", Configurator.miningLaserEntityId, ZCraft.instance, 120, 3, true);
//	}
//
//	public EntityMiningLaser(World par1World) {
//		super(par1World);
//		this.motionX *= 8;
//		this.motionY *= 8;
//		this.motionZ *= 8;
//	}
//	
//	public EntityMiningLaser(World par1World, EntityLivingBase par2EntityLivingBase) {
//		super(par1World, par2EntityLivingBase);
//		this.motionX *= 8;
//		this.motionY *= 8;
//		this.motionZ *= 8;
//	}
//	
//	public EntityMiningLaser(World par1World, double par2, double par4, double par6) {
//		super(par1World, par2, par4, par6);
//		this.motionX *= 8;
//		this.motionY *= 8;
//		this.motionZ *= 8;
//	}
//
////	@Override
////	protected void onImpact(MovingObjectPosition movingobjectposition) {
////		EntityPlayer thrower = (EntityPlayer)this.getThrower();
////		boolean isCreative = thrower.capabilities.isCreativeMode;
////		if (this.worldObj.getBlockId(movingobjectposition.blockX, movingobjectposition.blockY, movingobjectposition.blockZ) == Block.bedrock.blockID) {
////			if (isCreative) {
////				this.worldObj.destroyBlock(movingobjectposition.blockX, movingobjectposition.blockY, movingobjectposition.blockZ, true);
////			}
////		} else {
////			this.worldObj.destroyBlock(movingobjectposition.blockX, movingobjectposition.blockY, movingobjectposition.blockZ, true);
////		}
////		this.setDead();
////	}
//	
//	@Override
//	public void onImpact(MovingObjectPosition pos) {
//		EntityPlayer thrower = (EntityPlayer)this.getThrower();
//		if (this.worldObj.getBlock(pos.blockX, pos.blockY, pos.blockZ) == Blocks.bedrock) {
//			if (thrower.capabilities.isCreativeMode) {
//				Block blockHit = this.worldObj.getBlock(pos.blockX, pos.blockY, pos.blockZ);
////				blockHit.dropBlockAsItem(worldObj, p_149697_2_, p_149697_3_, p_149697_4_, p_149697_5_, p_149697_6_);
//				ItemStack dropStack = new ItemStack(blockHit.getItemDropped(p_149650_1_, p_149650_2_, p_149650_3_))
//			}
//		}
//	}
//	
//}
//
//
//
