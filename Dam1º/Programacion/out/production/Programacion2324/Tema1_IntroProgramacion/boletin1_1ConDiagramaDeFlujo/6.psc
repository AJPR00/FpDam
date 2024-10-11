Algoritmo sin_titulo
	// Realizar un programa que lea dos números enteros cualesquiera numeroA y numeroB y calcule el producto los 
	// números mediante sumas, es decir, sin usar el operador *
	Escribir 'Introduca dos numero para calcular su producto'
	Escribir 'Numero A:'
	Leer numA
	Escribir 'Numero B:'
	Leer numB
	Para i<- 1 Hasta numB Con Paso 1 Hacer
		
		producto = producto + numA
		
	Escribir  producto 
	FinPara
	Escribir  'El producto de ' numA, ' * ' numB, ' es ' producto
FinAlgoritmo
