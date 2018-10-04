package com.example.rhodierferreira.treetorah;


import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.rhodierferreira.treetorah.helper.FormularioHelper;

import java.util.concurrent.atomic.AtomicInteger;

import models.AtividadeExtrativa;

public class FormularioActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario);

        // Anos
        AutoCompleteTextView textView = (AutoCompleteTextView) findViewById(R.id.campo_ano);
        // Get the string array
        String[] anos = getResources().getStringArray(R.array.anos_array);
        // Create the adapter and set it to the AutoCompleteTextView
        ArrayAdapter<String> adapter =
                new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, anos);
        textView.setAdapter(adapter);


        // Estados
        AutoCompleteTextView textViewEstados = (AutoCompleteTextView) findViewById(R.id.campo_estado);
        // Get the string array
        String[] estados = getResources().getStringArray(R.array.estados_array);
        // Create the adapter and set it to the AutoCompleteTextView
        ArrayAdapter<String> adapterEstados =
                new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, estados);
        textViewEstados.setAdapter(adapterEstados);


        // Botão de Salvar
        Button botaoSalvar = findViewById(R.id.botao_salvar);
        botaoSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast toast = Toast.makeText(FormularioActivity.this, "Aluno salvo!", Toast.LENGTH_SHORT);
                TextView v = (TextView) toast.getView().findViewById(android.R.id.message);
                v.setTextColor(Color.RED);

                // # Procedimento de Gravação
                FormularioHelper formularioHelper = new FormularioHelper(FormularioActivity.this);
                AtividadeExtrativa atividadeExtrativa = formularioHelper.pegaAtividadeExtrativa();


                // Mostrar o Toast e Fechar

                toast.show();
                finish();

            }
        });
    }
}
