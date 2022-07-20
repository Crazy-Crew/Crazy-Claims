package com.badbones69.crazyclaims.paper.api.config

/*
@Singleton
class LangFile : IConfigFile {
    @Inject
    @Named("ConfigFolder")
    private val configFolder: File? = null

    @Inject
    private val methods: Methods? = null

    @Inject
    private val plugin: CrazyClaims? = null

    @Inject
    private val fileManager: FileManager? = null

    @Inject
    private val configFile: ConfigFile? = null
    private var blankFile: File? = null
    private fun create() {
        blankFile = File(configFolder, "/locale/" + configFile.getFile().getString("settings.language-file"))
        if (!blankFile!!.exists()) {
            val jarFile: InputStream = plugin.javaClass.getResourceAsStream(
                "/locale/" + configFile.getFile().getString("settings.language-file")
            )
            methods.copyFile(jarFile, blankFile)
        }
    }

    override fun load() {
        // Copy the file from src/main/resources
        create()
        fileManager!!.addConfiguration(
            blankFile!!.name, blankFile, YamlConfiguration.loadConfiguration(
                blankFile!!
            )
        )
    }

    override fun save() {
        // Copy the file from src/main/resources
        create()
        fileManager!!.saveFile(blankFile!!.name)
    }

    override fun remove() {
        fileManager!!.removeFile(blankFile!!.name)
    }

    override fun reload() {
        fileManager!!.reloadFile(
            blankFile!!.name, YamlConfiguration.loadConfiguration(
                fileManager.getFile(blankFile)!!
            )
        )
    }

    val file: FileConfiguration?
        get() = fileManager!!.getFile(blankFile!!.name)
}
 */