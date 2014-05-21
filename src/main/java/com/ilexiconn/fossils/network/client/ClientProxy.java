package com.ilexiconn.fossils.network.client;

import com.ilexiconn.fossils.Util;
import com.ilexiconn.fossils.network.ServerProxy;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;

public class ClientProxy extends ServerProxy
{
    public void renderEntity()
    {
        RenderingRegistry.registerEntityRenderingHandler(Util.getEntityToRender(), Util.getEntityRenderer());
    }

    public void renderTileEntity()
    {
        ClientRegistry.bindTileEntitySpecialRenderer(Util.getTileEntityToRender(), Util.getTileEntityRenderer());
    }
}
