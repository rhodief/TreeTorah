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

import static android.view.ViewGroup.LayoutParams.MATCH_PARENT;


public class TableHelper {

    private Context context;
    private TableLayout tableLayout;

    public TableHelper(Context activity, TableLayout tableLayoutR) {
        this.context = activity;
        this.tableLayout = tableLayoutR;
    }

    public void addTitle(String title) {
        TableRow tr = new TableRow(context);

        TextView t = new TextView(context);
        TableRow.LayoutParams rowParams = new TableRow.LayoutParams();
        rowParams.width = 30;
        rowParams.column = 30;
        rowParams.weight = 30;
        t.setBackgroundColor(Color.parseColor("#1a1c50"));
        t.setTextColor(Color.parseColor("#ffff00"));


        t.setTextSize(18);

        t.setLayoutParams(rowParams);
        t.setGravity(Gravity.CENTER);
        t.setText(title);
        tr.addView(t);


        tableLayout.addView(tr);
    }

    public void addRow(String[] columns) {
        TableRow tr = new TableRow(context);
        for (int i = 0; i < columns.length; i++) {
            TextView t = new TextView(context);
            TableRow.LayoutParams rowParams = new TableRow.LayoutParams();
            rowParams.width = 30;
            rowParams.column = 30;
            rowParams.weight = 30;
            t.setTextSize(18);

            t.setLayoutParams(rowParams);
            t.setText(columns[i]);
            tr.addView(t);
        }

        tableLayout.addView(tr);
    }
}
