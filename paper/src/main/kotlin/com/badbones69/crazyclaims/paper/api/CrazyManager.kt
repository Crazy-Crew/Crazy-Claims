package com.badbones69.crazyclaims.paper.api

import com.badbones69.crazyclaims.paper.CrazyClaims

class CrazyManager constructor(plugin: CrazyClaims) {

    private var plugin: CrazyClaims? = null

    init {
        this.plugin = plugin
    }

    fun start() {
        plugin?.logger?.info("Guten Tag!")
    }

    fun stop() {
        plugin?.logger?.info("Good Bye!")
    }
}