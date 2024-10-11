
package org.example;

public class Car {
    private String matrícula;
    private String marca;
    private String modelo;
    private String año;
    private String color;

    public Car(String matrícula, String marca, String modelo, String año, String color) {
        this.matrícula = matrícula;
        this.marca = marca;
        this.modelo = modelo;
        this.año = año;
        this.color = color;
    }

    public String getMatrícula() {
        return matrícula;
    }

    public void setMatrícula(String matrícula) {
        this.matrícula = matrícula;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getAño() {
        return año;
    }

    public void setAño(String año) {
        this.año = año;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
// getters and setters
}