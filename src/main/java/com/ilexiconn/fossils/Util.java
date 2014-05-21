package com.ilexiconn.fossils;

import com.ilexiconn.fossils.network.ServerProxy;
import cpw.mods.fml.common.SidedProxy;
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
    public ArrayList<CreativeTabs> tabs = new ArrayList<CreativeTabs>();
    public ArrayList<Block> blocks = new ArrayList<Block>();
    public ArrayList<Item> items = new ArrayList<Item>();
    public ArrayList<Class<? extends TileEntity>> tileEntities = new ArrayList<Class<? extends TileEntity>>();

    /** Render Stuff */
    public ArrayList<Class<? extends TileEntity>> tileEntityToRender = new ArrayList<Class<? extends TileEntity>>();
    public ArrayList<TileEntitySpecialRenderer> tileEntityRenderer = new ArrayList<TileEntitySpecialRenderer>();
    public ArrayList<Class<? extends EntityLiving>> entityToRender = new ArrayList<Class<? extends EntityLiving>>();
    public ArrayList<RenderLiving> entityRenderer = new ArrayList<RenderLiving>();

    /** Adders */
    public void addCreativeTab(CreativeTabs tab, boolean doRegister)
    {
        if (doRegister) tabs.add(tab);
    }
    public void addBlock(Block block, boolean doRegister)
    {
        if (doRegister) blocks.add(block);
    }
    public void addItem(Item item, boolean doRegister)
    {
        if (doRegister) items.add(item);
    }
    public void addBlockWithTileEntity(BlockContainer block, boolean doRegister, Class<? extends TileEntity> tileEntity, boolean doRegisterTile)
    {
        addBlock(block, doRegister);
        if (doRegisterTile) GameRegistry.registerTileEntity(tileEntity, tileEntity.getSimpleName());
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

    /** Getters */
    public CreativeTabs getCreativeTab(int id)
    {
        return tabs.get(id);
    }
    public Block getBlock(int id)
    {
        return blocks.get(id);
    }
    public Item getItem(int id)
    {
        return items.get(id);
    }
    public Class<? extends TileEntity> getTileEntity(int id)
    {
        return tileEntities.get(id);
    }
    public Class<? extends TileEntity> getTileEntityToRender()
    {
        return tileEntityToRender.get(0);
    }
    public TileEntitySpecialRenderer getTileEntityRenderer()
    {
        return tileEntityRenderer.get(0);
    }
    public Class<? extends EntityLiving> getEntityToRender()
    {
        return entityToRender.get(0);
    }
    public RenderLiving getEntityRenderer()
    {
        return entityRenderer.get(0);
    }
}
