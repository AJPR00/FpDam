
//Tienes un mapa de datos que contiene la información de varios productos. 
//Implementa una función que reciba un Map<String, double?> 
//donde las claves son los nombres de los productos y los valores son sus precios. 
//Algunos precios pueden ser null. 
//La función debe retornar la suma de los precios que no son nulos.

//Nota: Usa el operador ! para asegurar que los precios no nulos sean correctamente procesados.


double sumaPrecios(Map<String, double?> productos) {
  //return productos.values.nonNulls.reduce((a, b) => a + b);

  /*
  Map<String, double?> cloneProductos = {};
  cloneProductos.addEntries(productos.entries);

  for (var entry in cloneProductos.entries) {
    if (entry.value == null) {
      cloneProductos.update(entry.key, (value) => 0);
    }
  }

  return cloneProductos.values.reduce((a, b) => a! + b!)!;
  */

  //Otra manera:  
  List<double?> cloneProductosValues = [];
  for (var value in productos.values) {
    cloneProductosValues.add(value ?? 0);
  }

  return cloneProductosValues.reduce((a, b) => a! + b!)!;
}

void main() {
  Map<String, double?> productos = {
    'Manzana': 2.5,
    'Banana': null,
    'Naranja': 1.2,
    'Pera': null,
    'Fresa': 3.0
  };
  print(sumaPrecios(productos)); // Output:6.7
}
