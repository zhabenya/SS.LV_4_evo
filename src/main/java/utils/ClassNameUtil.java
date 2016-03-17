package utils;

/**
 * Created by zhabenya on 16.03.16.
 */
public class ClassNameUtil {

    private ClassNameUtil(){}

    public static String getCurrentClassName() {
        try {
            throw new RuntimeException();
        } catch (RuntimeException e){
            return e.getStackTrace()[1].getClassName();
        }
    }
}
