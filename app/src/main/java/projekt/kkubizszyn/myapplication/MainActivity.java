package projekt.kkubizszyn.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String TAG = "MainActivity";
    Intent intent = null;

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
        PobierzDane pobierzDane = new PobierzDane();
        pobierzDane.execute("http://ax.itunes.apple.com/WebObjects/MZStoreServices.woa/ws/RSS/topfreeapplications/limit=10/xml");
        //https://drive.google.com/open?id=1qKda62vLWHffWde_y6a09FZACCwYqkAS
        Log.d(TAG, "onCreate: done");


        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });



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
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
