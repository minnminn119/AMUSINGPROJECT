package amusing.minnminn;

import amusing.minnminn.LQM.lqm;
import amusing.minnminn.Listener.MainInv;
import amusing.minnminn.commands.MainCommands;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public class main extends JavaPlugin {
    String System="[AMUSINGMC]";

    @Override
    public void onEnable() {
        getConfig().options().copyDefaults(true);
        saveConfig();

        //リスナ
        getServer().getPluginManager().registerEvents(new lqm(this),this);
        getServer().getPluginManager().registerEvents(new MainInv(),this);
        //コマンド
        getCommand("agmc").setExecutor(new MainCommands(this));
        //ログ
        getLogger().info(ChatColor.DARK_PURPLE+System+ChatColor.GREEN+" Plugin is Enable");
    }
    @Override
    public void onDisable() {
        getLogger().info(ChatColor.DARK_PURPLE+System+ChatColor.GRAY+" Plugin is Disable");
    }
    @Override
    public void onLoad() {
        getLogger().info(ChatColor.DARK_PURPLE+System+ChatColor.DARK_AQUA+" Plugin is Load");
    }
}
