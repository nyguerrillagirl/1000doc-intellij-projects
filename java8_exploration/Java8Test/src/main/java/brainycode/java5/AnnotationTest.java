package brainycode.java5;

public class AnnotationTest {

    @MyLog("Executing sayHello")
    public void sayHello() {
        System.out.println("Hello!");
    }

    public static void main(String[] args) throws Exception {
        AnnotationTest t = new AnnotationTest();

        // Reflectively read the annotation
        var method = t.getClass().getMethod("sayHello");

        if (method.isAnnotationPresent(MyLog.class)) {
            MyLog log = method.getAnnotation(MyLog.class);
            System.out.println("Annotation says: " + log.value());
        }

        t.sayHello();
    }
}
