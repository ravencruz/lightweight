
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking


fun main() {
    
    println("Start")

    GlobalScope.launch {
        delay(1000)
        println("Hello")
    }

    runBlocking {
        delay(2000)
    }

    //Thread.sleep(2000) // wait for 2 seconds
    println("Stop")
}
