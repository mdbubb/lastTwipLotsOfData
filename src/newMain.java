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
    //public static double tot[];
    public static int t = 0;
    public static double fr = 0.0;
    public static String a = "";
    public static double c[];
    public static double p = 0.0;
    public static double numoferrors = 0.0;
    public static double sub;
    public static Scanner raw;
    public static ArrayList<String> id1 = new ArrayList<>();
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
         sc3.nextLine();
        while (sc3.hasNextLine()) {
            y = sc3.nextLine().split("\\t");

            id1.add(y[0]);
            fr1.add(y[1]);
            errornum.add(y[3]);
            //  System.out.println(fr1);
        }
        //sc3.nextLine();
        for (int i = 0; i < fr1.size(); i++) {


           try {
               if(errornum.get(i).isEmpty()){
                   errornumdouble.add(0.0);
                   System.out.println(684654654);
               }
               errornumdouble.add(Double.parseDouble(errornum.get(i)));
           }
           catch (NumberFormatException t){
               errornumdouble.add(0.0);
           }

            System.out.println(i + " " + fr1.get(i));
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
            int a = 1;
            while (hiya.hasNext()) {
                String hi = hiya.next();
                try {
                    one[a] = Double.parseDouble(hi);
                    totalone += one[a];
                    System.out.println(one[a] + "  " + a + "  " + totalone);
                    a++;


                } catch (NumberFormatException e) {

                }

            }
            tot.add(totalone);
            System.out.println(tot.get(count - 1));
            count++;


            Scanner t = new Scanner(new File("test"));
            t.next();
            t.next();
            System.out.println(t.next());



        }
        System.out.println("HIIIIIIIIIIIIIIIIIII");
        for (int i = 0; i <errornumdouble.size() +1; i++) {
            System.out.println(i+" "+errornum.get(i));
        }




            /*
            catch (NumberFormatException er) {
                String a = fr1.get(count);
                a = a.substring(a.length() - 2, a.length() - 1);
                a = fr1.get(count).replace(a, "");
                a = a.replaceAll("[^0123456789.+]", "");
                String p[] = a.split("\\+");
                n = Double.parseDouble(errornum.get(count));
                fix.getFR2(p, n);
                two[count] = fix.totalList.get(count) - fix.q;
                fr2list.add(two[count]);
            }
            count++;
        }
        while (sc2.hasNextLine()) {
            y = sc2.nextLine().split("\\t");
            id1.add(y[0]);
            fr1.add(y[1]);
            errornum.add(y[3]);
        }
        count = 1;
        two = new double[fix.totalList.size()];
        int fr1cout = 0;
        while (count < id1.size()) {

            String s = fr1.get(count);
            s = s.replaceAll("[^0123456789.+]", "");
            String y[] = s.split("\\+");

            n = Double.parseDouble(errornum.get(count));
            System.out.println(id1.get(count));
            try {
                fix.getFR1(y, n);

                double totalOne = fix.totalList.get(count);
                double totalTwo = fix.totalList.get(count + 1);
                double totalAvg = (totalOne + totalTwo) / 2;

                double fr1One = fix.fr1list.get(fr1cout);
                double fr1Two = fix.fr1list.get(fr1cout + 1);
                double fr1Avg = (fr1One + fr1Two) / 2;

                double fr2One = fr2list.get(fr1cout);
                double fr2Two = fr2list.get(fr1cout + 1);
                double fr2Avg = (fr2One + fr2Two) / 2;


                two[count] = fix.totalList.get(count) - fix.q;
                System.out.println("FR2: " + two[count]);
                System.out.println("TOTAL " + fix.totalList.get(count));
                System.out.println("Total average: " + totalAvg);
                System.out.println("Free response 1 average: " + fr1Avg);
                System.out.println("Free response 2 average: " + fr2Avg);
                System.out.println();
            }//STILL HAVE TO FIGURE THIS CATCH STATEMENT OUT
            catch (NumberFormatException er) {
                System.out.println(531824532);
                String a = fr1.get(count);
                a = a.substring(0, a.length() - 2);
                a = a.replaceAll("[^0123456789.+]", "");
                String p[] = a.split("\\+");
                n = Double.parseDouble(errornum.get(count));
                for (int i = 0; i < p.length; i++) {
                    if(p[i].equalsIgnoreCase("1.")){
                        p[i] = "1";
                    }
                    else if(p[i].equalsIgnoreCase(".51")){
                        p[i] = ".5";
                    }
                    //System.out.println(p[i]);
                }
                fix.getFR1(p, n);
                double totalOne = fix.totalList.get(count);
                double totalTwo = fix.totalList.get(count + 1);
                double totalAvg = (totalOne + totalTwo) / 2;

                double fr1One = fix.fr1list.get(fr1cout);
                double fr1Two = fix.fr1list.get(fr1cout + 1);
                double fr1Avg = (fr1One + fr1Two) / 2;

                double fr2One = fr2list.get(fr1cout);
                double fr2Two = fr2list.get(fr1cout + 1);
                double fr2Avg = (fr2One + fr2Two) / 2;
                two[count] = fix.totalList.get(count) - fix.q;
                System.out.println("FR2: " + two[count]);
                System.out.println("TOTAL " + fix.totalList.get(count));
                System.out.println("Total average: " + totalAvg);
                System.out.println("Free response 1 average: " + fr1Avg);
                System.out.println("Free response 2 average: " + fr2Avg);
                System.out.println();


            }
            count++;
            fr1cout++;
        }*/
    }
}
