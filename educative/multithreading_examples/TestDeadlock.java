public class TestDeadlock {

    public static void main(String[] args) {
        Deadlock deadlock = new Deadlock();
        try {
            deadlock.runTest();
        } catch (InterruptedException e) {

        }
    }
}
