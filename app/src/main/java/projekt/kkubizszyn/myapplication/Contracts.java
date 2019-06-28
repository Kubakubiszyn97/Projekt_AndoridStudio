package projekt.kkubizszyn.myapplication;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.provider.BaseColumns;
import android.provider.FontsContract;
import android.support.v7.app.AppCompatActivity;

class Contracts extends AppCompatActivity {
    public static final String TEMAT_EKS = "TEMAT_EKSPORTOWANY";
    public static String XML_URL = "https://dstachow.pl/kuba/java_projekt_test2.xml?fbclid=IwAR2awc8CdX99JVudjTOG3N_Q1chxnTScdRquL9lIcRBJm59obFg2gYihcrY";
    public static final String XML_URL_DEFAULT = "https://dstachow.pl/kuba/java_projekt_test2.xml?fbclid=IwAR2awc8CdX99JVudjTOG3N_Q1chxnTScdRquL9lIcRBJm59obFg2gYihcrY";
    protected static SQLiteDatabase db;


    protected void caOpenDataBase()
    {

    }



 public static class Nazewnictwo{

        public static final String _ID = BaseColumns._ID;
        public static final String NAZWA_TABELI = "Java_Projekty";
        public static final String TEMAT = "Temat";
        public static final String KATEGORIA = "Kategoria";
        public static final String OPIS_KROTKI = "Opis_krotki";
        public static final String OPIS_DLUGI = "Opis_dlugi";
    }


}
