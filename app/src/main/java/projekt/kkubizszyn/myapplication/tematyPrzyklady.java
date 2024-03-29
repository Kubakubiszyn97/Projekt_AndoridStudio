package projekt.kkubizszyn.myapplication;

import android.content.Intent;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

public class tematyPrzyklady extends Contracts implements RecyclerItemClickListener.OnRecyclerClickListener {
    private static final String TAG = "tematyPrzyklady";
    private RecyclerViewAdapter_Przyklady mRecyclerViewAdapter_przyklady;
    private Button showInfoButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tematy_przyklady);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.przyklady_recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        BazaDanych bazaDanych = new BazaDanych(this);
        ArrayList<Temat> lista_testowa = bazaDanych.WczytajProjekty("Przyklad");


        showInfoButton = (Button) findViewById(R.id.przykladyInfoButton);
        showInfoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),Info.class);
                startActivity(intent);
            }
        });

        recyclerView.addOnItemTouchListener(new RecyclerItemClickListener(this,recyclerView,this));
        mRecyclerViewAdapter_przyklady = new RecyclerViewAdapter_Przyklady(lista_testowa,this);
        recyclerView.setAdapter(mRecyclerViewAdapter_przyklady);

        Toast toast =  Toast.makeText(getApplicationContext(),"Aby wyświetlić temat, wybierz i przytrzymaj",Toast.LENGTH_LONG );
        toast.show();
    }


    @Override
    public void onItemClick(View view, int position) {
        Log.d(TAG, "onItemClick: starts on position" + position);
    }

    @Override
    public void onItemLongClick(View view, int position) {
        Log.d(TAG, "onItemLongClick: starts" + position);
        Intent intent = new Intent(this, PrzegladajSzczegolyActivity.class);
        intent.putExtra(TEMAT_EKS,mRecyclerViewAdapter_przyklady.getTemat(position));
        startActivity(intent);



    }
}
