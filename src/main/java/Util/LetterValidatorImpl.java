package Util;

public class LetterValidatorImpl implements LetterValidator{
    private static final String NAME_REGEX = "^[A-Za-zа-яА-ЯЁё]{1,5}$";

    @Override
    public boolean isValid(String letters) {
        if (letters == null || letters.isEmpty()) {
            return false;
        }
        return letters.matches(NAME_REGEX);
    }
}
