package com.perrybmw.solarmod.block;

import net.minecraft.block.ITileEntityProvider;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import com.perrybmw.solarmod.tileentities.TileBasicSolar;

public class BlockBasicSolar extends BlockSolarMod implements ITileEntityProvider
{
	public BlockBasicSolar()
	{
		super();
		setBlockName("basicsolar");
		setBlockTextureName("basicsolar");
	}

	@Override
	public TileEntity createNewTileEntity(World p_149915_1_, int p_149915_2_)
	{
		return new TileBasicSolar();
	}
}
