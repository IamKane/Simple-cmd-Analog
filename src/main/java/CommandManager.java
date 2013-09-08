import commands.Executable;

import java.io.File;
import java.io.IOException;
import java.util.Map;

public class CommandManager {

    private Map<String, String> settings;
    private Class cls;
    private String currentPath;
    private Executable exec;

    public CommandManager(Map<String, String> settings) {

        this.settings = settings;
        try {
            currentPath = new File(".").getCanonicalPath();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void run(String[] comm){


        if (settings.containsKey(comm[0])) {

            try {

                exec = (Executable) Class.forName("commands." + settings.get(comm[0])).newInstance();

            } catch (Exception e) {
                e.printStackTrace();
            }

            currentPath = exec.execute(currentPath, comm);

        } else System.out.println("Wrong command.\n");

    }

    public void printCurrentPath() {
        System.out.println(currentPath);
    }

}
