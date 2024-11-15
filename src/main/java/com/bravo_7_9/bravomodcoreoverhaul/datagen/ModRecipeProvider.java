package com.bravo_7_9.bravomodcoreoverhaul.datagen;

import com.bravo_7_9.bravomodcoreoverhaul.item.ModItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapelessRecipeBuilder;
import net.minecraft.world.item.Items;
import net.neoforged.neoforge.common.conditions.IConditionBuilder;

import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public ModRecipeProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries);
    }

    @Override
    protected void buildRecipes(RecipeOutput recipeOutput) {
        ShapelessRecipeBuilder.shapeless(RecipeCategory.COMBAT, ModItems.BAMBOO_BARE_SHAFT, 1)
                .requires(Items.BAMBOO).requires(Items.FLINT)
                .unlockedBy("has_bamboo", has(Items.BAMBOO)).save(recipeOutput);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.COMBAT, ModItems.WOOD_BARE_SHAFT,1)
                .requires(Items.STICK).requires(Items.FLINT)
                .unlockedBy("has_stick", has(Items.STICK)).save(recipeOutput);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.COMBAT, ModItems.BAMBOO_FEATHER_FLETCHED_SHAFT,1)
                .requires(ModItems.BAMBOO_BARE_SHAFT).requires(Items.FEATHER)
                .unlockedBy("has_bamboo_bare_shaft", has(ModItems.BAMBOO_BARE_SHAFT)).save(recipeOutput);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.COMBAT, ModItems.WOOD_FEATHER_FLETCHED_SHAFT,1)
                .requires(ModItems.WOOD_FEATHER_FLETCHED_SHAFT).requires(Items.FEATHER)
                .unlockedBy("has_wood_bare_shaft", has(ModItems.WOOD_BARE_SHAFT)).save(recipeOutput);

    }
}
