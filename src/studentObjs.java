/**
 * Created by mb977 on 5/11/17.
 */
public class studentobjs {
    public static String i;
    public studentobjs(String id, double total, double one, double two) {
        i=id;

    }

    public static String toStrings() {

        return ("ID: " +studentobjs.i + "   Total: " + Main.averageTotal + "   FR#1: " + Main.average + "   FR:2 " + Main.averagetwo);


    }
}
