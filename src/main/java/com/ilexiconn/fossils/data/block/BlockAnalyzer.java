package com.ilexiconn.fossils.data.block;

import com.ilexiconn.fossils.Fossils;
import com.ilexiconn.fossils.Util;
import com.ilexiconn.fossils.data.tile.TileAnalyzer;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class BlockAnalyzer extends BlockContainer
{
    @SideOnly(Side.CLIENT)
    public IIcon[] icons = new IIcon[4];

    public boolean active;

    public BlockAnalyzer(boolean active)
    {
        super(Material.iron);
        this.active = active;
        setBlockName("analyzer_" + (active ? "active" : "idle"));
        setBlockTextureName(Util.getModId() + "analyzer");
        setCreativeTab(active ? null : Util.getCreativeTab(0));
        setHardness(3.0f);
    }

    public TileEntity createNewTileEntity(World var1, int var2)
    {
        return new TileAnalyzer();
    }

    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int side, int metadata)
    {
        return side == 1 ? icons[0] : (side == 0 ? icons[0] : (side != metadata ? icons[2] : icons[3]));
    }

    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister iconRegister)
    {
        icons[0] = iconRegister.registerIcon(Util.getModId() + "analyzer_top");
        icons[1] = iconRegister.registerIcon(Util.getModId() + "analyzer_bottom");
        icons[2] = iconRegister.registerIcon(Util.getModId() + "analyzer_side");
        icons[3] = iconRegister.registerIcon(Util.getModId() + "analyzer_front_" + (active ? "active" : "idle"));
    }

    public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entity, ItemStack itemStack)
    {
        int l = MathHelper.floor_double((double) (entity.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;

        if (l == 0)
        {
            world.setBlockMetadataWithNotify(x, y, z, 2, 2);
        }

        if (l == 1)
        {
            world.setBlockMetadataWithNotify(x, y, z, 5, 2);
        }

        if (l == 2)
        {
            world.setBlockMetadataWithNotify(x, y, z, 3, 2);
        }

        if (l == 3)
        {
            world.setBlockMetadataWithNotify(x, y, z, 4, 2);
        }
    }

    public static void updateBlockState(boolean active, World world, int x, int y, int z)
    {
        TileEntity tileEntity = world.getTileEntity(x, y, z);
        int metadata = world.getBlockMetadata(x, y, z);

        world.setBlock(x, y, z, active ? Util.getBlock(2) : Util.getBlock(3));

        world.setBlockMetadataWithNotify(x, y, z, metadata, 2);
        tileEntity.validate();
        world.setTileEntity(x, y, z, tileEntity);
    }

    public static boolean getActive(World world, int x, int y, int z)
    {
        if (!(world.getBlock(x, y, z) instanceof BlockAnalyzer)) return false;
        BlockAnalyzer block = (BlockAnalyzer) world.getBlock(x, y, z);
        return block.active;
    }

    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float i, float d, float k)
    {
        player.openGui(Fossils.instance, 1, world, x, y, z);
        return true;
    }
}
