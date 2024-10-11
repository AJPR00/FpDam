
package practicaMemoria;

import java.util.Scanner;

public class PrincipalAlumnos {

    public static final int TAM = 4;
    public static final int INTENTOS = 1;

    public static final char OCULTO = '#';
    public static final char LETRA_INICIO = 'A';
    //public static final char LETRA_FINAL = 'A' + ((TAM * TAM) / 2 - 1);

    public static int live = INTENTOS;

    //Variable para almacenar la conversión a int desde la variable input.
    public static int selec1Fila;
    public static int selec1Colum;
    public static int selec2Fila;
    public static int selec2Colum;


    //Variables que controla la salida correcta de cada petición de las dos coordenadas
    public static boolean exitCoordenada1 = false;
    public static boolean exitCoordenada2 = true;


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
/*
        matrizVisible es una matriz de booleanos que nos servirá para saber si una celda está visible u oculta.
        Por defecto, todas las celdas estarán ocultas, por lo que inicializamos la matriz a false.
         */
        boolean[][] matrizVisible = new boolean[TAM][TAM];
        char[][] matriz = new char[TAM][TAM];               // Creamos la MATRIZ char para albergar las letras a veriguar.

        ocultarTodaLaMatriz(matrizVisible);

        /*
         * La estrategia que seguiremos será la siguiente: Rellenaremos la matriz con los valores de la A a la letra final
         * (que vendrá determinada por A + TAM * TAM / 2) dos veces. Una vez rellenada la matriz, la recorreremos y cambiaremos
         * su valor por otra celda de la matriz obtenida aleatoriamente.
         */

        fillMatrix(matriz);
        randomizeMatrix(matriz);

        printVisibleMatrix(matriz, matrizVisible);
        printMatrix(matriz);
        // TODO: Aplicar la lógica descrita del juego


        String input; //Variables de tipo String para verificar con .matches la entrada desde el teclado.
        boolean exit = false; // Variable verifica que las salidad de do-while es numerico en cada dígito de la coordenada.


        do {
            do {
                exitCoordenada1 = false;// reseteo la variable a false para que en caso de repetición del bucle, por casilla ya levantada.

                // HORIZONTAL, verificar entrada1.

                do { // do-while que controla que se introduzca un dígito númerico.

                    // Mensaje en pantalla mediante System.out para solicitar coordenadas.
                    System.out.print("\n\nPara ello introduce la primera cordenada a levantar." + "\nPrimero la horizontal (X):");
                    input = sc.next(); // Solicita la entrada por teclado y guarda la entrada en variable.

                    if (input.matches("\\d")) { //.matches analiza si input contiene díguitos númericos dando false o true.
                        selec1Fila = Integer.parseInt(input); // Si es true en selecFila1 guarda el contenido de input como un entero.

                        // if que pregunta si selecFila1 contiene numero de 0 al tamaño de fila de la arraiz, si es asi almacena true en la variable exit que nos permite salir del do-while
                        if (selec1Fila < matrizVisible.length && selec1Fila >= 0) {
                            exit = true;
                        } else {
                            System.out.println("Erro, introduzca dentro del rango."); // Si no esta dentro del rango muestra el sigueiente error.
                        }
                    } else {
                        System.out.println("Error, solo díguitos númericos");
                    }

                } while (!exit);

//VERTICAL, verificar entrada1.
                do {
                    System.out.print("Segundo la vertical (Y):");
                    input = sc.next();
                    if (input.matches("\\d")) { //.matches analiza si selecColum contiene díguitos númericos dando false o true.
                        selec1Colum = Integer.parseInt(input);
                        if (selec1Colum < matrizVisible.length && selec1Colum >= 0) {
                            exit = false;
                        } else {
                            System.out.println("Erro, introduzca dentro del rango.");
                        }
                    } else {
                        System.out.println("Error, solo díguitos númericos");
                    }

                } while (exit);

                //if que devuelve si las corrdenadas estan oculta o no.
                // Si la coordenada esta es true( está levantada)  devuelve un erro y almacena en exirCoordenada1,true, que obliga al bucle do-while repetirse.

                if (matrizVisible[selec1Fila][selec1Colum]) {
                    System.out.println("Error, casilla levantada introduzca nueva cooordenada!");
                    exitCoordenada1 = true;
                    //Si es falso las coordenadas guarda un true en la Matrix booleana. dando entender que se ha levantado.
                } else {
                    matrizVisible[selec1Fila][selec1Colum] = true;
                }

            } while (exitCoordenada1);

            printVisibleMatrix(matriz, matrizVisible);
            printMatrix(matriz);

            //HORIZONTAL,VERIFICAR ENTRADA2
            exit = true;
            do {
                //exitVertical2 = true;// reseteo la variable a false para que en caso de repetición del bucle, por casilla ya levantada.


                do {
                    System.out.print("\n\n Introduce la segunda  cordenada a levantar." + "\nPrimero la horizontal (X):");
                    input = sc.next();

                    if (input.matches("\\d")) { //.matches analiza si selecColum contiene díguitos númericos dando false o true.
                        selec2Fila = Integer.parseInt(input);

                        if (selec2Fila < matrizVisible.length && selec2Fila >= 0) {
                            exit = false;
                        } else {
                            System.out.println("Erro, introduzca dentro del rango.");

                        }


                    } else {
                        System.out.println("Error, solo díguitos númericos");
                    }

                } while (exit);

//VERTICAL, verificar entrada2.
                exit = true;
                do {
                    System.out.print("Segundo la vertical (Y):");
                    input = sc.next();
                    if (input.matches("\\d")) { //.matches analiza si selecColum contiene díguitos númericos dando false o true.
                        selec2Colum = Integer.parseInt(input);
                        if (selec2Colum < matrizVisible.length && selec2Colum >= 0) {
                            exit = false;
                        } else {
                            System.out.println("Erro, introduzca dentro del rango.");
                        }
                    } else {
                        System.out.println("Error, solo díguitos númericos");
                    }
                } while (exit);

                // Movimientos  del juego

                if (matrizVisible[selec2Fila][selec2Colum]) {
                    System.out.println("Error, casilla levantada introduzca nueva cooordenada!");
                } else {
                    matrizVisible[selec2Fila][selec2Colum] = true;
//if que compara las dos coordendas, si son iguales  muestra un mensaje de "Has acertado", si no es acertado y devuelve un false pasa a else que este pone a false las dos coordenadas comparadas
                    if (matriz[selec2Fila][selec2Colum] == matriz[selec1Fila][selec1Colum]) {
                        System.out.println("Has acertado!\n------------------------------------------------");

                    } else {
                        printVisibleMatrix(matriz, matrizVisible);

                        matrizVisible[selec2Fila][selec2Colum] = false;
                        matrizVisible[selec1Fila][selec1Colum] = false;

                        //En caso de no acierto devuelve el mensaje y le resta vida al jugador
                        System.out.println("\nLo siento, intentalo de nuevo.\n------------------------------------------------");
                        live--;
                    }
                    exitCoordenada2 = false;
                }
            } while (exitCoordenada2);

            printVisibleMatrix(matriz, matrizVisible);

        } while (live > 0 && checkFinished(matrizVisible));

