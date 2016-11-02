import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Created by awo on 02/11/16.
 */
public class Lang {
    private static String lang;
    private static String country;
    private static Locale locale;

    public static ResourceBundle resourceBundle;

    public static String msg(String message) { return resourceBundle.getString(message); }

    public static void setLanguage(String[] args) {
        if (args.length != 2) {
            lang    = "da";
            country = "DK";
        } else {
            lang    = args[0];
            country = args[1];
        }

        locale = new Locale(lang, country);
        resourceBundle = ResourceBundle.getBundle("lang", locale);
    }
}
