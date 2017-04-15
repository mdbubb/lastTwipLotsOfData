import org.apache.commons.lang.ArrayUtils;
import org.apache.xerces.impl.xpath.regex.Match;

import java.awt.geom.Arc2D;
import java.awt.image.BufferedImage;
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

    public static void main(String[] args) throws IOException {
        int t = 1;
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


                   //System.out.print(t);
                    System.out.println(s);
                    b = Stream.of(s.split("\\+")).filter(x -> !x.isEmpty()).toArray(String[]::new);


                    t++;
                } catch (IndexOutOfBoundsException e) {
                    raw.next();
                }
            } catch (NoSuchElementException e) {
                System.out.println();
            }

            double p = 0;
            double numoferrors = 0;
            try {
                try {
                    double[] c = new double[b.length];
                    for (int i = 0; i < b.length; i++) {
                        c[i] = Double.parseDouble(b[i]);

                        if (c[i] == 222) {
                            //   c = ArrayUtils.removeElement(c, 222);
                        } else if (c[i] == 0.511) {
                            c[i] = 0.5;
                        } else if (c[i] == 11.0) {
                            c[i] = 1.0;
                            numoferrors = 1;
                        } else if (c[i] == 14.0) {
                            c[i] = 1.0;
                            numoferrors = 4;
                        } else if (c[i] == 10.0) {
                            c[i] = 1.0;

                        }
                        //System.out.println(c[i]);
                        //System.out.println(numoferrors);
                        p += c[i];


                    }
                    double sub = numoferrors*.25;
                    System.out.print("Total points: " );
                    System.out.println(p - sub+ " \n");


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
