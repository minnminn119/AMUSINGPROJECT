package amusing.minnminn.Listener;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class MainInv implements Listener {

    @EventHandler
    public void onPlayerClickInv(InventoryClickEvent e){
        if(e.getInventory().getViewers().equals(ChatColor.DARK_GRAY +"システムコマンド")){
            if(e.getCurrentItem().getItemMeta() != null){
                if(e.getCurrentItem().getItemMeta().getDisplayName()!=null){
                    if(e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.RED+"Exit")){
                        Player player=(Player)e.getWhoClicked();
                        player.sendMessage(ChatColor.RED+"Exit");
                        e.setCancelled(true);

                    }

                }
            }

        }
    }
}