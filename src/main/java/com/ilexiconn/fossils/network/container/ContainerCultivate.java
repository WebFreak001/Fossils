package com.ilexiconn.fossils.network.container;

import com.ilexiconn.fossils.data.tile.TileCultivate;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;

public class ContainerCultivate extends Container
{
    public ContainerCultivate(InventoryPlayer inventory, TileCultivate tileEntity)
    {
    }

    public boolean canInteractWith(EntityPlayer var1)
    {
        return true;
    }
}
