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
                   // s = s.replaceAll("\\+", " ");
                    System.out.println(s);
                    b = Stream.of(s.split("\\+")).filter(x -> !x.isEmpty()).toArray(String[]::new);
                    //System.out.println(left);
                } catch (IndexOutOfBoundsException e) {
                    raw.nextLine();
                }
            } catch (NoSuchElementException e) {
                System.out.println();
            }

            try {
                try {
                    double[] c = new double[b.length];
                    for (int i = 0; i < b.length; i++) {
                        c[i] = Double.parseDouble(b[i]);
                      if (c[i]==0.5||c[i]==1.0){
                          System.out.println(c[i]);
                      }
                      else{
                          System.out.println();

                          System.out.println(c[i]);
                          System.out.println();
                      }


                    }
                }
                catch (InputMismatchException d){
                    raw.nextDouble();
                }
                catch (NumberFormatException a){

                    raw.next();
                }

            } catch (IndexOutOfBoundsException e) {
                raw.nextLine();
            }
        }


    }
}
