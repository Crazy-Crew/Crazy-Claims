package com.badbones69.crazyclaims.paper.config

import com.badbones69.crazyclaims.paper.api.files.AbstractConfig
import com.badbones69.crazyclaims.paper.api.files.annotations.Comment
import com.badbones69.crazyclaims.paper.api.files.annotations.Key
import com.badbones69.crazyclaims.paper.utils.FileUtils.dataFolder

class Config : AbstractConfig() {

    @Key("settings.language-file")
    @Comment("The language file to use in locale/ folder.")
    var languageFile = "locale-en.yml"

    fun save() {
        this.save(dataFolder.resolve("config.yml"), Config::class.java)
    }
}