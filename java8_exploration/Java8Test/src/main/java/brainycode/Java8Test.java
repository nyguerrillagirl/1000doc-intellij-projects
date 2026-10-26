package brainycode;

import java.time.LocalDate;
import java.util.*;
import java.util.function.Function;

public class Java8Test {
    public static void main(String[] args) {
        // Lambdas + Streams
        List<String> names = Arrays.asList("John", "Paul", "George", "Ringo", "Bob");
        names.stream()
                .filter(s -> s.length() > 3)
                .map(String::toUpperCase)
                .sorted()
                .forEach(System.out::println);

        // Optional
        Optional<String> opt = names.stream()
                .filter(s -> s.startsWith("F"))
                .findFirst();
        System.out.println(opt.orElse("none"));

        // Date/Time API
        LocalDate today = LocalDate.now();
        System.out.println("Today: " + today);

        // Default method
        List<Integer> nums = new ArrayList<>(Arrays.asList(3, 4, 1, 5, 2));
        nums.sort(Comparator.naturalOrder());
        System.out.println("Natural Order: " + nums);

        // Method reference
        Function<String, Integer> len = String::length;
        System.out.println("Length: " + len.apply("Hello"));
    }
}
