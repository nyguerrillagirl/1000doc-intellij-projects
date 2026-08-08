import java.util.function.Function;

public class TestTriFunction {

    public static void main(String[] args) {
        TriFunction<Integer, Integer, Integer, Integer> addThree =
                (a, b, c) -> a + b + c;

        System.out.println(addThree.apply(1, 2, 3));

        // Define a Function that doubles a number
        Function<Integer, Integer> doubleIt = x -> x * 2;
        // Chain them using andThen
        TriFunction<Integer, Integer, Integer, Integer> addThenDouble =
                addThree.andThen(doubleIt);
        int result = addThenDouble.apply(1, 2, 3);
        System.out.println(result);

        // Another simple example - build a full name
        TriFunction<String, String, String, String> fullName =
                (first, middle, last) -> first + " " + middle + " " + last;

        // Convert to uppercase
        Function<String, String> toUpper = s -> s.toUpperCase();

        // Chain them
        TriFunction<String, String, String, String> loudName =
                fullName.andThen(toUpper);

        System.out.println(loudName.apply("Lorraine", "Marie", "Smith"));

    }
}
