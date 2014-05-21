package com.ilexiconn.fossils;

import com.ilexiconn.fossils.network.ServerProxy;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.network.IGuiHandler;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLiving;
import net.minecraft.item.Item;
import net.minecraft.tileentity.TileEntity;

import java.util.ArrayList;

public class Util
{
    @SidedProxy(clientSide = "com.ilexiconn.fossils.network.client.ClientProxy", serverSide = "com.ilexiconn.fossils.network.ServerProxy")
    public static ServerProxy proxy;

    /** Stuff */
    private static CreativeTabs[] tabs = new CreativeTabs[512];
    private static Block[] blocks = new Block[512];
    private static Item[] items = new Item[512];

    /** Render Stuff */
    private static ArrayList<Class<? extends TileEntity>> tileEntityToRender = new ArrayList<Class<? extends TileEntity>>();
    private static ArrayList<TileEntitySpecialRenderer> tileEntityRenderer = new ArrayList<TileEntitySpecialRenderer>();
    private static ArrayList<Class<? extends EntityLiving>> entityToRender = new ArrayList<Class<? extends EntityLiving>>();
    private static ArrayList<RenderLiving> entityRenderer = new ArrayList<RenderLiving>();

    /** Adders */
    public void addCreativeTab(int id, CreativeTabs tab)
    {
        if (id != -1) tabs[id] = tab;
    }
    public void addBlock(int id, Block block)
    {
        if (id != -1) blocks[id] = block;
        GameRegistry.registerBlock(block, block.getClass().getSimpleName());
    }
    public void addItem(int id, Item item)
    {
        if (id != -1) items[id] = item;
        GameRegistry.registerItem(item, item.getClass().getSimpleName());
    }
    public void addBlockWithTileEntity(int id, BlockContainer block, Class<? extends TileEntity> tileEntity, boolean doRegister)
    {
        addBlock(id, block);
        if (doRegister) GameRegistry.registerTileEntity(tileEntity, tileEntity.getSimpleName());
    }
    public void addTileEntityRenderer(Class<? extends TileEntity> tileEntity, TileEntitySpecialRenderer renderer)
    {
        tileEntityToRender.clear();
        tileEntityToRender.add(tileEntity);
        tileEntityRenderer.clear();
        tileEntityRenderer.add(renderer);

        proxy.renderTileEntity();
    }
    public void addEntity(Class<? extends EntityLiving> entity, String name, RenderLiving renderer, int color1, int color2)
    {
        int entityId = EntityRegistry.findGlobalUniqueEntityId();
        EntityRegistry.registerGlobalEntityID(entity, name, entityId, color1, color2);
        EntityRegistry.registerModEntity(entity, name, entityId, Fossils.instance, 64, 1, true);
        entityToRender.clear();
        entityToRender.add(entity);
        entityRenderer.clear();
        entityRenderer.add(renderer);

        proxy.renderEntity();
    }
    public void addGuiHandler(IGuiHandler handler)
    {
        NetworkRegistry.INSTANCE.registerGuiHandler(Fossils.instance, handler);
    }

    /** Getters */
    public static CreativeTabs getCreativeTab(int id)
    {
        return tabs[id];
    }
    public static Block getBlock(int id)
    {
        return blocks[id];
    }
    public static Item getItem(int id)
    {
        return items[id];
    }
    public static Class<? extends TileEntity> getTileEntityToRender()
    {
        return tileEntityToRender.get(0);
    }
    public static TileEntitySpecialRenderer getTileEntityRenderer()
    {
        return tileEntityRenderer.get(0);
    }
    public static Class<? extends EntityLiving> getEntityToRender()
    {
        return entityToRender.get(0);
    }
    public static RenderLiving getEntityRenderer()
    {
        return entityRenderer.get(0);
    }
    public static String getModId()
    {
        return "fossils:";
    }
}
