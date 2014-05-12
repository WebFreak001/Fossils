package com.fossils.ilexiconn;

import com.fossils.core.ISideMod;
import com.fossils.core.Util;
import com.fossils.ilexiconn.block.BlockCultivate;
import com.fossils.ilexiconn.block.BlockCultivateData;
import com.fossils.ilexiconn.block.renderer.CultivateRenderer;
import com.fossils.ilexiconn.block.tileentity.TileCultivate;
import com.fossils.ilexiconn.block.tileentity.TileCultivateData;
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
            addBlockWithTileEntity(0, new BlockCultivate(), TileCultivate.class, true);
            addTileEntityRenderer(TileCultivate.class, new CultivateRenderer());
        }
        { /** Cultivate top (data storage) */
            addBlockWithTileEntity(1, new BlockCultivateData(true), TileCultivateData.class, true);
            addBlockWithTileEntity(2, new BlockCultivateData(false), TileCultivateData.class, false);
        }
    }
}
