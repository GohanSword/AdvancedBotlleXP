package fr.gohansword.advancedbotllexp;

import fr.gohansword.advancedbotllexp.Commands.CommandsBXP;
import fr.gohansword.advancedbotllexp.Config.LanguageConfig;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
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
        Bukkit.getConsoleSender().sendMessage("§f==============§b===============");
        Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', language.getLanguageConfig().getString("Prefix")) + "§aV 1.0.0");
        Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', language.getLanguageConfig().getString("Plugin-boot")));
        Bukkit.getConsoleSender().sendMessage("§f==============§b===============");
        getCommand("BXP").setExecutor(new CommandsBXP());
    }

    @Override
    public void onDisable() {
        Bukkit.getConsoleSender().sendMessage("§c==============§b===============");
        Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', language.getLanguageConfig().getString("Prefix")) + "§aV 1.0.0");
        Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', language.getLanguageConfig().getString("Plugin-stop")));
        Bukkit.getConsoleSender().sendMessage("§c==============§b===============");
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        String newLine = System.getProperty("line.separator");
        String blankline = "&c";

        if (label.equalsIgnoreCase("advancedbottlexp")) {
            if (args.length == 0) {
                sender.sendMessage(ChatColor.translateAlternateColorCodes('&',
                        this.language.getLanguageConfig().getString("Prefix") + this.language.getLanguageConfig().getString("Usage")));
            }
            if (args.length > 0) {
                if (args[0].equalsIgnoreCase("reload")) {
                    if (!sender.hasPermission("advancedbottlexp.admin")) {
                        sender.sendMessage(ChatColor.translateAlternateColorCodes('&',
                                this.language.getLanguageConfig().getString("Prefix") + this.language.getLanguageConfig().getString("No-permission")));
                        return true;
                    }else this.reloadConfig();
                    sender.sendMessage(ChatColor.translateAlternateColorCodes('&',
                            this.language.getLanguageConfig().getString("Prefix") + this.language.getLanguageConfig().getString("Reload")));
                    Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&',
                            this.language.getLanguageConfig().getString("Prefix") + this.language.getLanguageConfig().getString("Reload")));
                } else if (args[0].equalsIgnoreCase("help")) {
                    sender.sendMessage(ChatColor.translateAlternateColorCodes('&',
                            this.language.getLanguageConfig().getString("Help") + newLine + blankline + newLine + this.language.getLanguageConfig().getString("CommandHelp") + newLine + this.language.getLanguageConfig().getString("CommandReload") + newLine + this.language.getLanguageConfig().getString("CommandSmelt") + newLine + blankline + newLine + this.language.getLanguageConfig().getString("HelpEnd")));
                }
            }
        } else if (label.equalsIgnoreCase("abx")) {
            if (args.length == 0) {
                sender.sendMessage(ChatColor.translateAlternateColorCodes('&',
                        this.language.getLanguageConfig().getString("Prefix") + this.language.getLanguageConfig().getString("Usage")));
            }
            else if (args.length > 0) {
                if (args[0].equalsIgnoreCase("reload")) {
                    if (!sender.hasPermission("advancedbottlexp.admin")) {
                        sender.sendMessage(ChatColor.translateAlternateColorCodes('&',
                                this.language.getLanguageConfig().getString("Prefix") + this.language.getLanguageConfig().getString("No-permission")));
                        return true;
                    }else
                        this.reloadConfig();
                    language.createlanguageConfig();
                    sender.sendMessage(ChatColor.translateAlternateColorCodes('&',
                            this.language.getLanguageConfig().getString("Prefix") + this.language.getLanguageConfig().getString("Reload")));
                    Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&',
                            this.language.getLanguageConfig().getString("Prefix") + this.language.getLanguageConfig().getString("Reload")));
                }else if (args[0].equalsIgnoreCase("help")) {
                    sender.sendMessage(ChatColor.translateAlternateColorCodes('&',
                            this.language.getLanguageConfig().getString("Help" ) + newLine + blankline + newLine +this.language.getLanguageConfig().getString("CommandHelp") + newLine + this.language.getLanguageConfig().getString("CommandReload") + newLine + this.language.getLanguageConfig().getString("CommandSmelt") + newLine + blankline + newLine + this.language.getLanguageConfig().getString("HelpEnd")));
                }
            }
        } return false;
    }
}