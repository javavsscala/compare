import java.math.BigInteger;

/**
 * Fibonacci at any position is the sum of fibonacci at previous to positions:
 * Positions start at 0
 * position 0 is returned by fib(0) and is 0,
 * position 1 is fib(1) = 1 and
 * fib(n) = fib(n-1) + fib(n-2)
 */
public class JavaFibonacci {

	public static void main(String[] args) {
        //Sample Run
        int[] positionList = new int[] { 0, 1, 2, 3, 4, 5, 6, 7, 8, 1000, 2000, 3000, 4000, 5000, 6000, 7000, 8000, 9000, 10000 };
        for (int position : positionList) {
            BigInteger fibNumber = fib(position);
            System.out.println(String.format("Fibonacci for position %d=%s", position, fibNumber.toString()));
        }
	}

    public static BigInteger fib(Integer pos) {
        return fib(BigInteger.valueOf(0),BigInteger.valueOf(1), pos);
    }


    private static BigInteger fib(BigInteger a, BigInteger b, int pos) {
        if(pos == 0) {
            return a;
        } else {
            return fib(b, a.add(b), pos -1);
        }
    }

}






