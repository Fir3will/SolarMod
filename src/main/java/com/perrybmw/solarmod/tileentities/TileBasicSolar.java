package com.perrybmw.solarmod.tileentities;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.util.ForgeDirection;
import cofh.api.energy.EnergyStorage;
import cofh.api.energy.IEnergyProvider;
import cofh.api.energy.IEnergyReceiver;

public class TileBasicSolar extends TileEntity implements IEnergyProvider
{
	protected EnergyStorage storage = new EnergyStorage(80000, 40);

	@Override
	public void updateEntity()
	{
		storage.receiveEnergy(powerCreated(), false);
		sendNearby();
	}

	private void sendNearby()
	{
		Map<ForgeDirection, IEnergyReceiver> receivers = new HashMap<ForgeDirection, IEnergyReceiver>();
		for (ForgeDirection d : ForgeDirection.VALID_DIRECTIONS)
		{
			TileEntity tile = worldObj.getTileEntity(xCoord + d.offsetX, yCoord + d.offsetY, zCoord + d.offsetZ);
			if (tile != null && tile instanceof IEnergyReceiver && ((IEnergyReceiver) tile).canConnectEnergy(d.getOpposite()) && canConnectEnergy(d)) receivers.put(d.getOpposite(), (IEnergyReceiver) tile);
		}
		for (Entry<ForgeDirection, IEnergyReceiver> entry : receivers.entrySet())
		{
			ForgeDirection d = entry.getKey();
			IEnergyReceiver rec = entry.getValue();
			int i = getEnergyStored(ForgeDirection.UNKNOWN) / receivers.size();
			i = rec.receiveEnergy(d, i, true);
			i = extractEnergy(d.getOpposite(), i, false);
			rec.receiveEnergy(d, i, false);
		}
	}

	public int powerCreated()
	{
		return worldObj.canBlockSeeTheSky(xCoord, yCoord, zCoord) && worldObj.isDaytime() ? 16 : 0;
	}

	@Override
	public void readFromNBT(NBTTagCompound nbt)
	{
		super.readFromNBT(nbt);
		storage.readFromNBT(nbt);
	}

	@Override
	public void writeToNBT(NBTTagCompound nbt)
	{
		super.writeToNBT(nbt);
		storage.writeToNBT(nbt);
	}

	/* IEnergyConnection */
	@Override
	public boolean canConnectEnergy(ForgeDirection from)
	{
		return from != ForgeDirection.UP; // This means from all sides except the top
	}

	/* IEnergyProvider */
	@Override
	public int extractEnergy(ForgeDirection from, int maxExtract, boolean simulate)
	{
		return storage.extractEnergy(maxExtract, simulate);
	}

	/* IEnergyReceiver and IEnergyProvider */
	@Override
	public int getEnergyStored(ForgeDirection from)
	{
		return storage.getEnergyStored();
	}

	@Override
	public int getMaxEnergyStored(ForgeDirection from)
	{
		return storage.getMaxEnergyStored();
	}
}