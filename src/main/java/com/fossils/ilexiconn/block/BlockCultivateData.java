package com.fossils.ilexiconn.block;

import com.fossils.core.Util;
import com.fossils.ilexiconn.block.tileentity.TileCultivateData;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockCultivateData extends BlockContainer
{
    private boolean isActive;

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

    public boolean isActive()
    {
        return this.isActive;
    }

    public void setActive(boolean active)
    {
        isActive = active;
    }

    public void updateBlockState(boolean active, World world, int x, int y, int z)
    {
        int l = world.getBlockMetadata(x, y, z);
        TileEntity tileentity = world.getTileEntity(x, y, z);

        if (active)
        {
            world.setBlock(x, y, z, Util.getblockById(0));
        }
        else
        {
            world.setBlock(x, y, z, Util.getblockById(1));
        }

        world.setBlockMetadataWithNotify(x, y, z, l, 2);

        if (tileentity != null)
        {
            tileentity.validate();
            world.setTileEntity(x, y, z, tileentity);
        }
    }
}
