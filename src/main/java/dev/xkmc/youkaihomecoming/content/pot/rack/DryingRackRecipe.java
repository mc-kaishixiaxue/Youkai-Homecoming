package dev.xkmc.youkaihomecoming.content.pot.rack;

import dev.xkmc.youkaihomecoming.init.registrate.YHBlocks;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.AbstractCookingRecipe;
import net.minecraft.world.item.crafting.CookingBookCategory;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;

public class DryingRackRecipe extends AbstractCookingRecipe {

	public DryingRackRecipe(ResourceLocation id, String group, CookingBookCategory category,
							Ingredient ingredient, ItemStack stack, float exp, int time) {
		super(YHBlocks.RACK_RT.get(), id, group, category, ingredient, stack, exp, time);
	}

	public ItemStack getToastSymbol() {
		return YHBlocks.RACK.asStack();
	}

	public RecipeSerializer<?> getSerializer() {
		return YHBlocks.RACK_RS.get();
	}
}