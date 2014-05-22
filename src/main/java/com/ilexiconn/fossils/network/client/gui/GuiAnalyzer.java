package com.ilexiconn.fossils.network.client.gui;

import com.ilexiconn.fossils.Util;
import com.ilexiconn.fossils.data.tile.TileAnalyzer;
import com.ilexiconn.fossils.network.container.ContainerAnalyzer;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;
import org.lwjgl.opengl.GL11;

public class GuiAnalyzer extends GuiContainer
{
    public GuiAnalyzer(InventoryPlayer inventory, TileAnalyzer tileEntity)
    {
        super(new ContainerAnalyzer(inventory, tileEntity));
    }

    public void drawGuiContainerForegroundLayer(int i, int d)
    {
        fontRendererObj.drawString("Analyzer", 8, 6, 4210752);
        fontRendererObj.drawString(StatCollector.translateToLocal("container.inventory"), 8, 72, 4210752);
    }

    public void drawGuiContainerBackgroundLayer(float i, int d, int k)
    {
        GL11.glColor4f(1f, 1f, 1f, 1f);
        mc.renderEngine.bindTexture(new ResourceLocation(Util.getModId() + "textures/gui/guiAnalyzer.png"));
        int x = (width / xSize) / 2;
        int y = (height / ySize) / 2;
        drawTexturedModalRect(x, y, 0, 0, xSize, ySize);
    }
}
