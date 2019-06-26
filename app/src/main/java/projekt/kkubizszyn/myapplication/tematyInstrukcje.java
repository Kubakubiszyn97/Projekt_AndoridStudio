package projekt.kkubizszyn.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;

public class tematyInstrukcje extends Contracts implements RecyclerItemClickListener.OnRecyclerClickListener {
    private static final String TAG = "tematyInstrukcje";
    RecyclerViewAdapter_Instrukcje mRecyclerViewAdapter_instrukcje;

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

        ArrayList<Temat> lista_testowa = new ArrayList<Temat>();
        Temat test1 = new Temat("S","dupa1","to jest dlugi opis test","to jest krotki opis test");
        Temat test2 = new Temat("S","dupa2","to jest dlugi opis test2","to jest krotki opis test2");
        Temat test3 = new Temat("S","dupa3","to jest dlugi opis test3","to jest krotki opis test3");
        Temat test4 = new Temat("S","dupa4","to jest dlugi opis test4","to jest krotki opis test4");
        Temat test5 = new Temat("S","dupa5","to jest dlugi opis test5","to jest krotki opis test5");
        Temat test6 = new Temat("S","dupa2","to jest dlugi opis test6","to jest krotki opis test6");
        Temat test7 = new Temat("S","dupa245","to jest dlugi opis test6","to jest krotki opis tedasdst6");
        Temat test8 = new Temat("S","dupa21","to jest dlugi opis test6","to jest krotki opis tesdat6");
        Temat test9 = new Temat("S","dupa24","to jest dlugi opis test6","to jest krotki opis tesadsadt6");
        Temat test10 = new Temat("S","dupa19","to jest dlugi opis test6","to jest krotki opis tessaddst6");
        Temat test11 = new Temat("S","dupa11","to jest dlugi opis test6","to jest krotki opis tesasdadt6");
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
        mRecyclerViewAdapter_instrukcje = new RecyclerViewAdapter_Instrukcje(lista_testowa,this);
        recyclerView.setAdapter(mRecyclerViewAdapter_instrukcje);



    }
}
