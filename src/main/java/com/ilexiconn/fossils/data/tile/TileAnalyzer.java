package com.ilexiconn.fossils.data.tile;

import com.ilexiconn.fossils.Util;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;

import java.util.ArrayList;

public class TileAnalyzer extends TileEntity implements ISidedInventory
{
    public ArrayList<Item> dnas = new ArrayList<Item>();

    public int[] slots_top = new int[] {}; // input
    public int[] slots_bottom = new int[] {10, 11, 12}; // output
    public int[] slots_sides = new int[] {0, 1, 2, 3, 4, 5, 6, 7, 8}; // fuel

    public int analyzerBurnTime = 0;
    public int currentItemBurnTime = 100;
    public int analyzerCookTime = 0;

    public ItemStack[] stack = new ItemStack[13];

    public TileAnalyzer()
    {
        dnas.add(Util.getItem(0));
    }

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
        return this.worldObj.getTileEntity(this.xCoord, this.yCoord, this.zCoord) == this && var1.getDistanceSq((double) this.xCoord + 0.5D, (double) this.yCoord + 0.5D, (double) this.zCoord + 0.5D) <= 64.0D;
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

    public int[] getAccessibleSlotsFromSide(int par1)
    {
        return par1 == 0 ? slots_bottom : (par1 == 1 ? slots_top : slots_sides);
    }

    public boolean canInsertItem(int var1, ItemStack var2, int var3)
    {
        return this.isItemValidForSlot(var1, var2);
    }

    public boolean canExtractItem(int var1, ItemStack var2, int var3)
    {
        return var3 != 0 || var1 != 1 || var2.getItem() == Items.bucket;
    }

    public void readFromNBT(NBTTagCompound compound)
    {
        super.readFromNBT(compound);
        NBTTagList nbttaglist = compound.getTagList("Items", 10);
        stack = new ItemStack[getSizeInventory()];

        for (int i = 0; i <  nbttaglist.tagCount(); ++i)
        {
            NBTTagCompound var4 = nbttaglist.getCompoundTagAt(i);
            byte var5 = var4.getByte("Slot");

            if (var5 >= 0 && var5 < stack.length)
                stack[var5] = ItemStack.loadItemStackFromNBT(var4);
        }

        analyzerBurnTime = compound.getShort("BurnTime");
        analyzerCookTime = compound.getShort("CookTime");
        currentItemBurnTime = 100;
    }

    public void writeToNBT(NBTTagCompound compound)
    {
        super.writeToNBT(compound);
        compound.setShort("BurnTime", (short) analyzerBurnTime);
        compound.setShort("CookTime", (short) analyzerCookTime);
        NBTTagList tagList = new NBTTagList();

        for (int i = 0; i < stack.length; i++)
        {
            if (stack[i] != null)
            {
                NBTTagCompound slotCompound = new NBTTagCompound();
                slotCompound.setByte("Slot", (byte) i);
                stack[i].writeToNBT(slotCompound);
                tagList.appendTag(slotCompound);
            }
        }

        compound.setTag("Items", tagList);
    }
}
