package com.fossils.ilexiconn;

import com.fossils.core.ISideMod;
import com.fossils.core.Util;
import com.fossils.ilexiconn.block.BlockCultivateBottom;
import com.fossils.ilexiconn.block.tileentity.TileCultivate;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

public class Main extends Util implements ISideMod
{
    public String getCoder()
    {
        return "iLexiconn";
    }

    public void init(FMLPreInitializationEvent event)
    {
        { /** Cultivate bottom (Rendered part) */
            addBlockWithTileEntity(0, new BlockCultivateBottom(), TileCultivate.class, true);
            //addTileEntityRenderer(TileCultivate.class, null);
        }
        { /** Cultivate top (data storage) */

        }
    }
}
