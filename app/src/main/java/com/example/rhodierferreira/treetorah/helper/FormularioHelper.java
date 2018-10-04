package com.example.rhodierferreira.treetorah.helper;

import android.widget.AutoCompleteTextView;
import android.widget.EditText;

import com.example.rhodierferreira.treetorah.FormularioActivity;
import com.example.rhodierferreira.treetorah.R;

import models.AtividadeExtrativa;

public class FormularioHelper {

    private AutoCompleteTextView campoAno;
    private AutoCompleteTextView campoEstado;
    private EditText campoArvoresCortadas;
    private EditText campoDiametroMaior;
    private EditText campoDiametroMenor;
    private EditText campoAltura;
    private EditText campoArvoresRepostas;

    public FormularioHelper(FormularioActivity activity) {
        campoAno = activity.findViewById(R.id.campo_ano);
        campoEstado = activity.findViewById(R.id.campo_estado);
        campoArvoresCortadas = activity.findViewById(R.id.campo_arvores_cortadas);
        campoDiametroMaior = activity.findViewById(R.id.campo_diametro_maior);
        campoDiametroMenor = activity.findViewById(R.id.campo_diametro_menor);
        campoAltura = activity.findViewById(R.id.campo_altura);
        campoArvoresRepostas = activity.findViewById(R.id.campo_arvores_repostas);

    }

    public AtividadeExtrativa pegaAtividadeExtrativa() {
        AtividadeExtrativa atividadeExtrativa = new AtividadeExtrativa();

        atividadeExtrativa.setAno(campoAno.getText().toString());
        atividadeExtrativa.setEstado(campoEstado.getText().toString());
        atividadeExtrativa.setArvoresCortadas(Integer.parseInt(campoArvoresCortadas.getText().toString()));
        atividadeExtrativa.setDiametroMaior(Double.parseDouble(campoDiametroMaior.getText().toString()));
        atividadeExtrativa.setDiametroMenor(Double.parseDouble(campoDiametroMenor.getText().toString()));
        atividadeExtrativa.setAltura(Double.parseDouble(campoAltura.getText().toString()));
        atividadeExtrativa.setArvoresRepostas(Integer.parseInt(campoArvoresRepostas.getText().toString()));

        return atividadeExtrativa;

    }

}
