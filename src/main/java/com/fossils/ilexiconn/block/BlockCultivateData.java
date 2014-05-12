package com.fossils.ilexiconn.block;

import com.fossils.ilexiconn.block.tileentity.TileCultivateData;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockCultivateData extends BlockContainer
{
    public boolean isActive;

    public BlockCultivateData(boolean active)
    {
        super(Material.iron);
        isActive = active;
        setBlockName("cultivate_top_" + (active ? "active" : "idle"));
    }

    public TileEntity createNewTileEntity(World world, int position)
    {
        return new TileCultivateData();
    }

    public boolean isOpaqueCube()
    {
        return false;
    }

    public int getRenderType()
    {
        return -1;
    }

    public boolean renderAsNormalBlock()
    {
        return false;
    }
}
