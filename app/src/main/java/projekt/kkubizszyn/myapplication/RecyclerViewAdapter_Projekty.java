package projekt.kkubizszyn.myapplication;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

class RecyclerViewAdapter_Projekty extends RecyclerView.Adapter<RecyclerViewAdapter_Projekty.ProjektyViewHolder> {
    private static final String TAG = "RecyclerViewAdapter_Pro";
    private List<Temat> listaTematow;
    private Context mContext;

    public RecyclerViewAdapter_Projekty(List<Temat> listaTematow, Context context) {
        this.listaTematow = listaTematow;
        mContext = context;
    }

    @Override
    public void onBindViewHolder(@NonNull ProjektyViewHolder projektyViewHolder, int i) {
        Temat temat = listaTematow.get(i);
        projektyViewHolder.tytul.setText(temat.getTytul());
        projektyViewHolder.opis_krotki.setText(temat.getOpis_kr());

    }

    @NonNull
    @Override
    public ProjektyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        Log.d(TAG, "onCreateViewHolder:  new view requested");
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.przegladaj_temat,viewGroup,false);
        return new ProjektyViewHolder(view);

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

    static class ProjektyViewHolder extends RecyclerView.ViewHolder{
        private static final String TAG = "ProjektyViewHolder";
        TextView tytul;
        TextView opis_krotki;

        public ProjektyViewHolder(@NonNull View itemView) {
            super(itemView);
            Log.d(TAG, "ProjektyViewHolder: starts");
            this.tytul = (TextView) itemView.findViewById(R.id.przegladaj_Tytul);
            this.opis_krotki = (TextView) itemView.findViewById(R.id.przegladaj_opis_krotki);
        }
    }

}
