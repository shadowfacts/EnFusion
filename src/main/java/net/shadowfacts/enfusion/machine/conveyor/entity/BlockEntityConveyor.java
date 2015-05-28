package net.shadowfacts.enfusion.machine.conveyor.entity;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;
import net.shadowfacts.enfusion.EnFusion;
import net.shadowfacts.enfusion.block.EFBlocks;

/**
 * The block for the Entity Conveyor
 * @author shadowfacts
 */
public class BlockEntityConveyor extends Block implements ITileEntityProvider {

	@SideOnly(Side.CLIENT)
	private IIcon iconSide;
	@SideOnly(Side.CLIENT)
	private IIcon iconTop;

	public BlockEntityConveyor(String name) {
        super(Material.rock);
        setBlockName(name);
	}

	@Override
	public String getUnlocalizedName() {
		return "enfusion." + super.getUnlocalizedName();
	}

	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister iconRegister) {
		this.blockIcon = iconRegister.registerIcon(EnFusion.modId + ":machine/conveyor/entity");
		this.iconSide = iconRegister.registerIcon(EnFusion.modId + ":machine/conveyor/side");
		this.iconTop = iconRegister.registerIcon(EnFusion.modId + ":machine/conveyor/top");
	}

	@SideOnly(Side.CLIENT)
	public IIcon getIcon(IBlockAccess iba, int x, int y, int z, int intSide) {
		ForgeDirection side = ForgeDirection.getOrientation(intSide);
		if (side == ForgeDirection.UP) {
			return this.iconTop;
		} else {
			int metadata = iba.getBlockMetadata(x, y, z);
			if (intSide == metadata || intSide == ForgeDirection.OPPOSITES[metadata]) {
				return this.blockIcon;
			} else {
				return this.iconSide;
			}
		}
	}

	@SideOnly(Side.CLIENT)
	public Item getItem(World world, int x, int y, int z) {
		return Item.getItemFromBlock(EFBlocks.entityConveyor);
	}

	public TileEntity createNewTileEntity(World world, int metadata) {
		return new TileEntityEntityConveyor();
	}

	public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entity, ItemStack stack) {
		int l = MathHelper.floor_double(entity.rotationYaw * 4f / 360f + 0.5d) & 0x3;
		if (l == 0) {
			world.setBlockMetadataWithNotify(x, y, z, 2, 2);
		}
		if (l == 1) {
			world.setBlockMetadataWithNotify(x, y, z, 5, 2);
		}
		if (l == 2) {
			world.setBlockMetadataWithNotify(x, y, z, 3, 2);
		}
		if (l == 3) {
			world.setBlockMetadataWithNotify(x, y, z, 4, 2);
		}
	}

}
