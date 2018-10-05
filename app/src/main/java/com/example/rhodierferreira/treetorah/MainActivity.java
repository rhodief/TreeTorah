package com.example.rhodierferreira.treetorah;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements AnoFragment.OnFragmentInteractionListener, ListaFragment.OnFragmentInteractionListener, EstadoFragment.OnFragmentInteractionListener {

    private FrameLayout mMainFrame;

    private AnoFragment anoFragment;

    private EstadoFragment estadoFragment;

    private ListaFragment listaFragment;

    public String teste;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_ano:
                    setFragment(anoFragment);
                    return true;
                case R.id.navigation_estado:
                    setFragment(estadoFragment);
                    return true;
                case R.id.navigation_lista:
                    setFragment(listaFragment);
                    return true;
            }
            return false;
        }

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        anoFragment = new AnoFragment();
        estadoFragment = new EstadoFragment();
        listaFragment = new ListaFragment();
        mMainFrame = findViewById(R.id.main_frame);
        setFragment(anoFragment);
        BottomNavigationView navigation = findViewById(R.id.nav_main);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.adicionar_atividade_button);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent vaiParaFormulario = new Intent(MainActivity.this, FormularioActivity.class);
                startActivity(vaiParaFormulario);
                //Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG).setAction("Action", null).show();
            }
        });
    }



    @Override
    public void onResume(){
        super.onResume();
    }

    private void setFragment (Fragment fragment) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.main_frame, fragment);
        fragmentTransaction.commit();
    }



    @Override
    public void onFragmentInteraction(Uri uri){
        //you can leave it empty
    }



}
