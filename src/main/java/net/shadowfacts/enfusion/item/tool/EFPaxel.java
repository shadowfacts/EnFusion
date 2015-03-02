package net.shadowfacts.enfusion.item.tool;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTool;
import net.shadowfacts.enfusion.item.EFItems;
import scala.actors.threadpool.Arrays;

import java.util.HashSet;

/**
 * Paxel, acts as a pickaxe, axe, and shovel.
 * @author shadowfacts
 */
public class EFPaxel extends ItemTool {

	public EFPaxel(ToolMaterial material) {
		super(3, material, new HashSet<Block>(Arrays.asList(new Block[0])));
	}

	@Override
	public boolean getIsRepairable(ItemStack stack1, ItemStack stack2) {
		if (stack2.isItemEqual(getRepairStack(toolMaterial))) {
			return true;
		} else {
			return super.getIsRepairable(stack1, stack2);
		}
	}

	public static ItemStack getRepairStack(ToolMaterial material) {
		if (material == EFToolMaterials.ZINCHORIUM) {
			return new ItemStack(EFItems.zinchoriumAlloyIngot, 0, 1);
		} else {
			return new ItemStack(material.func_150995_f());
		}
	}

	@Override
	public float getDigSpeed(ItemStack stack, Block block, int metadata) {
		return block != Blocks.bedrock ? efficiencyOnProperMaterial: 1f;
	}

	@Override
	public boolean canHarvestBlock(Block block, ItemStack stack) {
		if (block == Blocks.obsidian) {
			return toolMaterial.getHarvestLevel() == 3;
		}

		if (block == Blocks.diamond_block || block == Blocks.diamond_ore ||
				block == Blocks.gold_block || block == Blocks.gold_ore ||
				block == Blocks.redstone_ore || block == Blocks.lit_redstone_ore) {
			return toolMaterial.getHarvestLevel() >= 2;
		}

		if (block == Blocks.iron_block || block == Blocks.iron_ore ||
				block == Blocks.lapis_block || block == Blocks.lapis_ore) {
			return toolMaterial.getHarvestLevel() >= 1;
		}

		if (block == Blocks.anvil) {
			return toolMaterial.getHarvestLevel() >= 0;
		}

		if (block == Blocks.snow || block == Blocks.snow_layer) {
			return true;
		}

		if (block.getMaterial() == Material.iron) {
			return true;
		}

		return block.getMaterial() == Material.rock;
	}

}
