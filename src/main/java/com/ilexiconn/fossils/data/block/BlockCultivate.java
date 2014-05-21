package com.ilexiconn.fossils.data.block;

import com.ilexiconn.fossils.Util;
import com.ilexiconn.fossils.data.tile.TileCultivate;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockCultivate extends BlockContainer
{
    public BlockCultivate()
    {
        super(Material.glass);
        setBlockName("cultivate");
        setBlockTextureName(Util.getModId() + "cultivate");
        setHardness(1.5f);
        setCreativeTab(Util.getCreativeTab(0));
    }

    public TileEntity createNewTileEntity(World var1, int var2)
    {
        return new TileCultivate();
    }

    public int getRenderType()
    {
        return -1;
    }
}
