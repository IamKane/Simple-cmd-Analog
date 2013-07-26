import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.input.SAXBuilder;

import java.io.FileReader;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        try {
            SAXBuilder parser = new SAXBuilder();
            FileReader fr = new FileReader("settings.xml");
            Document rDoc = parser.build(fr);
            System.out.println(rDoc.getRootElement().getName());
            List<Element> temp = rDoc.getRootElement().getChildren();
            for (int i = 0; i < temp.size(); ++i) {
                //System.out.println(temp.get(i).getName());
            }
            //System.out.println(rDoc.getRootElement().getChild("pwd").getAttributeValue("employment"));
            System.out.println(rDoc.getRootElement().getContentSize());
        }
        catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

    }

}
