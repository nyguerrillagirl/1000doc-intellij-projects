package brainycode;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class UserRegistrationValidator {
    private static final List<ValidationRule<String>> PASSWORD_RULES = Arrays.asList(
        ValidationRule.of(s -> s.length() >= 8, "Password must be at least 8 characters"),
        ValidationRule.of(s -> s.chars().anyMatch(Character::isDigit), "Password must contain a digit"),
        ValidationRule.of(s -> s.chars().anyMatch(Character::isUpperCase), "Password must contain an uppercase letter"),
        ValidationRule.of(s -> !s.contains(" "), "Password must not contain spaces")
    );

    public List<String> validatePassword(String password) {
        return PASSWORD_RULES.stream()
                .map(rule -> rule.check(password))      // run each rule
                .filter(Optional::isPresent)                               // keep failures
                .map(Optional::get)                                        // extract message
                .toList();                                                 // Java 16+ (Collectors.toList() for Java 8)
    }


    public static void main(String[] args) {
        UserRegistrationValidator userRegistrationValidator = new UserRegistrationValidator();
        List<String> errors = userRegistrationValidator.validatePassword("weak");

        System.out.println(errors);
    }
}
