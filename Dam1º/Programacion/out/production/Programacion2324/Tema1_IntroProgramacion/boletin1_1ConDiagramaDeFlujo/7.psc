Algoritmo sin_titulo
	// Realizar un programa que solicite una cantidad de números que van a pedirse por
	// teclado. Una vez que solicite todos ellos debe informar de cual es la media de los
	// números. Diseñar el programa de forma que si la cantidad es incorrecta vuelva a
	// solicitarse.
	Repetir
		Escribir 'Ingrese la cantidad de numeros para la media'
		Leer numVeces
	Hasta Que numVeces>0
	Para i<-1 Hasta numVeces Con Paso 1 Hacer
		Escribir 'Ingrese el numero ', i
		Leer num
		sumaNum = num + sumaNum
	FinPara
	media = sumaNum/numVeces
	Escribir 'La media es ' media
FinAlgoritmo
