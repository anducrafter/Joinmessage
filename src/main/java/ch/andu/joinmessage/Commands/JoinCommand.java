package ch.andu.joinmessage.Commands;

import ch.andu.joinmessage.configmanager.Config;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class JoinCommand implements CommandExecutor {

   private Config config;
    public  JoinCommand(Config config){
        this.config = config;
    }

    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String args, @NotNull String[] lenght) {
        if(!(commandSender instanceof  Player)){
            return false;
        }
        Player player = (Player) commandSender;
        if(!args.isEmpty()){
            player.sendMessage("§cBitte benutze den Command /Joinmessage");
        }

        if(!player.hasPermission(config.geString("Join_command_use_permission"))){
            player.sendMessage("§cDu hast keine Berechtigung für diesen Command");
        }
        config.setUser(player.getUniqueId().toString(),args);
        player.sendMessage(config.geString("Join_use_command_message").replace("%message%",args));

        return false;
    }
}
