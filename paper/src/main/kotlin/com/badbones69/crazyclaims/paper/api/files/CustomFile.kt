package com.badbones69.crazyclaims.paper.api.files

import com.badbones69.crazyclaims.paper.plugin
import org.bukkit.configuration.file.FileConfiguration
import org.bukkit.configuration.file.YamlConfiguration
import java.io.File

// TODO() - Use mini message for logging.
class CustomFile(private val fileName: String, private val homeFolder: String) {

    init {
        create()
    }

    private var file: FileConfiguration? = null

    private val blankFile: File? = null

    fun getFileName() = fileName

    fun getHomeFolder() = homeFolder

    var getFile = file

    fun exists() = file != null

    private fun create() {

        val newFile = File(plugin.dataFolder, "/$homeFolder/$fileName")

        runCatching {
            file = if (newFile.exists()) {
                YamlConfiguration.loadConfiguration(newFile)
            } else {
                null
            }
        }.onFailure {
            newFile.mkdir()

            plugin.logger.warning("Could not save ${newFile.name}!")

            plugin.logger.info("The folder $homeFolder/ was not found so it was made.")

            file = null
        }
    }

    fun save() {
        if (file == null) return

        runCatching {
            if (blankFile != null) file?.save(blankFile)
        }.onFailure {
            plugin.logger.warning("Could not save $fileName")

            it.printStackTrace()
        }.onSuccess {
            plugin.logger.finest("$fileName has been saved.")
        }
    }

    fun reload() {
        if (file == null) return

        runCatching {
            file = blankFile?.let { YamlConfiguration.loadConfiguration(it) }
        }.onFailure {
            plugin.logger.warning("Could not reload $fileName")

            it.printStackTrace()
        }.onSuccess {
            plugin.logger.finest("$fileName has been reloaded.")
        }
    }
}