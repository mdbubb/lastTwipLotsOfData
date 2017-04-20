
import java.io.*;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.regex.*;
import java.util.stream.Stream;

/**
 * Created by mdb17 on 4/12/2017.
 */
public class Main {
    public static String left;
    public static String id;
    public static String s;
    public static String b[];
    public static String g;
    public static String y[];
    public static int t = 0;
    public static double total = 0.0;
    public static String a = "";
    public static double c[];
    public static double p = 0.0;
    public static double numoferrors = 0.0;
    public static double sub;
    public static Scanner raw;
//
    public static void main(String[] args) throws IOException {

        raw = new Scanner(new File("raw"));
        while (raw.hasNext()) {
            try {

                left = raw.nextLine().replaceAll("[^0123456789.+]", "");
                char p[] = left.toCharArray();
                try {
                    id = "";
                    if (Character.isDigit(p[0])) {
                        if (Character.isDigit(p[1])) {
                            id = (p[0] + "" + p[1]);
                        } else {
                            id = (p[0] + "");
                        }
                    }
                    StringBuilder d = new StringBuilder(left);

                    if (id.length() == 1) {
                        d.delete(0, 2);
                        s = d.toString();
                    } else {
                        d.delete(0, 3);
                        s = d.toString();

                    }


                    System.out.print(t + " ");
                    //  System.out.println(s);

                    b = Stream.of(s.split("\\+")).filter(x -> !x.isEmpty()).toArray(String[]::new);


                } catch (IndexOutOfBoundsException e) {
                    raw.next();
                }
            } catch (NoSuchElementException e) {
                System.out.println();
            }

            p = 0;
            numoferrors = 0;

            fix.fix1();
        }


    }
}
