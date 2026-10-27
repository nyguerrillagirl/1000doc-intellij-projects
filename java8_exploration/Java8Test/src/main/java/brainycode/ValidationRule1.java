package brainycode;

@FunctionalInterface
public interface ValidationRule1 {
    String check(String value); // return null if OK, otherwise an error message
}


