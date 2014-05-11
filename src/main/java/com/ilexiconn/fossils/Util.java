package com.ilexiconn.fossils;

import com.ilexiconn.fossils.proxy.ServerProxy;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.item.Item;

public class Util
{
    @SidedProxy(clientSide = "com.ilexiconn.fossils.proxy.ClientProxy", serverSide = "com.ilexiconn.fossils.proxy.ServerProxy")
    public static ServerProxy proxy;

    private static Block[] blocks = new Block[1024];
    private static Item[] items = new Item[1024];

    /** ADDERS! :D */
    public void addBlock(int id, Block block)
    {
        blocks[id] = block;
        GameRegistry.registerBlock(blocks[id], blocks[id].getUnlocalizedName());
    }

    public void addItem(int id, Item item)
    {
        items[id] = item;
        GameRegistry.registerItem(items[id], items[id].getUnlocalizedName());
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
}
