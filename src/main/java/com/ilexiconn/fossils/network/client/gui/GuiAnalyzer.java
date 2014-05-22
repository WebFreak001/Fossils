package com.ilexiconn.fossils.network.client.gui;

import com.ilexiconn.fossils.data.tile.TileAnalyzer;
import com.ilexiconn.fossils.network.container.ContainerAnalyzer;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;

public class GuiAnalyzer extends GuiContainer
{
    public GuiAnalyzer(InventoryPlayer inventory, TileAnalyzer tileEntity)
    {
        super(new ContainerAnalyzer(inventory, tileEntity));
    }

    public void drawGuiContainerForegroundLayer(int i, int d)
    {

    }

    public void drawGuiContainerBackgroundLayer(float i, int d, int k)
    {

    }
}
