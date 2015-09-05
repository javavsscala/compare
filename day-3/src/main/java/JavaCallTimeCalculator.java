/**
 * A mechanism to time function call or a code block
 */
public class JavaCallTimeCalculator {

	public static void main(String[] args) {
        //Sample Run
        CallTimeCalculator ctc = new CallTimeCalculator() {
            @Override
            public void execute() {
                try {
                    //Begin Body of code for which to measure time
                    Thread.sleep(1000);
                    //End Body
                } catch (InterruptedException e) {
                }
            }
        };

        long timeMS = ctc.calculateTime();
        System.out.println(String.format("Time Taken in ms:%d", timeMS));
	}

    private static abstract class CallTimeCalculator {
        public long calculateTime() {
            long beforeTimeMS = System.currentTimeMillis();
            try {
                execute();
            } finally {
                long afterTimeMS = System.currentTimeMillis();
                return (afterTimeMS-beforeTimeMS);
            }
        }

        public abstract void execute();
    }


}






