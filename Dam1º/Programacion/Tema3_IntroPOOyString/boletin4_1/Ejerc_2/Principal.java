package Tema3_IntroPOOyString.boletin4_1.Ejerc_2;

/*2. Realizar un programa que permita gestionar el saldo de una cuenta corriente. Una
        vez introducido el saldo inicial, se mostrará un menú que permitirá efectuar las
        siguientes operaciones:

        1. Hacer un reintegro, se pedirá la cantidad a retirar.
        2. Hacer un ingreso, se pedirá la cantidad a ingresar.
        3. Consultar el saldo y el número de reintegros e ingresos
        realizados.

        4. Finalizar las operaciones. Debe confirmar si realmente desea
        salir e informar del saldo al final de todas las operaciones.
        Debe realizarse una clase Cuenta y la clase Principal1.
*/
public class Principal {

    public static void main(String[] args) {

        Cuenta usuario1 = new Cuenta();
        usuario1.menu();

    }


}

