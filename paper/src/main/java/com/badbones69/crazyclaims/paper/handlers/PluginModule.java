package com.badbones69.crazyclaims.paper.handlers;

import com.badbones69.crazyclaims.paper.CrazyClaims;
import com.badbones69.crazyclaims.paper.api.CrazyManager;
import com.badbones69.crazyclaims.paper.api.FileManager;
import com.badbones69.crazyclaims.paper.api.config.ConfigFile;
import com.badbones69.crazyclaims.paper.api.config.LangFile;
import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.name.Names;
import javax.annotation.Nonnull;
import java.io.File;

public class PluginModule extends AbstractModule {

    private final CrazyClaims plugin;

    private final CrazyManager crazyManager;

    private final FileManager fileManager;

    private final ConfigFile configFile;
    private final LangFile langFile;

    public PluginModule(CrazyClaims plugin, ConfigFile configFile, LangFile langFile, CrazyManager crazyManager, FileManager fileManager) {
        this.plugin = plugin;

        this.crazyManager = crazyManager;
        this.fileManager = fileManager;

        this.configFile = configFile;
        this.langFile = langFile;
    }

    @Nonnull
    public Injector createInjector() {
        return Guice.createInjector(this);
    }

    @Override
    protected void configure() {
        bind(CrazyClaims.class).toInstance(plugin);

        bind(CrazyManager.class).toInstance(crazyManager);
        bind(FileManager.class).toInstance(fileManager);

        bind(ConfigFile.class).toInstance(configFile);
        bind(LangFile.class).toInstance(langFile);

        bind(File.class).annotatedWith(Names.named("ConfigFolder")).toInstance(plugin.getDataFolder());
    }
}