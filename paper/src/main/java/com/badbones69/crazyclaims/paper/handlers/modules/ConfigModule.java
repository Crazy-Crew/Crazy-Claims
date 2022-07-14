package com.badbones69.crazyclaims.paper.handlers.modules;

import com.badbones69.crazyclaims.paper.CrazyClaims;
import com.badbones69.crazyclaims.paper.api.config.ConfigFile;
import com.badbones69.crazyclaims.paper.api.config.LangFile;
import com.badbones69.crazyclaims.paper.handlers.ModuleHandler;
import com.google.inject.Inject;
import com.google.inject.Singleton;

@Singleton
public class ConfigModule implements ModuleHandler {

    @Inject private ConfigFile configFile;
    @Inject private LangFile langFile;

    @Inject private CrazyClaims plugin;

    @Override
    public void enable() {
        configFile.load();
        langFile.load();
    }

    @Override
    public void disable() {
        configFile.save();
        langFile.save();
    }
}