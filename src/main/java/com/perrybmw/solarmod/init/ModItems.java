package com.perrybmw.solarmod.init;

import com.perrybmw.solarmod.item.ItemSolarCore;
import com.perrybmw.solarmod.item.ItemSolarMod;
import com.perrybmw.solarmod.reference.Reference;
import cpw.mods.fml.common.registry.GameRegistry;

@GameRegistry.ObjectHolder(Reference.MOD_ID)
public class ModItems {

    public static final ItemSolarMod SolarCore = new ItemSolarCore();

    public static void init(){

        GameRegistry.registerItem(SolarCore,  "SolarCore");

    }

}
