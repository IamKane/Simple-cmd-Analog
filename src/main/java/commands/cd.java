package commands;


import java.io.File;

public class cd implements Executable {

    public cd() {



    }

    @Override
    public String execute(String path, String[] comm) {

        if (comm.length < 2) {
            System.out.println("Need to specify directory in the arguments.");
            return path;
        }


        if (comm[1].equals("..")){   //Переход на каталог выше
            if (path.lastIndexOf('\\') == 2 ) {   //Если мы в корне диска
                path = path.substring(0, path.lastIndexOf('\\')) + "\\";
            } else {
                path = path.substring(0, path.lastIndexOf('\\'));
            }

            System.out.println("Current directory: " + path);
            return path;
        }

        if (comm[1].startsWith(":\\", 1)) {  //Если в аргументах указать другой диск
            path = comm[1];
            System.out.println("Current directory: " + path);
            return path;
        }

        if (comm[1].endsWith("\\")) { //Избыточно, но к ошибкам не приводит
            System.out.println("Wrong args, do not use \"\\\" at end of directory.");
            return path;
        }

        if (new File(path + "\\" + comm[1]).exists()){
            path += "\\" + comm[1];
            System.out.println("Current directory: " + path);
            return path;
        }

        System.out.println("Wrong directory.");

        return path;

    }
}
