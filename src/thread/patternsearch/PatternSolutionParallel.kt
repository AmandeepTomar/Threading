package thread.patternsearch

import org.omg.PortableServer.LIFESPAN_POLICY_ID
import java.io.File
import java.util.concurrent.Callable
import java.util.concurrent.Executors
import java.util.concurrent.Future


class PatternSolutionParallel {

    fun findLineNumbers(){
        val pattern = "aman"

        val dir = File("./src/sample")

        val files = dir.listFiles()
        val map=HashMap<String,Future<List<Int>>>()
        val startTime=System.currentTimeMillis()
        for (file in files){
            val executorService=Executors.newFixedThreadPool(4)
         val future:Future<List<Int>> =   executorService.submit(object :Callable<List<Int>>{
                override fun call(): List<Int> {
                   return PatternFinder().find(file,pattern)
                }
            })
            map[file.name] = future

            waitforAll(map)

            // Display the result.
            // Display the result.
            for ((key, value) in map) {
                println(
                    pattern + " found at - " + value +
                            " in file " + key
                )
            }


            System.out.println(
                " Time taken for search - "
                        + (System.currentTimeMillis() - startTime)
            )


        }
    }

    private fun waitforAll(map: java.util.HashMap<String, Future<List<Int>>>) {

        for (key in map.keys) {
            val future =map[key]
            while (!future?.isDone!!) { // Passing the CPU to other
// threads so that they can
// complete the operation.
// With out this we are simply
// keeping the CPU in loop and
// wasting its time.
                Thread.yield()
            }
            // Replace the future object with the obtained result.
            map.put(key, future)
        }

    }
}

fun main() {
    PatternSolutionParallel().findLineNumbers()

}