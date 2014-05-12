package com.fossils.ilexiconn.block.tileentity;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;

public class TileCultivateData extends TileCultivate implements IInventory
{
    public int getSizeInventory()
    {
        return 0;
    }

    public ItemStack getStackInSlot(int slot)
    {
        return null;
    }

    public ItemStack decrStackSize(int slot, int id)
    {
        return null;
    }

    public ItemStack getStackInSlotOnClosing(int slot)
    {
        return null;
    }

    public void setInventorySlotContents(int slot, ItemStack itemStack)
    {

    }

    public String getInventoryName()
    {
        return null;
    }

    public boolean hasCustomInventoryName()
    {
        return false;
    }

    public int getInventoryStackLimit()
    {
        return 64;
    }

    public boolean isUseableByPlayer(EntityPlayer entityPlayer)
    {
        return false;
    }

    public void openInventory()
    {

    }

    public void closeInventory()
    {

    }

    public boolean isItemValidForSlot(int slot, ItemStack itemStack)
    {
        return false;
    }
}
