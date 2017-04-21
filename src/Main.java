
import org.omg.CORBA.INTERNAL;

import java.io.*;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.regex.*;
import java.util.stream.DoubleStream;
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
    public static double fr = 0.0;
    public static String a = "";
    public static double c[];
    public static double p = 0.0;
    public static double numoferrors = 0.0;
    public static double sub;
    public static Scanner raw;

    //
    public static void main(String[] args) throws IOException {
        ArrayList<String> id1 = new ArrayList<>();
        ArrayList<String> errornum = new ArrayList<>();
        ArrayList<String> fr2 = new ArrayList<>();
        ArrayList<String> fr1 = new ArrayList<>();
        ArrayList<String> errornum2 = new ArrayList<>();
        ArrayList<String> comments1 = new ArrayList<>();


        raw = new Scanner(new File("raw"));
        Scanner sc2 = new Scanner(new File("raw"));


        while (sc2.hasNextLine()) {
            String s[] = sc2.nextLine().split("\\t");
            id1.add(s[0]);
            fr1.add(s[1]);
            errornum.add(s[2]);
            if (!s[3].startsWith("\"")) {
                comments1.add(s[3]);
                fr2.add(s[4]);
                errornum2.add(s[5]);
            } else {
                fr2.add(s[3]);
                try {
                    errornum2.add(s[4]);
                } catch (ArrayIndexOutOfBoundsException e) {
                    errornum2.add("0");
                }

            }





        }
        int e = 1;

        double[] id2 = new double[id1.size() - 1];
        for (int i = 1; i < id1.size() - 1; i++) {
            id2[i] = Double.parseDouble(id1.get(i));
            // System.out.println(fr1.get(i));
        }
        String s = fr1.get(1);
        s = s.replaceAll("[^0123456789.+]", "");
        String y []= s.split("\\+");
        int n = Integer.parseInt(errornum.get(1));
        //System.out.println(y[1]);
        fix.fix1(y,n);;
        //System.out.println(y[2]);


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

            // fix.fix1();


        }
    }

}
