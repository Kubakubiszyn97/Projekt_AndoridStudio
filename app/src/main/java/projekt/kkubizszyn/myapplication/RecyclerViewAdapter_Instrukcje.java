package projekt.kkubizszyn.myapplication;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

public class RecyclerViewAdapter_Instrukcje extends RecyclerView.Adapter<RecyclerViewAdapter_Instrukcje.InstrukcjeViewHolder> {


    private static final String TAG = "RecyclerViewAdapter_Prz";
    private List<Temat> listaTematow;
    private Context mContext;

    public RecyclerViewAdapter_Instrukcje(List<Temat> listaTematow, Context context) {
        this.listaTematow = listaTematow;
        mContext = context;
    }

    @NonNull
    @Override
    public InstrukcjeViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        Log.d(TAG, "onCreateViewHolder:  new view requested");
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.przegladaj_temat,viewGroup,false);
        return new InstrukcjeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull InstrukcjeViewHolder instrukcjeViewHolder, int i) {
        Temat temat = listaTematow.get(i);
        instrukcjeViewHolder.tytul.setText(temat.getTytul());
        instrukcjeViewHolder.opis_krotki.setText(temat.getOpis_kr());

    }

    public Temat getTemat(int position)
    {
        return ((listaTematow != null)&& (listaTematow.size() != 0) ? listaTematow.get(position): null);
    }

    @Override
    public int getItemCount() {
        Log.d(TAG, "getItemCount: called");
        return ((listaTematow != null)&& (listaTematow.size() != 0)? listaTematow.size():0);
    }

    static class InstrukcjeViewHolder extends RecyclerView.ViewHolder{
        private static final String TAG = "InstrukcjeViewHolder";
        TextView tytul;
        TextView opis_krotki;

        public InstrukcjeViewHolder(@NonNull View itemView) {
            super(itemView);
            Log.d(TAG, "ProjektyViewHolder: starts");
            this.tytul = (TextView) itemView.findViewById(R.id.przegladaj_Tytul);
            this.opis_krotki = (TextView) itemView.findViewById(R.id.przegladaj_opis_krotki);
        }
    }

}
