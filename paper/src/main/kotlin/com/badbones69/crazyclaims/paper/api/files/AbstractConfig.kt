package com.badbones69.crazyclaims.paper.api.files

import com.badbones69.crazyclaims.paper.api.files.annotations.Comment
import com.badbones69.crazyclaims.paper.api.files.annotations.Key
import org.bukkit.configuration.file.FileConfiguration
import org.bukkit.configuration.file.YamlConfiguration
import java.io.File
import java.nio.file.Path
import kotlin.reflect.full.memberProperties

/**
 * @author BillyGalbreath
 * @maintainer Ryder Belserion
 * @see <a href="https://github.com/BillyGalbreath">...</a>
 */
// TODO() - Use mini message for logging.
open class AbstractConfig {

    private val files: HashSet<File> = hashSetOf()

    private val configurations: HashMap<File, FileConfiguration> = hashMapOf()

    fun save(path: Path, classObject: Class<*>) {
        files.clear()
        configurations.clear()

        val file = path.toFile()

        // Create file
        if (!file.exists()) file.createNewFile()

        // Add file to hashSet.
        addFile(file)

        // Put file in hashmap.
        addConfiguration(file)

        val getConfig = getConfiguration(file)

        // Set option values.
        getConfig?.options()?.copyDefaults(true)
        getConfig?.options()?.parseComments(true)

        runCatching {
            // Load the file.
            getConfig?.load(file)
        }.onFailure {
            it.printStackTrace()
        }

        println("Pre-forloop")

        classObject.kotlin.memberProperties.forEach {

            println(it.getter.call(this))

            println(it.name)
        }

        classObject.declaredFields.forEach {
            val key = it.getDeclaredAnnotation(Key::class.java)
            val comment = it.getDeclaredAnnotation(Comment::class.java)

            println(key.value)
            println(comment.value)
        }

        runCatching {
            // Save the file.
            getConfig?.save(file)
        }.onFailure {
            it.printStackTrace()
        }
    }

    private fun addFile(file: File) = files.add(file)

    private fun addConfiguration(file: File) {
        configurations[file] = YamlConfiguration.loadConfiguration(file)
    }

    private fun getConfiguration(file: File) = configurations[file]

    private fun getValues(file: File, path: String, default: Any): Any? {
        if (getConfiguration(file)?.get(path) == null) getConfiguration(file)?.set(path, default)

        return getConfiguration(file)?.get(path)
    }
}