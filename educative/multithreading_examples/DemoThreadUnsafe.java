import java.util.Random;

public class DemoThreadUnsafe {

    // We'll use this to randomly sleep our threads
    static Random random = new Random(System.currentTimeMillis());

    public static void main(String[] args) throws InterruptedException {
        // create object of unsafe counter
        ThreadUnsafeCounter badCounter = new ThreadUnsafeCounter();

        // setup thread1 to increment the badCounter 10000 times
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10000; i++) {
                    badCounter.increment();
                    DemoThreadUnsafe.sleepRandomlyForLessThan2MilliSecs();
                }
            }
        });

        // setup thread2 to decrement the badCounter 10000 times
        Thread thread2 = new Thread(new Runnable() {

            @Override
            public void run() {
                for (int i = 0; i < 10000; i++) {
                    badCounter.decrement();
                    DemoThreadUnsafe.sleepRandomlyForLessThan2MilliSecs();
                }
            }
        });

        // run both threads
        thread1.start();
        thread2.start();

        // wait for t1 and t2 to complete.
        thread1.join();
        thread2.join();

        // print final value of counter
        badCounter.printFinalCounterValue();
    }

    public static void sleepRandomlyForLessThan2MilliSecs() {
        try {
            Thread.sleep(random.nextInt(2));
        } catch (InterruptedException ie) {
        }
    }
}
