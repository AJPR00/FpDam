package Tema5_ConceptoAvanzadosOPP.boletin5_1.ejerc3;


import java.util.Comparator;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    private static final Scanner sc = new Scanner(System.in);
    //Todo falta tratar las excepciones.
    private static final int NUM_PERSONAJES = 100;
    private static int posArray = 0;
    private static final Personaje[] arrayPersonajes = new Personaje[NUM_PERSONAJES];

    public static void main(String[] args) throws PersonajeException {
        while (true) {
            arrayPersonajes[0] = new Mago("Reinaldo", TRaza.HUMANO, 10, 18, 60);
            arrayPersonajes[3] = new Mago("Anglor", TRaza.ORCO, 10, 18, 60);
            arrayPersonajes[1] = new Mago("Zafiro", TRaza.ENANO, 4, 20, 80);
            arrayPersonajes[2] = new Clerigo("Recio", TRaza.ELFO, 2, 6, 55, "Esfera");
            menuOpciones();
            menuLogica();
        }


    }

       /* Mago magoA = new Mago("Reinaldo", TRaza.HUMANO, 10, 18, 60);
        Mago magoB = new Mago("Zafiro", TRaza.ENANO, 4, 20, 80);
        Clerigo clerigoA = new Clerigo("Recio", TRaza.ELFO, 2, 6, 55, "Esfera");

        System.out.println(magoA.toString());
        System.out.println(magoB.toString());
        System.out.println(clerigoA.toString());
        try {
            magoA.aprendeHechizo("Aparecium");
            magoA.aprendeHechizo("Leviosa");
            // magoB.aprendeHechizo("Aqua Vortex");
            System.out.println(magoA.toString());
            System.out.println(magoB.toString());

            magoA.lanzaHechizo(magoB, "Aparecium");
            magoB.lanzaHechizo(magoA, "Aqua Vortex");

            clerigoA.curar(magoB);

            magoA.lanzaHechizo(magoB, "Leviosa");

            System.out.println(magoA.toString());
            System.out.println(magoB.toString());
            System.out.println(clerigoA.toString());


            magoA.setFuerza(50);
        } catch (PersonajeException e) {
            System.out.println(e.getMessage());
        }

        menu();
*/

    private static void menuLogica() {
        boolean repetir = false;
        int opcMenuPrincipal;
        try {
            if (!sc.hasNextInt()) { // si no es un dígito lanza la excepción
                throw new PersonajeException("Introduzca un dígito");
            }
        } catch (PersonajeException e) { // captura la excepción y ejecuta el contenido.
            sc.next(); // se come el espacio del .NexInt()
            System.out.println(e.getMessage());
            menuLogica();
        }
        if (sc.hasNextInt()) {
            opcMenuPrincipal = sc.nextInt();
            switch (opcMenuPrincipal) {
                case 1:
                    altaPersonaje();
                    break;
                case 2:
                    boolean salir2 = false;
                    do {
                        System.out.println("Seleccione el Mago a enseñar el hechizo");
                        int selecMago;
                    /*for (Personaje magoDisponibles : arrayPersonajes) {
                        //Pregunto mediante instanceof si madoDisponible es un Mago
                        if (magoDisponibles instanceof Mago){
                            System.out.println(magoDisponibles);
                        }
                    }*/
                        System.out.println("#id");
                        int contador = 0;
                        for (int i = 0; i < arrayPersonajes.length; i++) {

                            if (arrayPersonajes[i] instanceof Mago) {
                                System.out.println((i + 1) + ". " + arrayPersonajes[i].getNombre());
                                contador++;
                            }
                        }
                        if (contador == 0) {
                            System.out.println("Magos no disponibles");
                        }
                        if (sc.hasNextInt()) {
                            selecMago = sc.nextInt();
                            sc.nextLine();
                            System.out.println("Dime el hechizo a enseñar");
                            String selecHechizo = sc.nextLine().toUpperCase();
                            try {
                                ((Mago) arrayPersonajes[selecMago - 1]).aprendeHechizo(selecHechizo);
                            } catch (PersonajeException e) {
                                System.out.println(e.getMessage());
                            }
                        } else {
                            System.out.println("Introduzca un dígito");
                        }
                        salir2 = true;
                    } while (!salir2);
                    break;

                case 3:
                    /*Mago lanza hechizo: Se solicitará el nombre del Mago y el nombre
                    del Personaje al que quiere lanzar un hechizo. Debe controlarse
                    que no puede lanzarse un hechizo a él mismo. Si al lanzar el
                    hechizo, el personaje se queda con menos de cero puntos, el
                    personaje muere pero no se eliminará.*/
                    boolean salir3 = false;
                    int selecMagoLanzador;
                    do {
                        System.out.println("Seleccione el Mago a lanzar el hechizo");

                    /*for (Personaje magoDisponibles : arrayPersonajes) {
                        //Pregunto mediante instanceof si madoDisponible es un Mago
                        if (magoDisponibles instanceof Mago){
                            System.out.println(magoDisponibles);
                        }
                    }*/
                        System.out.println("#id");
                        int contador = 0;
                        for (int i = 0; i < arrayPersonajes.length; i++) {
                            if (arrayPersonajes[i] instanceof Mago) {
                                System.out.println((i + 1) + ". " + arrayPersonajes[i].getNombre());
                                contador++;
                            }
                        }
                        //Si contador contiene = 0, es que no ha encontrado ningún MAGO
                        if (contador == 0) {
                            System.out.println("No hay Magos disponibles");
                        }


                        //Todo escoger a quien lanzar
                        if (sc.hasNextInt()) {
                            selecMagoLanzador = sc.nextInt();

                            System.out.println("Ahora dime a quien quieres joder!");
                            for (int i = 0; i < arrayPersonajes.length; i++) {
                                if (arrayPersonajes[i].getVidaActual() > 0) {
                                    System.out.println((i + 1) + ". " + arrayPersonajes[i].getClass().getSimpleName() + ": " + arrayPersonajes[i].getNombre());
                                }
                                contador++;
                            }
                            if (contador == 0) {
                                System.out.println("Están todos muertos");
                            }

                            if (sc.hasNextInt()) {
                                contador = 0;
                                int selecJoder = sc.nextInt();
                                sc.nextLine();
                                System.out.println("Que hechizo vas a lanzar");
                                String hechizoLanzar = sc.nextLine().toUpperCase();

                                try {
                                    ((Mago) arrayPersonajes[selecMagoLanzador - 1]).lanzaHechizo(arrayPersonajes[selecJoder - 1], hechizoLanzar);
                                } catch (PersonajeException e) {
                                    System.out.println(e.getMessage());
                                }
                            } else {
                                System.out.println("Introduzca un dígito");
                            }
                        }
                        salir3 = true;
                    } while (!salir3);

                    break;
                case 4:
                  /*  4. Clérigo cura al mago: Se solicitará el nombre del Clérigo y el
                    nombre del Mago al que quiere curar, y se curará. Un Clérigo
                    puede curar a un Personaje que ya está muerto*/
                    boolean salir4 = false;
                    do {
                        System.out.println("Seleccione un Clérigo");

                    /*for (Personaje magoDisponibles : arrayPersonajes) {
                        //Pregunto mediante instanceof si madoDisponible es un Mago
                        if (magoDisponibles instanceof Mago){
                            System.out.println(magoDisponibles);
                        }
                    }*/
                        System.out.println("#id");
                        int contador = 0;
                        for (int i = 0; i < arrayPersonajes.length; i++) {
                            if (arrayPersonajes[i] instanceof Clerigo) {
                                System.out.println((i + 1) + ". " + arrayPersonajes[i].getNombre());
                                contador++;
                            }
                        }
                        //Si contador contiene = 0, es que no ha encontrado ningún MAGO
                        if (contador == 0) {
                            System.out.println("No hay Clérigo disponibles");
                        }

                        if (sc.hasNextInt()) {
                            int selecClerigo = sc.nextInt();

                            System.out.println("Ahora dime a quien quieres sanar");
                            for (int i = 0; i < arrayPersonajes.length; i++) {
                                System.out.println((i + 1) + ". " + arrayPersonajes[i]);
                            }
                        }

                        if (sc.hasNextInt()) {
                            contador = 0;
                            int selecSanar = sc.nextInt();
                            try {
                                ((Clerigo) arrayPersonajes[selecSanar - 1]).curar(arrayPersonajes[selecSanar - 1]);
                            } catch (PersonajeException e) {
                                System.out.println(e.getMessage());
                            }
                        } else {
                            System.out.println("Introduzca un dígito");
                        }

                        salir4 = true;
                    } while (!salir4);
                    break;
                case 5:
                    mostrarListadoPersonajes();
                    break;
                case 6:
                    /*Mostrar el listado de personajes ordenados por puntos
                    actuales de mayor a menor*/
                    mostrarListadoPersonajesOrdenados(arrayPersonajes);

                    break;
                case 7:
                    // Finaliza el el flujo de ejecución,status se refiere al estado en que finaliza el programa, 0 es igual a perfec.
                    System.exit(0);


                    /*try {
                        System.out.println("¿Quieres añadir otro personaje, S o N?");
                        char sN = Character.toUpperCase(sc.next().charAt(0));

                        if (sN != 'S' && sN != 'N') {
                            throw new PersonajeException("Has introducido un valor erróneo");
                        }
                        if (sN == 'S') {
                            System.out.println("S");
                            menuLogica();
                        } else {
                            System.out.println("Gracias por jugar");
                        }
                    } catch (PersonajeException e) {
                        System.out.println(e.getMessage());
                        menuLogica();
                    }*/

                    break;

                default:
                    try {
                        throw new PersonajeException("Introduzca una opción valida, 1 al 7");
                    } catch (PersonajeException e) {
                        System.out.println(e.getMessage());
                    }
            }
        }

    }

    private static void menuOpciones() {

        System.out.print("""                                
                Selecciones una acción: 
                                               
                1. Alta de personaje.
                2. Mago aprender hechizo.
                3. Mago lanza hechizo.
                4. Clérigo cura al maho.
                5. Mostrar listado de personajes.
                6. Mostrar listado de personajes ordenados por puntos actuales de mayor a menor.
                7. Salir.
                """);

    }

    private static void altaPersonaje() {

        for (int i = posArray; i < arrayPersonajes.length; i++) {
            System.out.print("""                                
                    Cual quieres crear:                        
                    1. Mago.
                    2. Clérigo.
                    """);
            try {
                if (!sc.hasNextInt()) { // si no es un dígito lanza la excepción
                    throw new PersonajeException("Introduzca un dígito");
                }
            } catch (PersonajeException e) { // captura la excepción y ejecuta el contenido.
                sc.next(); // se come el espacio del .NexInt()
                System.out.println(e.getMessage());
                altaPersonaje();
            }
            int opc = sc.nextInt();
            try {
                if (opc < 1 || opc > 2) {
                    throw new PersonajeException("Introduzca un valor 1 o 2");
                }
            } catch (PersonajeException e) {
                System.out.println(e.getMessage());
                altaPersonaje();
            }
            String tipoPersonaje = null;
            boolean exit = false;
            if (opc == 1) {
                arrayPersonajes[i] = new Mago();
                tipoPersonaje = "mago";
            }
            if (opc == 2) {
                arrayPersonajes[i] = new Clerigo();
                tipoPersonaje = "clérido";
            }
            sc.nextLine();
            System.out.printf("Dime el nombre de tu %s: ", tipoPersonaje);
            arrayPersonajes[i].setNombre(sc.nextLine().toUpperCase());
            if (opc == 2) {
                System.out.println("Dime el Dios adorar:");
                ((Clerigo) arrayPersonajes[i]).setNombreDios(sc.nextLine().toUpperCase());
            }
            // Converte la clase TRaza en una array.
            TRaza[] arrayTraza = TRaza.values();
            do {
                exit = false;
                System.out.printf("A que raza pertenece tu %s: \n", tipoPersonaje);
                for (int j = 0; j < arrayTraza.length; j++) {
                    System.out.println("# " + arrayTraza[j]);
                }
                try {
                    //TRaza.valueOf("devuelve valor que quiere de la enum")
                    arrayPersonajes[i].setRaza(TRaza.valueOf(sc.nextLine().toUpperCase()));
                } catch (Exception e) {
                    exit = true;
                    System.out.println("Raza no encontrada");
                }
            } while (exit);
            do {
                exit = false;
                System.out.print("Dime el índice de fuerza del " + tipoPersonaje + " " + arrayPersonajes[i].getNombre() + ":");
                try {
                    arrayPersonajes[i].setFuerza(sc.nextInt());
                } catch (PersonajeException e) {
                    exit = true;
                    System.out.println(e.getMessage());
                }
            } while (exit);
            do {
                exit = false;
                System.out.print("Dime el índice de inteligencia del " + tipoPersonaje + " " + arrayPersonajes[i].getNombre() + ": ");
                try {
                    arrayPersonajes[i].setInteligencia(sc.nextInt());
                } catch (PersonajeException e) {
                    exit = true;
                    System.out.println(e.getMessage());
                }
            } while (exit);
            try {
                arrayPersonajes[i].setVidaMaxima(Personaje.VIDA_MAXIMA);
                arrayPersonajes[i].setVidaActual(Personaje.VIDA_MAXIMA);
            } catch (PersonajeException e) {
                System.out.println(e.getMessage());
            }
            posArray++;
            sc.nextLine();
            break;
        }
    }

    private static void mostrarListadoPersonajes() {
        for (Personaje personaje : arrayPersonajes) {
            if (personaje != null) {
                System.out.println("# " + personaje.getClass().getSimpleName() + " " + personaje.getNombre());
            }
        }
    }

    private static void mostrarListadoPersonajesOrdenados(Personaje[] arrayPersonajes) {

       Arrays.sort(arrayPersonajes, Comparator.comparing(Personaje::getVidaActual));
       for (Personaje perOrde : arrayPersonajes ){
           System.out.println(perOrde.getNombre());
       }

    }

}
