package Tema3_IntroPOOyString.boletin4_2.ejer1;

import java.time.LocalDate;

public class Persona {

    String nombre;
    LocalDate fecha;
    int dni;
    char sexo;
    float altura;
    float peso;


    public char letraDni() {

        char[] letra = {'T', 'R', 'W', 'A', 'G', 'M', 'Y', 'F', 'P', 'D', 'X',
                'B', 'N', 'J', 'Z', 'S', 'Q', 'V', 'H', 'L', 'C', 'K', 'E'};
        return letra[dni % 23];

    }

    public float imc() {

        return peso/ (altura*altura);
    }

    public Persona(String nombre, String fecha, int dni, char sexo, float altura, float peso) {
        this.nombre = nombre;
        this.fecha = LocalDate.parse(fecha);
        this.dni = dni;
        this.sexo = sexo;
        this.altura = altura;
        this.peso = peso;
    }

    public static void main(String[] args) {
        Persona usuario1=new Persona("Antonio","1988-01-25",29614958,'H',184,95);

        System.out.println(usuario1.dni+""+usuario1.letraDni());
        System.out.printf("%.5f",usuario1.imc());
    }

}
