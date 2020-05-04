package thread.synchroniousproblem

class Counter(private var x: Int) {

    fun getX():Int{
        return x
    }

    // used @Synchronized to solve this block
    @Synchronized fun increment():Int{
        var y=x
        y++
        Thread.sleep(1)
        x=y
        return x
    }

    // solution 2
    fun incrementSynchronizedBlock():Int{
        synchronized(this){
            var y=x
            y++
            Thread.sleep(1)
            x=y
            return x
        }
    }

}

class MyTask(val counter: Counter):Runnable{
    override fun run() { counter.incrementSynchronizedBlock()
    }
}

fun main() {
    val counter=Counter(10)
    val thread1=Thread(MyTask(counter))
    val thread2=Thread(MyTask(counter))
    val thread3=Thread(MyTask(counter))
    val thread4=Thread(MyTask(counter))
    val thread5=Thread(MyTask(counter))
    val thread6=Thread(MyTask(counter))
    thread1.start()
    thread2.start()
    thread3.start()
    thread4.start()
    thread5.start()
    thread6.start()

    thread1.join()
    thread2.join()
    thread3.join()
    thread4.join()
    thread5.join()
    thread6.join()

    // here we use join method that will assure both thread will finish work

    println(counter.getX())
}