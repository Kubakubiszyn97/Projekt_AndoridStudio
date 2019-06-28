package projekt.kkubizszyn.myapplication;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.strictmode.SqliteObjectLeakedViolation;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

import java.util.ArrayList;

public class MainActivity extends Contracts implements View.OnClickListener,OnTaskCompleted {
    private static final String TAG = "MainActivity";
    private BazaDanych bazaDanych;
    private PobierzDane pobierzDane;
    Intent intent = null;

    public void OnTaskCompleted(ArrayList<Temat> lista){

        bazaDanych.WczytajDaneXML(lista);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        Button projektyButton  = (Button) findViewById(R.id.projektyButton);
        Button instruckjeButton = (Button) findViewById(R.id.instrukcjeButton);
        Button przykladyButton = (Button) findViewById(R.id.przykladyButton);

        instruckjeButton.setOnClickListener(this);
        projektyButton.setOnClickListener(this);
        przykladyButton.setOnClickListener(this);

        //pobieranie danych
        Log.d(TAG, "onCreate:starting Async Task");
        pobierzDane = new PobierzDane(this);
        pobierzDane.execute(XML_URL);
        //https://dstachow.pl/kuba/java_projekt_test2.xml?fbclid=IwAR2awc8CdX99JVudjTOG3N_Q1chxnTScdRquL9lIcRBJm59obFg2gYihcrY
        Log.d(TAG, "onCreate: done");



        // BAZA
        bazaDanych = new BazaDanych(this);


    }

    @Override
    public void onClick(View v) {

        switch (v.getId())
        {
            case R.id.przykladyButton:
                intent = new Intent(this,tematyPrzyklady.class);
                break;
            case R.id.instrukcjeButton:
                intent = new Intent(this,tematyInstrukcje.class);
                break;
            case R.id.projektyButton:
                intent = new Intent(this,tematyProjekty.class);
                break;

        }
        if (intent != null)
        {
            startActivity(intent);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            Intent intent = new Intent(this,Settings.class);
            startActivity(intent);
        }

        return super.onOptionsItemSelected(item);
    }

    public void PobierzPonownieTematy()
    {
        pobierzDane.execute(XML_URL);

    }
}
