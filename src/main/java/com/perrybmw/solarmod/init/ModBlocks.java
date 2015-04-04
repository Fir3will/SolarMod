package com.perrybmw.solarmod.init;

import com.perrybmw.solarmod.block.BlockBasicSolar;
import com.perrybmw.solarmod.block.BlockSolarMod;
import com.perrybmw.solarmod.reference.Reference;
import cpw.mods.fml.common.registry.GameRegistry;

@GameRegistry.ObjectHolder(Reference.MOD_ID)
public class ModBlocks {

    public static final BlockSolarMod basicsolar = new BlockBasicSolar();

    public static void init(){

        GameRegistry.registerBlock(basicsolar, "basicsolar");

    }

}
