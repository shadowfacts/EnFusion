package net.shadowfacts.enfusion.entity;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;
import net.shadowfacts.enfusion.EnFusion;
import net.shadowfacts.enfusion.config.Configurator;
import cpw.mods.fml.common.registry.EntityRegistry;

public class EntityLaserBolt extends EntityThrowable {
	
	public static void initialize() {
		EntityRegistry.registerModEntity(EntityLaserBolt.class, "LaserBolt", Configurator.laserBoltEntityId, EnFusion.instance, 120, 3, true);
	}

	public EntityLaserBolt(World par1World) {
		super(par1World);
		this.motionX *= 8;
		this.motionY *= 8;
		this.motionZ *= 8;
	}
	
	public EntityLaserBolt(World par1World, EntityLivingBase par2EntityLivingBase) {
		super(par1World, par2EntityLivingBase);
		this.motionX *= 8;
		this.motionY *= 8;
		this.motionZ *= 8;
	}
	
	public EntityLaserBolt(World par1World, double par2, double par4, double par6) {
		super(par1World, par2, par4, par6);
		this.motionX *= 8;
		this.motionY *= 8;
		this.motionZ *= 8;
	}

	@Override
	public void onImpact(MovingObjectPosition movingobjectposition) {
		if (!this.worldObj.isRemote) {
			this.worldObj.createExplosion(this, this.posX, this.posY, this.posZ, (float) 6, true);
			this.setDead();
		}
	}
	
	@Override
	public float getGravityVelocity() {
		return 0;
	}
}
