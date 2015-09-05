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

  /**
   * Examine the longOperation method. In particular the use of a FiniteDuration instance.
   * It demonstrates a number scala features.
   * "2 seconds" translates to 2.seconds().
   *  If the method has no parameters in parameter then the parenthesis can be dropped.
   *  The dot between an instance and the method name can be dropped as well.
   *  However there is no seconds() method on the Int class.
   *  So yet another feature called implicits is used.
   *  The implicit feature looks for a class in scope that can use "2"(Int) to construct an instance of itself.
   *  In addition that class must have a method seconds()
   *  DurationInt is the class that satisfies this constraint.
   *  The third item to notice in this case is that the import is done inside the method longOperation.
   *  This feature allows imports to be be done closest to the point of use.
   *  The scope of the import is restricted to the block in which it is declared and blocks inside it.
   */
  //Sample Run
  def longOperation(): Unit = {
    import scala.concurrent.duration._
    val time: FiniteDuration = 2 seconds
    val ms =  time.toMillis
    Thread.sleep(time.toMillis)
  }

  val timeInMillisecs = timerMS {
    longOperation
  }

  println(s"Time taken for operation is $timeInMillisecs")

}
