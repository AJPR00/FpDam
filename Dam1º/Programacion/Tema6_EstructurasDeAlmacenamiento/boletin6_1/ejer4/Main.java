package ejer4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

public class Main {
/*
    Ejercicio 4
    Crear un método genérico reverse que devuelva un ArrayList de objetos con la misma
    información, pero en orden inverso, es decir donde en la primera posición esté la
    información del último objeto, en la segunda la penúltima y así sucesivamente.
    private static <T> ArrayList<T> reverse ( ArrayList<T> arrayOriginal)*/


    public static void main(String[] args) {

        ArrayList<Integer> arrayListInt = new ArrayList<>();
        arrayListInt.add(1);
        arrayListInt.add(2);
        arrayListInt.add(3);
        arrayListInt.add(4);
        arrayListInt.add(5);

        reverse(arrayListInt).stream().forEach(i -> System.out.println(i));

    }

    private static <T> ArrayList<T> reverse(ArrayList<T> arrayOriginal) {
        ArrayList<T> arrayList0 = new ArrayList<T>(arrayOriginal.size());
        Iterator<T> it = arrayOriginal.iterator();
        int con = 0;

        while (it.hasNext()) {
            arrayList0.set(arrayOriginal.size() - 1 -con, it.next());
            con++;
                }
        return arrayList0;
    }


}
