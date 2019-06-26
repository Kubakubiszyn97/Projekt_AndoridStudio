package projekt.kkubizszyn.myapplication;

import android.util.Log;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.StringReader;
import java.util.ArrayList;

public class ParseXML {
    private static final String TAG = "ParseXML";
    private ArrayList<Temat> listaProjektow;

    public ParseXML() {
        this.listaProjektow = new ArrayList<>();
    }

    public ArrayList<Temat> getProjekty() {
        return listaProjektow;
    }

    public boolean parse(String xmlData) {
        boolean status = true;
        Temat currentTemat = null;
        boolean inTemat = false;
        String textValue = "";

        try {
            XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
            factory.setNamespaceAware(true);
            XmlPullParser xpp = factory.newPullParser();
            xpp.setInput(new StringReader(xmlData));
            int eventType = xpp.getEventType();
            while(eventType != XmlPullParser.END_DOCUMENT) {
                String tagName = xpp.getName();
                switch (eventType) {
                    case XmlPullParser.START_TAG:
                        Log.d(TAG, "parse: Starting tag for " + tagName);
                        if("entry".equalsIgnoreCase(tagName)) {
                            inTemat = true;
                            currentTemat = new Temat();
                        }
                        break;

                    case XmlPullParser.TEXT:
                        textValue = xpp.getText();
                        break;

                    case XmlPullParser.END_TAG:
                        Log.d(TAG, "parse: Ending tag for " + tagName);
                        if(inTemat) {
                            if("entry".equalsIgnoreCase(tagName)) {
                                listaProjektow.add(currentTemat);
                                inTemat = false;
                            } else if("name".equalsIgnoreCase(tagName)) {
                                currentTemat.setKategoria(textValue);
                            } else if("artist".equalsIgnoreCase(tagName)) {
                                currentTemat.setTytul(textValue);
                            } else if("summary".equalsIgnoreCase(tagName)) {
                                currentTemat.setOpis_kr(textValue);
                            } else if("image".equalsIgnoreCase(tagName)) {
                                currentTemat.setOpis_kr(textValue);
                            }
                        }
                        break;

                    default:
                        // Nothing else to do.
                }
                eventType = xpp.next();

            }
            for (Temat app: listaProjektow) {
                Log.d(TAG, "******************");
                Log.d(TAG, app.toString());
            }

        } catch(Exception e) {
            status = false;
            e.printStackTrace();
        }

        return status;
    }
}

