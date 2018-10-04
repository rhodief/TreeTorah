package com.example.rhodierferreira.treetorah;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

public class FormularioActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario);

        // Anos
        AutoCompleteTextView textView = (AutoCompleteTextView) findViewById(R.id.autocomplete_anos);
        // Get the string array
        String[] anos = getResources().getStringArray(R.array.anos_array);
        // Create the adapter and set it to the AutoCompleteTextView
        ArrayAdapter<String> adapter =
                new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, anos);
        textView.setAdapter(adapter);


        // Estados
        AutoCompleteTextView textViewEstados = (AutoCompleteTextView) findViewById(R.id.autocomplete_estados);
        // Get the string array
        String[] estados = getResources().getStringArray(R.array.estados_array);
        // Create the adapter and set it to the AutoCompleteTextView
        ArrayAdapter<String> adapterEstados =
                new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, estados);
        textViewEstados.setAdapter(adapterEstados);
    }
}
