package za.ac.cput.Util;
import java.util.UUID;

public class CreateID {

    public static String createUUID(){
        return UUID.randomUUID().toString();
    }
}