        sc.close(); // Cerramos el teclado

        if (checkFinished(matrizVisible)) {
            System.out.println("¡Enhorabuena! Has ganado");
        } else {
            System.out.println("\n¡Vaya! Has perdido. Vuelve a jugar otra vez.");
        }


    }

    /**
     * Imprime la matriz por pantalla
     *
     * @param matriz
     */
    private static void printMatrix(char[][] matriz) {

        System.out.println("\n                  MEMORAMA");
        System.out.println("            \"Encuentra su pareja\" ");
        System.out.print("                      PLANTILLA!!!\n\n");
        //
        //Para visualizar la Matriz atraves de un for.
        System.out.print("              X|Y 0   1   2   3");
        for (int i = 0; i < matriz.length; i++) {

            System.out.print("\n" + "              " + i);

            for (int j = 0; j < matriz[i].length; j++) {
                System.out.print("   " + matriz[i][j]);
            }
        }
    }

    /**
     * Imprime la matriz visible por pantalla, mostrando las celdas ocultas con el valor de la constante OCULTO
     *
     * @param matriz
     * @param matrizVisible
     */
    private static void printVisibleMatrix(char[][] matriz, boolean[][] matrizVisible) {

        System.out.println("\n                  MEMORAMA");
        System.out.println("            \"Encuentra su pareja\"");
        System.out.printf("             Te queda %d intento \n\n", live);
        //
        //Para visualizar la Matriz atraves de un for.
        System.out.print("              X|Y 0   1   2   3");
        for (int i = 0; i < matriz.length; i++) {
            System.out.print("\n" + "              " + i);
            for (int j = 0; j < matriz[i].length; j++) {
                if (matrizVisible[i][j]) {
                    System.out.print("   " + matriz[i][j]);
                } else {
                    System.out.print("   " + OCULTO);
                }
            }
        }
        System.out.println(); // Nueva línea para imprimir la siguiente fila
    }


    /**
     * Rellena la matriz con los valores de la A a la letra final (que vendrá determinada por A + TAM * TAM / 2) dos veces
     *
     * @param matriz
     */
    public static void fillMatrix(char[][] matriz) {

// for recorre la Matriz asignando una letra y cada j impar se suma una a la variable letra que es la que propociona la nueva letra
        char letra = LETRA_INICIO;

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz.length; j++) {
                matriz[i][j] = letra;
                if (j % 2 != 0) {
                    letra++;
                }
            }
        }
    }

    /**
     * Desordena la matriz
     *
     * @param matriz
     */
    private static void randomizeMatrix(char[][] matriz) {
        // Una vez rellena la matriz, la desordenamos

        char temBox;
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz.length; j++) {

                int rowRandom = (int) (Math.random() * matriz.length - 1);
                int columnRandom = (int) (Math.random() * matriz.length - 1);
                temBox = matriz[i][j];
                matriz[i][j] = matriz[rowRandom][columnRandom];
                matriz[rowRandom][columnRandom] = temBox;
            }
        }
    }

    /**
     * Hace que todas las celdas de la matriz sean false (ocultas)
     *
     * @param matrizVisible
     */
    private static void ocultarTodaLaMatriz(boolean[][] matrizVisible) {

        for (int i = 0; i < matrizVisible.length; i++) {
            for (int j = 0; j < matrizVisible[i].length; j++) {
                matrizVisible[i][j] = false;
            }
        }
    }

    /**
     * Comprueba si todas las celdas de la matriz son true (visibles)
     *
     * @param matrizVisible
     * @return
     */
    private static boolean checkFinished(boolean[][] matrizVisible) {

        boolean allTrue = true;


        for (int i = 0; i < matrizVisible.length && allTrue; i++) {
            for (int j = 0; j < matrizVisible.length && allTrue; j++) {
                if (!matrizVisible[i][j]) {
                    allTrue = false;
                }
            }
        }


        return allTrue;
    }

}

