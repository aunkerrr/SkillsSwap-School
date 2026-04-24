package Util;

public class NameValidatorImpl implements NameValidator {
    @Override
    public boolean isValid(String name) {
        if (name == null || name.isEmpty()) {
            return false;
        }


    }
}
