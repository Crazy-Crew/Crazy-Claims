package com.badbones69.crazyclaims.paper;

import com.badbones69.crazyclaims.paper.api.CrazyManager;
import com.badbones69.crazyclaims.paper.handlers.ModuleLoader;
import com.google.inject.Inject;
import com.google.inject.Injector;
import org.bukkit.plugin.java.JavaPlugin;

public class CrazyClaims extends JavaPlugin {

    private Injector injector;

    private boolean isEnabled = false;

    @Inject
    private CrazyManager crazyManager;

    @Override
    public void onEnable() {
        try {
            Class.forName("io.papermc.paper.configuration.PaperConfigurations");
        } catch (ClassNotFoundException e) {
            getServer().getLogger().severe("This plugin requires Paper or a fork of to run.");
            getServer().getPluginManager().disablePlugin(this);
            return;
        }

        try {
            crazyManager = new CrazyManager(this);

            ModuleLoader module = new ModuleLoader(this, crazyManager);

            injector = module.createInjector();

            injector.injectMembers(this);

            crazyManager.load();
        } catch (Exception e) {
            getLogger().severe(e.getMessage());
            getLogger().severe(e.getCause().getMessage());

            return;
        }

        isEnabled = true;
    }

    @Override
    public void onDisable() {
        if (!isEnabled) return;

        crazyManager.stop();

        injector = null;
    }
}