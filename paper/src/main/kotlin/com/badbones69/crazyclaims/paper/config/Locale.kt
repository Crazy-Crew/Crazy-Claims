package com.badbones69.crazyclaims.paper.config

import com.badbones69.crazyclaims.paper.api.files.AbstractConfig
import com.badbones69.crazyclaims.paper.api.files.annotations.Key
import com.badbones69.crazyclaims.paper.utils.FileUtils.localeDir

class Locale : AbstractConfig() {

    @Key("locale.config-prefix")
    var configPrefix = " <red>Parcord <gray>|</gray> <reset>"

    @Key("locale.config-reload")
    var configReload = "%prefix% <gray>You have reloaded the plugin.</gray>"

    fun save() {
        this.save(localeDir.resolve(Config().languageFile), Locale::class.java)
    }
}