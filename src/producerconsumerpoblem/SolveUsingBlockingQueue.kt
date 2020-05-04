package producerconsumerpoblem

import java.util.concurrent.ArrayBlockingQueue
import java.util.concurrent.BlockingDeque
import java.util.concurrent.BlockingQueue

class SolveUsingBlockingQueue(val producerBlocking: ProducerBlocking,val consumerBlocking: ConsumerBlocking) {


init {
    val producing=Thread(producerBlocking)
    val consuming=Thread(consumerBlocking)
    producing.start()
    consuming.start()
}





}

class ProducerBlocking(val messageQueue: BlockingQueue<String>):Runnable{
    override fun run() {
        for (i in 1..10){
            val msg="Produce $i"
            messageQueue.put(msg)
            println(msg)
        }
    }
}

class ConsumerBlocking(val messageQueue: BlockingQueue<String>):Runnable{
    override fun run() {
        for (i in 1..10){
            val msg= messageQueue.take()
            println(msg)
        }
    }
}