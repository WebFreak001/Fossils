package com.fossils.core;

import com.fossils.SideMods;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = "fossils", name = "Fossils and Archaeology mod: Jurassic Park Edition", version = "1.0.1")
public class Core
{
    @Mod.Instance("fossils")
    public static Core instance;

    @Mod.EventHandler
    public void init(FMLPreInitializationEvent event)
    {
        SideMods.load();
        Util.initMods(event);
    }
}
