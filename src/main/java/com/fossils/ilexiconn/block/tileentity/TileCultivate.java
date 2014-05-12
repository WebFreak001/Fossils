package com.fossils.ilexiconn.block.tileentity;

import net.minecraft.block.Block;
import net.minecraft.tileentity.TileEntity;

public class TileCultivate extends TileEntity
{
    public Block getBlock()
    {
        return worldObj.getBlock(xCoord, yCoord + 1, zCoord);
    }
}
