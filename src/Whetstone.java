import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Whetstone extends Experiment {
    public Whetstone(){
        super();
    }


    @Override
    public void run() {
        System.out.println("Here");
    }

    @Override
    public void generateCommands() {
        System.out.println("And here");
    }




//    public static void main(String[] args){
//        try {
//            List<String> cmds = new ArrayList<String>();
////            cmds.add("/usr/bin/gcc");
//            cmds.add("/bin/sh");
//            cmds.add("-c");
//            cmds.add("sudo -S perf stat ./whetstone 200000");
////            cmds.add("gcc -o whetstone whetstone.c -lm -O2");
//            ProcessBuilder p = new ProcessBuilder(cmds);
//            p.directory(new File("/home/ethan/code/performance"));
//
//            Process proc = p.start();
//            BufferedReader stdout = new BufferedReader(new InputStreamReader(proc.getInputStream()));
//            BufferedReader stderr = new BufferedReader(new InputStreamReader(proc.getErrorStream()));
//            OutputStream stdin = proc.getOutputStream();
//
//            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(stdin));
//            writer.write("notmyrealpassword\n");
//            writer.flush();
//
//            List<String> op = new ArrayList<String>();
//            String line;
//            while ((line = stderr.readLine()) != null) {
//                op.add(line.trim());
//            }
//            stdout.close();
//            stdin.close();
//            stderr.close();
//
//            for(int i=0; i < op.size(); i++){
//                if (op.get(i).contains("seconds time")){
//                    String seconds = op.get(i).substring(0,op.get(i).indexOf(' ')).substring(4);
//                    System.out.println(seconds);
//                }
//            }
//
//        }
//        catch (Exception err) {
//            err.printStackTrace();
//        }
//    }
//    public static void generateCommands(String level, String iterations){
//        return;
//    }
}

//interface class should have counter for each number