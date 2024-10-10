package ch.andu.joinmessage.Listener;

import ch.andu.joinmessage.configmanager.Config;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class JoinListener implements Listener {

    private Config config;

    public  JoinListener(Config config){
        this.config = config;
    }
    @EventHandler
    public void onJoin(PlayerJoinEvent event){
        Player player = event.getPlayer();
        config.addUser(player.getUniqueId().toString());
        if(!player.hasPermission(config.geString("Join_use_permission"))){
            event.setJoinMessage(config.geString("Join_default_message").replace("&","§").replace("%name%",player.getName()));
        }
        if(config.getboolean("Join_default_message_use")) {
            event.setJoinMessage(config.getUser("Join_default_message").replace("&", "§").replace("%name%", player.getName()));
        }
    }
}
