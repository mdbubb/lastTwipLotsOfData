/**
 * Created by mb977 on 5/11/17.
 */
public class studentobjs {
    public static String i;
    public static String n;
    public studentobjs(String name, String id, double total, double one, double two) {
        i=id;
        n=name;

    }

    public static String toStrings() {

        return ("Name: "+ studentobjs.n+"ID: " +studentobjs.i + "   Total: " + Main.averageTotal + "   FR#1: " + Main.average + "   FR:2 " + Main.averagetwo);


    }
}
