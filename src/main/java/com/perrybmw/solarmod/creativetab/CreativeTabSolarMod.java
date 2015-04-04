package com.perrybmw.solarmod.creativetab;

import com.perrybmw.solarmod.init.ModItems;
import com.perrybmw.solarmod.reference.Reference;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class CreativeTabSolarMod {

    public static final CreativeTabs SolarMod_TAB = new CreativeTabs(Reference.MOD_ID.toLowerCase() ) {

        @Override

        public Item getTabIconItem() {

            return ModItems.SolarCore;

        }

    };

}
