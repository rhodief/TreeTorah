package models;

import java.util.ArrayList;
import java.util.HashMap;

public class AtividadeExtrativa {
    private String ano;
    private String estado;
    private int arvoresCortadas;
    private int arvoresRepostas;
    private double diametroMaior;
    private double diametroMenor;
    private double altura;


    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getArvoresCortadas() {
        return arvoresCortadas;
    }

    public void setArvoresCortadas(int arvoresCortadas) {
        this.arvoresCortadas = arvoresCortadas;
    }

    public String getVolumeCortado() {
        return "volume cortado";
    }


    public int getArvoresRepostas() {
        return arvoresRepostas;
    }

    public void setArvoresRepostas(int arvoresRepostas) {
        this.arvoresRepostas = arvoresRepostas;
    }

    public String getValorASerPago() {
        return "valor a ser pago";
    }

    public double getDiametroMaior() {
        return diametroMaior;
    }

    public void setDiametroMaior(double diametroMaior) {
        this.diametroMaior = diametroMaior;
    }

    public double getDiametroMenor() {
        return diametroMenor;
    }

    public void setDiametroMenor(double diametroMenor) {
        this.diametroMenor = diametroMenor;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    // Retorna ArrayList de String na ordem ta tabela;
    //  "Estado (UF)"; "Árv. Cortadas"); "Volume (m2)"); "Árv. Repostas"); "A Restituir");
    public ArrayList<String>camposParaListaPorAno() {
        ArrayList<String> listaParaRetorno = new ArrayList<>();
        listaParaRetorno.add(getEstado());
        listaParaRetorno.add(String.valueOf(getArvoresCortadas()));
        listaParaRetorno.add(String.valueOf(getVolumeCortado()));
        listaParaRetorno.add(String.valueOf(getArvoresRepostas()));
        listaParaRetorno.add(String.valueOf(getValorASerPago()));

        return listaParaRetorno;
    }
}
