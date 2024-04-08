package `in`.bitcode.internalstorage

import android.content.Context
import java.io.File
import java.io.FileInputStream
import java.io.FileOutputStream

object FileUtil {

    fun createDirectory(dirName: String): Boolean {
        val dir = File(dirName)
        if (dir.exists()) {
            return true
        }
        return dir.mkdir()
    }

    fun createFile(filePath: String): Boolean {
        val newFile = File(filePath)
        if (newFile.exists()) {
            return true
        }
        return newFile.createNewFile()
    }

    fun deleteFile(filePath: String): Boolean {
        val file = File(filePath)
        if (!file.exists()) {
            return false
        }
        if (file.isFile) {
            return file.delete()
        }

        //delete the files under the file which is a dir
        for (f in file.listFiles()) {
            deleteFile(f.absolutePath)
        }

        return file.delete()
    }

    fun writeData(filePath: String, data : String) {
        val fout = FileOutputStream(filePath, true)
        fout.write(data.toByteArray())
        fout.close()
    }

    fun readData(filePath: String) : String {
        val fin = FileInputStream(filePath)
        val data = ByteArray(1024)
        val count = fin.read(data)
        fin.close()
        return String(data, 0, count)
    }

}