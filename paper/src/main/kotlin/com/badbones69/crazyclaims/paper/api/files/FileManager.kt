package com.badbones69.crazyclaims.paper.api.files

import com.badbones69.crazyclaims.paper.plugin
import org.bukkit.configuration.file.YamlConfiguration
import java.io.File

// TODO() - Use mini message for logging.
class FileManager {

    private val homeFolders = arrayListOf<String>()
    private val customFiles = arrayListOf<CustomFile>()
    private val jarHomeFolders = hashMapOf<String, String>()
    private val autoGeneratedFiles = hashMapOf<String, String>()

    fun setup(): FileManager {
        if (!plugin.dataFolder.exists()) plugin.dataFolder.mkdirs()

        if (isHomeFoldersEmpty()) {
            getHomeFolders().forEach { homeFolder ->
                val homeFile = File(plugin.dataFolder, "/$homeFolder")
                var folder = homeFolder

                if (homeFile.exists()) {
                    homeFile.list()?.forEach { name ->
                        if (name.endsWith(".yml")) {
                            val customFile = CustomFile(name, folder)

                            if (customFile.exists()) addCustomFile(customFile)
                        }
                    }

                    return this
                } else {
                    homeFile.mkdir()

                    val autoGenerated = getAutoGeneratedFiles()

                    autoGenerated.keys.forEach { fileName ->
                        if (autoGenerated[fileName].equals(folder, ignoreCase = true)) {
                            folder = autoGenerated[fileName].toString()

                            runCatching {
                                if (fileName.lowercase().endsWith(".yml")) customFiles.add(CustomFile(fileName, homeFolder))
                            }.onSuccess {
                                plugin.logger.info("Created default file: $folder/$fileName")
                            }.onFailure {
                                plugin.logger.warning("Could not save $fileName")

                                it.printStackTrace()
                            }
                        }
                    }
                }
            }
        }

        return this
    }

    private fun isHomeFoldersEmpty() = homeFolders.size > 0

    private fun getHomeFolders() = homeFolders

    private fun getAutoGeneratedFiles() = autoGeneratedFiles

    private fun getOrDefault(fileName: String, folder: String) = jarHomeFolders.getOrDefault(fileName, folder)

    fun registerCustomFolder(homeFolder: String): FileManager {
        homeFolders.add(homeFolder)

        return this
    }

    fun unregisterCustomFolder(homeFolder: String): FileManager {
        homeFolders.remove(homeFolder)

        return this
    }

    fun registerDefaultGeneratedFiles(fileName: String, homeFolder: String): FileManager {
        autoGeneratedFiles[fileName] = homeFolder
        jarHomeFolders[fileName] = homeFolder

        return this
    }

    fun unregisterDefaultGeneratedFiles(fileName: String): FileManager {
        autoGeneratedFiles.remove(fileName)
        jarHomeFolders.remove(fileName)

        return this
    }

    private fun addCustomFile(customFile: CustomFile) {
        customFiles.add(customFile)

        plugin.logger.info("Loaded custom file: ${customFile.getHomeFolder()}/${customFile.getFileName()}!")
    }

    private fun getCustom(fileName: String): CustomFile? {
        customFiles.forEach {
            if (it.getFileName().equals(fileName, ignoreCase = true)) return it
        }

        return null
    }

    fun saveCustom(fileName: String) {
        val customFile = getCustom(fileName) ?: return

        runCatching {
            customFile.getFile?.save(File(plugin.dataFolder, "${customFile.getHomeFolder()}/${customFile.getFileName()}"))
        }.onFailure {
            plugin.logger.warning("Could not save ${customFile.getFileName()}!")

            it.printStackTrace()
        }.onSuccess {
            plugin.logger.info("Successfully saved ${customFile.getFileName()}.")
        }
    }

    fun reloadCustom(fileName: String) {
        val customFile = getCustom(fileName) ?: return

        runCatching {
            customFile.getFile = YamlConfiguration.loadConfiguration(File(plugin.dataFolder, "/${customFile.getHomeFolder()}/${customFile.getFileName()}"))
        }.onFailure {
            plugin.logger.warning("Could not reload ${customFile.getFileName()}!")

            it.printStackTrace()
        }.onSuccess {
            plugin.logger.info("Successfully reloaded ${customFile.getFileName()}.")
        }
    }
}