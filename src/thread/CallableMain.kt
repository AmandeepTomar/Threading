package thread

import java.util.concurrent.Callable
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors
import java.util.concurrent.Future

data class UserProfile(val name:String,val age:Int,val isAdult:Boolean)

fun main() {

    println("Main start")
    val executorService= Executors.newFixedThreadPool(1)
    for (i in 1..100){
        print("Mian one ")
    }
    val future= createCallable(executorService)
    for (i in 1..100){
        print("Mian two ")
    }
    while (!future.isDone)
        ;

        val getList=future.get()
    println("Final List $getList")

    for (i in 1..100){
        print("Mian three ")
    }

}


fun createCallable(executorService: ExecutorService): Future<List<UserProfile>> {
    val future=executorService.submit(object :Callable<List<UserProfile>>{
        override fun call(): List<UserProfile> {
            return getUserProfileList()
        }
    })

    return future

}

fun getUserProfileList(): MutableList<UserProfile> {
    val userList= mutableListOf<UserProfile>()

    for (i in 1..10){
        userList.add(UserProfile("Amandeep $i",i,true))
        Thread.sleep(1000)
        println("$i item added in list")
    }

    return userList
}
