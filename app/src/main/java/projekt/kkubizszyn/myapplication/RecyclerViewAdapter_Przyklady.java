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

class RecyclerViewAdapter_Przyklady extends RecyclerView.Adapter<RecyclerViewAdapter_Przyklady.PrzykladyViewHolder> {
    private static final String TAG = "RecyclerViewAdapter_Prz";
    private List<Temat> listaTematow;
    private Context mContext;

    public RecyclerViewAdapter_Przyklady(List<Temat> listaTematow, Context context) {
        this.listaTematow = listaTematow;
        mContext = context;
    }

    @NonNull
    @Override
    public PrzykladyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        Log.d(TAG, "onCreateViewHolder:  new view requested");
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.przegladaj_temat,viewGroup,false);
        return new PrzykladyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PrzykladyViewHolder przykladyViewHolder, int i) {
        Temat temat = listaTematow.get(i);
        przykladyViewHolder.tytul.setText(temat.getTytul());
        przykladyViewHolder.opis_krotki.setText(temat.getOpis_kr());

    }

    @Override
    public int getItemCount() {
        Log.d(TAG, "getItemCount: called");
        return ((listaTematow != null)&& (listaTematow.size() != 0)? listaTematow.size():0);
    }

    public Temat getTemat(int position)
    {
        return ((listaTematow != null)&& (listaTematow.size() != 0) ? listaTematow.get(position): null);
    }


    static class PrzykladyViewHolder extends RecyclerView.ViewHolder {
        private static final String TAG = "ProjektyViewHolder";
        TextView tytul;
        TextView opis_krotki;

        public PrzykladyViewHolder(@NonNull View itemView) {
            super(itemView);
            Log.d(TAG, "ProjektyViewHolder: starts");
            this.tytul = (TextView) itemView.findViewById(R.id.przegladaj_Tytul);
            this.opis_krotki = (TextView) itemView.findViewById(R.id.przegladaj_opis_krotki);
        }
    }

}
