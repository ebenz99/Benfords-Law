import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;


public class Whetstone extends Experiment {
    public Whetstone(){
        super();
    }


    @Override
    public void run() {
        ConcurrentHashMap<Integer, String> times = new ConcurrentHashMap<Integer, String>();
        Runnable r = new WhetstoneThreader(times,1);
        new Thread(r).start();
//        for(int k = 0; k < 10; k++){
//
//        }


    }
}
