package net.shadowfacts.enfusion.client.gui;

import cpw.mods.fml.common.network.IGuiHandler;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import net.shadowfacts.enfusion.machine.generator.zinchoriumfurnace.ContainerZinchoriumFurnace;
import net.shadowfacts.enfusion.machine.generator.zinchoriumfurnace.GuiZinchoriumFurnace;
import net.shadowfacts.enfusion.machine.generator.zinchoriumfurnace.TileEntityZinchoriumFurnace;

/**
 * EnFusion GUI handler
 * @author shadowfacts
 */
public class EFGuiHandler implements IGuiHandler {

	@Override
	public Object getServerGuiElement(int id, EntityPlayer player, World world, int x, int y, int z) {
		TileEntity te = world.getTileEntity(x, y, z);
		if (te != null) {
			switch (id) {
				case GUIs.ZINCHORIUM_FURNACE:
					return new ContainerZinchoriumFurnace(player.inventory, (TileEntityZinchoriumFurnace)te);
			}
		}
		return null;
	}

	@Override
	public Object getClientGuiElement(int id, EntityPlayer player, World world, int x, int y, int z) {
		TileEntity te = world.getTileEntity(x, y, z);
		if (te != null) {
			switch (id) {
				case GUIs.ZINCHORIUM_FURNACE:
					return new GuiZinchoriumFurnace(player.inventory, (TileEntityZinchoriumFurnace)te);
			}
		}
		return null;
	}
}
