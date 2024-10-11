Algoritmo sin_titulo
	// Realizar un programa que solicite un conjunto de números. Después de introducir cada
	// número se realizará la pregunta: "¿Desea introducir más números (S/N)". Si la
	// respuesta es 'S' se solicitará otro número. Cuando no desee introducir más números
	// debe informar cual es el menor de los números introducidos.ç
	// NOTA: Debe comprobarse que la respuesta es 'S' o 'N' y si no lo es, volver
	// a pedirla
	Repetir
		Escribir 'Cuantos números quieres ingresar'
		Leer cantidadNum
	Hasta Que cantidadNum>0
	box = 0
	Para i<-1 Hasta cantidadNum Con Paso 1 Hacer
		Escribir 'Ingrese el numero ', i
		Leer num
		Si num>box Entonces
			box <- num
		FinSi
	FinPara
	Repetir
		Escribir '¿Quieres volver a ingrsar otro numero S/N?'
		Leer Respuesta
	Hasta Que Respuestas='S' O Respuesta='N'
	Repetir
		Si Respuesta='S' O Respuesta='s' Entonces
			Escribir 'Ingrese otro número'
			Leer num
		FinSi
	Hasta Que Respuesta='N'
FinAlgoritmo
