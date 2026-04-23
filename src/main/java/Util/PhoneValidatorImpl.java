package Util;

import com.google.i18n.phonenumbers.NumberParseException;
import com.google.i18n.phonenumbers.PhoneNumberUtil;
import com.google.i18n.phonenumbers.Phonenumber;

public class PhoneValidatorImpl implements PhoneValidator{
    // Singleton google parser
    private static final PhoneNumberUtil phoneUtil = PhoneNumberUtil.getInstance();

    @Override
    public boolean isValid(String phone) {
        if (phone == null || phone.trim().isEmpty()) {
            return false;
        }

        try {
           Phonenumber.PhoneNumber numberProto = phoneUtil.parse(phone, "IT");
           return phoneUtil.isValidNumber(numberProto);
        }  catch (NumberParseException exception) { // If there is real trash inside
            return false;
        }                                        
    }

    @Override
    public String numberFormatter(String phone) {
        try {
            Phonenumber.PhoneNumber numberProto =  phoneUtil.parse(phone, "IT");
            return phoneUtil.format(numberProto, PhoneNumberUtil.PhoneNumberFormat.INTERNATIONAL);
        }   catch (NumberParseException exception) {
            return phone;
        }
    }
}
