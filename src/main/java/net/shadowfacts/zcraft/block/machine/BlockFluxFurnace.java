//package net.shadowfacts.zcraft.block.machine;
//
//import java.util.Random;
//
//import net.minecraft.block.Block;
//import net.minecraft.block.ITileEntityProvider;
//import net.minecraft.block.material.Material;
//import net.minecraft.client.renderer.texture.IIconRegister;
//import net.minecraft.entity.EntityLivingBase;
//import net.minecraft.entity.item.EntityItem;
//import net.minecraft.entity.player.EntityPlayer;
//import net.minecraft.item.Item;
//import net.minecraft.item.ItemStack;
//import net.minecraft.nbt.NBTTagCompound;
//import net.minecraft.tileentity.TileEntity;
//import net.minecraft.util.IIcon;
//import net.minecraft.util.MathHelper;
//import net.minecraft.world.World;
//import net.shadowfacts.zcraft.ZCraft;
//import net.shadowfacts.zcraft.block.ZBlocks;
//import net.shadowfacts.zcraft.gui.GUIs;
//import net.shadowfacts.zcraft.tileentity.TileEntityFluxFurnace;
//import cpw.mods.fml.relauncher.Side;
//import cpw.mods.fml.relauncher.SideOnly;
//
//public class BlockFluxFurnace extends Block implements ITileEntityProvider {
//
//	@SideOnly(Side.CLIENT)
//	private IIcon front;
//	
//	// Furnace Status
//	private static boolean isBurning;
//	private final boolean isBurning2;
//	
//	private final Random random = new Random();
//	
//	
//	
//	public BlockFluxFurnace(boolean isActive) {
//		super(Material.rock);
//		isBurning2 = isActive;
//	}
//
//	/**
//	 * Create the TileEntity
//	 */
//	@Override
//	public TileEntity createNewTileEntity(World world, int par2) {
//		return new TileEntityFluxFurnace();
//	}
//	
//	/**
//	 * Register the icons for the block
//	 */
//	@SideOnly(Side.CLIENT)
//	public void registerIcons(IIconRegister iconRegistry) {
//		this.blockIcon = iconRegistry.registerIcon(ZCraft.modId + ":machine/fluxFurnace_side");
//		if (this.isBurning2) {
//			this.front = iconRegistry.registerIcon(ZCraft.modId + ":machine/fluxFurnace_front_active");
//		} else {
//			this.front = iconRegistry.registerIcon(ZCraft.modId + ":machine/fluxFurnace_front_idle");
//		}
//	}
//	
//	/**
//	 * The the icon that should be displayed
//	 */
//	@SideOnly(Side.CLIENT)
//	public IIcon getIcon(int side, int metadata) {
//		if (side == 3) {
//			return this.front;
//		} else {
//			return this.blockIcon;
//		}
//	}
//	
//	/**
//	 * What to do when the block is right clicked
//	 */
//	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int meta, float hitX, float hitY, float hitZ) {
//		if (world.isRemote) {
//			if (world.getTileEntity(x, y, z) != null) {
//				player.openGui(ZCraft.instance, GUIs.FLUX_FURNACE.ordinal(), world, x, y, z);
//			}
//		}
//		return true;
//	}
//	
//	/**
//	 * Get the item that the block should drop when broken with a pickaxe
//	 */
//	@Override
//	public Item getItemDropped(int par1, Random random, int par3) {
//		return Item.getItemFromBlock(ZBlocks.fluxFurnaceIdle);
//	}
//	
//	/**
//	 * What item should be used when player in creative mode middle-clicks the block
//	 */
//	@Override
//	public Item getItem(World world, int par2, int par3, int par4) {
//		return Item.getItemFromBlock(ZBlocks.fluxFurnaceIdle);
//	}
//	
//	/**
//	 * What to do when the block is placed
//	 */
//	@SideOnly(Side.CLIENT)
//	public void onBlockAdded(World world, int x, int y, int z) {
//		super.onBlockAdded(world, x, y, z);
//		this.direction(world, x, y, z);
//	}
//	
//	/**
//	 * Figure out which direction the block is facing
//	 */
//	private void direction(World world, int x, int y, int z) {
//		if (world.isRemote) {
//			Block direction = world.getBlock(x, y, z - 1);
//			Block direction1 = world.getBlock(x, y, z + 1);
//			Block direction2 = world.getBlock(x - 1, y, z);
//			Block direction3 = world.getBlock(x + 1, y, z);
//			
//			byte b0 = 3;
//			
//			if (direction.func_149730_j() && direction.func_149730_j()) {
//				b0 = 3;
//			}
//			if (direction1.func_149730_j() && direction1.func_149730_j()) {
//				b0 = 2;
//			}
//			if (direction2.func_149730_j() && direction2.func_149730_j()) {
//				b0 = 5;
//			}
//			if (direction3.func_149730_j() && direction3.func_149730_j()) {
//				b0 = 4;
//			}
//			
//			world.setBlockMetadataWithNotify(x, y, z, b0, 2);
//		}
//	}
//	
//	/**
//	 * What happens when the block is placed, set the direction that the block is facing.
//	 */
//	public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entity, ItemStack itemStack) {
//		int direction = MathHelper.floor_double((double)(entity.rotationYaw * 4.0f / 360.0f) + 0.5D) & 3;
//		
//		if (direction == 0) {
//			world.setBlockMetadataWithNotify(x, y, z, 2, 2);
//		}
//		if (direction == 1) {
//			world.setBlockMetadataWithNotify(x, y, z, 5, 2);
//		}
//		if (direction == 2) {
//			world.setBlockMetadataWithNotify(x, y, z, 3, 2);
//		}
//		if (direction == 3) {
//			world.setBlockMetadataWithNotify(x, y, z, 4, 2);
//		}
//		
//		if (itemStack.hasDisplayName()) {
//			((TileEntityFluxFurnace) world.getTileEntity(x, y, z)).furnaceName(itemStack.getDisplayName());
//		}
//	}
//	
//	/**
//	 * Update whether the furnace is burning or not.
//	 */
//	public static void updateBlockState(boolean burning, World world, int x, int y, int z) {
//		int direction = world.getBlockMetadata(x, y, z);
//		TileEntity tileEntity = world.getTileEntity(x, y, z);
//		isBurning = true;
//		
//		if (burning) {
//			world.setBlock(x, y, z, ZBlocks.fluxFurnaceActive);
//		} else {
//			world.setBlock(x, y, z, ZBlocks.fluxFurnaceIdle);
//		}
//		
//		isBurning = false;
//		
//		world.setBlockMetadataWithNotify(x, y, z, direction, 2);
//		
//		if (tileEntity != null) {
//			tileEntity.validate();
//			world.setTileEntity(x, y, z, tileEntity);
//		}
//	}
//	
//	/**
//	 * What happens when the block is broken.
//	 * Drop furnace and drop all items inside it.
//	 */
//	public void breakBlock(World world, int x, int y, int z, Block block, int meta) {
//		if (!isBurning) {
//			TileEntityFluxFurnace tileEntity = (TileEntityFluxFurnace)world.getTileEntity(x, y, z);
//			
//			if (tileEntity != null) {
//				for (int i = 0; i < tileEntity.getInventorySize(); i++) {
//					ItemStack itemStack = tileEntity.getStackInSlot(i);
//					if (itemStack != null) {
//						float f = this.random.nextFloat() * 0.6f + 0.1f; // x
//						float f1 = this.random.nextFloat() * 0.6f + 0.1f; // y
//						float f2 = this.random.nextFloat() * 0.6f + 0.1f; // z
//						
//						while (itemStack.stackSize > 0) {
//							int j = this.random.nextInt(21) + 10;
//							if (j > itemStack.stackSize) { // Make sure that the number of items that will be dropped is not greated than the number of items actually in the furnace
//								j = itemStack.stackSize;
//							}
//							
//							itemStack.stackSize -= j; // Remove that many items from the itemStack
//							
//							// Spawn items on ground
//							EntityItem entityItem = new EntityItem(world, (double)((float)x + f), (double)((float)y + f1), (double)((float)z + f2), new ItemStack(itemStack.getItem(), j, itemStack.getItemDamage()));
//							
//							if (itemStack.hasTagCompound()) {
//								entityItem.getEntityItem().setTagCompound((NBTTagCompound)itemStack.getTagCompound().copy());
//							}
//							
//							float f3 = 0.025f;
//							entityItem.motionX = (double) ((float)this.random.nextGaussian() * f3);
//							entityItem.motionY = (double) ((float)this.random.nextGaussian() * f3 + 0.1f);
//							entityItem.motionZ = (double) ((float)this.random.nextGaussian() * f3);
//							
//							world.spawnEntityInWorld(entityItem);
//						}
//					}
//				}
//				
//				world.func_147453_f(x, y, z, block);
//				
//			}
//		}
//		
//		super.breakBlock(world, x, y, z, block, meta);
//		
//	}
//	
//	/**
//	 * Display particle effects
//	 */
//	@SideOnly(Side.CLIENT)
//	public void randomDisplayTick(World world, int x, int y, int z, Random random) {
//		if (isBurning2) {
//			int direction = world.getBlockMetadata(x, y, z);
//			
//			float xx = (float)x + 0.5f;
//			float yy = (float)random.nextFloat() * 6.0f / 16.0f;
//			float zz = (float)z + 0.5f;
//			float xx2 = random.nextFloat() * 0.3f - 0.2f;
//			float zz2 = 0.5f;
//			
//			if (direction == 4) {
//				world.spawnParticle("smoke", (double)(xx - zz2), (double)yy, (double)(zz + xx2), 0.0f, 0.0f, 0.0f);
//				world.spawnParticle("flame", (double)(xx - zz2), (double)yy, (double)(zz + xx2), 0.0f, 0.0f, 0.0f);
//			} else if (direction == 5) {
//				world.spawnParticle("smoke", (double)(xx - zz2), (double)yy, (double)(zz + xx2), 0.0f, 0.0f, 0.0f);
//				world.spawnParticle("flame", (double)(xx - zz2), (double)yy, (double)(zz + xx2), 0.0f, 0.0f, 0.0f);
//			} else if (direction == 3) {
//				world.spawnParticle("smoke", (double)(xx - zz2), (double)yy, (double)(zz + xx2), 0.0f, 0.0f, 0.0f);
//				world.spawnParticle("flame", (double)(xx - zz2), (double)yy, (double)(zz + xx2), 0.0f, 0.0f, 0.0f);
//			} else if (direction == 2) {
//				world.spawnParticle("smoke", (double)(xx - zz2), (double)yy, (double)(zz + xx2), 0.0f, 0.0f, 0.0f);
//				world.spawnParticle("flame", (double)(xx - zz2), (double)yy, (double)(zz + xx2), 0.0f, 0.0f, 0.0f);
//			}
//			
//		}
//	}
//
//}
//
//
//
//
//
