import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.input.SAXBuilder;

import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: Константин
 * Date: 26.07.13
 * Time: 20:02
 * To change this template use File | Settings | File Templates.
 */
public class XMLLoader {

    private String xmlFile;
    private Map<String, String> settings;

    public XMLLoader() {

        settings = new HashMap<String, String>();

    }

    public XMLLoader(String file) {

        this();
        this.xmlFile = file;

    }

    private void readSettings(){

        SAXBuilder parser;
        Document rDoc = null;
        FileReader fr = null;
        List<Element> commands;

        parser = new SAXBuilder();

        try {
            fr = new FileReader("settings.xml");
            rDoc = parser.build(fr);
        }
        catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        System.out.println(rDoc.getRootElement().getName());
        commands = rDoc.getRootElement().getChildren();

        for (int i = 0; i < commands.size(); ++i) {
            settings.put(commands.get(i).getName(),
                         commands.get(i).getAttributeValue("application"));
        }

        try {
            if (fr != null) {
                fr.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public Map<String, String> getSettings() {

        readSettings();

        return settings;

    }

    public void loadFrom(String file){

        this.xmlFile = xmlFile;

    }

}
