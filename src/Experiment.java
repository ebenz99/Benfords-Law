import java.util.HashMap;
import java.util.Map;

public abstract class Experiment {
    private Map<Object, Integer> occurrences;

    public Experiment(){
        this.occurrences = new HashMap<Object, Integer>();
    }

    public static void prt(){
        System.out.println("Hello World");
    }

    public abstract void run();
    public abstract void generateCommands();
}
