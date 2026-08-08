import java.util.Objects;
import java.util.function.Function;

@FunctionalInterface
public interface TriFunction<A, B, C, R> {
    R apply(A a, B b, C c);

    default <K> TriFunction<A, B, C, K> andThen(Function<?super R, ? extends K> f) {
        Objects.requireNonNull(f);
        return (A a, B b, C c) -> f.apply(apply(a, b, c));
    }
}
