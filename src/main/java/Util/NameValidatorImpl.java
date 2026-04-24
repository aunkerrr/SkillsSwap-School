package Util;

public class NameValidatorImpl implements NameValidator {
    private static final String NAME_REGEX = "^[A-Za-zА-Яа-я\\s\\-]+$";

    @Override
    public boolean isValid(String name) {
        if (name == null || name.isEmpty()) {
            return false;
        }
        return name.matches(NAME_REGEX);
    }
}
