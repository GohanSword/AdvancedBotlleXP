package fr.gohansword.advancedbotllexp;

import fr.gohansword.advancedbotllexp.Commands.CommandsBXP;
import fr.gohansword.advancedbotllexp.Config.LanguageConfig;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public final class AdvancedBotlleXP extends JavaPlugin {


    private static AdvancedBotlleXP instance;

    public LanguageConfig language = new LanguageConfig();

    public static AdvancedBotlleXP getInstance() {
        return instance;
    }


    @Override
    public void onEnable() {

        instance = this;
        saveDefaultConfig();
        this.language.createlanguageConfig();
        getCommand("BXP").setExecutor(new CommandsBXP());
        Bukkit.getConsoleSender().sendMessage("§c==============§b===============");
        Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', language.getLanguageConfig().getString("Prefix")) + "§aV 1.0.0");
        Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', language.getLanguageConfig().getString("Plugin-boot")));
        Bukkit.getConsoleSender().sendMessage("§c==============§b===============");
        getCommand("BXP").setExecutor(new CommandsBXP());
    }

    @Override
    public void onDisable() {
        Bukkit.getConsoleSender().sendMessage("§c==============§b===============");
        Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', language.getLanguageConfig().getString("Prefix")) + "§aV 1.0.0");
        Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', language.getLanguageConfig().getString("Plugin-stop")));
        Bukkit.getConsoleSender().sendMessage("§c==============§b===============");    }
}
