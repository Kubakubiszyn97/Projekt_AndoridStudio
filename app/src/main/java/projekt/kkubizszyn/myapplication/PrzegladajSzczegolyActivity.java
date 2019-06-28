package projekt.kkubizszyn.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

public class PrzegladajSzczegolyActivity extends Contracts {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_przegladaj_szegoly);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



        Intent intent =getIntent();
        Temat temat = (Temat) intent.getSerializableExtra(TEMAT_EKS);
        if(temat != null)
        {
            TextView tytul =(TextView) findViewById(R.id.szczegoly_tytul);
            TextView opis = (TextView) findViewById(R.id.szczegoly_opis);
            opis.setText(temat.getOpis_dł());
            tytul.setText(temat.getTytul());

        }


    }

}
