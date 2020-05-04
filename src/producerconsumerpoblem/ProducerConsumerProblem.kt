package producerconsumerpoblem

import java.util.concurrent.ArrayBlockingQueue

fun main() {


    solvingUsingBlockingQueue()

}

fun solvingUsingBlockingQueue(){
    val messageQueue=ArrayBlockingQueue<String>(1)
    val producer=ProducerBlocking(messageQueue)
    val consumer=ConsumerBlocking(messageQueue)

    SolveUsingBlockingQueue(producer,consumer)
}

fun solvingUsingWaitAndNotify(){
    val messageQueue = MessageQueueWaitNotify(1)
    val producer = Producer(messageQueue)
    val consumer = Consumer(messageQueue)

    SolveUsingWaitNotify(producer, consumer)
}

