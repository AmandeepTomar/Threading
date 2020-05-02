package thread.filecopy

import java.util.concurrent.Executors


fun main() {

    val sourceFile = "a.txt"
    val sourceFile2 = "b.txt"
    val sourceFile3 = "c.txt"
    val sourceFile4 = "d.txt"
    val sourceFile5 = "e.txt"
    val sourceFile6 = "f.txt"

    val destFile = "g.txt"
    val destFile2 = "h.txt"
    val destFile3 = "i.txt"
    val destFile4 = "j.txt"
    val destFile5 = "k.txt"
    val destFile6 = "l.txt"


    // simple way
    //  IOUtils.copyFile(sourceFile,destFile)

    // In parallel way
    /**
     * 1. Create three task for parallel execution
     * run these task from main thread
     * basically 4 thread are in our project after that working in parallel
     * */

    val task1 = CopyTask(sourceFile, destFile)
    val task2 = CopyTask(sourceFile2, destFile2)
    val task3 = CopyTask(sourceFile3, destFile3)


    //   callThradCreationForEachTask(task1, task2, task3)

    // Using Executors to handle the unwanted thread creation or we can say we should not create new thread for each task.

    val task4 = CopyTask(sourceFile4, destFile4)
    val task5 = CopyTask(sourceFile5, destFile5)
    val task6 = CopyTask(sourceFile6, destFile6)


    //  callThreadExecutor(task1 = task1, task2 = task2, task3 = task3, task4 = task4, task5 = task5, task6 = task6)

    println("Done")

    createOwnThreadGroup(sourceFile,destFile)
    getThreadGroupInfo()

}


fun getThreadGroupInfo() {
    val thread = Thread.currentThread()
    println(thread)
    var currentThreadgroup = thread.threadGroup
    println(currentThreadgroup)
    while (currentThreadgroup.getParent() != null) {
        currentThreadgroup = currentThreadgroup.getParent();
    }
    currentThreadgroup.list()

    val threads = arrayOfNulls<Thread>(10)
    val n: Int = currentThreadgroup.enumerate(threads)

    for (i in 0 until n) {
        println(
            "Thread Name: " + threads[i]!!.name +
                    " ; isDaemon: " + threads[i]!!.isDaemon
        )
    }

    // output of for loop
    /**
     * Thread Name: Reference Handler ; isDaemon: true
    Thread Name: Finalizer ; isDaemon: true
    Thread Name: Signal Dispatcher ; isDaemon: true
    Thread Name: main ; isDaemon: false
    Thread Name: Monitor Ctrl-Break ; isDaemon: true
    Thread Name: Thread-0 ; isDaemon: false

     That means all reference , handler and signal Dispatcher threads are daemon thread they not prent jvm to stopping application.
     */



}

fun createOwnThreadGroup(src: String, dest: String) {
    val threadGroup = ThreadGroup("MyThreadGroup")
    threadGroup.maxPriority = 3

    val myTask = CopyTask(src, dest)
    val myThread = Thread(threadGroup, myTask)
    myThread.start()
}


fun callThreadExecutor(
    task1: CopyTask,
    task2: CopyTask,
    task3: CopyTask,
    task4: CopyTask,
    task5: CopyTask,
    task6: CopyTask
) {
    println("ExecutorService Called ---------------------------")
    val executor = Executors.newFixedThreadPool(2)

    executor.execute(task1)
    Thread.sleep(1000)
    executor.execute(task2)
    executor.execute(task3)
    Thread.sleep(1000)

    executor.execute(task4)
    Thread.sleep(1000)

    executor.execute(task5)
    Thread.sleep(1000)

    executor.execute(task6)
}

fun callThradCreationForEachTask(task1: CopyTask, task2: CopyTask, task3: CopyTask) {

    val thread1 = Thread(task1)
    val thread2 = Thread(task2)
    val thread3 = Thread(task3)

    thread1.start()
    thread2.start()
    thread3.start()
}
