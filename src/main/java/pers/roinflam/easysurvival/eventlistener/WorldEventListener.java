package pers.roinflam.easysurvival.eventlistener;

import net.minecraft.util.math.BlockPos;
import net.minecraft.world.Explosion;
import net.minecraft.world.GameRules;
import net.minecraft.world.World;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.event.world.ExplosionEvent;
import net.minecraftforge.event.world.WorldEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.util.List;

@Mod.EventBusSubscriber
public class WorldEventListener {

    @SubscribeEvent
    public static void onWorldLoad(WorldEvent.Load evt) {
        // 获取事件中的世界对象
        World world = evt.getWorld();
        // 判断世界是否为服务端
        if (!world.isRemote) {
            // 获取世界的游戏规则对象
            GameRules gameRules = world.getGameRules();
            // 设置或创建游戏规则，传入规则名称和值作为参数
            // 设置死亡不掉落为true
            gameRules.setOrCreateGameRule("keepInventory", "true");
            // 设置生物无法破坏方块为false
            gameRules.setOrCreateGameRule("mobGriefing", "false");
            gameRules.setOrCreateGameRule("doFireTick", "false");
        }
    }

    // 在事件订阅者中定义一个静态方法，用注解标记为事件处理器，并指定要监听的事件类型
    @SubscribeEvent
    public static void onExplosion(ExplosionEvent.Detonate evt) {
        // 获取事件中的爆炸对象
        Explosion explosion = evt.getExplosion();
        // 获取爆炸的影响范围列表
        List<BlockPos> affectedBlocks = explosion.getAffectedBlockPositions();
        // 清空影响范围列表，使爆炸不破坏方块
        affectedBlocks.clear();
    }

    @SubscribeEvent
    public static void onFarmlandTrample(BlockEvent.FarmlandTrampleEvent evt) {
        evt.setCanceled(true);
    }
}
