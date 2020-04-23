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
        ConcurrentHashMap<Integer, int[]> times = new ConcurrentHashMap<Integer, int[]>();

        List<Thread> threads = new ArrayList<Thread>();

        for(int k = 0; k < 5; k++){
            Runnable r = new WhetstoneThreader(times, k);
            Thread t = new Thread(r);
            t.start();
            threads.add(t);
        }

        for(int i = 0; i < threads.size(); i++){
            try {
                threads.get(i).join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


        System.out.println(times.size());

        for(ConcurrentHashMap.Entry<Integer, int[]> entry : times.entrySet()){
            System.out.println(Arrays.toString(entry.getValue()));
        }


    }
}
