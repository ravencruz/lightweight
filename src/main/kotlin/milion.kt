import kotlinx.coroutines.*
import java.util.concurrent.atomic.AtomicLong
import kotlin.concurrent.thread

fun main () {
//    val c = AtomicLong()
//
//    for (i in 1..1_000_000L)
//        thread(start = true) {
//            c.addAndGet(i)
//        }
//
//    println(c.get())


//    val c = AtomicLong()
//
//    for (i in 1..1_000_000L)
//        GlobalScope.launch {
//            c.addAndGet(i)
//        }
//    println(c.get())

    val deferred = (1..1_000_000).map { n ->
        GlobalScope.async {
//            delay(1000)
//            n
            workload(n)
        }
    }

    runBlocking {
        val sum = deferred.map { it.await().toLong() }.sum()
        println("Sum $sum")
    }

}

suspend fun workload(n: Int): Int {
    delay(1000)
    return n
}