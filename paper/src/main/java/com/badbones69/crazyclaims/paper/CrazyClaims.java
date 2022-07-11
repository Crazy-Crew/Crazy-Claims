package com.badbones69.crazyclaims.paper;

import com.badbones69.crazyclaims.paper.api.CrazyManager;
import com.badbones69.crazyclaims.paper.handlers.ModuleLoader;
import com.badbones69.crazyclaims.paper.handlers.modules.ConfigModule;
import com.google.inject.Inject;
import com.google.inject.Injector;
import org.bukkit.plugin.java.JavaPlugin;

public class CrazyClaims extends JavaPlugin {

    private Injector injector;

    private boolean isEnabled = false;

    @Inject
    private CrazyManager crazyManager;

    @Inject
    private ConfigModule configModule;

    @Override
    public void onEnable() {
        try {
            Class.forName("io.papermc.paper.configuration.PaperConfigurations");
        } catch (ClassNotFoundException e) {
            getServer().getLogger().severe("This plugin requires Paper or any fork based on Paper to run.");
            getServer().getPluginManager().disablePlugin(this);
            return;
        }

        try {
            crazyManager = new CrazyManager(this);

            ModuleLoader module = new ModuleLoader(this, crazyManager);

            injector = module.createInjector();

            injector.injectMembers(this);

            crazyManager.load();
        } catch (Exception ex) {
            getLogger().severe(ex.getMessage());
            getLogger().severe(ex.getCause().getMessage());

            return;
        }

        isEnabled = true;
    }

    @Override
    public void onDisable() {
        if (!isEnabled) return;

        try {
            injector = null;

            crazyManager.stop();
        } catch (Exception ex) {
            getLogger().severe(ex.getMessage());
            getLogger().severe(ex.getCause().getMessage());
        }
    }
}