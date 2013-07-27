package commands;

import java.io.File;

public class dir implements Executable {

    @Override
    public String execute(String path, String[] comm) {

        System.out.println("\nDirectory content:");

        String list[] = new File(path).list();
        for(int i = 0; i < list.length; i++)
            System.out.println(list[i]);

        System.out.println();

        return path;

    }
}
