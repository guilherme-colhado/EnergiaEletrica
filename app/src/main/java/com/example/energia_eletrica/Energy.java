package com.example.energia_eletrica;

public class Energy {
    private double consumo;

    public Energy(double consumo) {
        setConsumo(consumo);
    }

    public double getConsumo() {
        return consumo;
    }

    public void setConsumo(double consumo) {
        this.consumo = consumo;
    }

    public double fornecimento(){
        return getConsumo() * 0.28172;
    }

    public double icms(){
        double fatorDeMultiplicacao, aliquota;
        if (getConsumo()<=200){
            aliquota = 0.12;
            fatorDeMultiplicacao = 0.136363;
        } else{
            aliquota = 0.25;
            fatorDeMultiplicacao = 0.333333;
        }
        return fornecimento() * aliquota * fatorDeMultiplicacao;
    }

    public double cofins(){
        double fatorDeMultiplicacao, aliquota = 5.033/100;
        if (getConsumo()<=200){
            fatorDeMultiplicacao = 0.136363;
        } else{
            fatorDeMultiplicacao = 0.333333;
        }
        return fornecimento() * aliquota * fatorDeMultiplicacao;
    }

    public double pisPasep(){
        double fatorDeMultiplicacao, aliquota = 1.0927/100;
        if (getConsumo()<=200){
            fatorDeMultiplicacao = 0.013346;
        } else{
            fatorDeMultiplicacao = 0.0158651;
        }
        return fornecimento() * aliquota * fatorDeMultiplicacao;
    }

    public double icmsCofins(){
        return fornecimento() * icms() * cofins();
    }

    public double icmsPisPassep(){
        return fornecimento() * icms() * pisPasep();
    }

    public double fatura(){
        return fornecimento() + icms() + cofins() + pisPasep() + icmsCofins() + icmsPisPassep();
    }
}
