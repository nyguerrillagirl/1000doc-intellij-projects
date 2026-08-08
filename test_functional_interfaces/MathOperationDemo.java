public class MathOperationDemo {

    public static void main(String[] args) {
        MathOperation add = (a, b) -> a + b;
        MathOperation multiply = (a, b) -> a * b;

        System.out.println(add.operate(10, 20));
        System.out.println(multiply.operate(10, 20));
    }
}
