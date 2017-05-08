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
    public static String h[];
    public static int t = 0;
    public static double fr = 0.0;
    public static String a = "";
    public static double c[];
    public static double p = 0.0;
    public static double numoferrors = 0.0;
    public static double sub;
    public static Scanner raw;
    public static ArrayList<String> id1 = new ArrayList<>();
    public static ArrayList<String> id5 = new ArrayList<>();
    public static ArrayList<Double> fr2list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        ArrayList<String> errornum = new ArrayList<>();
        ArrayList<Double> errornumdouble = new ArrayList<>();
        ArrayList<String> fr1 = new ArrayList<>();
        ArrayList<Double> tot = new ArrayList<>();
        raw = new Scanner(new File("raw"));
        Scanner sc2 = new Scanner(new File("raw"));
        Scanner sc3 = new Scanner(new File("raw"));
        while (raw.hasNextLine()) {
            try {
                left = raw.nextLine().replaceAll("[^0123456789.+]", "");
                char p[] = left.toCharArray();
                try {
                    id = "";
                    if (Character.isDigit(p[0])) {
                        if (Character.isDigit(p[1])) {
                            id = (p[0] + "" + p[1]);
                            id5.add(id);
                        } else {
                            id = (p[0] + "");
                            id5.add(id);
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
        sc3.nextLine();
        while (sc3.hasNextLine()) {
            y = sc3.nextLine().split("\\t");
            id1.add(y[0]);
            fr1.add(y[1]);
            errornum.add(y[3]);
            //  System.out.println(y[5]);
        }
        //sc3.nextLine();
        for (int i = 0; i < fr1.size(); i++) {


            try {
                if (!errornum.get(i).isEmpty()) {

                    errornumdouble.add(Double.parseDouble(errornum.get(i)));
                }
            } catch (NumberFormatException t) {
                errornumdouble.add(0.0);
            }


            // System.out.println(i + " " + errornum.get(i));
            // System.out.println(errornum.get(i));
        }


        int count = 1;
        double n = 0;
        double two[] = new double[fix.totalList.size()];
        while (count < id1.size()) {

            String s = fr1.get(count);
            s = s.replaceAll("[^0123456789.]", " ");
            String y[] = s.split("\\+");
//            n = Double.parseDouble(errornum.get(count));

            // fix.getFR2(y, n);
            two[count] = fix.totalList.get(count) - fix.q;
            fr2list.add(two[count]);
            double one[] = new double[7];
            // double tot[] = new double[56];
            double totalone = 0;

            String ji = y[0];
            ji = ji.replaceAll("[^0123456789.]", " ");
            h = ji.split("\\\\s+");
            Scanner hiya = new Scanner(h[0]);
            int a = 0;
            while (hiya.hasNext()) {
                String hi = hiya.next();
                try {
                    one[a] = Double.parseDouble(hi);
                    totalone += one[a];
                    //   System.out.println(one[a] + "  " + a + "  " + totalone);
                    a++;


                } catch (NumberFormatException e) {

                }

            }

            tot.add(totalone);
            //    System.out.println(tot.get(count - 1));
            count++;


        }
        tot.add(3.5);
        for (int i = 0; i < errornumdouble.size(); i++) {
            System.out.println(id5.get(i) + " FR #1: " + ((tot.get(i)) - ((errornumdouble.get(i) * .25))) + "   FR# 2: " + ((fix.totalList.get(i)) - (tot.get(i)) - ((errornumdouble.get(i) * .25))));
            // System.out.println(fix.totalList.get(i+1));
        }


    }
}
