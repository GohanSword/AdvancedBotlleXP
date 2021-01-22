package fr.gohansword.advancedbotllexp.Config;

import fr.gohansword.advancedbotllexp.AdvancedBotlleXP;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class LanguageConfig {
    private File languageConfigFile;
    private FileConfiguration languageConfig;


    public FileConfiguration getLanguageConfig() {
        return this.languageConfig;
    }

    public void createlanguageConfig() {
        this.languageConfigFile = new File(AdvancedBotlleXP.getInstance().getDataFolder(), "language/" + AdvancedBotlleXP.getInstance().getConfig().getString("language") + ".yml");
        if (!this.languageConfigFile.exists()) {
            this.languageConfigFile.getParentFile().mkdirs();
            AdvancedBotlleXP.getInstance().saveResource("language/" + AdvancedBotlleXP.getInstance().getConfig().getString("language") + ".yml", false);
        }

        this.languageConfig = (FileConfiguration) new YamlConfiguration();
        try {
            this.languageConfig.load(this.languageConfigFile);
        } catch (IOException | org.bukkit.configuration.InvalidConfigurationException e) {
            e.printStackTrace();
        }
    }
}
