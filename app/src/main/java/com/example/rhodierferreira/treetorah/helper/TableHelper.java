package com.example.rhodierferreira.treetorah.helper;

import android.app.ActionBar;
import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.example.rhodierferreira.treetorah.MainActivity;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.HashMap;

import models.AtividadeExtrativa;

import static android.view.ViewGroup.LayoutParams.MATCH_PARENT;


public class TableHelper {

    private Context context;
    private TableLayout tableLayout;

    public TableHelper(Context activity, TableLayout tableLayoutR) {
        tableLayoutR.removeAllViewsInLayout();
        this.context = activity;
        this.tableLayout = tableLayoutR;
    }

    public void renderAno (ArrayList<AtividadeExtrativa>atividades){
        // Mostra mensgem não houver Atividades Extrativas Cadastradas;
        if(atividades.size() == 0) {
            ArrayList<String> columns = new ArrayList();
            columns.add("Não há Atividades Extrativas Registradas");
            addRow(columns);
            return;
        }
        // Renderização da Tabela....
        String AnoRetentor = "";
        Integer tot_av_cor = 0;
        double tot_vol = 0;
        double tot_av_rep = 0;
        double tot_av_a_resp = 0;
        double tot_val_a_resp = 0;
        for (int i = 0; i < atividades.size(); i++){
            if(AnoRetentor.compareTo(atividades.get(i).getAno()) != 0){
                if(i != 0) {
                    addTotal(tot_av_cor, _round(tot_vol, 2), _round(tot_av_rep, 2), _round(tot_av_a_resp, 2), _round(tot_val_a_resp, 2));
                    tot_av_cor = 0;
                    tot_vol = 0;
                    tot_av_rep = 0;
                    tot_av_a_resp = 0;
                    tot_val_a_resp = 0;
                }
                addTitle(atividades.get(i).getAno(), "Estado (UF)");
            }
            AnoRetentor = atividades.get(i).getAno();

            //Insere as linhas
            addRow(camposParaListaPorAno(atividades.get(i)));
            tot_av_cor += atividades.get(i).getArvoresCortadas();
            tot_vol += atividades.get(i).getVolumeCortado();
            tot_av_rep += atividades.get(i).getArvoresRepostas();
            tot_av_a_resp += atividades.get(i).getArvoresARepor();
            tot_val_a_resp += atividades.get(i).getValorASerPago();
            if (atividades.size() == i +1) {
                addTotal(tot_av_cor, _round(tot_vol, 2), _round(tot_av_rep, 2), _round(tot_av_a_resp, 2), _round(tot_val_a_resp, 2));
                tot_av_cor = 0;
                tot_vol = 0;
                tot_av_rep = 0;
                tot_av_a_resp = 0;
                tot_val_a_resp = 0;
            }
        }
        _fechamento();
    }

    public void renderEstado(ArrayList<AtividadeExtrativa>atividades) {
        // Mostra mensgem não houver Atividades Extrativas Cadastradas;
        if(atividades.size() == 0) {
            ArrayList<String> columns = new ArrayList();
            columns.add("Não há Atividades Extrativas Registradas");
            addRow(columns);
            return;
        }
        // Renderização da Tabela....
        String EstadoRetentor = "";
        Integer tot_av_cor = 0;
        double tot_vol = 0;
        double tot_av_rep = 0;
        double tot_av_a_resp = 0;
        double tot_val_a_resp = 0;
        for (int i = 0; i < atividades.size(); i++){
            if(EstadoRetentor != atividades.get(i).getEstado()){
                if(i != 0) {
                    addTotal(tot_av_cor, _round(tot_vol, 2), _round(tot_av_rep, 2), _round(tot_av_a_resp, 2), _round(tot_val_a_resp, 2));
                    tot_av_cor = 0;
                    tot_vol = 0;
                    tot_av_rep = 0;
                    tot_av_a_resp = 0;
                    tot_val_a_resp = 0;
                }
                addTitle(atividades.get(i).getAno().toString(), "Ano Ext.");
            }
            EstadoRetentor = atividades.get(i).getEstado();

            //Insere as linhas
            addRow(camposParaListaPorEstado(atividades.get(i)));
            tot_av_cor += atividades.get(i).getArvoresCortadas();
            tot_vol += atividades.get(i).getVolumeCortado();
            tot_av_rep += atividades.get(i).getArvoresRepostas();
            tot_av_a_resp += atividades.get(i).getArvoresARepor();
            tot_val_a_resp += atividades.get(i).getValorASerPago();
            if (atividades.size() == i +1) {
                addTotal(tot_av_cor, _round(tot_vol, 2), _round(tot_av_rep, 2), _round(tot_av_a_resp, 2), _round(tot_val_a_resp, 2));
                tot_av_cor = 0;
                tot_vol = 0;
                tot_av_rep = 0;
                tot_av_a_resp = 0;
                tot_val_a_resp = 0;
            }
        }
        _fechamento();
    }

