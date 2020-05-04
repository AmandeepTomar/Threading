package producerconsumerpoblem

import org.omg.CORBA.Object
import java.util.*
import kotlin.reflect.jvm.internal.impl.load.kotlin.JvmType

class SolveUsingWaitNotify(val producer: Producer,val consumer: Consumer) {

    init {
        start()
    }
    private fun start(){
        val thread1 = Thread(producer)

        val thread2= Thread(consumer)
        thread1.start()
        thread2.start()
    }


}


class Producer(val messageQueue: MessageQueueWaitNotify) :Runnable{
    override fun run() {
        for (i in 1..10){
            val msg="Produce $i"
            messageQueue.enqueue(msg)
            println("Produce =$msg")
        }
    }
}

class Consumer(val messageQueue: MessageQueueWaitNotify) :Runnable{
    override fun run() {
        for (i in 1..10){
          val message=  messageQueue.dequeue()
            println("Consume =$message")
        }
    }
}