package Util;

public class EmailValidatorImpl implements EmailValidator{
    private static final String EMAIL_REGEX = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9+_.-]+\\.[A-Za-z]{2,6}$";

    @Override
    public boolean isValid(String email) {
        if (email == null || email.isEmpty()) {
            return false;
        }
        return email.matches(EMAIL_REGEX);
    }
}
