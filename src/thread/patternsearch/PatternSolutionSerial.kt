package thread.patternsearch

import java.io.File




object PatternSolutionSerial {


    fun findLineNumbers(){
        val pattern = "aman"

        val dir = File("./src/sample")

        val files = dir.listFiles()

        for (file in files){
            println(file.name)
            val lineNumbers=PatternFinder().find(file,pattern)
            if (lineNumbers.isNotEmpty()){
                println("$pattern find at $lineNumbers in ${file.name}")
            }

        }
    }


}