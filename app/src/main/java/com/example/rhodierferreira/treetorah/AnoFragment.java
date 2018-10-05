package com.example.rhodierferreira.treetorah;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TableLayout;

import com.example.rhodierferreira.treetorah.helper.TableHelper;

import java.util.ArrayList;

import models.AtividadeExtrativa;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link AnoFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link AnoFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AnoFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public AnoFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment AnoFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static AnoFragment newInstance(String param1, String param2) {
        AnoFragment fragment = new AnoFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_ano, container, false);
        buildAnoTable(container.getContext(), view);
        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void onResume() {
        super.onResume();

    }

    private void buildAnoTable(Context context, View view) {
        TableHelper table = new TableHelper(context, (TableLayout) view.findViewById(R.id.ano_table));
        ArrayList<String> row = new ArrayList();

        // Mostrar 3 atividaes
        AtividadeExtrativa atividadeExtrativa1 = new AtividadeExtrativa();
        atividadeExtrativa1.setArvoresCortadas(3);
        atividadeExtrativa1.setAltura(2);
        atividadeExtrativa1.setDiametroMenor(0.2);
        atividadeExtrativa1.setDiametroMaior(0.3);
        atividadeExtrativa1.setArvoresRepostas(5);
        atividadeExtrativa1.setEstado("ES - Espirito Santo");
        atividadeExtrativa1.setAno("2018");

        AtividadeExtrativa atividadeExtrativa2 = new AtividadeExtrativa();
        atividadeExtrativa2.setArvoresCortadas(4);
        atividadeExtrativa2.setAltura(4);
        atividadeExtrativa2.setDiametroMenor(0.2);
        atividadeExtrativa2.setDiametroMaior(0.3);
        atividadeExtrativa2.setArvoresRepostas(9);
        atividadeExtrativa2.setEstado("DF - Distrito Federal");
        atividadeExtrativa2.setAno("2018");


        AtividadeExtrativa atividadeExtrativa3 = new AtividadeExtrativa();
        atividadeExtrativa3.setArvoresCortadas(3);
        atividadeExtrativa3.setAltura(2);
        atividadeExtrativa3.setDiametroMenor(0.3);
        atividadeExtrativa3.setDiametroMaior(0.4);
        atividadeExtrativa3.setArvoresRepostas(0);
        atividadeExtrativa3.setEstado("SP - São Paulo");
        atividadeExtrativa3.setAno("2019");


        AtividadeExtrativa atividadeExtrativa4 = new AtividadeExtrativa();
        atividadeExtrativa4.setArvoresCortadas(3);
        atividadeExtrativa4.setAltura(2);
        atividadeExtrativa4.setDiametroMenor(0.3);
        atividadeExtrativa4.setDiametroMaior(0.4);
        atividadeExtrativa4.setArvoresRepostas(0);
        atividadeExtrativa4.setEstado("SP - São Paulo");
        atividadeExtrativa4.setAno("2019");


        AtividadeExtrativa atividadeExtrativa5 = new AtividadeExtrativa();
        atividadeExtrativa5.setArvoresCortadas(3);
        atividadeExtrativa5.setAltura(2);
        atividadeExtrativa5.setDiametroMenor(0.3);
        atividadeExtrativa5.setDiametroMaior(0.4);
        atividadeExtrativa5.setArvoresRepostas(0);
        atividadeExtrativa5.setEstado("SP - São Paulo");
        atividadeExtrativa5.setAno("2019");


        AtividadeExtrativa atividadeExtrativa6 = new AtividadeExtrativa();
        atividadeExtrativa6.setArvoresCortadas(3);
        atividadeExtrativa6.setAltura(2);
        atividadeExtrativa6.setDiametroMenor(0.3);
        atividadeExtrativa6.setDiametroMaior(0.4);
        atividadeExtrativa6.setArvoresRepostas(0);
        atividadeExtrativa6.setEstado("SP - São Paulo");
        atividadeExtrativa6.setAno("2019");


        AtividadeExtrativa atividadeExtrativa7 = new AtividadeExtrativa();
        atividadeExtrativa7.setArvoresCortadas(3);
        atividadeExtrativa7.setAltura(2);
        atividadeExtrativa7.setDiametroMenor(0.3);
        atividadeExtrativa7.setDiametroMaior(0.4);
        atividadeExtrativa7.setArvoresRepostas(0);
        atividadeExtrativa7.setEstado("SP - São Paulo");
        atividadeExtrativa7.setAno("2019");

        ArrayList<AtividadeExtrativa> atividades = new ArrayList();
        atividades.add(atividadeExtrativa1);
        atividades.add(atividadeExtrativa2);
        atividades.add(atividadeExtrativa3);
        atividades.add(atividadeExtrativa4);
        atividades.add(atividadeExtrativa5);
        atividades.add(atividadeExtrativa6);
        atividades.add(atividadeExtrativa7);

        // Fim da simulação

        table.renderAno(atividades);
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
