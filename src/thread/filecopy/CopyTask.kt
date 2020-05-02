package thread.filecopy

import java.io.IOException

class CopyTask (val sourceFile:String,val destFile:String):Runnable{

    override fun run() {
        try {
        IOUtils.copyFile(sourceFile,destFile)
        }catch (e:IOException){
            e.printStackTrace()
        }
    }
}