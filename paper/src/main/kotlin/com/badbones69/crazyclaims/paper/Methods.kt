package com.badbones69.crazyclaims.paper

import java.io.File
import java.io.FileOutputStream
import java.io.InputStream

class Methods {
    /*
    fun copyFile(sourceFile: InputStream, destinationFile: File?) {
        try {
            sourceFile.use { fis ->
                FileOutputStream(destinationFile).use { fos ->
                    val buf = ByteArray(1024)
                    var i: Int
                    while (fis.read(buf).also { i = it } != -1) {
                        fos.write(buf, 0, i)
                    }
                }
            }
        } catch (e: Exception) {
            plugin.getLogger().warning(e.message)
            for (stack in e.stackTrace) {
                plugin.getLogger().severe(stack.toString())
            }
        }
    }
     */
}