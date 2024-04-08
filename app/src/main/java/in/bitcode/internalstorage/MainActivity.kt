package `in`.bitcode.internalstorage

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import `in`.bitcode.internalstorage.databinding.ActivityMainBinding
import java.io.FileInputStream
import java.io.FileOutputStream

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Internal Storage
        //1
        /* var fout : FileOutputStream =
             openFileOutput("demofile01.txt", Activity.MODE_APPEND or Activity.MODE_PRIVATE)
         fout.write("This is a file called demofile01.txt".toByteArray())
         fout.close()

         val data = ByteArray(1024)

         var fin : FileInputStream =
             openFileInput("demofile01.txt")
         var count = fin.read(data)
         binding.txtInfo.text = String(data, 0, count)*/

        //Delete the file
        //deleteFile("demofile01.txt")

        binding.txtInfo.text = filesDir.absolutePath

        /*FileUtil.createFile("${filesDir.absolutePath}/java01.txt")
        FileUtil.createFile("${filesDir.absolutePath}/android01.txt")

        FileUtil.createDirectory("${filesDir.absolutePath}/bitcode")
        FileUtil.createDirectory( "${filesDir.absolutePath}/bitcode/android")
        FileUtil.createDirectory("${filesDir.absolutePath}/bitcode/java")

        FileUtil.createFile("${filesDir.absolutePath}/bitcode/java/java01.java")
        FileUtil.createFile("${filesDir.absolutePath}/bitcode/java/java02.java")

        FileUtil.createFile("${filesDir.absolutePath}/bitcode/android/android01.kt")
        FileUtil.createFile("${filesDir.absolutePath}/bitcode/android/android02s.kt")*/

        /*FileUtil.writeData("${filesDir.absolutePath}/bitcode/java/java01.java", "This is dummy data being written to the file programmatically!")
        val fileData = FileUtil.readData("${filesDir.absolutePath}/bitcode/java/java01.java")
        binding.txtInfo.text = fileData*/

        //FileUtil.deleteFile("${filesDir.absolutePath}/java01.txt")
        //FileUtil.deleteFile("${filesDir.absolutePath}/bitcode")

        //binding.txtInfo.append("\n" + cacheDir.absolutePath)

        //External Storage
        val state = Environment.getExternalStorageState()
        if (state.equals(Environment.MEDIA_MOUNTED)) {
            binding.txtInfo.text = "R+W"
        } else {
            if (state.equals(Environment.MEDIA_MOUNTED_READ_ONLY)) {
                binding.txtInfo.text = "R"
            } else {
                binding.txtInfo.text = "Not Usable"
            }
        }

        val extStorageDir = Environment.getExternalStorageDirectory()
        binding.txtInfo.text = "\n" + extStorageDir.absolutePath


        val extStorageMusic = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_MUSIC)
        binding.txtInfo.append("\n" + extStorageMusic.absolutePath)

        val extAppFolder = getExternalFilesDir(null)
        binding.txtInfo.append("\n" + extAppFolder!!.absolutePath)

        val extAppMusicFolder = getExternalFilesDir(Environment.DIRECTORY_MUSIC)
        binding.txtInfo.append("\n" + extAppMusicFolder!!.absolutePath)

        binding.txtInfo.append("\n" + externalCacheDir!!.absolutePath)


    }
}