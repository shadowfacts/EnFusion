package net.shadowfacts.enfusion;

import net.shadowfacts.enfusion.client.EFBlockTextures;
import net.shadowfacts.enfusion.block.EFBlocks;
import net.shadowfacts.enfusion.client.EFItemTextures;
import net.shadowfacts.enfusion.item.EFItems;
import net.shadowfacts.enfusion.recipes.EFRecipes;
import nova.core.block.BlockManager;
import nova.core.item.ItemManager;
import nova.core.loader.Loadable;
import nova.core.loader.NovaMod;
import nova.core.nativewrapper.NativeManager;
import nova.core.network.NetworkManager;
import nova.core.recipes.RecipeManager;
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

	public static BlockManager blockManager;
	public static ItemManager itemManager;
	public static RenderManager renderManager;
	public static NativeManager nativeManager;
	public static NetworkManager networkManager;
	public static RecipeManager recipeManager;

	public static EFBlocks blocks;
	public static EFBlockTextures blockTextures;

	public EnFusion(BlockManager blockManager, ItemManager itemManager, RenderManager renderManager, NativeManager nativeManager, NetworkManager networkManager, RecipeManager recipeManager) {
		EnFusion.blockManager = blockManager;
		EnFusion.itemManager = itemManager;
		EnFusion.renderManager = renderManager;
		EnFusion.nativeManager = nativeManager;
		EnFusion.networkManager = networkManager;
		EnFusion.recipeManager = recipeManager;

		blocks = new EFBlocks();
		blockTextures = new EFBlockTextures();
	}

	@Override
	public void preInit() {
		EFBlockTextures.registerTextures(renderManager);
		EFBlocks.registerBlocks(blockManager);

		EFItemTextures.registerTextures(renderManager);
		EFItems.registerItems(itemManager);

		EFRecipes.registerAll(recipeManager);
	}
}
