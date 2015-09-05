import java.math.BigInteger

import scala.annotation.tailrec

/**
 * Fibonacci at any position is the sum of fibonacci at previous to positions:
 * Positions start at 0
 * position 0 is returned by fib(0) and is 0,
 * position 1 is fib(1) = 1 and
 * fib(n) = fib(n-1) + fib(n-2)
 */
object ScalaFibonacci extends App{

  def fib(pos: Int) : BigInteger = {
    fib(BigInteger.valueOf(0),BigInteger.valueOf(1), pos)
  }

  @tailrec
  def fib(a: BigInteger, b: BigInteger, pos: Int) : BigInteger = {
    if(pos == 0) {
      a
    } else {
      fib(b, a.add(b), pos -1)
    }
  }

  //Sample Run
  val positionList = List(0, 1, 2, 3, 4, 5, 6, 7, 8, 1000, 2000, 3000, 4000, 5000, 6000, 7000, 8000, 9000, 10000)
  for (position <- positionList) {
    val fibNumber = fib(position)
    println(s"Fibonacci for position $position=$fibNumber")
  }

}
