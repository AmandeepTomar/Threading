package thread.filecopy

import java.io.FileInputStream
import java.io.FileOutputStream
import java.io.IOException


object IOUtils {

   private fun copy(sorceInput:FileInputStream,destSource:FileOutputStream){
        var value: Int=-1
        while (sorceInput.read().also({ value = it }) != -1) {
            destSource.write(value)
        }
    }

    @Throws(IOException::class)
    fun copyFile(sourceFile:String,destinationFile:String){
        val fin = FileInputStream(sourceFile)
        val fout = FileOutputStream(destinationFile)

        copy(fin, fout)

        fin.close()
        fout.close()

        println(" copy $sourceFile to $destinationFile is done")
    }
}