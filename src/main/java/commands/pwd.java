package commands;

public class pwd implements Executable {

    public pwd() {



    }

    @Override
    public String execute(String path, String[] comm) {

        System.out.println("Directory path:");
        System.out.println(path);
        System.out.println();

        return path;

    }
}
