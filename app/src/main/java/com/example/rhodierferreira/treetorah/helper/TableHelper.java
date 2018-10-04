package com.example.rhodierferreira.treetorah.helper;

import android.app.ActionBar;
import android.content.Context;
import android.graphics.Color;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.example.rhodierferreira.treetorah.MainActivity;

import java.util.ArrayList;

import static android.view.ViewGroup.LayoutParams.MATCH_PARENT;


public class TableHelper {

    private Context context;
    private TableLayout tableLayout;

    public TableHelper(Context activity, TableLayout tableLayoutR) {
        this.context = activity;
        this.tableLayout = tableLayoutR;
    }

    public void addTitle(String title) {
        // # Cabeçalho 1
        ArrayList<String> header = new ArrayList<>();
        header.add("2018");
        _addRow(header, "#FFFFFFFF", "#1a1c50");

        // # Cabeçalho 2
        ArrayList<String> newTitle = new ArrayList<>();
        newTitle.add("Estado (UF)");
        newTitle.add("Árv. Cortadas");
        newTitle.add("Volume (m2)");
        newTitle.add("Árv. Repostas");
        newTitle.add("A Restituir");
        _addRow(newTitle, "#FFFFFFFF", "#3f51b5");
    }

    public void addRow(ArrayList<String> columns) {
        _addRow(columns, "", "");
    }

    private void _addRow(ArrayList<String> columns, String color, String backgroundColor) {
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
}
