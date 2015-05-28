package net.shadowfacts.enfusion.machine.zinchoriumfurnace;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.shadowfacts.enfusion.EnFusion;
import net.shadowfacts.enfusion.block.EFBlocks;
import net.shadowfacts.enfusion.client.gui.GUIs;

import java.util.Random;

/**
 * Block class for the flux furnace.
 * @author shadowfacts
 */
public class BlockZinchoriumFurnace extends BlockContainer {

	@SideOnly(Side.CLIENT)
	private IIcon iconTop;
	@SideOnly(Side.CLIENT)
	private IIcon iconFrontActive;
	@SideOnly(Side.CLIENT)
	private IIcon iconFrontIdle;

	public BlockZinchoriumFurnace(String blockName) {
		super(Material.rock);
        setBlockName(blockName);
	}

	@Override
	public String getUnlocalizedName() {
		return "enfusion." + super.getUnlocalizedName();
	}

	@SideOnly(Side.CLIENT)
	public Item getItem(World world, int x, int y, int z) {
		return Item.getItemFromBlock(EFBlocks.zinchoriumFurnace);
	}

	public void onBlockAdded(World world, int x, int y, int z) {
		super.onBlockAdded(world, x, y, z);
		if (!world.isRemote) {
			Block block = world.getBlock(x, y, z - 1);
			Block block1 = world.getBlock(x, y, z + 1);
			Block block2 = world.getBlock(x - 1, y, z);
			Block block3 = world.getBlock(x + 1, y, z);
			byte b0 = 3;
			if ((block.func_149730_j()) && (!block1.func_149730_j())) {
				b0 = 3;
			}
			if ((block1.func_149730_j()) && (!block.func_149730_j())) {
				b0 = 2;
			}
			if ((block2.func_149730_j()) && (!block3.func_149730_j())) {
				b0 = 5;
			}
			if ((block3.func_149730_j()) && (!block2.func_149730_j())) {
				b0 = 4;
			}
			world.setBlockMetadataWithNotify(x, y, z, b0, 2);
		}
	}

	@SideOnly(Side.CLIENT)
	public IIcon getIcon(IBlockAccess world, int x, int y, int z, int side) {
		if (side == world.getBlockMetadata(x, y, z)) {
			TileEntity tileEntity = world.getTileEntity(x, y, z);
			if (tileEntity instanceof TileEntityZinchoriumFurnace) {
				TileEntityZinchoriumFurnace te = (TileEntityZinchoriumFurnace)tileEntity;
				if (te.isBurning()) {
					return this.iconFrontActive;
				} else {
					return this.iconFrontIdle;
				}
			} else {
				return null;
			}
		} else {
			return this.blockIcon;
		}
	}

	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister registry) {
		this.blockIcon = registry.registerIcon(EnFusion.modId + ":machine/zinchoriumFurnace/base");
		this.iconFrontActive = registry.registerIcon(EnFusion.modId + ":machine/zinchoriumFurnace/front_active");
		this.iconFrontIdle = registry.registerIcon(EnFusion.modId + ":machine/zinchoriumFurnace/front_idle");
	}

	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int par6, float par7, float par8, float par9) {
		if (!world.isRemote) {
			player.openGui(EnFusion.instance, GUIs.ZINCHORIUM_FURNACE, world, x, y, z);
		}
		return true;
	}

	public TileEntity createNewTileEntity(World world, int metadata) {
		return new TileEntityZinchoriumFurnace();
	}

	public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entity, ItemStack stack) {
		int l = MathHelper.floor_double(entity.rotationYaw * 4.0f / 360.0f + 0.5d) & 0x3;
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

	public void breakBlock(World world, int x, int y, int z, Block block, int par6) {
		TileEntityZinchoriumFurnace te = (TileEntityZinchoriumFurnace)world.getTileEntity(x, y, z);
		if (te != null) {
			Random random = new Random();
			for (int i1 = 0; i1 < te.getSizeInventory(); i1++) {
				ItemStack stack = te.getStackInSlot(i1);
				if (stack != null) {
					float f = random.nextFloat() * 0.8f + 0.1f;
					float f1 = random.nextFloat() * 0.8f + 0.1f;
					float f2 = random.nextFloat() * 0.8f + 0.1f;
					while (stack.stackSize > 0) {
						int j1 = random.nextInt(21) + 10;
						if (j1 > stack.stackSize) {
							j1 = stack.stackSize;
						}
						stack.stackSize -= j1;
						EntityItem entityItem = new EntityItem(world, x + f, y + f1, z + f2, new ItemStack(stack.getItem(), j1, stack.getItemDamage()));
						if (stack.hasTagCompound()) {
							entityItem.getEntityItem().setTagCompound((NBTTagCompound)stack.getTagCompound().copy());
						}
						entityItem.motionX = ((float)random.nextGaussian() * 0.05f);
						entityItem.motionY = ((float)random.nextGaussian() * 0.05f + 0.2f);
						entityItem.motionZ = ((float)random.nextGaussian() * 0.05f);
						world.spawnEntityInWorld(entityItem);
					}
				}
			}
			world.func_147453_f(x, y, z, block);
		}
		super.breakBlock(world, x, y, z, block, par6);
	}

	@SideOnly(Side.CLIENT)
	public void randomDisplayTick(World world, int x, int y, int z, Random random) {
		if (world.getTileEntity(x, y, z) instanceof TileEntityZinchoriumFurnace) {
			TileEntityZinchoriumFurnace te = (TileEntityZinchoriumFurnace)world.getTileEntity(x, y, z);
			if (te.isBurning()) {
				int l = world.getBlockMetadata(x, y, z);
				float f = x + 0.5f;
				float f1 = y + random.nextFloat() * 6.0f / 16.0f;
				float f2 = z + 0.5f;
				float f3 = 0.52f;
				float f4 = random.nextFloat() * 0.6f - 0.3f;
				if (l == 4) {
					world.spawnParticle("smoke", f - f3, f1, f2 + f4, 0.0D, 0.0D, 0.0D);
					world.spawnParticle("flame", f - f3, f1, f2 + f4, 0.0D, 0.0D, 0.0D);
				} else if (l == 5) {
					world.spawnParticle("smoke", f + f3, f1, f2 + f4, 0.0D, 0.0D, 0.0D);
					world.spawnParticle("flame", f + f3, f1, f2 + f4, 0.0D, 0.0D, 0.0D);
				} else if (l == 2) {
					world.spawnParticle("smoke", f + f4, f1, f2 - f3, 0.0D, 0.0D, 0.0D);
					world.spawnParticle("flame", f + f4, f1, f2 - f3, 0.0D, 0.0D, 0.0D);
				} else if (l == 3) {
					world.spawnParticle("smoke", f + f4, f1, f2 + f3, 0.0D, 0.0D, 0.0D);
					world.spawnParticle("flame", f + f4, f1, f2 + f3, 0.0D, 0.0D, 0.0D);
				}
			}
		}
	}

}
