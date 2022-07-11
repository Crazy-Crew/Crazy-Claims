package com.badbones69.crazyclaims.paper.api;

import com.badbones69.crazyclaims.paper.CrazyClaims;
import com.google.inject.Inject;
import com.google.inject.Singleton;

@Singleton
public class CrazyManager {

    private final CrazyClaims plugin;

    @Inject
    public CrazyManager(CrazyClaims plugin) {
        this.plugin = plugin;
    }

    public void load() {
        plugin.getLogger().info("Guten Tag!");
    }

    public void stop() {
        plugin.getLogger().info("Good Bye!");
    }
}