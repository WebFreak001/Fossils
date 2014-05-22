package com.ilexiconn.fossils.data.tile;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;

public class TileAnalyzer extends TileEntity implements IInventory
{
    public ItemStack[] stack = new ItemStack[3];

    public int getSizeInventory()
    {
        return stack.length;
    }

    public ItemStack getStackInSlot(int slot)
    {
        return stack[slot];
    }

    public ItemStack decrStackSize(int slot, int size)
    {
        if (stack[slot] != null)
        {
            ItemStack itemstack;

            if (stack[slot].stackSize <= size)
            {
                itemstack = stack[slot];
                stack[slot] = null;
                return itemstack;
            }
            else
            {
                itemstack = stack[slot].splitStack(size);

                if (stack[slot].stackSize == 0)
                {
                    stack[slot] = null;
                }

                return itemstack;
            }
        }
        else
        {
            return null;
        }
    }

    public ItemStack getStackInSlotOnClosing(int slot)
    {
        if (stack[slot] != null)
        {
            ItemStack itemstack = this.stack[slot];
            stack[slot] = null;
            return itemstack;
        }
        else
        {
            return null;
        }
    }

    public void setInventorySlotContents(int slot, ItemStack itemStack)
    {
        stack[slot] = itemStack;

        if (itemStack != null && itemStack.stackSize > getInventoryStackLimit())
        {
            itemStack.stackSize = getInventoryStackLimit();
        }
    }

    public String getInventoryName()
    {
        return "Analyzer";
    }

    public boolean hasCustomInventoryName()
    {
        return false;
    }

    public int getInventoryStackLimit()
    {
        return 64;
    }

    public boolean isUseableByPlayer(EntityPlayer var1)
    {
        return true;
    }

    public void openInventory()
    {

    }

    public void closeInventory()
    {

    }

    public boolean isItemValidForSlot(int slot, ItemStack itemStack)
    {
        return true;
    }
}
