package fr.gohansword.advancedbotllexp.Commands;

import fr.gohansword.advancedbotllexp.AdvancedBotlleXP;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class CommandsBXP implements CommandExecutor {

    AdvancedBotlleXP plugin = AdvancedBotlleXP.getInstance();

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        Player p = (Player) sender;
        int xpfinal = p.getTotalExperience() / 7;

        if (p.hasPermission("advancedbottlexp.use")) {

            if (p.getTotalExperience() > 7) {

                p.sendMessage(ChatColor.translateAlternateColorCodes('&', plugin.language.getLanguageConfig().getString("Prefix") + plugin.language.getLanguageConfig().getString("Succes") + xpfinal + " " + plugin.language.getLanguageConfig().getString("Bottlename")));
                ItemStack bottlegive = new ItemStack(Material.EXPERIENCE_BOTTLE, xpfinal);
                p.getInventory().addItem(bottlegive);
                p.setTotalExperience(0);
                p.setLevel(0);
                p.setExp(0);

            } else
                p.sendMessage(ChatColor.translateAlternateColorCodes('&', plugin.language.getLanguageConfig().getString("Prefix") + plugin.language.getLanguageConfig().getString("No-xp")));


            return false;
        } else p.sendMessage(ChatColor.translateAlternateColorCodes('&', plugin.language.getLanguageConfig().getString("Prefix") + plugin.language.getLanguageConfig().getString("No-permission")));

        return false;

    }
}