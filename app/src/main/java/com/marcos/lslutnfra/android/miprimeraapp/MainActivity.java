package com.marcos.lslutnfra.android.miprimeraapp;

import android.annotation.TargetApi;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.security.Timestamp;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    String[] languages={"Android ","java","IOS","SQL","JDBC","Web services"};
    private TextView text;
    private AutoCompleteTextView autoCompleteTextView;
    private EditText textoEditable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text= (TextView) findViewById(R.id.textView);
        Button botonBorrar = (Button) findViewById(R.id.borrar);
        botonBorrar.setOnClickListener(this);

        textoEditable = (EditText) findViewById(R.id.textoEditable);

        autoCompleteTextView = (AutoCompleteTextView) findViewById(R.id.autocompleteTextView);
        autoCompleteTextView.requestFocus();

        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, languages );
        autoCompleteTextView.setAdapter(adapter);

        autoCompleteTextView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                text.setText(autoCompleteTextView.getText());
            }
        });

        autoCompleteTextView.setOnKeyListener(new View.OnKeyListener() {
            @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (keyCode == KeyEvent.KEYCODE_ENTER && autoCompleteTextView.isPopupShowing()) {
                    Toast.makeText(getApplicationContext(), "Enter!!", Toast.LENGTH_LONG).show();
                    //estaria bueno que al hacer click se complete el texto con el primer sugerido por el autocomplete

                    return true;
                }
                return false;
            }
        });

        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(this);

        /*
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Un click!", Toast.LENGTH_LONG).show();
                Calendar calendar = GregorianCalendar.getInstance();
                Date date = calendar.getTime();
                text.setText("FECHA: " + date.getDate() + "/" + (date.getMonth() + 1) + " - " + new Random().nextInt(10));
            }
        });
        */

    }

    @Override
    public void onClick(View v) {
        text.setText( v.getId() == R.id.button ? textoEditable.getText() : "");
    }
}
