package com.fossils.core;

import cpw.mods.fml.common.event.FMLPreInitializationEvent;

public interface ISideMod
{
    public String getCoder();

    public void init(FMLPreInitializationEvent event);
}
