import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;

/**
 * Created by mb977 on 4/20/17.
 */
public class fix {
    public static ArrayList<Double> totalList = new ArrayList<>();
    public static ArrayList<Double> fr1list = new ArrayList<>();


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
                    }else if (Main.c[i] == 13203) {
                        Main.c[i] = 1.0;
                        Main.numoferrors += 3;
                    }
                    else if (Main.c[i] == .5 || Main.c[i] == 1.0) {
                    }
                    Main.p += Main.c[i];
                }

                if (Main.t==4){
                    Main.numoferrors-=1;
                }
                else if (Main.t==7){
                    Main.numoferrors+=1;
                }
                else if (Main.t==11){
                    Main.numoferrors+=12;
                }
                else if (Main.t==14){
                    Main.numoferrors+=1;
                }
                else if (Main.t==17){
                    Main.numoferrors+=2;
                }
                else if (Main.t==20){
                    Main.numoferrors+=3;
                }
                else if (Main.t==22){
                    Main.numoferrors+=2;
                }
                else if (Main.t==25){
                    Main.numoferrors+=1;
                }
                else if (Main.t==26){
                    Main.numoferrors-=1;
                }
                else if (Main.t==28){
                    Main.numoferrors+=1;
                }
                else if (Main.t==29){
                    Main.numoferrors-=1;
                }
                else if (Main.t==33){
                    Main.numoferrors-=4;
                }
                else if (Main.t==34){
                    Main.numoferrors+=1;
                }
                else if (Main.t==35){
                    Main.numoferrors-=2;
                }
                else if (Main.t==41){
                    Main.numoferrors+=4;
                }
                else if (Main.t==42){
                    Main.numoferrors-=1;
                }
                else if (Main.t==51){
                    Main.numoferrors+=2;
                }








                Main.sub = Main.numoferrors * .25;
                Main.fr = Main.p - Main.sub;
                totalList.add(Main.fr);

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
}

