package com.perrybmw.solarmod.init;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.registry.GameRegistry;

public class Recipes
{
	public static void init()
	{
		GameRegistry.addRecipe(new ItemStack(ModItems.SolarCore), "iii", "iri", "iii", 'i', new ItemStack(Items.iron_ingot), 'r', new ItemStack(Items.redstone));
		GameRegistry.addShapelessRecipe(new ItemStack(ModBlocks.basicsolar), new ItemStack(ModItems.SolarCore), new ItemStack(ModItems.SolarCore), new ItemStack(ModItems.SolarCore), new ItemStack(ModItems.SolarCore));
	}
}
