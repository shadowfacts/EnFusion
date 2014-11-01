package net.shadowfacts.enfusion.client.gui.container;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import net.shadowfacts.enfusion.EnFusion;
import net.shadowfacts.enfusion.container.ContainerFluxFurnace;
import net.shadowfacts.enfusion.tileentity.TileEntityFluxFurnace;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class GuiFluxFurnace extends GuiContainer
{
    private static final ResourceLocation furnaceGuiTextures = new ResourceLocation(EnFusion.modId + ":textures/gui/container/fluxFurnace.png");
    private TileEntityFluxFurnace tileFluxFurnace;
    
    public GuiFluxFurnace(InventoryPlayer par1, TileEntityFluxFurnace par2)
    {
        super(new ContainerFluxFurnace(par1, par2));
        this.tileFluxFurnace = par2;
    }
    
    protected void drawGuiContainerForegroundLayer(int p_drawGuiContainerForegroundLayer_1_, int p_drawGuiContainerForegroundLayer_2_)
    {
        String str = this.tileFluxFurnace.hasCustomInventoryName() ? this.tileFluxFurnace.getInventoryName() : I18n.format(this.tileFluxFurnace.getInventoryName(), new Object[0]);
        this.fontRendererObj.drawString(str, this.xSize / 2 - this.fontRendererObj.getStringWidth(str) / 2, 6, 4210752);
        
        this.fontRendererObj.drawString(I18n.format("container.inventory", new Object[0]), 8, this.ySize - 96 + 2, 4210752);
    }
    
    protected void drawGuiContainerBackgroundLayer(float p_drawGuiContainerBackgroundLayer_1_, int p_drawGuiContainerBackgroundLayer_2_, int p_drawGuiContainerBackgroundLayer_3_)
    {
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        this.mc.getTextureManager().bindTexture(furnaceGuiTextures);
        int i = (this.width - this.xSize) / 2;
        int j = (this.height - this.ySize) / 2;
        drawTexturedModalRect(i, j, 0, 0, this.xSize, this.ySize);
        if (this.tileFluxFurnace.isBurning())
        {
            int k = this.tileFluxFurnace.getBurnTimeRemainingScaled(13);
            drawTexturedModalRect(i + 56, j + 36 + 12 - k, 176, 12 - k, 14, k + 1);
            k = this.tileFluxFurnace.getCookProgressScaled(24);
            drawTexturedModalRect(i + 79, j + 34, 176, 14, k + 1, 16);
        }
    }
}
