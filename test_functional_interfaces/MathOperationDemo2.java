public class MathOperationDemo2 {
    public static int process(int x, int y, MathOperation op) {
        System.out.println("Processing numbers...");
        return op.operate(x, y);   // <-- calls the function we passed in
    }

    public static void main(String[] args) {
        MathOperation add = (a, b) -> a + b;
        MathOperation multiply = (a, b) -> a * b;

        int result1 = process(3, 4, add);
        int result2 = process(3, 4, multiply);

        System.out.println(result1);  // 7
        System.out.println(result2);  // 12
    }
}
