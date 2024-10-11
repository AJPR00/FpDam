package Tema3_IntroPOOyString.boletin4_2.ejer2;

import Tema3_IntroPOOyString.boletin4_3.Mensajeria.NoCompatibleCpuPlacaException;

import java.net.Socket;

public class Ordenador {

    private PlacaBase placaBase;
    private Procesador procesador;
    private TarjetaGrafica tarjetaGrafica;
    private DiscoDuro discoDuro;


    public Ordenador(PlacaBase placaBase, Procesador procesador, TarjetaGrafica tarjetaGrafica, DiscoDuro discoDuro) {

        //

        if (!placaBase.compatibilidadCpu(procesador)) {

            throw new NoCompatibleCpuPlacaException();
        } else {

            this.placaBase = placaBase;
            this.procesador = procesador;
            this.tarjetaGrafica = tarjetaGrafica;
            this.discoDuro = discoDuro;
        }


    }

    public Procesador getProcesador() {
        return procesador;
    }

    public static void main(String[] args) {

        PlacaBase _AsusIntelLga800 = new PlacaBase("ASUS", "Intel", "LGA1200");
        Procesador _CpuInteli7 = new Procesador("Intel", "i7", "LGA1200", 3, 8);
        DiscoDuro _Hdd1TbSeagate = new DiscoDuro("Seagate", "HD", 1000);
        TarjetaGrafica _NvidiaGtx1660 = new TarjetaGrafica("NVIDIA", "GTX 1660", 6, 1, 8);
        try {
            Ordenador riperIV = new Ordenador(_AsusIntelLga800, _CpuInteli7, _NvidiaGtx1660, _Hdd1TbSeagate);
            System.out.print("Caracteristicas del PC" + riperIV.toString());

        } catch (NoCompatibleCpuPlacaException noCompatible) {

            System.out.println("Cpu no compatible");

        }




    }

    @Override
    public String toString() {
        return "Ordenador:\n" +
                "PlacaBase: " + placaBase +
                "\nProcesador: " + procesador +
                "\nTarjetaGrafica: " + tarjetaGrafica +
                "\nDiscoDuro: " + discoDuro;

    }
}
