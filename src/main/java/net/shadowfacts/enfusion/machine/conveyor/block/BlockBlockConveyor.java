//package net.shadowfacts.enfusion.machine.conveyor.block;
//
//import cpw.mods.fml.relauncher.Side;
//import cpw.mods.fml.relauncher.SideOnly;
//
//import net.minecraft.block.material.Material;
//import net.minecraft.client.renderer.texture.IIconRegister;
//import net.minecraft.util.IIcon;
//
//import net.minecraft.world.IBlockAccess;
//import net.minecraftforge.common.util.ForgeDirection;
//import net.shadowfacts.enfusion.EnFusion;
//import net.shadowfacts.shadowcore.block.BaseTileEntityBlock;
//
///**
// * The Block class for the Block Conveyor.
// * NOTE: The class name "BlockBlockConveyor" is not a typo, it is correct.
// * @author shadowfacts
// */
//public class BlockBlockConveyor extends BaseTileEntityBlock {
//
//	@SideOnly(Side.CLIENT)
//	private IIcon iconSide;
//	@SideOnly(Side.CLIENT)
//	private IIcon iconTop;
//
//	public BlockBlockConveyor(String name) {
//		super(name, Material.piston);
//	}
//
//	@SideOnly(Side.CLIENT)
//	public void registerBlockIcons(IIconRegister iconRegister) {
//		this.blockIcon = iconRegister.registerIcon(EnFusion.modId + ":machine/conveyor/block");
//		this.iconSide = iconRegister.registerIcon(EnFusion.modId + ":machine/conveyor/side");
//		this.iconTop = iconRegister.registerIcon(EnFusion.modId + ":machine/conveyor/top");
//
//	}
//
//	@SideOnly(Side.CLIENT)
//	public IIcon getIcon(IBlockAccess iba, int x, int y, int z, int intSide) {
//		ForgeDirection side = ForgeDirection.getOrientation(intSide);
//		if (side == ForgeDirection.UP) {
//			return this.iconTop;
//		} else {
//			int metadata = iba.getBlockMetadata(x, y, z);
//			if (intSide == metadata || intSide == ForgeDirection.OPPOSITES[metadata]) {
//				return this.blockIcon;
//			} else {
//				return this.iconSide;
//			}
//		}
//	}
//
//}
