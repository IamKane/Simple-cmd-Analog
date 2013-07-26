public class Main {

    public static void main(String[] args) {

        XMLLoader loader = new XMLLoader("settings.xml");
        System.out.println(loader.getSettings());

    }

}
