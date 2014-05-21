package com.ilexiconn.fossils.network.client;

import com.ilexiconn.fossils.Fossils;
import com.ilexiconn.fossils.network.ServerProxy;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;

public class ClientProxy extends ServerProxy
{
    public void renderEntity()
    {
        RenderingRegistry.registerEntityRenderingHandler(Fossils.instance.getEntityToRender(), Fossils.instance.getEntityRenderer());
    }

    public void renderTileEntity()
    {
        ClientRegistry.bindTileEntitySpecialRenderer(Fossils.instance.getTileEntityToRender(), Fossils.instance.getTileEntityRenderer());
    }
}
