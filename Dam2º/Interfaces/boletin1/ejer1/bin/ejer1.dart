import 'dart:ffi';

import 'package:ejer1/ejer1.dart' as ejer1;

void main(List<String> arguments) {
  print("Ejercicio 1");
  print(suma(5, null));
  print(suma(null, 10));
  print(suma(null, null));
  print(suma(2, 3));
   print(" ");

   print("Ejercicio 2");
   Map<String,double?> productos={
    "Manzanas":2.5,
    "Bananas":null,
    "Naranjas":1.2,
    "Peras":null,
    "Fresas":3.0,
   };
   print(sumaPrecios(productos));
  print(" ");

   print("Ejercicio 3");
print(filtrarLista(["Hola",null,"mundo"]));
print(filtrarLista([null,null,]));

    print(" ");
   print("Ejercicio 4");

   Persona p1 = Persona("Carlos", 25);
   p1.presentacio();
   Persona p2 = Persona("Ana");
   p2.presentacio();
   
    print(" ");
   print("Ejercicio 5");
List<int> lista =[10,20,30,40];
print(obtenerResultado(lista,30 ));
print(obtenerResultado(lista,50 ));

    print(" ");
   print("Ejercicio 6");

   List<Producto> productoss = [
    Producto("TV", 500),
    Producto("Celular", null),
    Producto("Laptop", 1000),
    Producto("Tablet", null),
   ];
   print(productoMasCaro(productoss));

}










// Ejercicio 1
 int? suma(int? a , int? b){  
  return (a ?? 0) + (b ?? 0); // ?? si la entrada de algun número es nula, este se establece a 0.
 }

 // Ejercicio 2 
double? sumaPrecios(Map<String, double?> productos){
  double total=0;
  for (var key in productos.keys) {    
    total+=productos[key] ?? 0;    
  }
  return total;
}
 
 // Ejercicio 3
 List<String> filtrarLista(List<String?> lista){
List<String> listSinNulo=[];

  for (var src in lista) {
    if(src!=null) listSinNulo.add(src);
  }
return listSinNulo.isEmpty ? ["No hay datos"] : listSinNulo;
}

 // Ejercicio 4
class Persona{
  String nombre;
  int? edad;

  Persona(this.nombre, [this.edad]);

  void presentacio(){
  String mensaje = edad ==null ? "no he proporcionado mi edad." : " mi edad es $edad.";
  print("Me llamo $nombre y $mensaje");
}
}


 // Ejercicio 5
 // OJO, en cuanto encuentre solo una coicidencia se sale de la funcion.

 int? buscarElemento(List<int> lista, int numero){    
  for (var element=0 ; element < lista.length ; element++) { 
      if(lista[element]==numero) return element;
      }
      return null;
 }

 String obtenerResultado(List<int> lista, int numero){
  
  int? indiceEncontrado = buscarElemento(lista, numero);
  String? encontrado;

  if(indiceEncontrado!=null) encontrado= "el número está en el índice $indiceEncontrado.";
      return encontrado?? "Elemento no encontrado.";

 }

 // Ejercicio 6
 class Producto{
  String nombre;
  double? precio;

  Producto(this.nombre, this.precio);


}

 String? productoMasCaro(List<Producto> producto){
    List<Producto>productosConPrecio=producto.where((p)=> p.precio != null).toList();
    Producto productoAux =Producto("null", -1);


if(productosConPrecio.isNotEmpty){
    for (var pro in productosConPrecio) {
      if(pro.precio!>productoAux.precio!) productoAux=pro;     
    }
    }
    
    return productoAux.nombre?? "No hay Producots válidos";
       
  }
  
 

