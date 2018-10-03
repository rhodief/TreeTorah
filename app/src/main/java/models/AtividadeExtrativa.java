package models;

import java.util.HashMap;

public class AtividadeExtrativa {
    private String ano;
    private String estado;
    private int arvoresCortadas;
    private int arvoresRespostas;
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


    public int getArvoresRespostas() {
        return arvoresRespostas;
    }

    public void setArvoresRespostas(int arvoresRespostas) {
        this.arvoresRespostas = arvoresRespostas;
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
}
