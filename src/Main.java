import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;

/**
 * Created by mb977 on 4/20/17.
 */
public class fix {
    public static ArrayList<Double> totalList = new ArrayList<>();
    public static studentObjs s;
    public static double q;

    public static void fix1() {
        try {
            try {
                Main.c = new double[Main.b.length];
                for (int i = 0; i < Main.b.length; i++) {
                    if (Main.b[i].endsWith(".")) {
                        Main.a = Main.b[i].substring(Main.b[i].length() - 1, Main.b[i].length());
                        Main.b[i] = Main.b[i].replace(Main.a, "");
                    }
                    if (Main.b[i].equals(".5.1") || Main.b[i].equals(".5.0")) {
                        Main.b[i] = ".5";
                    } else if (Main.b[i].equals("1.")) {
                        Main.b[i] = "1";
                    } else if (Main.b[i].equals(".511.51")) {
                        Main.b[i] = ".5";
                    }
                    Main.c[i] = Double.parseDouble(Main.b[i]);
                    if (Main.c[i] == 222.0) {
                        Main.c[i] = -1.0;
                    } else if (Main.c[i] == 0.511) {
                        Main.c[i] = 0.5;
                    } else if (Main.c[i] == 11.0) {
                        Main.c[i] = 1.0;
                        Main.numoferrors += 1;
                    } else if (Main.c[i] == 14.0) {
                        Main.c[i] = 1.0;
                        Main.numoferrors += 4;
                    } else if (Main.c[i] == 10.0) {
                        Main.c[i] = 1.0;

                    } else if (Main.c[i] == 0.51) {
                        Main.c[i] = 0.5;
                        Main.numoferrors += 1;
                    } else if (Main.c[i] == 12.0) {
                        Main.c[i] = 1.0;
                        Main.numoferrors += 2;

                    } else if (Main.c[i] == 0.53) {
                        Main.c[i] = 0.5;

                    } else if (Main.c[i] == 17.0) {
                        Main.c[i] = 1.0;
                        Main.numoferrors += 7;
                    } else if (Main.c[i] == 50.0 || Main.c[i] == 53.0 || Main.c[i] == 5.0) {
                        Main.c[i] = .5;

                    } else if (Main.c[i] == 132) {
                        Main.c[i] = 1.0;
                        Main.numoferrors += 3;
                    } else if (Main.c[i] == 1.1) {
                        Main.c[i] = 1.0;
                        Main.numoferrors += 1;
                    } else if (Main.c[i] == 0.54) {
                        Main.c[i] = 0.5;
                        Main.numoferrors += 4;
                    } else if (Main.c[i] == 51.0) {
                        Main.c[i] = 0.5;
                        Main.numoferrors += 1;
                    } else if (Main.c[i] == 0.52 || Main.c[i] == 52.0) {
                        Main.c[i] = 0.5;
                        Main.numoferrors += 2;
                    } else if (Main.c[i] == 16.0) {
                        Main.c[i] = 1;
                        Main.numoferrors += 6;
                    } else if (Main.c[i] == 13.0) {
                        Main.c[i] = 1.0;
                        Main.numoferrors += 3;
                    } else if (Main.c[i] == 15.0) {
                        Main.c[i] = 1.0;
                        Main.numoferrors += 5;
                    } else if (Main.c[i] == 5131.0) {
                        Main.c[i] = 0.5;
                        Main.numoferrors += 3;
                    } else if (Main.c[i] == 10.5) {
                        Main.c[i] = 1.0;
                        Main.numoferrors += 0.5;
                    } else if (Main.c[i] == 122.0) {
                        Main.c[i] = 1.0;
                        Main.numoferrors += 4;
                    } else if (Main.c[i] == 112.0) {
                        Main.c[i] = 1.0;
                        Main.numoferrors += 1;
                    } else if (Main.c[i] == 0.5121) {
                        Main.c[i] = 0.5;
                        Main.numoferrors += 2;
                    } else if (Main.c[i] == .5 || Main.c[i] == 1.0) {
                    }
                    Main.p += Main.c[i];
                    Main.sub = Main.numoferrors * .25;
                }
                Main.fr = Main.p - Main.sub;
                s = new studentObjs(Main.id, Main.fr);
                totalList.add(Main.fr);
                if (Main.t == 4) {
                    Main.numoferrors -= 1;
                } else if (Main.t == 8 || Main.t == 15 || Main.t == 26 || Main.t == 37) {
                    Main.numoferrors += 1;
                } else if (Main.t == 21) {
                    Main.numoferrors += 3;
                } else if (Main.t == 38) {
                    Main.numoferrors -= 2;
                } else if (Main.t == 27 || Main.t == 31 || Main.t == 32 || Main.t == 43 || Main.t == 45) {
                    Main.numoferrors -= 1;
                }
            } catch (InputMismatchException d) {
                Main.raw.nextDouble();
            } catch (NumberFormatException l) {

                Main.raw.next();
            }
            Main.t++;

        } catch (IndexOutOfBoundsException e) {
            Main.raw.nextLine();
        }
    }

    public static void getFR1(String[] dd, double n) {
        Main.c = new double[dd.length];
        Main.p = 0.0;
        for (int i = 1; i < dd.length; i++) {
            Main.c[i] = Double.parseDouble(dd[i]);
            Main.p += Main.c[i];
        }
        Main.sub = n * .25;
        q = Main.p - Main.sub;
        System.out.print("FR1: ");
        System.out.println(q);
        Main.p = 0;
    }

    public static void getAverage() throws IOException {

    }
}


