import java.io.*;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.stream.Stream;

/**
 * Created by mdb17 on 4/12/2017.
 */
public class Main {
    public static String lines;
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
    public static studentobjs objs;
    public static double average = 0;
    public static double averageTotal = 0;
    public static double averagetwo = 0;

    public static void main(String[] args) throws IOException {
        ArrayList<String> errornumstring = new ArrayList<>();
        ArrayList<Double> errornumdouble = new ArrayList<>();
        ArrayList<String> fr1 = new ArrayList<>();
        ArrayList<Double> tot = new ArrayList<>();
        raw = new Scanner(new File("raw"));
        Scanner sc3 = new Scanner(new File("raw"));
        while (raw.hasNextLine()) {
            try {
                lines = raw.nextLine().replaceAll("[^0123456789.+]", "");
                char p[] = lines.toCharArray();
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
                    StringBuilder d = new StringBuilder(lines);
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
        while (sc3.hasNextLine()) {
            y = sc3.nextLine().split("\\t");
            id1.add(y[0]);
            fr1.add(y[1]);
            errornumstring.add(y[3]);
        }
        for (int i = 1; i < fr1.size(); i++) {
            try {
                if (!errornumstring.get(i).isEmpty()) {

                    errornumdouble.add(Double.parseDouble(errornumstring.get(i)));
                }
            } catch (NumberFormatException t) {
                errornumdouble.add(0.0);
            }
        }
        int count = 1;
        double two[] = new double[fix.totalList.size()];
        while (count < id1.size()) {
            String s = fr1.get(count);
            s = s.replaceAll("[^0123456789.]", " ");
            String y[] = s.split("\\+");
            two[count] = fix.totalList.get(count) - fix.q;
            fr2list.add(two[count]);
            double one[] = new double[7];
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
                    a++;
                } catch (NumberFormatException e) {

                }
                //
            }
            tot.add(totalone);
            count++;
        }
        Scanner names = new Scanner(new File("names.txt")).useDelimiter("\\t");
        ArrayList<String> fileNames = new ArrayList<>();
        ArrayList<String> fileID = new ArrayList<>();


        String name = "";
        String num = "";
        while (names.hasNextLine()) {
            // read.add(names.nextLine());
            String curline = names.nextLine();
            String[] split = curline.split(" +");
            name = split[0].trim();
            fileNames.add(name);
            num = split[1].trim();
            fileID.add(num);
        }

        ArrayList<String> namestxt = new ArrayList<>();
        ArrayList<Integer> newID = new ArrayList<>();
        int i = 0;
        int t = 0;
        while (t < id5.size()) {
            while (i < id5.size()) {
                try {
                    if (fileID.get(t).equals(id5.get(i))) {
                        newID.add(Integer.parseInt(fileID.get(t)));
                        namestxt.add(fileNames.get(t));
                        // System.out.println(newID +" "+ namestxt);
                        t++;
                        i = 0;
                    } else {
                        i++;
                    }
                } catch (IndexOutOfBoundsException e) {
                    System.out.println("hi");
                }

            }

        }
        fix.totalList.remove(0);
        int j = 0;
        while (j < fix.totalList.size()) {
            if (id5.get(j).equals(id5.get(j + 1))) {
                average = (((tot.get(j)) - ((errornumdouble.get(j) * .25))) + ((tot.get(j + 1)) - ((errornumdouble.get(j + 1) * .25)))) / 2;
                averageTotal = (fix.totalList.get(j) + fix.totalList.get(j + 1)) / 2;
                averagetwo = averageTotal - average;
                // System.out.println("Name: " + namestxt.get(j)+id5.get(j) + " Average total: " + averageTotal + " FR #1: Average " + average + " FR #2: Average " + averagetwo);

                id5.remove(j + 1);
                fix.totalList.remove(j + 1);
                objs = new studentobjs(namestxt.get(j), id5.get(j), averageTotal, average, averagetwo);
                System.out.println(studentobjs.toStrings());
            } else {
                average = (((tot.get(j)) - ((errornumdouble.get(j) * .25))));
                averageTotal = fix.totalList.get(j);
                averagetwo = averageTotal - average;
                //System.out.println("Name: " + namestxt.get(j)+id5.get(j) + " Average total: " + averageTotal+ " FR #1: Average " + average + " FR #2: Average " + averagetwo );
                objs = new studentobjs(namestxt.get(j), id5.get(j), averageTotal, average, averagetwo);
                System.out.println(studentobjs.toStrings());
            }
            j++;
        }
        tot.add(3.5);


    }
}
