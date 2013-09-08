package commands;


import java.io.File;

public class cd implements Executable {

    private String path;
    private String[] commandLine;

    @Override
    public String execute(String path, String[] commandLine) {

        this.path = path;
        this.commandLine = commandLine;

        if (checkPresenceArgs()) {
            System.out.println("Need to specify directory in the arguments.\n");
            return path;
        }

        if (checkValidityArgument()) {
            System.out.println("Wrong args, do not use \"\\\" at end of directory.\n");
            return path;
        }

        if (isArgsChangeDisk()) {
            changeDisk();
            return path;
        }

        if (isArgsChangeDirectoryHigher()){
            changeDirectoryHigher();
            return path;
        }

        if (isArgsChangeDirectoryLower()){
            changeDirectoryLower();
            return path;
        }

        System.out.println("Wrong directory.\n");

        return path;
    }

    private boolean checkPresenceArgs(){
        if (commandLine.length < 2) {
            return true;
        } else {
            return false;
        }
    }

    private boolean checkValidityArgument() {
        if (commandLine[1].endsWith("\\")) {
            return  true;
        } else {
            return false;
        }
    }

    private boolean isArgsChangeDisk() {
        if (commandLine[1].startsWith(":\\", 1)) {
            return true;
        } else {
            return false;
        }
    }

    private void changeDisk() {
        path = commandLine[1];
        System.out.println("Current directory: " + path + "\n");
    }

    private boolean isArgsChangeDirectoryHigher() {
        if (commandLine[1].equals("..")){
            return true;
        } else{
            return false;
        }
    }

    private void changeDirectoryHigher() {
        if (isPathRootDisk()) {
            path = path.substring(0, path.lastIndexOf('\\')) + "\\";
        } else {
            path = path.substring(0, path.lastIndexOf('\\'));
        }
        System.out.println("Current directory: " + path + "\n");
    }

    private boolean isArgsChangeDirectoryLower() {
        if (new File(path + "\\" + commandLine[1]).exists()){
            return true;
        } else {
            return false;
        }
    }

    private void changeDirectoryLower() {
        path += "\\" + commandLine[1];
        System.out.println("Current directory: " + path +"\n");
    }

    private boolean isPathRootDisk(){
        if (path.lastIndexOf('\\') == 2) {
            return true;
        } else {
            return false;
        }
    }

}
