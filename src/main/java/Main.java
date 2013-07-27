import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {

        XMLLoader loader = new XMLLoader("settings.xml");
        CommandManager cm = new CommandManager(loader.getSettings());

        Scanner scan = new Scanner(System.in);


        while (true) {
            System.out.print("Enter command: ");
            cm.run(scan.nextLine().split(" "));
        }


    }

}
