package com.badbones69.crazyclaims.paper.handlers;

import com.badbones69.crazyclaims.paper.CrazyClaims;
import com.badbones69.crazyclaims.paper.api.CrazyManager;
import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Injector;
import javax.annotation.Nonnull;

public class ModuleLoader extends AbstractModule {

    private final CrazyClaims plugin;

    private final CrazyManager crazyManager;

    public ModuleLoader(CrazyClaims plugin, CrazyManager crazyManager) {
        this.plugin = plugin;
        this.crazyManager = crazyManager;
    }

    @Nonnull
    public Injector createInjector() {
        return Guice.createInjector(this);
    }

    @Override
    protected void configure() {
        bind(CrazyClaims.class).toInstance(plugin);

        bind(CrazyManager.class).toInstance(crazyManager);
    }
}