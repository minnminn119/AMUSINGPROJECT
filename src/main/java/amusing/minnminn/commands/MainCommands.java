package amusing.minnminn.commands;

import amusing.minnminn.LQM.lqmC;
import amusing.minnminn.Listener.MainInv;
import amusing.minnminn.main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class MainCommands implements CommandExecutor {
    main plugin;
    public MainCommands(main instance){
        plugin=instance;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (command.getName().equalsIgnoreCase("agmc")) {
            if (sender instanceof Player) {
                Player player = (Player) sender;
                sender.sendMessage("プレイヤーからの実行だね");
                displayGUI(player);
            } else {
                sender.sendMessage("コンソールからの実行だね？");
            }
        }
        return true;
    }
    public void displayGUI(Player player){
        MainInv InventoryS =new MainInv();
        Inventory inv= Bukkit.createInventory(null,27, ChatColor.BLUE +"システムコマンド");
        ItemStack exit =new ItemStack(Material.SPRUCE_DOOR);
        ItemMeta MetaExit=exit.getItemMeta();
        MetaExit.setDisplayName(ChatColor.RED+"Exit");
        inv.setItem(4,exit);
        player.openInventory(inv);
    }
}
