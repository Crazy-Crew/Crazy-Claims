package com.badbones69.crazyclaims.paper;

import com.badbones69.crazyclaims.paper.api.CrazyManager;
import com.badbones69.crazyclaims.paper.api.FileManager;
import com.badbones69.crazyclaims.paper.api.config.ConfigFile;
import com.badbones69.crazyclaims.paper.api.config.LangFile;
import com.badbones69.crazyclaims.paper.handlers.PluginModule;
import com.badbones69.crazyclaims.paper.handlers.modules.ConfigModule;
import com.google.inject.Inject;
import com.google.inject.Injector;
import org.bukkit.plugin.java.JavaPlugin;

public class CrazyClaims extends JavaPlugin {

    private Injector injector;

    private boolean isEnabled = false;

    @Inject
    private CrazyManager crazyManager;

    @Inject private ConfigModule configModule;

    @Inject private ConfigFile configFile;
    @Inject private LangFile langFile;

    @Inject private FileManager fileManager;

    @Inject private TestCommand testCommand;

    @Override
    public void onEnable() {

        try {
            crazyManager = new CrazyManager(this);
            fileManager = new FileManager();

            configFile = new ConfigFile();
            langFile = new LangFile();

            PluginModule module = new PluginModule(this, configFile, langFile, crazyManager, fileManager);

            injector = module.createInjector();

            injector.injectMembers(this);

            fileManager.registerCustomFolder("/locale")
                    .registerDefaultGenerateFiles("locale-en.yml", "/locale")
                    .registerDefaultGenerateFiles("locale-de.yml", "/locale").setup().isLogging(true);

            configModule.enable();

            crazyManager.load();
        } catch (Exception e) {
            getLogger().severe(e.getMessage());

            for (StackTraceElement stack : e.getStackTrace()) {
                getLogger().severe(String.valueOf(stack));
            }

            return;
        }

        getCommand("test").setExecutor(testCommand);

        isEnabled = true;
    }

    @Override
    public void onDisable() {
        if (!isEnabled) return;

        crazyManager.stop();

        injector = null;
    }
}