package com.badbones69.crazyclaims.paper.api.config;

import com.badbones69.crazyclaims.paper.CrazyClaims;
import com.badbones69.crazyclaims.paper.Methods;
import com.badbones69.crazyclaims.paper.api.FileManager;
import com.badbones69.crazyclaims.paper.api.config.interfaces.IConfigFile;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.google.inject.name.Named;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import java.io.File;
import java.io.InputStream;

@Singleton
public class LangFile implements IConfigFile {

    @Inject
    @Named("ConfigFolder")
    private File configFolder;

    @Inject private Methods methods;

    @Inject private CrazyClaims plugin;

    @Inject private FileManager fileManager;

    @Inject private ConfigFile configFile;

    private File blankFile = null;

    private void create() {
        blankFile = new File(configFolder, "/locale/" + configFile.getFile().getString("settings.language-file"));

        if (!blankFile.exists()) {
            InputStream jarFile = plugin.getClass().getResourceAsStream("/locale/" + configFile.getFile().getString("settings.language-file"));
            methods.copyFile(jarFile, blankFile);
        }
    }

    @Override
    public void load() {
        // Copy the file from src/main/resources
        create();

        fileManager.addConfiguration(blankFile.getName(), blankFile, YamlConfiguration.loadConfiguration(blankFile));
    }

    @Override
    public void save() {
        // Copy the file from src/main/resources
        create();

        fileManager.saveFile(blankFile.getName());
    }

    @Override
    public void remove() {
        fileManager.removeFile(blankFile.getName());
    }

    @Override
    public void reload() {
        fileManager.reloadFile(blankFile.getName(), YamlConfiguration.loadConfiguration(fileManager.getFile(blankFile)));
    }

    @Override
    public FileConfiguration getFile() {
        return fileManager.getFile(blankFile.getName());
    }
}