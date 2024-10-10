package ch.andu.joinmessage;

import ch.andu.joinmessage.Commands.JoinCommand;
import ch.andu.joinmessage.Listener.JoinListener;
import ch.andu.joinmessage.configmanager.Config;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class Joinmessage extends JavaPlugin {

    public static  Joinmessage  instance;
    public Config config;
    @Override
    public void onEnable() {
        //Dieses Plugin habe ich ganz schnell für jemanden Programmiert xD
        instance = this;
        config = new Config();
        config.loadConfigs();
        Bukkit.getConsoleSender().sendMessage("Joinmessage by anducrafter is  successful loaded");
        getCommand("Joinmessage").setExecutor(new JoinCommand(config));
        Bukkit.getPluginManager().registerEvents(new JoinListener(config),this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public static Joinmessage getInstance() {
        return instance;
    }
}
