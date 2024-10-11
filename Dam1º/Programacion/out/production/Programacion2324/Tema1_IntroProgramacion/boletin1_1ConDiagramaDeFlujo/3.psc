Algoritmo sin_titulo
	Escribir 'Cuantos números vas a introducir?'
	leer Num_veces
	Para i<-1 Hasta Num_veces Con Paso 1 Hacer	
							
			Escribir 'Introduzca numeros'
			Leer num
			Mientras num<1 Hacer
				Escribir 'Introduzca numeros mayor a CERO'
				Leer num
			FinMientras
			Si num MOD 2=0 Entonces
				Escribir 'El ', num, ' es PAR'
			SiNo
				Escribir 'El ', num, ' es IMPAR'
			FinSi
			
		FinPara
FinAlgoritmo
