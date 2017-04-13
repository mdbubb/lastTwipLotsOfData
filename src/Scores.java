import java.util.Scanner;

/**
 * Created by mdb17 on 4/12/2017.
 */
public class Scores {
public static void main (String [] args){
    String a = "hi+;alkdsfj+aslkjdfj+asdhhgnt";
    Scanner input = new Scanner(a);
    input.useDelimiter("\\+");
    while(input.hasNext()){
        System.out.println(input.next());
    }







}
}
