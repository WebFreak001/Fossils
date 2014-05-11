package com.ilexiconn.fossils;

import com.ilexiconn.fossils.proxy.ServerProxy;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraft.tileentity.TileEntity;

import java.util.ArrayList;

public class Util
{
    @SidedProxy(clientSide = "com.ilexiconn.fossils.proxy.ClientProxy", serverSide = "com.ilexiconn.fossils.proxy.ServerProxy")
    public static ServerProxy proxy;

    private static Block[] blocks = new Block[1024];
    private static Item[] items = new Item[1024];

    /** Entity stuff.. Pff... (and model studd for the eggs, and the eggs are for the entities, hmm....) */
    private static ArrayList<Class<? extends Entity>> entityToRender = new ArrayList<Class<? extends Entity>>();
    private static ArrayList<RenderLiving> entityRenderer = new ArrayList<RenderLiving>();
    private static ArrayList<Class<? extends TileEntity>> tileToRender = new ArrayList<Class<? extends TileEntity>>();
    private static ArrayList<TileEntitySpecialRenderer> tileRenderer = new ArrayList<TileEntitySpecialRenderer>();

    /** ADDERS! :D */
    public static void addBlock(int id, Block block)
    {
        blocks[id] = block;
        GameRegistry.registerBlock(blocks[id], blocks[id].getUnlocalizedName());
    }

    public static void addItem(int id, Item item)
    {
        items[id] = item;
        GameRegistry.registerItem(items[id], items[id].getUnlocalizedName());
    }

    public static void addEntity(Class<? extends Entity> entityClass, String name, RenderLiving renderer, int primaryColor, int secondaryColor)
    {
        int entityID = EntityRegistry.findGlobalUniqueEntityId();
        EntityRegistry.registerGlobalEntityID(entityClass, name, entityID, primaryColor, secondaryColor);
        EntityRegistry.registerModEntity(entityClass, name, entityID, Main.instance, 64, 1, true);

        entityToRender.clear();
        entityRenderer.clear();

        entityToRender.add(entityClass);
        entityRenderer.add(renderer);

        proxy.renderEntity();
    }

    public static void addBlockWithTileEntity(int id, BlockContainer block, Class<? extends TileEntity> tileEntity, boolean register)
    {
        blocks[id] = block;
        GameRegistry.registerBlock(blocks[id], blocks[id].getUnlocalizedName());
        if (register) GameRegistry.registerTileEntity(tileEntity, blocks[id].getUnlocalizedName() + "_tileEntity");
    }

    public static void addTileEntityRenderer(Class<? extends TileEntity> tileEntity, TileEntitySpecialRenderer renderer)
    {
        tileToRender.clear();
        tileRenderer.clear();

        tileToRender.add(tileEntity);
        tileRenderer.add(renderer);

        proxy.renderTileEntity();
    }

    /** GETTERS! :D */
    public static Block getblockById(int id)
    {
        return blocks[id];
    }

    public static Item getItemById(int id)
    {
        return items[id];
    }

    public static Class<? extends Entity> getEntityToRender()
    {
        return entityToRender.get(0);
    }

    public static RenderLiving getEntityRenderer()
    {
        return entityRenderer.get(0);
    }

    public static Class<? extends TileEntity> getTileToRender()
    {
        return tileToRender.get(0);
    }

    public static TileEntitySpecialRenderer getTileRenderer()
    {
        return tileRenderer.get(0);
    }
}
