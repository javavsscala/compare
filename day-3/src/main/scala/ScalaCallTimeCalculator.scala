import java.util.Calendar

/**
 * A mechanism to time function call or a code block
 */
object ScalaCallTimeCalculator extends App {

  def timerMS(body: => Unit) : Long = {

    var diff = 0L;
    val before = Calendar.getInstance().getTime.getTime
    //println(new java.util.Date)
    try {
      body
      //Thread.sleep(10000)
    } finally {
      //println(new java.util.Date)
      val after = Calendar.getInstance().getTime.getTime
      diff = after - before
    }
    diff
  }

  //Sample Run
  def longOperation(): Unit = {
    Thread.sleep(1000)
  }

  val timeInMillisecs = timerMS {
    longOperation
  }

  println(s"Time taken for operation is $timeInMillisecs")

}
