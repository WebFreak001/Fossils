package com.fossils.ilexiconn.block;

import com.fossils.core.Util;
import com.fossils.ilexiconn.block.tileentity.TileCultivate;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockCultivateBottom extends BlockContainer
{
    public BlockCultivateBottom()
    {
        super(Material.iron);
        setBlockName("cultivate_bottom");
        setBlockTextureName(Util.getModID() + "cultivate");
        setBlockBounds(0f, 0f, 0f, 1f, 2f, 1f);
        setCreativeTab(CreativeTabs.tabBlock);
    }

    public TileEntity createNewTileEntity(World world, int location)
    {
        return new TileCultivate();
    }

    public boolean isOpaqueCube()
    {
        return false;
    }

    public int getRenderType()
    {
        return -1;
    }
}
