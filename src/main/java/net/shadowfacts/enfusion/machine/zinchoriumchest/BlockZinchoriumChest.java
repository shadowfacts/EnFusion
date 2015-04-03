package net.shadowfacts.enfusion.machine.zinchoriumchest;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import net.shadowfacts.shadowcore.block.BaseContainerBlock;

import java.util.ArrayList;

/**
 * @author shadowfacts
 */
public class BlockZinchoriumChest extends BaseContainerBlock {

	public BlockZinchoriumChest() {
		super("zinchoriumChest", Material.iron);
	}

//	Block
	@Override
	public String getUnlocalizedName() {
		return "enfusion." + super.getUnlocalizedName();
	}

	@Override
	public boolean isOpaqueCube() {
		return false;
	}

	@Override
	public boolean renderAsNormalBlock() {
		return false;
	}

//	Textures
	@SideOnly(Side.CLIENT)
	@Override
	public void registerBlockIcons(IIconRegister iconRegister) {
//		TODO: Textures
	}

//	@SideOnly(Side.CLIENT)
//	@Override
//	public IIcon getIcon(IBlockAccess iBlockAccess, int x, int y, int z, int metadata) {
//		return null;
////		TODO: Textures
//	}

	@Override
	public int getRenderType() {
		return 22; // Chest render type
	}

	@Override
	public ArrayList<ItemStack> getDrops(World world, int x, int y, int z, int metadata, int fortune) {
		return new ArrayList<ItemStack>(); // TODO: TileEntity + Drops
	}

	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ) {
		return false; // TODO: TileEntity + GUI
	}

	@Override
	public void onBlockPlacedBy(World p_149689_1_, int p_149689_2_, int p_149689_3_, int p_149689_4_, EntityLivingBase p_149689_5_, ItemStack p_149689_6_) {
		// TODO: Rotation
	}

	//	ITileEntityProvider
	@Override
	public TileEntity createNewTileEntity(World world, int metadata) {
		return new TileEntityZinchoriumChest(); // TODO: Implement TileEntityZinchoriumChest

	}
}
