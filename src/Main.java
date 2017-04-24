import java.io.*;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.stream.Stream;

/**
 * Created by mdb17 on 4/12/2017.
 */
public class Main {
    public static String left;
    public static String id;
    public static String s;
    public static String b[];
    public static String y[];
    public static int t = 0;
    public static double fr = 0.0;
    public static String a = "";
    public static double c[];
    public static double p = 0.0;
    public static double numoferrors = 0.0;
    public static double sub;
    public static Scanner raw;
    public static ArrayList<String> id1 = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        ArrayList<String> errornum = new ArrayList<>();
        ArrayList<String> fr1 = new ArrayList<>();
        raw = new Scanner(new File("raw"));
        Scanner sc2 = new Scanner(new File("raw"));
        while (raw.hasNextLine()) {
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
                    b = Stream.of(s.split("\\+")).filter(x -> !x.isEmpty()).toArray(String[]::new);
                } catch (IndexOutOfBoundsException b) {
                    raw.next();
                }
            } catch (NoSuchElementException c) {
                System.out.println();
            }

            p = 0;
            numoferrors = 0;
            fix.fix1();

        }
        while (sc2.hasNextLine()) {
            y = sc2.nextLine().split("\\t");
            id1.add(y[0]);
            fr1.add(y[1]);
            errornum.add(y[2]);
        }
        int count = 1;
        double n = 0;
        double two[] = new double[fix.totalList.size()];
        while (count < id1.size()) {

            String s = fr1.get(count);
            s = s.replaceAll("[^0123456789.+]", "");
            String y[] = s.split("\\+");
            n = Double.parseDouble(errornum.get(count));
            System.out.println(id1.get(count));
            try {
                fix.getFR1(y, n);
                two[count] = fix.totalList.get(count) - fix.q;
                System.out.println("FR2: " + two[count]);
                System.out.println("TOTAL " + fix.totalList.get(count));
                System.out.println();
            }//STILL HAVE TO FIGURE THIS CATCH STATEMENT OUT
            catch (NumberFormatException er) {
                System.out.println(531824532);
                String a = fr1.get(count);
                a = a.substring(a.length() - 2, a.length() - 1);
                a = fr1.get(count).replace(a, "");
                a = a.replaceAll("[^0123456789.+]", "");
                String p[] = a.split("\\+");
                n = Double.parseDouble(errornum.get(count));
                fix.getFR1(p, n);
                two[count] = fix.totalList.get(count) - fix.q;
                System.out.println("FR2: " + two[count]);
                System.out.println("TOTAL " + fix.totalList.get(count));
                System.out.println();


            }
            count++;
        }
    }
}
