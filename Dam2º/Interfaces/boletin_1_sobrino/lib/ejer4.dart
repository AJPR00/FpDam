//Implementa una clase llamada Persona con las siguientes características:

//Tiene dos atributos: nombre de tipo String (no puede ser nulo) y 
//edad de tipo int? (puede ser nulo).
//Define un constructor que acepte un nombre no nulo y una edad opcional.
//Crea un método llamado presentacion() que imprima un mensaje 
//presentando el nombre y, si existe, la edad. 
//Si la edad es nula, el mensaje debe indicar que la edad no fue proporcionada.

class Persona {
  String nombre;
  int? edad;

  //Completa el constructor y el método
  Persona(this.nombre, [this.edad]);

  void presentacion() {
    String mensajeEdad = edad == null ? "no he proporcionado mi edad" : "tengo $edad edad";
    print("Me llamo $nombre y $mensajeEdad");
  }
}

void main() {
  Persona p1 = Persona('Carlos', 25);
  p1.presentacion();
  //Output: Me llamo Carlos y tengo 25 años.

  Persona p2 = Persona('Ana');
  p2.presentacion();
  //Output: Me llamo Ana y no he proporcionado mi edad.
}