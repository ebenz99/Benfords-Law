import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Whetstone extends Experiment {
    public Whetstone(){
        super();
    }

    public List<String> buildCommands(int iterations){
        List<String> cmds = new ArrayList<String>();
        cmds.add("/bin/sh");
        cmds.add("-c");
        cmds.add("gcc -o whetstone /home/ethan/IdeaProjects/BenfordsLaw/whetstone.c -lm -O2 && sudo -S perf stat ./whetstone " + iterations );
        return cmds;
    }

    @Override
    public void run() {
        try {

            List<String> times = new ArrayList<String>();

            for (int j = 1000; j < 11000; j += 1000) {
                List<String> cmds = buildCommands(j);

                ProcessBuilder p = new ProcessBuilder(cmds);
                p.directory(new File("/home/ethan/code/performance"));

                Process proc = p.start();
                BufferedReader stdout = new BufferedReader(new InputStreamReader(proc.getInputStream()));
                BufferedReader stderr = new BufferedReader(new InputStreamReader(proc.getErrorStream()));
                OutputStream stdin = proc.getOutputStream();


                BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(stdin));
                writer.write((new Login()).getPassword());
                writer.flush();

                List<String> op = new ArrayList<String>();
                String line;


                while ((line = stderr.readLine()) != null) {
                    op.add(line.trim());
                }
                stdout.close();
                stdin.close();
                stderr.close();

                for (int i = 0; i < op.size(); i++) {
                    if (op.get(i).contains("seconds time")) {
//                    String seconds = op.get(i).substring(0, op.get(i).indexOf(' ')).substring(4);
//                    System.out.println(op.get(i));
                        String seconds = op.get(i).replace(".", "");
                        System.out.println(seconds);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
