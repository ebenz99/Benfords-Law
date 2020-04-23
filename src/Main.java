import java.util.ArrayList;
import java.util.List;
import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
//        System.out.println("What do you want to inspect?");
        Scanner ip = new Scanner(System.in);
//        String decision = ip.nextLine();
        String decision = "Whetstone";
        if (decision.equals("Whetstone")){
            Whetstone w = new Whetstone();
            w.run();
        }
        return;
    }
}
