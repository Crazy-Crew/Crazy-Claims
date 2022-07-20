package com.badbones69.crazyclaims.paper.api.config

class ConfigFile {


    private fun create() {
        //blankFile = File(configFolder, "/" + "config.yml")
        //if (!blankFile!!.exists()) {
        //    val jarFile: InputStream = plugin.javaClass.getResourceAsStream("/" + "config.yml")
        //    methods.copyFile(jarFile, blankFile)
        //}
    }

    fun load() {
        // Copy the file from src/main/resources
        // create()
        //fileManager!!.addConfiguration(
        //    blankFile!!.name, blankFile, YamlConfiguration.loadConfiguration(
        //        blankFile!!
        //    )
        //)
    }

    fun save() {
        // Copy the file from src/main/resources
        // create()
       // fileManager!!.saveFile(blankFile!!.name)
    }

    fun remove() {
        //fileManager!!.removeFile(blankFile!!.name)
    }

    fun reload() {
        //fileManager!!.reloadFile(
        //    blankFile!!.name, YamlConfiguration.loadConfiguration(
        //        fileManager.getFile(blankFile)!!
        //    )
        //)
    }

    //val file: FileConfiguration? get() = fileManager!!.getFile(blankFile!!.name)
}