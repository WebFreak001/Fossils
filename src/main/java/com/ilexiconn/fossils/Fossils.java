package com.ilexiconn.fossils;

import com.ilexiconn.fossils.data.block.BlockCultivate;
import com.ilexiconn.fossils.data.block.GhostBlock;
import com.ilexiconn.fossils.data.item.ItemCultivate;
import com.ilexiconn.fossils.data.tile.TileCultivate;
import com.ilexiconn.fossils.network.client.render.RenderCultivate;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;

@Mod(modid = "fossils", name = "Fossils and Archaeology mod", version = "1.1.2")
public class Fossils extends Util
{
    @Mod.Instance("fossils")
    public static Fossils instance;

    @Mod.EventHandler
    public void init(FMLPreInitializationEvent event)
    {
        { /** Creativetabs */
            addCreativeTab(0, new CreativeTabs("fossilTab")
            {
                public Item getTabIconItem()
                {
                    return Items.arrow;
                }
            });
        }
        { /** Blocks */
            addBlockWithTileEntity(0, new BlockCultivate(), TileCultivate.class, true); //cultivateBottom
            addBlock(1, new GhostBlock("cultivate_ghost", new int[] {-1}, -1, 0, 0f, -1f, 0f, 1f, 1f, 1f)); //cultivateTop
        }
        { /** Items */
            addItem(0, new ItemCultivate());
        }
        { /** Entities */

        }
        { /** Renderers */
            addTileEntityRenderer(TileCultivate.class, new RenderCultivate());
        }
    }
}
