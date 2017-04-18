
import java.io.*;
import java.util.InputMismatchException;
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
    public static int t = 0;
    public static double total = 0.0;
    public static String a = "";
    public static double c[];
    public static double p = 0.0;
    public static double numoferrors = 0.0;
    public static double sub;

    public static void main(String[] args) throws IOException {

        Scanner raw = new Scanner(new File("raw"));
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

                    String gt = s.substring(0,s.length()/2);
                      System.out.print(t + " ");
                    System.out.println(s);
                    System.out.print(t + " ");
                    System.out.println(gt);
                    b = Stream.of(s.split("\\+")).filter(x -> !x.isEmpty()).toArray(String[]::new);
                    t++;


                } catch (IndexOutOfBoundsException e) {
                    raw.next();
                }
            } catch (NoSuchElementException e) {
                System.out.println();
            }

             p = 0;
             numoferrors = 0;
            try {
                try {
                    c = new double[b.length];
                    for (int i = 0; i < b.length; i++) {
                        if (b[i].endsWith(".")) {

                             a = b[i].substring(b[i].length() - 1, b[i].length());
                            b[i] = b[i].replace(a, "");
                            // System.out.println();
                            //System.out.println();
                            //System.out.println(b[i]);

                        }
                        if (b[i].equals(".5.1") || b[i].equals(".5.0")) {
                            b[i] = ".5";
                        } else if (b[i].equals("1.")) {
                            b[i] = "1";
                        } else if (b[i].equals(".511.51")) {
                            b[i] = ".5";
                        }
                        c[i] = Double.parseDouble(b[i]);

                        if (c[i] == 222.0) {
                            c[i] = -1.0;
                        } else if (c[i] == 0.511) {
                            c[i] = 0.5;
                        } else if (c[i] == 11.0) {
                            c[i] = 1.0;
                            numoferrors += 1;
                        } else if (c[i] == 14.0) {
                            c[i] = 1.0;
                            numoferrors += 4;
                        } else if (c[i] == 10.0) {
                            c[i] = 1.0;

                        } else if (c[i] == 0.51) {
                            c[i] = 0.5;
                            numoferrors += 1;
                        } else if (c[i] == 12.0) {
                            c[i] = 1.0;
                            numoferrors += 2;

                        } else if (c[i] == 0.53) {
                            c[i] = 0.5;

                        } else if (c[i] == 17.0) {
                            c[i] = 1.0;
                            numoferrors += 7;
                        } else if (c[i] == 50.0||c[i]==53.0||c[i]==5.0) {
                            c[i] = .5;

                        } else if (c[i] == 132) {
                            c[i] = 1.0;
                            numoferrors += 3;
                        } else if (c[i] == 1.1) {
                            c[i] = 1.0;
                            numoferrors += 1;
                        } else if (c[i] == 0.54) {
                            c[i] = 0.5;
                            numoferrors += 4;
                        } else if (c[i] == 51.0) {
                            c[i] = 0.5;
                            numoferrors += 1;
                        }
                        else if (c[i] == 0.52||c[i]==52.0) {
                            c[i] = 0.5;
                            numoferrors += 2;
                        }
                        else if (c[i] == 16.0) {
                            c[i] = 1;
                            numoferrors += 6;
                        }
                        else if (c[i] == 13.0) {
                            c[i] = 1.0;
                            numoferrors += 3;
                        }
                        else if (c[i] == 15.0) {
                            c[i] = 1.0;
                            numoferrors += 5;
                        } else if (c[i] == 5131.0) {
                            c[i] = 0.5;
                            numoferrors += 3;
                        }
                        else if (c[i] == 10.5) {
                            c[i] = 1.0;
                            numoferrors+=0.5;
                        }
                        else if (c[i] == 122.0) {
                            c[i] = 1.0;
                            numoferrors += 4;
                        }
                        else if (c[i] == 112.0) {
                            c[i] = 1.0;
                            numoferrors += 1;
                        }
                        else if (c[i] == 0.5121) {
                            c[i] = 0.5;
                            numoferrors += 2;
                        }
                       else if (c[i]==.5||c[i]==1.0){

                        }
                        else {
                            System.out.println(c[i]);
                        }


                        // System.out.println(c[i]+"\t");
                        // System.out.println(numoferrors);
                        p += c[i];


                    }
                     sub = numoferrors * .25;
                    if (t == 6) {
                        sub -= .25;
                    } else if (t == 10) {
                        sub += .25;
                    }
                    total = p - sub;
                   studentObjs s = new studentObjs(id, total);
                    if (total == 0.0) {
                        System.out.print("");
                    } else {
                      //System.out.println(s.toString());

                       // System.out.println(id);
                       System.out.print("Total points: ");
                        System.out.println(total + " \n");

                    }

                } catch (InputMismatchException d) {
                    raw.nextDouble();
                } catch (NumberFormatException l) {

                    raw.next();
                }

            } catch (IndexOutOfBoundsException e) {
                raw.nextLine();
            }
        }


    }
}
