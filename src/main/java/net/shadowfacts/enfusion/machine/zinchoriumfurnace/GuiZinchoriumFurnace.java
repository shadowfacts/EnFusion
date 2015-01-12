package net.shadowfacts.enfusion.machine.zinchoriumfurnace;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import net.shadowfacts.enfusion.EnFusion;
import org.lwjgl.opengl.GL11;

/**
 * GUI for the Zinchorium Furnace
 * @author shadowfacts
 */
public class GuiZinchoriumFurnace extends GuiContainer {

	public static final ResourceLocation bg = new ResourceLocation(EnFusion.modId + ":textures/gui/zinchorium_furnace.png");

	public TileEntityZinchoriumFurnace te;

	public GuiZinchoriumFurnace(InventoryPlayer inventoryPlayer, TileEntityZinchoriumFurnace te) {
		super(new ContainerZinchoriumFurnace(inventoryPlayer, te));

		this.te = te;

		this.xSize = 176;
		this.ySize = 166;
	}

	public void drawGuiContainerForegroundLayer(int i, int j) {
		this.fontRendererObj.drawString(this.te.getInventoryName(), 8, 6, 4210752);
		this.fontRendererObj.drawString(I18n.format("container.inventory", new Object[0]), 8, this.ySize - 96 + 2, 4210752);
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float i, int j, int k) {
		GL11.glColor4f(1f, 1f, 1f, 1f);

		Minecraft.getMinecraft().getTextureManager().bindTexture(bg);
		drawTexturedModalRect(guiLeft, guiTop, 0, 0, xSize, ySize);

		if (this.te.isBurning()) {
			int m = this.te.getBurnTimeRemainingScaled(14);
			int l = 14 - m;
			drawTexturedModalRect(guiLeft + 57, guiTop + 36 + l, 176, 17 + l, 14, 14 - l);
		}

		int m = this.te.getCookProgressScaled(24);
		drawTexturedModalRect(guiLeft + 79, guiTop + 34, 176, 0, m + 1, 16);

	}

}
