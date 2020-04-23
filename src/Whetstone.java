import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.lang.Character.forDigit;

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

    public void submitSudoPassword(OutputStream stdin) throws IOException {
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(stdin));
        writer.write((new Login()).getPassword());
        writer.flush();
    }

    public List<String> readTerminalOutput(BufferedReader std) throws IOException {
        List<String> op = new ArrayList<String>();
        String line;
        while ((line = std.readLine()) != null) {
            op.add(line.trim());
        }
        return op;
    }

    public void processNumbers(List<String> times){
        int[] occurrences = new int[10];

        for(String time : times){
            System.out.println(time);
            for(char x : time.toCharArray()){
                System.out.println(((int) x) - 48);
                occurrences[((int) x) - 48] += 1;
            }
        }
        System.out.println(Arrays.toString(occurrences));
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

                submitSudoPassword(stdin);

                List<String> op = readTerminalOutput(stderr);

                stdout.close();
                stdin.close();
                stderr.close();

                for (int i = 0; i < op.size(); i++) {
                    if (op.get(i).contains("seconds time")) {
                        String seconds = op.get(i).replaceAll("\\D", "");
                        times.add(seconds);
                    }
                }
            }

            processNumbers(times);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
