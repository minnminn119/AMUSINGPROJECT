package amusing.minnminn.LQM;


import amusing.minnminn.main;
import org.bukkit.*;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class lqm implements Listener {
    //***>>>エントリーポイント参照<<<***
    main plugin; //インスタンスだと思う
    public lqm(main instance){ //コンストラクタ
        plugin = instance;
    }
    //***>>>フィールド<<<***
    String[] CM=new String[1];//index[0~1]Config.yml Customメッセを習得
    //***>>>PlayerEvent<<<***
    @EventHandler//JoinMessage
    public void Join(PlayerJoinEvent e){
        Player p=e.getPlayer();
        rep(p);
        this.CM[0]=plugin.getConfig().getString("lqm.CustomMessage.Join");
        e.setJoinMessage(ChatColor.translateAlternateColorCodes('&',CM[0]));
        pje(p);
        pjs();
    }
    @EventHandler//QuitMessage
    public void Quit(PlayerQuitEvent e){
        Player p=e.getPlayer();
        rep(p);
        this.CM[1]=plugin.getConfig().getString("lqm.CustomMessage.Quit");
        e.setQuitMessage(ChatColor.translateAlternateColorCodes('&',CM[1]));
        pqe(p);
        pqs();
    }

    //***>>>Effect<<<***
    //PlayerJoinEffect/<Method>
    public void pje(Player player){
        Location loc=player.getLocation();
        for(int i=0;i<10;i++){
            player.getWorld().playEffect(loc , Effect.ENDER_SIGNAL,0);
        }
    }
    //PlayerQuitEffect/<Method>
    public void pqe(Player player){
        Location loc=player.getLocation();
        for(int i=0;i<10;i++){
            player.getWorld().playEffect(loc,Effect.SMOKE,0);
        }
    }

    //***>>Sound<<<***
    public void pjs(){//PlayerJoinSound
        for(Player player: Bukkit.getOnlinePlayers()){
            player.playSound(player.getLocation(), Sound.BLOCK_IRON_DOOR_OPEN,10,0);
        }
    }
    public void pqs(){//PlayerQuitSound
        for(Player player:Bukkit.getOnlinePlayers()){
            player.playSound(player.getLocation(),Sound.BLOCK_IRON_DOOR_CLOSE,10,0);
        }
    }

    public void rep(Player p){
        String pname= p.getName();
        for(int i=0;i<=1;i++){
            CM[i]=CM[i].replaceAll("%player",pname);
        }
    }

}
