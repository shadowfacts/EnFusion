package net.shadowfacts.enfusion.client.gui;

import cpw.mods.fml.common.network.IGuiHandler;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.shadowfacts.enfusion.client.gui.machine.GuiFluxFurnace;

/**
 * @author shadowfacts
 */
public class EFGuiHandler implements IGuiHandler {

	@Override
	public Object getServerGuiElement(int id, EntityPlayer player, World world, int x, int y, int z) {
		return null;
	}

	@Override
	public Object getClientGuiElement(int id, EntityPlayer player, World world, int x, int y, int z) {
		if (id == GUIs.FLUX_FURNACE.ordinal()) {
//			return new GuiFluxFurnace(player, world, x, y, z);
		}
		return null;
	}
}
