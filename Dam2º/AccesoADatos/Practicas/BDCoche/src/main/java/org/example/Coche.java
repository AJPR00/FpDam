package org.example;

public class Coche {
    private String pkMatricula, marca, modelo;


    public Coche(String matricula, String marca, String modelo) {
        this.pkMatricula = matricula;
        this.marca = marca;
        this.modelo = modelo;
    }

    public String getPkMatricula() {
        return pkMatricula;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer();
        sb.append(pkMatricula).append(" ").append(marca).append(" ").append(modelo);

        return sb.toString();
    }
}
