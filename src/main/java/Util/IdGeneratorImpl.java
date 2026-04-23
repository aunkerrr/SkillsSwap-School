package Util;

import java.util.UUID;

public class IdGeneratorImpl {
    public static String generateUuid() {
        return UUID.randomUUID().toString();
    }
}
