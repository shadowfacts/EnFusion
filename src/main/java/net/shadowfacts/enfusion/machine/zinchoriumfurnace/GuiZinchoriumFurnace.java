package net.shadowfacts.enfusion.machine.zinchoriumfurnace;

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
	protected void drawGuiContainerBackgroundLayer(float f1, int i1, int i2) {
//		GL11.glColor4f(1f, 1f, 1f, 1f);
//
//		Minecraft.getMinecraft().getTextureManager().bindTexture(bg);
//		drawTexturedModalRect(guiLeft, guiTop, 0, 0, xSize, ySize);
//
////		Flame
//		if (this.te.isBurning()) {
//			int m = this.te.getBurnTimeRemainingScaled(14);
//			int l = 14 - m;
////			drawTexturedModalRect(guiLeft + 57, guiTop + 36 + l, 176, 30 + l, 14, 14 - l);
////			drawTexturedModalRect(guiLeft + 51, guiTop - 7 + l, );
//		}
//
//		System.out.println("guiTop: " + guiTop);
//
////		Progress arrow
//		int m = this.te.getCookProgressScaled(45);
//		drawTexturedModalRect(guiLeft + 79, guiTop + 36, 176, 16, m + 1, 16);

		GL11.glColor4f(1f, 1f, 1f, 1f);

		mc.getTextureManager().bindTexture(bg);

		int k = (width - xSize) / 2;
		int l = (height - ySize) / 2;

		drawTexturedModalRect(k, l, 0, 0, xSize, ySize);

		if (te.isBurning()) {
			int i3 = te.getBurnTimeRemainingScaled(13);
			drawTexturedModalRect(k + 56, l + 36 + 12 - i3, 176, 12 - i3, 14, i3 + 1);

			int i4 = te.getCookProgressScaled(24);
			drawTexturedModalRect(k + 79, l + 34, 176, 14, i4 + 1, 16);
		}

	}

}
