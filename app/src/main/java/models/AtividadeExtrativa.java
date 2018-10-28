package models;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.HashMap;

public class AtividadeExtrativa {
    private int id;
    private String ano;
    private String estado;
    private int arvoresCortadas;
    private int arvoresRepostas;
    private double diametroMaior;
    private double diametroMenor;
    private double altura;
    private double valorArvore = 0.75;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

    public double getVolumeCortado() {
        //Para uma aproximação, calculamos o Volume da Tora com Base na Fórumula do Volume do Tronco de Cone
        return _round(arvoresCortadas * (altura * 3.14 / 3) * (Math.pow(diametroMaior/2, 2) + diametroMaior/2 * diametroMenor/2 + Math.pow(diametroMenor/2, 2)), 2);
    }


    public int getArvoresRepostas() {
        return arvoresRepostas;
    }

    public void setArvoresRepostas(int arvoresRepostas) {
        this.arvoresRepostas = arvoresRepostas;
    }

    //O valor-árvore é calculado por árvore cortada;
    public Double getValorASerPago() {
        if(arvoresRepostas != 0) {
            return 0.0;
        }
        return arvoresCortadas * valorArvore;
    }

    // A quantidade a repor é com base no metro-cúbico da tora.
    public Double getArvoresARepor() {
        return _round(getVolumeCortado() * 6, 2) - arvoresRepostas;
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

    @Override
    public String toString() {
        super.toString();
        return ano + " - " + estado + " - " + arvoresCortadas + " Árv. Cortadas";
    }

    private static double _round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        BigDecimal bd = new BigDecimal(value);
        bd = bd.setScale(places, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }



}
