import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Created by mdb17 on 4/12/2017.
 */
public class secretNum {
    public static ArrayList<Integer> a = new ArrayList<>();
    public static int secretNum = 0;

    public static void printSecretNums() throws IOException {
        Scanner raw = new Scanner(new File("raw"));
        while (raw.hasNextLine()) {

            try {
                //Secret Number into 'a' arrayList
                secretNum = raw.nextInt();
                boolean containsSecretNum = a.contains(secretNum);
                if (!containsSecretNum) {
                    a.add(secretNum);
                }
            } catch (InputMismatchException e) {
                raw.nextLine();
            }


        }
        for (int i = 0; i < a.size(); i++) {
            System.out.println(a.get(i));

        }


    }


}
        /*try {
                try {
                    double[] c = new double[b.length];
                    for (int i = 0; i < b.length; i++) {
                        c[i] = Double.parseDouble(b[i]);



                    }
                }
                catch (InputMismatchException d){
                    raw.nextDouble();
                }
                catch (NumberFormatException l){

                    raw.next();
                }

            } catch (IndexOutOfBoundsException e) {
                raw.nextLine();
            }
        }


    }
}*/
