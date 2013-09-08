package commands;

public class pwd implements Executable {

    @Override
    public String execute(String path, String[] commandLine) {
        System.out.println("Directory path:");
        System.out.println(path);
        System.out.println();
        return path;
    }
}