    public void addTitle(String title, String primeiraColuna) {
        //Espaço Antes
        addBlankRow();
        // # Cabeçalho 1
        ArrayList<String> header = new ArrayList<>();
        header.add(title);
        _addRow(header, "#FFFFFFFF", "#1a1c50", null);

        // # Cabeçalho 2
        ArrayList<String> newTitle = new ArrayList<>();
        newTitle.add(primeiraColuna);
        newTitle.add("Árv. Cor");
        newTitle.add("Vol (m2)");
        newTitle.add("Árv. Rep");
        newTitle.add("Árv a Res");
        newTitle.add("R$ a Res");
        _addRow(newTitle, "#FFFFFFFF", "#3f51b5", null);
    }

    public void addRow(ArrayList<String> columns) {
        _addRow(columns, "", "", null);
    }

    public void addBlankRow() {
        ArrayList<String> blank = new ArrayList<>();
        blank.add(" ");
        _addRow(blank, "#FFFFFFFF", "#FFFFFFFF", null);
    }

    public void addTotal(Integer t_av_cortada, double t_vol, double t_av_rep, double t_av_a_res, double t_val_res) {
        ArrayList<String> total = new ArrayList<>();
        total.add(" ");
        total.add(String.valueOf(t_av_cortada));
        total.add(String.valueOf(t_vol));
        total.add(String.valueOf(t_av_rep));
        total.add(String.valueOf(t_av_a_res));
        total.add(String.valueOf(t_val_res));
        _addRow(total, "", "#FFD1D9DE", null);

    }

    private void _addRow(ArrayList<String> columns, String color, String backgroundColor, HashMap<Integer, String> colors) {
        TableRow tr = new TableRow(context);
        for (int i = 0; i < columns.size(); i++) {
            TextView t = new TextView(context);
            TableRow.LayoutParams rowParams = new TableRow.LayoutParams();
            rowParams.width = 30;
            rowParams.column = 30;
            rowParams.weight = 30;
            if (backgroundColor != "") {
                t.setBackgroundColor(Color.parseColor(backgroundColor));
            }
            if(colors != null && colors.size() > 0 && colors.get(i) != null){
                t.setBackgroundColor(Color.parseColor(colors.get(i)));
            }

            if(color != "") {
                t.setTextColor(Color.parseColor(color));
            }

            t.setTextSize(18);

            t.setLayoutParams(rowParams);
            t.setGravity(Gravity.CENTER);

            t.setText(columns.get(i));
            tr.addView(t);
        }

        tableLayout.addView(tr);
    }

    // Retorna ArrayList de String na ordem ta tabela;
    //  "Estado (UF)"; "Árv. Cortadas"); "Volume (m2)"); "Árv. Repostas"); "A Restituir");
    public ArrayList<String>camposParaListaPorAno(AtividadeExtrativa atividadeExtrativa) {
        ArrayList<String> listaParaRetorno = new ArrayList<>();
        listaParaRetorno.add(atividadeExtrativa.getEstado());
        listaParaRetorno.add(String.valueOf(atividadeExtrativa.getArvoresCortadas()));
        listaParaRetorno.add(String.valueOf(atividadeExtrativa.getVolumeCortado()));
        listaParaRetorno.add(String.valueOf(atividadeExtrativa.getArvoresRepostas()));
        listaParaRetorno.add(String.valueOf(atividadeExtrativa.getArvoresARepor()));
        listaParaRetorno.add(String.valueOf(atividadeExtrativa.getValorASerPago()));

        return listaParaRetorno;
    }

    public ArrayList<String>camposParaListaPorEstado(AtividadeExtrativa atividadeExtrativa) {
        ArrayList<String> listaParaRetorno = new ArrayList<>();
        listaParaRetorno.add(atividadeExtrativa.getAno());
        listaParaRetorno.add(String.valueOf(atividadeExtrativa.getArvoresCortadas()));
        listaParaRetorno.add(String.valueOf(atividadeExtrativa.getVolumeCortado()));
        listaParaRetorno.add(String.valueOf(atividadeExtrativa.getArvoresRepostas()));
        listaParaRetorno.add(String.valueOf(atividadeExtrativa.getArvoresARepor()));
        listaParaRetorno.add(String.valueOf(atividadeExtrativa.getValorASerPago()));

        return listaParaRetorno;
    }

    private void _fechamento() {
        addBlankRow();
        addBlankRow();
    }

    private static double _round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        BigDecimal bd = new BigDecimal(value);
        bd = bd.setScale(places, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }
}
