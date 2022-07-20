package com.badbones69.crazyclaims.paper.api.config.interfaces

import org.bukkit.configuration.file.FileConfiguration

interface IConfigFile {

    fun load()

    fun save()

    fun reload()

    fun remove()

    val file: FileConfiguration?

}