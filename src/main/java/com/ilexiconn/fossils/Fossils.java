package com.ilexiconn.fossils;

import com.ilexiconn.fossils.data.block.BlockCultivate;
import com.ilexiconn.fossils.data.tile.TileCultivate;
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
            addCreativeTab(new CreativeTabs("fossilTab")
            {
                public Item getTabIconItem()
                {
                    return Items.arrow;
                }
            }, true);
        }
        { /** Blocks */
            addBlockWithTileEntity(new BlockCultivate(), TileCultivate.class, true, true);
        }
        { /** Items */

        }
        { /** Entities */

        }
        { /** Renderers */

        }
    }
}
