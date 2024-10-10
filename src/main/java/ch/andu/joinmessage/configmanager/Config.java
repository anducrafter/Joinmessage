package ch.andu.joinmessage.configmanager;

import ch.andu.joinmessage.Joinmessage;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class Config {
    private final File message = new File(Joinmessage.getInstance().getDataFolder()+"message");
    private final YamlConfiguration messagecfg = YamlConfiguration.loadConfiguration(message);

    private final File user = new File(Joinmessage.getInstance().getDataFolder()+"user");
    private final YamlConfiguration usercfg = YamlConfiguration.loadConfiguration(message);

    public void saveCfgmessage(){
        try {
            messagecfg.save(message);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void saveCfguser(){
        try {
            usercfg.save(user);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void loadConfigs(){
        saveCfgmessage();
        saveCfguser();
    }

    public void addOptions(){

        messagecfg.addDefault("Join_use_command_message","&7Du hast deinen Joinmessage zu %message% eingestellt");
        messagecfg.addDefault("Join_command_use_permission","Join_command_use");
        messagecfg.addDefault("Join_use_permission","Join_use");

        messagecfg.addDefault("Join_default_message","&7Der User %name% ist gejoint");

        messagecfg.addDefault("Join_default_message_use",true);
        messagecfg.options().copyDefaults(false);
        saveCfgmessage();
    }

    public String geString(String perms){
        return messagecfg.getString(perms);
    }

    public Boolean getboolean(String perms){
        return messagecfg.getBoolean(perms);
    }

    public void addUser(String name){
        if(!usercfg.isSet(name)){
            usercfg.set(name,messagecfg.get("Join_default_message"));
            saveCfguser();
        }
    }

    public void setUser(String name,String message){
        usercfg.set(name,message);
        saveCfguser();
    }
    public String getUser(String name){
        if(!usercfg.isSet(name)){
            return "error";
        }
        return usercfg.getString(name);
    }

}
