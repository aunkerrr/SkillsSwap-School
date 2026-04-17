package Util;

import java.util.UUID;

public class IdGeneratorImpl {
    private IdGeneratorImpl(){
    }

    public static String generateUuid() {
        return UUID.randomUUID().toString();
    }
}
