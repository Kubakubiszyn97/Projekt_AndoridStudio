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

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class tematyProjekty extends Contracts implements RecyclerItemClickListener.OnRecyclerClickListener {
    private static final String TAG = "tematyProjekty";
    private RecyclerViewAdapter_Projekty mRecyclerViewAdapter_projekty;
    private Button showInfoButton;
    @Override
    public void onItemClick(View view, int position) {

    }

    @Override
    public void onItemLongClick(View view, int position) {
        Log.d(TAG, "onItemLongClick: starts" + position);
        Intent intent = new Intent(this, PrzegladajSzczegolyActivity.class);
        intent.putExtra(TEMAT_EKS,mRecyclerViewAdapter_projekty.getTemat(position));
        startActivity(intent);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tematy_projekty);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.projekty_recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        BazaDanych bazaDanych = new BazaDanych(this);
        ArrayList<Temat> lista_testowa = bazaDanych.WczytajProjekty("Aplikacja");

        showInfoButton = (Button) findViewById(R.id.infoProjektyButton);
        showInfoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),Info.class);
                startActivity(intent);
            }
        });

        recyclerView.addOnItemTouchListener(new RecyclerItemClickListener(this,recyclerView,this));
        mRecyclerViewAdapter_projekty = new RecyclerViewAdapter_Projekty(lista_testowa,this);
        recyclerView.setAdapter(mRecyclerViewAdapter_projekty);

        Toast toast =  Toast.makeText(getApplicationContext(),"Aby wyświetlić temat, wybierz i przytrzymaj",Toast.LENGTH_LONG );
        toast.show();




    }
}
