package net.shadowfacts.enfusion.machine.grinder;

import net.shadowfacts.enfusion.EnFusion;
import net.shadowfacts.enfusion.client.EFBlockTextures;
import net.shadowfacts.enfusion.api.recipe.grinder.GrinderRecipe;
import nova.core.block.Block;
import nova.core.block.Stateful;
import nova.core.block.component.StaticBlockRenderer;
import nova.core.component.Category;
import nova.core.component.misc.Collider;
import nova.core.component.renderer.ItemRenderer;
import nova.core.entity.component.Player;
import nova.core.inventory.Inventory;
import nova.core.inventory.InventorySimple;
import nova.core.item.Item;
import nova.core.network.NetworkTarget.Side;
import nova.core.recipes.crafting.SpecificItemIngredient;
import nova.core.render.texture.Texture;
import nova.core.retention.Storable;
import nova.core.retention.Store;
import nova.core.util.Direction;

import java.util.Optional;

/**
 * @author shadowfacts
 */
public class BlockGrinder extends Block implements Storable, Stateful {

	@Store
	private Inventory inventory = new InventorySimple(1);

	@Store
	private String activeRecipe;

	public BlockGrinder() {
		add(new StaticBlockRenderer(this)).setTexture(this::getTexture);
		add(new ItemRenderer(this));
		add(new Collider());
		add(new Category(EnFusion.id + ".category.machines"));

		events.on(RightClickEvent.class).bind(this::onRightClick);
	}

	private Optional<Texture> getTexture(Direction dir) {
		return Optional.of(EFBlockTextures.grinderFront);
	}

	private void onRightClick(RightClickEvent event) {
//		if (NetworkTarget.Side.get().isServer())
		if (Side.get().isServer() &&
			!inventory.get(0).isPresent() &&
			event.entity.has(Player.class)) {

			Player player = event.entity.get(Player.class);
			if (player.getInventory().getHeldItem().isPresent()) {
				Item heldItem = player.getInventory().getHeldItem().get();
				EnFusion.recipeManager.getRecipes(GrinderRecipe.class).stream().filter(recipe ->
								recipe.input.equals(new SpecificItemIngredient(heldItem.getID()))
				).forEach(recipe -> {
					activeRecipe = recipe.getID();
					inventory.set(0, heldItem.clone());
					heldItem.setCount(heldItem.count() - 1);
					if (heldItem.count() <= 0) {
						player.getInventory().remove(player.getInventory().getHeldSlot());
					}
					event.result = true;
					System.out.println("Item: " + inventory.get(0));
					System.out.println("Recipe: " + activeRecipe);
					return;
				});
				System.out.println("For each ended.");
			}
		}
	}

	@Override
	public String getID() {
		return EnFusion.id + ".machine.grinder";
	}

	public Inventory getInventory() {
		return inventory;
	}
}
