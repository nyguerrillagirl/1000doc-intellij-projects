package brainycode;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SimpleValidator {
    private static final ValidationRule1[] RULES = {
            s -> s.length() >= 8 ? null : "Password must be at least 8 characters",
            s -> s.chars().anyMatch(Character::isDigit) ? null : "Password must contain a digit",
            s -> s.chars().anyMatch(Character::isUpperCase) ? null : "Password must contain an uppercase letter",
            s -> !s.contains(" ") ? null : "Password must not contain spaces"
    };

    public String[] validate(String password) {
        List<String> errors = new ArrayList<>();

        for (ValidationRule1 rule : RULES) {
            String result = rule.check(password);
            if (result != null) {
                errors.add(result);
            }
        }

        return errors.toArray(new String[0]);
    }

    public static void main(String[] args) {
        SimpleValidator validator = new SimpleValidator();
        String[] errors = validator.validate("weak");

        System.out.println(Arrays.toString(errors));
    }
}
