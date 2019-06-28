package projekt.kkubizszyn.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Settings extends Contracts {
    private static final String TAG = "Settings";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        Button resetURL = (Button) findViewById(R.id.resetURLButton);
        Button zatwierdz = (Button) findViewById(R.id.applyButton);
        final EditText editText = (EditText) findViewById(R.id.editUrlText);


        resetURL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick:  current XML is: " + Contracts.XML_URL);
                Contracts.XML_URL = XML_URL_DEFAULT;
                Log.d(TAG, "onClick: Now current XML is: " + Contracts.XML_URL);

               Toast toast =  Toast.makeText(getApplicationContext(),"Przywrócono do utawień domyślnych",Toast.LENGTH_LONG );
               toast.show();
            }
        });

        editText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.setText("");
            }
        });

        zatwierdz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Log.d(TAG, "Current XML is " + Contracts.XML_URL);
                String newUrl = editText.getText().toString();
                Contracts.XML_URL = newUrl;
                Log.d(TAG, "New URL is : " + Contracts.XML_URL);
                Toast toast =  Toast.makeText(getApplicationContext(), "Zmieniono URL",Toast.LENGTH_LONG );
                toast.show();
                editText.setText("");

            }
        });

    }
}
