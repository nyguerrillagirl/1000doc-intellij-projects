package brainycode.java5;

public class RetentionTest {

    @MyLog("Testing retention")
    public void demo() {}

    public static void main(String[] args) throws NoSuchMethodException {
        var method = RetentionTest.class.getMethod("demo");
        var ann = method.getAnnotation(MyLog.class);

        System.out.println("Annotation Value: " + ann.value());
    }
}
