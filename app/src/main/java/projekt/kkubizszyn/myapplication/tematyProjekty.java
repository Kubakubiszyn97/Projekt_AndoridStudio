package projekt.kkubizszyn.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class tematyProjekty extends Contracts implements RecyclerItemClickListener.OnRecyclerClickListener {
    private static final String TAG = "tematyProjekty";
    private RecyclerViewAdapter_Projekty mRecyclerViewAdapter_projekty;

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

        ArrayList<Temat> lista_testowa = new ArrayList<Temat>();
        Temat test1 = new Temat("S","dupa1","3-5","to jest dlugi opis test","to jest krotki opis test");
        Temat test2 = new Temat("S","dupa2","3-5","to jest dlugi opis test2","to jest krotki opis test2");
        Temat test3 = new Temat("S","dupa3","3-5","to jest dlugi opis test3","to jest krotki opis test3");
        Temat test4 = new Temat("S","dupa4","3-5","to jest dlugi opis test4","to jest krotki opis test4");
        Temat test5 = new Temat("S","dupa5","3-5","to jest dlugi opis test5","to jest krotki opis test5");
        Temat test6 = new Temat("S","dupa2","3-5","to jest dlugi opis test6","to jest krotki opis test6");
        Temat test7 = new Temat("S","dupa245","3-5","to jest dlugi opis test6","to jest krotki opis tedasdst6");
        Temat test8 = new Temat("S","dupa21","3-5","to jest dlugi opis test6","to jest krotki opis tesdat6");
        Temat test9 = new Temat("S","dupa24","3-5","to jest dlugi opis test6","to jest krotki opis tesadsadt6");
        Temat test10 = new Temat("S","dupa19","3-5","to jest dlugi opis test6","to jest krotki opis tessaddst6");
        Temat test11 = new Temat("S","dupa11","3-5","to jest dlugi opis test6","to jest krotki opis tesasdadt6");
        lista_testowa.add(test1);
        lista_testowa.add(test2);
        lista_testowa.add(test3);
        lista_testowa.add(test4);
        lista_testowa.add(test5);
        lista_testowa.add(test6);
        lista_testowa.add(test7);
        lista_testowa.add(test8);
        lista_testowa.add(test9);
        lista_testowa.add(test10);
        lista_testowa.add(test11);
        recyclerView.addOnItemTouchListener(new RecyclerItemClickListener(this,recyclerView,this));
        mRecyclerViewAdapter_projekty = new RecyclerViewAdapter_Projekty(lista_testowa,this);
        recyclerView.setAdapter(mRecyclerViewAdapter_projekty);




    }
}
