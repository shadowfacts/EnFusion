package net.shadowfacts.enfusion.machine.generator.solar;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;
import net.shadowfacts.shadowcore.block.BaseTileEntityBlock;
import net.shadowfacts.shadowcore.debug.IDebuggable;
import net.shadowfacts.shadowcore.util.StringHelper;

import java.util.ArrayList;

/**
 * The solar panel block.
 * @author shadowfacts
 */
public class BlockSolarPanel extends BaseTileEntityBlock implements IDebuggable {

	protected final int maxEnergyGeneration;
	protected final int maxEnergyTransfer;
	protected final int capacity;
	private IIcon sideIcon;

	public BlockSolarPanel(String blockName, int maxEnergyGeneration, int capacity) {
		super(blockName);
		this.maxEnergyGeneration = maxEnergyGeneration;
		this.maxEnergyTransfer = maxEnergyGeneration * 8;
		this.capacity = capacity;

		// Rendering
		setBlockBounds(0.0f, 0.0f, 0.0f, 1.0f, 0.2f, 1.0f);
		setLightOpacity(255);
		useNeighborBrightness = true;
	}

	@Override
	public boolean renderAsNormalBlock() {
		return false;
	}

	@Override
	public boolean isOpaqueCube() {
		return false;
	}

	public int getMaximumEnergyGeneration() {
		return this.maxEnergyGeneration;
	}

	public int getMaximumEnergyTransfer() {
		return this.maxEnergyTransfer;
	}

	public int getEnergyCapacity() {
		return this.capacity;
	}


//	ITileEntityProvider
	@Override
	public TileEntity createNewTileEntity(World world, int metadata) {
		return new TileEntitySolarPanel(maxEnergyGeneration, maxEnergyTransfer, capacity);
	}

//	Block
	@Override
	public IIcon getIcon(int side, int metadata) {
		if (ForgeDirection.getOrientation(side) == ForgeDirection.UP) {
			return super.getIcon(side, metadata);
		}
		return sideIcon;
	}

	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float x2, float y2, float z2) {
		if (!world.isRemote && !player.isSneaking()) {
			displayChatInformation(world, x, y, z, player);
			return true;
		}
		return false;
	}

	private void displayChatInformation(World world, int x, int y, int z, EntityPlayer player) {
		TileEntity te = world.getTileEntity(x, y, z);
		if (te instanceof TileEntitySolarPanel && te != null) {
			TileEntitySolarPanel solarPanel = (TileEntitySolarPanel)te;
			StringBuilder msg1 = new StringBuilder();
			msg1.append("Energy Stored: ");
			msg1.append(solarPanel.getEnergyStored());
			msg1.append(" / ");
			msg1.append(solarPanel.getMaxEnergyStored());
			msg1.append(String.format(" RF (%d%%)", solarPanel.getPercentageEnergyStored()));

			StringBuilder msg2 = new StringBuilder();
			msg2.append("Generating: ");
			msg2.append(solarPanel.getEnergyProduced());
			msg2.append(" RF/t");

			player.addChatMessage(new ChatComponentText(msg1.toString()));
			player.addChatMessage(new ChatComponentText(msg2.toString()));
		}
	}

	@Override
	public void registerBlockIcons(IIconRegister iconRegister) {
		super.registerBlockIcons(iconRegister);
		sideIcon = iconRegister.registerIcon(this.getTextureName() + "_side");
	}

//	IDebuggable
	public ArrayList<String> getDebugInfo() {

		ArrayList<String> list = new ArrayList<String>();

		StringBuilder msg1 = new StringBuilder();
		msg1.append(StringHelper.BRIGHT_GREEN + "Energy Stored" + StringHelper.WHITE + ": ");


		return list;

	}

}
