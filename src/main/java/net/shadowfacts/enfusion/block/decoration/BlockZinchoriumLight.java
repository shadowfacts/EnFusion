package net.shadowfacts.enfusion.block.decoration;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockRedstoneLight;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.world.World;
import net.shadowfacts.enfusion.block.ZBlocks;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockZinchoriumLight extends BlockRedstoneLight {
	
	/** Whether this lamp block is the powered version. */
    private final boolean powered;

    public BlockZinchoriumLight(boolean par1)
    {
        super(par1);
        this.powered = par1;

        if (par1)
        {
            this.setLightLevel(1.0F);
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
                par1World.scheduleBlockUpdate(par2, par3, par4, this, 4);
            }
            else if (!this.powered && par1World.isBlockIndirectlyGettingPowered(par2, par3, par4))
            {
                par1World.setBlock(par2, par3, par4, ZBlocks.greenZinchoriumLightActive, 0, 2);
            }
        }
    }

    @Override
    /**
     * Lets the block know when one of its neighbor changes. Doesn't know which neighbor changed (coordinates passed are
     * their own) Args: x, y, z, neighbor blockID
     */
    public void onNeighborBlockChange(World par1World, int par2, int par3, int par4, Block par5Block)
    {
        if (!par1World.isRemote)
        {
            if (this.powered && !par1World.isBlockIndirectlyGettingPowered(par2, par3, par4))
            {
                par1World.scheduleBlockUpdate(par2, par3, par4, this, 4);
            }
            else if (!this.powered && par1World.isBlockIndirectlyGettingPowered(par2, par3, par4))
            {
                par1World.setBlock(par2, par3, par4, ZBlocks.greenZinchoriumLightActive, 0, 2);
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
            par1World.setBlock(par2, par3, par4, ZBlocks.greenZinchoriumLightIdle, 0, 2);
        }
    }
    
    @Override
    public Item getItemDropped(int par1, Random par2Random, int par3) {
    	return Item.getItemFromBlock(ZBlocks.greenZinchoriumLightIdle);
    }
    
    @SideOnly(Side.CLIENT)
    @Override
    public Item getItem(World par1World, int par2, int par3, int par4)
    {
        return Item.getItemFromBlock(ZBlocks.greenZinchoriumLightIdle);
    }
}
