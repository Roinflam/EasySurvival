package pers.roinflam.easysurvival;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import pers.roinflam.easysurvival.proxy.CommonProxy;
import pers.roinflam.easysurvival.utils.Reference;

import javax.annotation.Nonnull;

@Mod(modid = Reference.MOD_ID, useMetadata = true)
public class EasySurvival {
    public static SimpleNetworkWrapper network;
    @Mod.Instance
    public static EasySurvival instance;

    @SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.COMMON_PROXY_CLASS)
    public static CommonProxy proxy;

    @Mod.EventHandler
    public static void preInit(@Nonnull FMLPreInitializationEvent evt) {

    }

    @Mod.EventHandler
    public static void init(FMLInitializationEvent evt) {
    }

    @Mod.EventHandler
    public static void postInit(FMLPostInitializationEvent evt) {
    }
}
