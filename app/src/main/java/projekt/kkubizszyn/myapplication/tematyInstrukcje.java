package projekt.kkubizszyn.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

public class tematyInstrukcje extends Contracts implements RecyclerItemClickListener.OnRecyclerClickListener {
    private static final String TAG = "tematyInstrukcje";
    RecyclerViewAdapter_Instrukcje mRecyclerViewAdapter_instrukcje;
    Button showInfoButton;

    @Override
    public void onItemClick(View view, int position) {

    }

    @Override
    public void onItemLongClick(View view, int position) {
        Log.d(TAG, "onItemLongClick: starts" + position);
        Intent intent = new Intent(this, PrzegladajSzczegolyActivity.class);
        intent.putExtra(TEMAT_EKS,mRecyclerViewAdapter_instrukcje.getTemat(position));
        startActivity(intent);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tematy_instrukcje);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.instrukcje_recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        BazaDanych bazaDanych = new BazaDanych(this);
        ArrayList<Temat> lista_testowa = bazaDanych.WczytajProjekty("Instrukcja") ;

        showInfoButton = (Button) findViewById(R.id.infoInstrukcjebutton);
        showInfoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),Info.class);
                startActivity(intent);
            }
        });

        recyclerView.addOnItemTouchListener(new RecyclerItemClickListener(this,recyclerView,this));
        mRecyclerViewAdapter_instrukcje = new RecyclerViewAdapter_Instrukcje(lista_testowa,this);
        recyclerView.setAdapter(mRecyclerViewAdapter_instrukcje);

        Toast toast =  Toast.makeText(getApplicationContext(),"Aby wyświetlić temat, wybierz i przytrzymaj",Toast.LENGTH_LONG );
        toast.show();



    }
}
