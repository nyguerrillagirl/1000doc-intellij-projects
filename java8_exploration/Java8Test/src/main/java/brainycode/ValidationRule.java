package brainycode;

import java.util.Optional;
import java.util.function.Function;
import java.util.function.Predicate;

@FunctionalInterface
public interface ValidationRule<T> {
    Optional<String> check(T value);

    static <T> ValidationRule<T> of(Predicate<T> predicate, String message) {
        return value -> predicate.test(value)
                ? Optional.empty()
                : Optional.of(message);
    }
}
