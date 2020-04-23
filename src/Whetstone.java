import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;


public class Whetstone extends Experiment {
    private static int[] nums;

    public Whetstone(){
        super();
        this.nums = new int[10];
    }

    public void culminateNums(int[] arr){
        for(int i = 0; i < 10; i++){
            this.nums[i]+=arr[i];
        }
    }


    @Override
    public void run() {
        ConcurrentHashMap<Integer, int[]> times = new ConcurrentHashMap<Integer, int[]>();
        List<Thread> threads = new ArrayList<Thread>();

        for(int k = 0; k < 10; k++){
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


        for(ConcurrentHashMap.Entry<Integer, int[]> entry : times.entrySet()){
            culminateNums((entry.getValue()));
        }

        System.out.println(Arrays.toString(this.nums));

        return;
    }

}
