package net.shadowfacts.enfusion;

import net.shadowfacts.enfusion.block.EFBlockTextures;
import net.shadowfacts.enfusion.block.EFBlocks;
import nova.core.block.BlockManager;
import nova.core.item.ItemManager;
import nova.core.loader.Loadable;
import nova.core.loader.NovaMod;
import nova.core.nativewrapper.NativeManager;
import nova.core.render.RenderManager;

/**
 * Main mod class
 * @author shadowfacts
 */
@NovaMod(id = EnFusion.id, name = EnFusion.name, version = EnFusion.version, novaVersion = EnFusion.novaVersion, description = EnFusion.description)
public class EnFusion implements Loadable {

	public static final String id = "enfusion";
	public static final String name = "EnFusion";
	public static final String version = "0.1.0";
	public static final String novaVersion = "0.0.1";
	public static final String description = "EnFusion is a mod primarily focusing on complex and unique technological expansion.";

	public final BlockManager blockManager;
	public final ItemManager itemManager;
	public final RenderManager renderManager;
	public final NativeManager nativeManager;

	public static EFBlocks blocks;
	public static EFBlockTextures blockTextures;

	public EnFusion(BlockManager blockManager, ItemManager itemManager, RenderManager renderManager, NativeManager nativeManager) {
		this.blockManager = blockManager;
		this.itemManager = itemManager;
		this.renderManager = renderManager;
		this.nativeManager = nativeManager;

		blocks = new EFBlocks();
		blockTextures = new EFBlockTextures();
	}

	@Override
	public void preInit() {
		blocks.registerBlocks(blockManager);
		blockTextures.registerTextures(renderManager);
	}
}
