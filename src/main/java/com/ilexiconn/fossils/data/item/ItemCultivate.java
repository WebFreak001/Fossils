package com.ilexiconn.fossils.data.item;

import com.ilexiconn.fossils.Util;
import net.minecraft.item.ItemBlock;

public class ItemCultivate extends ItemBlock
{
    public ItemCultivate()
    {
        super(Util.getBlock(0));
        setUnlocalizedName("cultivate_placer");
        setTextureName(Util.getModId() + "cultivate_placer");
        setCreativeTab(Util.getCreativeTab(0));
    }
}
