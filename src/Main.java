import org.apache.xerces.impl.xpath.regex.Match;

import java.awt.geom.Arc2D;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.regex.*;

/**
 * Created by mdb17 on 4/12/2017.
 */
public class Main {
    public static String left;
    public static String id;
    public static String s;

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
                    s= s.replaceAll("\\+", " ");
                    System.out.println(s);
                    //System.out.println(left);
                } catch (IndexOutOfBoundsException e) {
                    raw.nextLine();
                }
            } catch (NoSuchElementException e) {
                System.out.println();
            }

            try {

                        int a = s.indexOf("");
                        String b = s.substring(a, s.indexOf(" "));
                        ArrayList<Double> list = new ArrayList<>();
                        double c = Double.parseDouble(b);
                        list.add(c);

                        if(s.contains(" ")){
                            b = s.substring(s.indexOf(" "), s.indexOf(" ")+ 3);
                            c = Double.parseDouble(b);
                            list.add(c);
                            for (int i = 0; i <list.size() ; i++) {

                                System.out.println();
                                System.out.println(list.get(i));
                            }


                    }
                } catch (IndexOutOfBoundsException e) {
                    raw.nextLine();
                }
            }



    }
}
