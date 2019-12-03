package amusing.minnminn.LQM;

import amusing.minnminn.main;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class lqmC implements CommandExecutor {
    private String CommandGeter;
    main plugin;
    public lqmC(main instance){
        plugin=instance;
    }
    public lqmC(String lqmC){
        CommandGeter=lqmC;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        return true;
    }
}
