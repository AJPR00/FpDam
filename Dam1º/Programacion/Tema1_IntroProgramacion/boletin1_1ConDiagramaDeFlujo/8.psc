Algoritmo sin_titulo
	// Realizar un programa que solicite un conjunto de n�meros. Despu�s de introducir cada
	// n�mero se realizar� la pregunta: "�Desea introducir m�s n�meros (S/N)". Si la
	// respuesta es 'S' se solicitar� otro n�mero. Cuando no desee introducir m�s n�meros
	// debe informar cual es el menor de los n�meros introducidos.�
	// NOTA: Debe comprobarse que la respuesta es 'S' o 'N' y si no lo es, volver
	// a pedirla
	Repetir
		Escribir 'Cuantos n�meros quieres ingresar'
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
		Escribir '�Quieres volver a ingrsar otro numero S/N?'
		Leer Respuesta
	Hasta Que Respuestas='S' O Respuesta='N'
	Repetir
		Si Respuesta='S' O Respuesta='s' Entonces
			Escribir 'Ingrese otro n�mero'
			Leer num
		FinSi
	Hasta Que Respuesta='N'
FinAlgoritmo
