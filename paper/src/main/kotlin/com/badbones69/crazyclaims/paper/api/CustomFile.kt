package com.badbones69.crazyclaims.paper.api

import com.badbones69.crazyclaims.paper.CrazyClaims
import org.bukkit.configuration.file.FileConfiguration
import org.bukkit.configuration.file.YamlConfiguration
import java.io.File

/*
class CustomFile(name: String, homeFolder: String?, loggable: Boolean, plugin: CrazyClaims?) {
    /**
     * Get the name of the file without the .yml part.
     * @return The name of the file without the .yml.
     */
    val name: String

    // Get the full name of the file with .yml included.
    val fileName: String

    // Get the name of the home folder where the file is.
    val homeFolder: String?

    // Get the custom file.
    var file: FileConfiguration?
    private val blankFile: File
    private val plugin: CrazyClaims?
    private val loggable: Boolean

    /**
     * A custom file that is being made.
     * @param name Name of the file.
     * @param homeFolder The home folder of the file.
     */
    init {
        this.name = name.replace(".yml", "")
        fileName = name
        this.homeFolder = homeFolder
        this.plugin = plugin
        this.loggable = loggable
        val newFile = File(this.plugin!!.dataFolder, "/$homeFolder")
        val namedFile = File(newFile, "/$name")
        blankFile = File(this.plugin.dataFolder, "/$homeFolder/$fileName")
        if (newFile.exists()) {
            file = if (namedFile.exists()) {
                YamlConfiguration.loadConfiguration(namedFile)
            } else {
                null
            }
            return
        }
        newFile.mkdirs()
        if (this.loggable) this.plugin.logger.info("The folder $homeFolder/ was not found so it was created.")
        file = null
    }

    // Check if file exists, True if yes, False if no.
    fun exists(): Boolean {
        return file != null
    }

    // Save the file.
    fun saveFile(): Boolean {
        if (file == null) return true
        try {
            file!!.save(blankFile)
            if (loggable) plugin!!.logger.info("Saved $fileName.")
            return true
        } catch (e: Exception) {
            plugin!!.logger.warning("Could not save $fileName!")
            for (stack in e.stackTrace) {
                plugin.logger.severe(stack.toString())
            }
        }
        if (loggable) plugin!!.logger.warning("There was a null custom file that could not be found!")
        return false
    }

    // Reload the file.
    fun reloadFile(): Boolean {
        if (file == null) return true
        try {
            file = YamlConfiguration.loadConfiguration(blankFile)
            if (loggable) plugin!!.logger.info("Reloaded $fileName.")
        } catch (e: Exception) {
            plugin!!.logger.warning("Could not save $fileName!")
            for (stack in e.stackTrace) {
                plugin.logger.severe(stack.toString())
            }
        }
        if (loggable) plugin!!.logger.warning("There was a null custom file that could not be found!")
        return false
    }
}
 */