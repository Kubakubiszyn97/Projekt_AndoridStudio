package projekt.kkubizszyn.myapplication;

import android.database.sqlite.SQLiteDatabase;
import android.os.AsyncTask;
import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

class PobierzDane extends AsyncTask<String,Void,String> {
    private OnTaskCompleted listener;
    private static final String TAG = "PobierzDane";
    private ArrayList<Temat> listaProjektow = null;


    public PobierzDane(OnTaskCompleted listener) {
        this.listener = listener;
    }

    @Override
    protected String doInBackground(String... strings) {
        Log.d(TAG, "doInBackground: starts with " + strings[0]);
        String rssFeed = DownloadXML(strings[0]);
        if (rssFeed == null)
        {
            Log.d(TAG, "doInBackground: Error Downloading");
        }
        return rssFeed;


    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        Log.d(TAG, "onPostExecute: parameter is" + s);
        ParseXML parseXML = new ParseXML();
        listaProjektow=parseXML.parse(s);
        Log.d(TAG,"size : " + listaProjektow.size());
        Log.d(TAG, "lista :" + listaProjektow.get(1).getTytul() );
        listener.OnTaskCompleted(listaProjektow);
    }

    private String DownloadXML (String urlPath)
    {
        StringBuilder xmlResult = new StringBuilder();

        try {
            URL url = new URL(urlPath);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            int response = connection.getResponseCode();
            Log.d(TAG, "DownloadXML: Response code was: " + response);
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            int charsRead;
            char[] inputBuffer = new char[1500];
            while(true)
            {
                charsRead = reader.read(inputBuffer);
                if(charsRead < 0){
                    break;
                }
                if (charsRead > 0){
                    xmlResult.append(String.copyValueOf(inputBuffer,0,charsRead));
                }
            }
            reader.close();
            return xmlResult.toString();
        }catch(MalformedURLException e)
        {
            Log.e(TAG, "DownloadXML: Invalid URL: " + e.getMessage() );
        }catch(IOException e)
        {
            Log.e(TAG, "DownloadXML: IO Exception reading data" + e.getMessage() );
        }catch(Exception e)
        {
            Log.e(TAG, "DownloadXML: error:" + e.getMessage() );
        }
        return null;


    }

    public ArrayList<Temat> getListaProjektow() {
        return listaProjektow;
    }
}



