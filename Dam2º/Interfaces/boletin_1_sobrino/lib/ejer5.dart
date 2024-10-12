//Escribe una función llamada buscarElemento que reciba una lista de enteros List<int> y 
//un número int que quiere buscar en la lista. Si el número está en la lista, 
//la función debe devolver su índice. Si no está, debe devolver null. 
//Luego, implementa otra función llamada obtenerResultado, 
//que use el operador ?? para devolver el índice o
//el mensaje 'Elemento no encontrado' si el resultado de buscarElemento es null.


int? buscarElemento(List<int> lista, int numero) {
  int index = lista.indexOf(numero);
  return index == -1 ? null : index;
}

String obtenerResultado(List<int> lista, int numero) {
  int? index = buscarElemento(lista, numero);
  String result = index?.toString() ?? 'Elemento no encontrado';

  return int.tryParse(result) == null ? result : 'El número está en el índice $result';

  //Kotlin?
  //return buscarElemento(lista, numero)?.let((index) => 'El número está en el índice $index') ?? 'Elemento no encontrado';
}

void main() {
  List<int> lista = [10, 20, 30, 40];
  print(obtenerResultado(lista, 30));
  //Output: El número está en el índice 2
  print(obtenerResultado(lista, 50));
  //Output: Elemento no encontrado
}