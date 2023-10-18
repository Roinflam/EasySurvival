package pers.roinflam.easysurvival.eventlistener;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

@Mod.EventBusSubscriber
public class ItemEventListener {

    @SubscribeEvent
    public static void onPlayerTick(TickEvent.PlayerTickEvent evt) {
        if (!evt.player.world.isRemote) {
            EntityPlayer entityPlayer = evt.player;
            ItemStack heldItemMainhand = entityPlayer.getHeldItemMainhand();
            ItemStack heldItemOffhand = entityPlayer.getHeldItemOffhand();
            if (!heldItemMainhand.isEmpty() && heldItemMainhand.getMaxStackSize() == 1 && heldItemMainhand.getItemDamage() > 0) {
                heldItemMainhand.setItemDamage(0);
            }
            if (!heldItemOffhand.isEmpty() && heldItemOffhand.getMaxStackSize() == 1 && heldItemOffhand.getItemDamage() > 0) {
                heldItemOffhand.setItemDamage(0);
            }
            for (ItemStack arrmor : entityPlayer.getArmorInventoryList()) {
                if (!arrmor.isEmpty() && arrmor.getMaxStackSize() == 1 && arrmor.getItemDamage() > 0) {
                    arrmor.setItemDamage(0);
                }
            }
        }
    }

}
