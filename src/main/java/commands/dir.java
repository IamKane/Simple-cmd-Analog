package commands;

import java.io.File;

public class dir implements Executable {

    @Override
    public String execute(String path, String[] commandLine) {
        System.out.println("\nDirectory content:");
        String fileList[] = new File(path).list();
        for (String aFileList : fileList){
            System.out.println(aFileList);
        }
        System.out.println();
        return path;
    }
}
