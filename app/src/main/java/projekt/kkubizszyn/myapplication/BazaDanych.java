package projekt.kkubizszyn.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.strictmode.SqliteObjectLeakedViolation;
import android.util.Log;

import java.lang.reflect.Array;
import java.util.ArrayList;

class BazaDanych extends SQLiteOpenHelper {
    private static final String TAG = "BazaDanych";

    public static final String NAZWA_BAZY = "Projekty.db";
    public static final int WERSJA = 1;

    private static BazaDanych instance = null;

    public BazaDanych(Context context){
        super(context,NAZWA_BAZY,null,WERSJA);
        SQLiteDatabase db = this.getWritableDatabase();
        Log.d(TAG, "BazaDanych: constructor");
    }


   /* static BazaDanych getInstance(Context context){
        if (instance == null) {
            Log.d(TAG, "getInstance: creating new instance");
            instance = new BazaDanych(context);
        }
        return instance;
    } */




    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.d(TAG, "onCreate: Starts");
        String sqlStatement = "CREATE TABLE IF NOT EXISTS "+ Contracts.Nazewnictwo.NAZWA_TABELI +"(_id INTEGER PRIMARY KEY NOT NULL, "+ Contracts.Nazewnictwo.KATEGORIA +
                " TEXT NOT NULL, "+ Contracts.Nazewnictwo.TEMAT + " TEXT NOT NULL," + Contracts.Nazewnictwo.OPIS_KROTKI +
                " TEXT NOT NULL,"+ Contracts.Nazewnictwo.OPIS_DLUGI + " TEXT NOT NULL);";
        Log.d(TAG, sqlStatement);
        db.execSQL(sqlStatement);
        Log.d(TAG, "onCreate: ENDS");
    }

    public ArrayList<Temat>WczytajProjekty(String kategoria)
    {
        ArrayList<Temat> listaTematowZBazy = new ArrayList<>();
        Log.d(TAG, "WczytajProjekty: Pobieranie tematow");
        SQLiteDatabase db = this.getReadableDatabase();
        String reuslt = "";
        String query  = "SELECT * FROM " + Contracts.Nazewnictwo.NAZWA_TABELI + " WHERE " + Contracts.Nazewnictwo.KATEGORIA + " = " +"'"+kategoria+"'";
        Cursor cursor = db.rawQuery(query,null);
        while (cursor.moveToNext())
        {
            Temat temat = new Temat();
            temat.setKategoria(cursor.getString(cursor.getColumnIndex(Contracts.Nazewnictwo.KATEGORIA)));
            temat.setTytul(cursor.getString(cursor.getColumnIndex(Contracts.Nazewnictwo.TEMAT)));
            temat.setOpis_kr(cursor.getString(cursor.getColumnIndex(Contracts.Nazewnictwo.OPIS_KROTKI)));
            temat.setOpis_dł(cursor.getString(cursor.getColumnIndex(Contracts.Nazewnictwo.OPIS_DLUGI)));
            listaTematowZBazy.add(temat);
            Log.d(TAG, "WczytajProjekty: dodano temat : " + temat.toString() );

        }
        cursor.close();
        db.close();
        Log.d(TAG, "WczytajProjekty: pomyslnie pobrano tematy");
        return listaTematowZBazy;

    }


    public void WczytajDaneXML(ArrayList<Temat> listaTematow)
    {
        Temat temat;
        Log.d(TAG, "WczytajDaneXML: dodawanie listy tematow");
        SQLiteDatabase db = this.getWritableDatabase();
        String sqlStatement = "DROP TABLE IF EXISTS " + Contracts.Nazewnictwo.NAZWA_TABELI;
        db.execSQL(sqlStatement);
        Log.d(TAG, "WczytajDaneXML: Droping Table");
        sqlStatement = "CREATE TABLE IF NOT EXISTS "+ Contracts.Nazewnictwo.NAZWA_TABELI +"(_id INTEGER PRIMARY KEY NOT NULL, "+ Contracts.Nazewnictwo.KATEGORIA +
                " TEXT NOT NULL, "+ Contracts.Nazewnictwo.TEMAT + " TEXT NOT NULL," + Contracts.Nazewnictwo.OPIS_KROTKI +
                " TEXT NOT NULL,"+ Contracts.Nazewnictwo.OPIS_DLUGI + " TEXT NOT NULL);";
        db.execSQL(sqlStatement);
        Log.d(TAG, "WczytajDaneXML:  Creating Table");
        for (int i = 0; i < listaTematow.size();i++)
        {
            temat = listaTematow.get(i);
            ContentValues values = new ContentValues();
            values.put(Contracts.Nazewnictwo.KATEGORIA,temat.getKategoria());
            values.put(Contracts.Nazewnictwo.TEMAT,temat.getTytul());
            values.put(Contracts.Nazewnictwo.OPIS_KROTKI,temat.getOpis_kr());
            values.put(Contracts.Nazewnictwo.OPIS_DLUGI,temat.getOpis_dł());
            db.insert(Contracts.Nazewnictwo.NAZWA_TABELI,null,values);
            Log.d(TAG, "WczytajDaneXML: dodano " + temat.toString());
        }
        db.close();

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.d(TAG, "onUpgrade: starts");
        switch(oldVersion) {
            case 1:
                break;
            default: throw new IllegalStateException("onUpgrade() with uknown newVersion" + newVersion);
        }
        Log.d(TAG, "onUpgrade: ends ");

    }
}
