//Escribe una función que reciba dos parámetros, ambos opcionales y de tipo int?. 
//La función debe retornar la suma de los valores no nulos. 
//Si ambos son null, debe retornar 0.

int suma([int? a, int? b]) {
  /*if (a == null) {
    a = b;
  } else {
    a += b ?? 0;
  }

  return a ?? 0;*/

  return (a ?? 0) + (b ?? 0);
}

void main() {
  print(suma(5, null));  // Output: 5
  print(suma(null, 10)); // Output: 10
  print(suma(null, null)); // Output: 0
  print(suma(2, 3)); // Output: 5
  print(suma(2)); // Output: 2
  print(suma(3)); // Output: 3
  print(suma()); // Output: 0
}