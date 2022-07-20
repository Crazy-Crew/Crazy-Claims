package com.badbones69.crazyclaims.paper

import org.bukkit.plugin.java.JavaPlugin

class CrazyClaims : JavaPlugin() {

    private var pluginEnabled = false

    override fun onEnable() {

        runCatching {

        }.onFailure {

            // Create our own colored logger using MiniMessage.

            pluginEnabled = false
        }

        pluginEnabled = true
    }

    override fun onDisable() {
        if (!pluginEnabled) return

        //crazyManager.stop();

        //injector = null;
    }
}