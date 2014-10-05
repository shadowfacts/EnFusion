package net.shadowfacts.zcraft.block.decoration;

import java.util.Random;

import net.minecraft.block.BlockRedstoneLight;
import net.minecraft.block.material.Material;
import net.minecraft.world.World;
import net.shadowfacts.zcraft.block.ZBlocks;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockZinchoriumLight extends BlockRedstoneLight {
	
	
	
	/** Whether this lamp block is the powered version. */
    private final boolean powered;

    public BlockZinchoriumLight(int par1, boolean par2)
    {
        super(par1, par2);
        this.powered = par2;

        if (par2)
        {
            this.setLightValue(1.0F);
        }
    }

    @Override
    /**
     * Called whenever the block is added into the world. Args: world, x, y, z
     */
    public void onBlockAdded(World par1World, int par2, int par3, int par4)
    {
        if (!par1World.isRemote)
        {
            if (this.powered && !par1World.isBlockIndirectlyGettingPowered(par2, par3, par4))
            {
                par1World.scheduleBlockUpdate(par2, par3, par4, this.blockID, 4);
            }
            else if (!this.powered && par1World.isBlockIndirectlyGettingPowered(par2, par3, par4))
            {
                par1World.setBlock(par2, par3, par4, ZBlocks.greenZinchoriumLightActive.blockID, 0, 2);
            }
        }
    }

    @Override
    /**
     * Lets the block know when one of its neighbor changes. Doesn't know which neighbor changed (coordinates passed are
     * their own) Args: x, y, z, neighbor blockID
     */
    public void onNeighborBlockChange(World par1World, int par2, int par3, int par4, int par5)
    {
        if (!par1World.isRemote)
        {
            if (this.powered && !par1World.isBlockIndirectlyGettingPowered(par2, par3, par4))
            {
                par1World.scheduleBlockUpdate(par2, par3, par4, this.blockID, 4);
            }
            else if (!this.powered && par1World.isBlockIndirectlyGettingPowered(par2, par3, par4))
            {
                par1World.setBlock(par2, par3, par4, ZBlocks.greenZinchoriumLightActive.blockID, 0, 2);
            }
        }
    }

    @Override
    /**
     * Ticks the block if it's been scheduled
     */
    public void updateTick(World par1World, int par2, int par3, int par4, Random par5Random)
    {
        if (!par1World.isRemote && this.powered && !par1World.isBlockIndirectlyGettingPowered(par2, par3, par4))
        {
            par1World.setBlock(par2, par3, par4, ZBlocks.greenZinchoriumLightIdle.blockID, 0, 2);
        }
    }
    
    @Override
    /**
     * Returns the ID of the items to drop on destruction.
     */
    public int idDropped(int par1, Random par2Random, int par3)
    {
        return ZBlocks.greenZinchoriumLightIdle.blockID;
    }

    @SideOnly(Side.CLIENT)
    @Override
    /**
     * only called by clickMiddleMouseButton , and passed to inventory.setCurrentItem (along with isCreative)
     */
    public int idPicked(World par1World, int par2, int par3, int par4)
    {
        return ZBlocks.greenZinchoriumLightIdle.blockID;
    }
}
