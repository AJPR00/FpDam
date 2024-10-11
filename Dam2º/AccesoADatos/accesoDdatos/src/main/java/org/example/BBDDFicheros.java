package org.example;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

public class BBDDFicheros {

    private final String NOM_FICHERO, CLAVE_PRIMARIA;
    private final Map<String, Integer> CAMPOS;  // String nombre de campo, Int tamaño de los campos.
    private int longReg;
    private long numReg, numRegMarcadoBorrado;

    public BBDDFicheros(String FICHERO, String CLAVE_PRIMARIA, Map<String, Integer> CAMPOS) throws IOException {
        this.NOM_FICHERO = FICHERO;
        this.CLAVE_PRIMARIA = CLAVE_PRIMARIA;
        this.CAMPOS = CAMPOS;
        this.numReg = 0;
        this.numRegMarcadoBorrado = 0;
        this.longReg = 0;

        //Calcula la longitud del fichero sumando la longitud en bytes de cada unos de ellos
        for (Map.Entry<String, Integer> campo : CAMPOS.entrySet()) {
            longReg += campo.getValue();
        }

        File f = new File(FICHERO);
        if (!f.createNewFile()) this.numReg = f.length();
    }

    public String getNOM_FICHERO() {
        return NOM_FICHERO;
    }

    public Map<String, Integer> getCAMPOS() {
        return CAMPOS;
    }

    public String getCLAVE_PRIMARIA() {
        return CLAVE_PRIMARIA;
    }

    public long getNumReg() {
        return numReg;
    }

    public int getLongReg() {
        return longReg;
    }

    public long getNumRegMarcadoBorrado() {
        return numRegMarcadoBorrado;
    }

   /* public Map<String,String> recuperar(String valorClave){
        int pos=0;
        boolean encontrado = false;
        Map<String,String> resultado;
        try (FileInputStream fis = new FileInputStream(this.NOM_FICHERO)){
            resultado= null;
            //Recorremos todos los registros mientras no hayamos encontrado una ocurrencia del valorClave
            while (pos < this.numReg && !encontrado){
                byte[] buffer = new byte[this.longReg];
                if (fis.read(buffer, 0, this.longReg) < this.numReg){
                    return null;
                }

                int offsetCampo =0;
                String unValorClave = null;
                for (Map.Entry<String,Integer> campo : CAMPOS.entrySet()){
                    String unCampo = campo.getKey();
                    int longCampo = campo.getValue();
                    if (unCampo.equals(valorClave)){
                        unValorClave= new String(buffer, offsetCampo, longCampo, StandardCharsets.UTF_8);
                        break;
                    }

                    offsetCampo += longCampo;

                    if (valorClave.equals(unValorClave)){
                        encontrado = true;
                        offsetCampo=0;
                        resultado= new HashMap<>();
                    }
                }
            }

        }catch (IOException e) {
            System.out.println("Error E/S "+e.getMessage());;
        }
    }*/

    public Map<String, String> recuperar(String valorClave) {
        int pos = 0;
        boolean encontrado = false;
        Map<String, String> result = null;
        try (FileInputStream fis = new FileInputStream(this.NOM_FICHERO)) {
            //recorremos todos los registros mientras no hayamos encotrado una ocurrencia del valorClave
            while (pos < this.numReg && !encontrado) {
                byte[] buffer = new byte[this.longReg];
                if (fis.read(buffer, 0, this.longReg) < this.longReg) {
                    return null;
                }

                int offsetCampo = 0;
                String unValorClave = null;
                for (Map.Entry<String, Integer> campo : CAMPOS.entrySet()) {
                    String unCampo = campo.getKey();
                    int longCampo = campo.getValue();
                    if (unCampo.equals(this.CLAVE_PRIMARIA)) {
                        unValorClave = new String(buffer, offsetCampo, longCampo, StandardCharsets.UTF_8);
                        break;
                    }
                    offsetCampo += longCampo;
                }
                if (valorClave.equals(unValorClave)) {//Para cada registro, comparamos si unValorClave recuperado del campo clave coincide con el que estamos buscando y hemos introducido como parámetro
                    encontrado = true;
                    offsetCampo = 0;
                    result = new HashMap<String, String>();
                    for (Map.Entry<String, Integer> campo : CAMPOS.entrySet()) {
                        String unCampo = campo.getKey();
                        int longCampo = campo.getValue();
                        String valorCampo = new String(buffer, offsetCampo, longCampo, StandardCharsets.UTF_8);
                        result.put(unCampo, valorCampo);
                        offsetCampo += longCampo;
                    }
                }
                pos++;
            }

        } catch (IOException io) {
            System.out.println("Error E/S: " + io.getMessage());
        } finally {
            return result;
        }

        /**
         * Insertar un nuevo registro en el fichero, siempre al final de éste.
         * @param reg Registro a insertar
         * @return posición en la que hemos insertado el registro o -1 en caso de que no se haya podido insertar
         * porque ya existe un registro que tiene el mismo valor en el campoclave
         * @throws IOException
         */


//    public boolean modificar(String valorClave, String nombreCampo, String valorCampo) throws  IOException{
//        if(nombreCampo.equals(this.campoClave)){
//            System.out.println("No se puede modificar el campo clave: " + nombreCampo);
//            return false;
//        }
//        int pos = 0;
//        boolean encontrado = false;
//        RandomAccessFile raf = new RandomAccessFile(this.nomFich, "rws");
//        while(pos < this.numReg && !encontrado){
//            byte buffer[] = new byte[this.longReg];
//            if (raf.read(buffer, 0, this.longReg) < this.longReg){
//                return false;
//            }
//            String unValorClave = recuperarValorCampoClave(buffer);
//
//            if(valorClave.equals(unValorClave)){
//                int offsetCampo = 0;
//                encontrado = true;
//                raf.seek(pos*longReg);
//                for(Map.Entry<String,Integer> campo: campos.entrySet()){
//                    String unCampo = campo.getKey();
//                    int longCampo = campo.getValue();
//                    if(nombreCampo.equals(unCampo)){
//                        raf.skipBytes(offsetCampo);
//                        String valorCampoForm = String.format("%1$-" + longCampo + "s", valorCampo);
//                        raf.write(valorCampoForm.getBytes("UTF-8"), 0, longCampo);
//                        break;
//                    }
//                    offsetCampo += longCampo;
//                }
//            }
//            pos++;
//        }
//        return encontrado;
//
//    }
    }

    public long insertar(HashMap<String, String> reg) throws IOException {
        String valorCampoClave = reg.get(this.CAMPOS);
        if (recuperar(valorCampoClave) != null) {//Comprobamos si ya existe un registro con el mismo valor para el campo clave que el queremos insertar (No está permitido)
            System.err.println("Clase primera existente -" + CLAVE_PRIMARIA);
            return -1;
        }


        try (FileOutputStream fos = new FileOutputStream(NOM_FICHERO, true)) {
            for (Map.Entry<String, Integer> campo : CAMPOS.entrySet()) {
                int longCampo = campo.getValue();
                String valorCampo = reg.get(campo.getKey());
                if (valorCampo == null) {
                    valorCampo = "";
                }

                String valorCampoForm = String.format("%1$-" + longCampo + "s", valorCampo); //devuelve el valor del 1er argumento en un String con longitud "longCampo" y alineado a la izquierda (gracias al uso de "-")
                fos.write(valorCampoForm.getBytes("UTF-8"), 0, longCampo);
            }
        } catch (IOException e) {
            System.out.println("Error de E/S: " + e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.numReg++;
        return this.numReg - 1;
    }
}


