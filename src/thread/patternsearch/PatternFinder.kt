package thread.patternsearch

import java.io.BufferedReader
import java.io.File
import java.io.FileReader

class PatternFinder {

    fun find(file: File,pattern: String): MutableList<Int> {
        val lineNumbers= mutableListOf<Int>()
        try {
            BufferedReader(FileReader(file)).use { br ->
                var lineNo = 1
                var line: String
                // for each line in the file.
                while (br.readLine().also { line = it } != null) {
                    if (line.contains(pattern)) { // capture the lineNo where the pattern is found.
                        lineNumbers.add(lineNo)
                    }
                    lineNo++
                }
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }


        Thread.sleep(1000)
        return lineNumbers
    }
}


fun main() {
    PatternSolutionSerial.findLineNumbers()
}