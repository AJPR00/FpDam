//Escribe una función que reciba una lista de cadenas de texto List<String?>, 
//donde algunos elementos pueden ser null. 
//La función debe retornar una nueva lista con todos los elementos no nulos. 
//Si todos los elementos son null, debe retornar una lista con el texto ['No hay datos'].

List<String> filtrarLista(List<String?> lista) {
  List<String> listaFiltrada = [];
  /*
  for (var cadena in lista) {
    if (cadena != null) {
      listaFiltrada.add(cadena);
    }
  }
  */
  //MODO B:
  listaFiltrada = lista.where((str) => str?.isNotEmpty ?? false).cast<String>().toList();
  //listaFiltrada = lista.where((str) => str != null).cast<String>().toList();

  return listaFiltrada.isEmpty ? ['No hay datos'] : listaFiltrada;
}

void main() {
  print(filtrarLista(['Hola', null, 'Mundo']));
  //Output: ['Hola', 'Mundo']
  print(filtrarLista([null, null]));
  //Output: ['No hay Datos']
}