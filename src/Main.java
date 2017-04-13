import org.apache.xerces.impl.xpath.regex.Match;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.regex.*;

/**
 * Created by mdb17 on 4/12/2017.
 */
public class Main {
    private static ArrayList<Integer> a = new ArrayList<>();

    private static int secretNum = 0;

    public static void main(String[] args) throws IOException {
        Scanner raw = new Scanner(new File("raw"));
        int index = 0;

        String line[] = new String[56];
        raw.nextLine();
        while (raw.hasNext()) {
            try {
                raw.useDelimiter("\\+");
                System.out.println(raw.next());
                raw.useDelimiter("\\s+");
               // System.out.println(raw.next());
            }
            catch (NoSuchElementException e){
                System.out.println();
            }
        }


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
            //
            line[index] = raw.nextLine();
            index++;

        }


    }
}
