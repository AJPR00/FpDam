//Escribe una clase Producto que tenga un nombre (String) y un precio (double?).
//Luego, crea una función que reciba una lista de productos y
//devuelva el nombre del producto más caro.
//Si algún producto tiene un precio null, ignóralo.
//Si todos los precios son null, la función debe
//retornar el mensaje 'No hay productos válidos'.

import 'dart:ffi';

class Producto {
  String nombre;
  double? precio;

  Producto(this.nombre, this.precio);
}

String? productoMasCaro(List<Producto> productos) {
  /*String? nombreProducto;
  for (var producto in productos) {
    
  }*/

  productos.sort((a, b) => ((a.precio ?? -1) > (b.precio ?? -1)) ? 1 : -1);
  print(productos.map();
  return 'ad';
}

void main() {
  List<Producto> productos = [
    Producto('Televisor', 50),
    Producto('Celular', null),
    Producto('Laptop', 1000),
    Producto('Tablet', null)
  ];
  print(productoMasCaro(productos));
  // Output: Laptop
}
