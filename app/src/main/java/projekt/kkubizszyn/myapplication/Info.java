package projekt.kkubizszyn.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.widget.TextView;

public class Info extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
        TextView textView = (TextView) findViewById(R.id.textScrollowalny);
        textView.setMovementMethod(new ScrollingMovementMethod());

        textView.setText("Projekty: \n" +
                "   Katerogia: \n" +
                "   - Web Appp \n" +
                "   - Enterprise App \n" +
                "   - Desktop App \n"+
                "   - Hybrid App \n"+
                "   - Mobile App \n"+
                "   - Enbedded App \n" +
                "   - Inna (Java Cloud, Java TV \n \n" +
                "Instrukcje: \n" +
                "   Przykłady i zadania mają być realizowane w aktualnych wersjach danych Plaform \n" +
                "   Niektóre przykłady i zadania należy zrealizować w dwóch  wersjach, jednej sam kod oraz drugiej kroki budowy \n" +
                "   Projekty powinny zawierać: \n" +
                "       - Plik doc& z instrukcją \n" +
                "       - Kody źrodłowe \n" +
                "       - Struktury Projektów\n \n" +
                "Przykłady: \n" +
                "   Student w sumie wybiera 3 przykłady, ale tylko po jednym z  danej kategori (1 -5)\n" +
                "   Przykłady mają być realizowane w aktualnych wersjach  danych");
    }
}
