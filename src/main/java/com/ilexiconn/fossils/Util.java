package com.ilexiconn.fossils;

import com.ilexiconn.fossils.proxy.ServerProxy;
import cpw.mods.fml.common.SidedProxy;

public class Util
{
    @SidedProxy(clientSide = "com.ilexiconn.fossils.proxy.ClientProxy", serverSide = "com.ilexiconn.fossils.proxy.ServerProxy")
    public static ServerProxy proxy;
}
