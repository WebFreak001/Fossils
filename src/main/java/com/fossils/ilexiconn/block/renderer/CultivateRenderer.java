package com.fossils.ilexiconn.block.renderer;

import com.fossils.core.Util;
import com.fossils.models.blocks.ModelCultivate;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

import static org.lwjgl.opengl.GL11.*;

public class CultivateRenderer extends TileEntitySpecialRenderer
{
    public boolean isActive;

    public CultivateRenderer(boolean active)
    {
        isActive = active;
    }

    public void renderTileEntityAt(TileEntity entity, double x, double y, double z, float scale)
    {
        glPushMatrix();
        glTranslatef((float) x + 0.5f, (float) y + 1.5f, (float) z + 0.5f);
        bindTexture(new ResourceLocation(Util.getModID() + "textures/blocks/cultivate_" + (isActive ? "active" : "idle") + ".png"));
        glRotatef(180.0f, 0.0f, 0.0f, 1.0f);
        new ModelCultivate().render();
        glPopMatrix();
    }
}
