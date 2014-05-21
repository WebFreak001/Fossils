package com.ilexiconn.fossils.network.client.gui;

import com.ilexiconn.fossils.data.tile.TileCultivate;
import com.ilexiconn.fossils.network.container.ContainerCultivate;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;

public class GuiCultivate extends GuiContainer
{
    public GuiCultivate(InventoryPlayer inventory, TileCultivate tileEntity)
    {
        super(new ContainerCultivate(inventory, tileEntity));
    }

    public void drawGuiContainerForegroundLayer(int i, int d)
    {

    }

    public void drawGuiContainerBackgroundLayer(float i, int d, int k)
    {

    }
}
