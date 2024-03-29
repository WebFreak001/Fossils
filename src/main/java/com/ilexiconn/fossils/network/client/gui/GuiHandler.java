package com.ilexiconn.fossils.network.client.gui;

import com.ilexiconn.fossils.data.tile.TileAnalyzer;
import com.ilexiconn.fossils.data.tile.TileCultivate;
import com.ilexiconn.fossils.network.container.ContainerAnalyzer;
import com.ilexiconn.fossils.network.container.ContainerCultivate;
import cpw.mods.fml.common.network.IGuiHandler;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class GuiHandler implements IGuiHandler
{
    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
    {
        TileEntity tileEntity = world.getTileEntity(x, y, z);
        if (tileEntity instanceof TileCultivate) return new ContainerCultivate(player.inventory, (TileCultivate) tileEntity);
        if (tileEntity instanceof TileAnalyzer) return new ContainerAnalyzer(player.inventory, (TileAnalyzer) tileEntity);
        return null;
    }

    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
    {
        TileEntity tileEntity = world.getTileEntity(x, y, z);
        if (tileEntity instanceof TileCultivate) return new GuiCultivate(player.inventory, (TileCultivate) tileEntity);
        if (tileEntity instanceof TileAnalyzer) return new GuiAnalyzer(player.inventory, (TileAnalyzer) tileEntity);
        return null;
    }
}
