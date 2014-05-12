package com.fossils.ilexiconn.block;

import com.fossils.core.Util;
import com.fossils.ilexiconn.block.tileentity.TileCultivate;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockCultivate extends BlockContainer
{
    public BlockCultivate()
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

    public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase livingBase, ItemStack itemStack)
    {
        world.setBlock(x, y + 1, z, Util.getblockById(1));
    }

    public boolean removedByPlayer(World world, EntityPlayer player, int x, int y, int z)
    {
        return world.setBlockToAir(x, y, z) && world.setBlockToAir(x, y + 1, z);
    }
}
