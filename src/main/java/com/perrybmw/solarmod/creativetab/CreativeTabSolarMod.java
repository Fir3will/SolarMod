package com.perrybmw.solarmod.creativetab;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import com.perrybmw.solarmod.init.ModItems;
import com.perrybmw.solarmod.reference.Reference;

public class CreativeTabSolarMod
{
	public static final CreativeTabs SolarMod_TAB = new CreativeTabs(Reference.MOD_ID.toLowerCase())
	{
		@Override
		public Item getTabIconItem()
		{
			return ModItems.SolarCore;
		}
	};
}
