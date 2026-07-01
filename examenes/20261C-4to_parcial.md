# Cuarto Parcial A - Junio 2026

## Ejercicio 1 { objetos, arreglos de objetos, memoria }
Un `PanelSolar` está compuesto por una grilla de `CeldaSolar[][]` de tamaño nxm. El panel debe ser capaz de arrojar cuatro simples reportes:

* `double energiaTotalGenerada()`
* `CeldaSolar celdaMasProductiva()`
* `boolean esMasProductivaQueVecinasEnColumna(int fila, int columna)`
* `int cantidadCeldasDefectuosasEn(int fila)`

**Requisitos:**

1. Resolver el problema programando sólamente el `PanelSolar`.  
2. Expresar pre y post condiciones de cada método público, así como parámetros y valores de retorno.  
3. Manejar la ruptura de contrato mediante Error.  
4. Realizar el diagrama de memoria para un `PanelSolar` con tres filas de dos `CeldaSolar` cada una, de las cuales una esté defectuosa y el resto reporte distintas producciones energéticas cada una.

**Aclaración:** Toda `CeldaSolar` puede:

* `double informarProduccion()`  
* `boolean estaDefectuosa()`

## Ejercicio 2 { pruebas }
a. Documentar al menos dos (2) pruebas para la clase `CeldaSolar` y al menos tres (3) pruebas para la clase `PanelSolar`. Las pruebas deben ser conceptualmente distintas (Nombre, Qué prueba, Entrada, Salida Esperada)  
b. Programar en JUnit tres (3) pruebas de las documentadas anteriormente.

## Ejercicio 3 { ordenamiento, búsqueda, mezcla }
¿Cómo puede obtenerse el rango de un array ordenado, sin saber si está en forma ascendente o descendente?  
Describir en dos oraciones el proceso completo que debería realizar un método que reciba un array y devuelva su rango. No puede modificarse el array original.

**Ejemplo**  
```
[1, 3, 5, 7, 9] -> [1, 9]
[10, 5, 3, 2] -> [2, 10]
```

# Cuarto Parcial B - Junio 2026

## Ejercicio 1 { objetos, arreglos de objetos, memoria }
Una `Tribuna` está compuesta por una grilla de `Asiento[][]` de tamaño nxm. La tribuna debe ser capaz de arrojar cuatro simples reportes:

* `int libresPorFila(int fila)`
* `Asiento asientoMasCaro()`
* `int filaConMasAsientosLibres()`
* `int mayorCantidadDeAsientosLibresConsecutivosEn(int fila)`

**Requisitos:**

1. Resolver el problema programando sólamente la `Tribuna`.  
2. Expresar pre y post condiciones de cada método público, así como parámetros y valores de retorno.  
3. Manejar la ruptura de contrato mediante Error.  
4. Realizar el diagrama de memoria para una `Tribuna` con dos filas de tres `Asiento` cada uno, de las cuales uno esté ocupado y sea gratis, y el resto tenga distintos precios cada uno.

**Aclaración:** Todo `Asiento` puede:

* `double informarPrecio()`
* `boolean estaLibre()`

## Ejercicio 2 { pruebas }
a. Documentar al menos dos (2) pruebas para la clase `Asiento` y al menos tres (3) pruebas para la clase `Tribuna`. Las pruebas deben ser conceptualmente distintas (Nombre, Qué prueba, Entrada, Salida Esperada)  
b. Programar en JUnit tres (3) pruebas de las documentadas anteriormente.

## Ejercicio 3 { ordenamiento, búsqueda, mezcla }
¿Cómo puede verificarse que un array es monótono creciente?  
Describir en dos oraciones el proceso completo que debería realizar un método que reciba un array y devuelva verdadero o falso, según corresponda. No puede modificarse el array original.

**Información importante**  
Un array se considera monótonamente creciente cuando la secuencia de valores almacenados respeta una relación de orden no decreciente entre índices sucesivos.  
```
[1, 2, 3, 4, 4, 4] -> true  
[1, 2, 3, 4, 2] -> false
```

# Cuarto Parcial C - Junio 2026

## Ejercicio 1 { objetos, arreglos de objetos, memoria }
Un `Bosque` está compuesto por una grilla de `Parcela[][]` de tamaño nxm. Cada parcela tiene a lo sumo un sólo árbol. El bosque debe ser capaz de arrojar cuatro simples reportes:

* `double alturaPromedioDeÁrbolesEnParcelasNoDesiertas()`  
* `Parcela primeraParcelaDesierta()`  
* `boolean estáEntreDosDesiertasEnFila(int fila, int columna)`  
* `int cantidadDesiertosEn(int fila)`

**Requisitos:**

1. Resolver el problema programando sólamente el `Bosque`.  
2. Expresar pre y post condiciones de cada método público, así como parámetros y valores de retorno.  
3. Manejar la ruptura de contrato mediante Error.  
4. Realizar el diagrama de memoria para un `Bosque` con dos filas de tres `Parcela` cada una, de las cuales una `Parcela` con árbol esté entre dos desiertas y la otra fila no esté desierta, y tenga distintas alturas de árboles cada una.

**Aclaración:** Toda `Parcela` puede:

* `double informarAlturaÁrbol()`  
* `boolean estáDesierta()`

## Ejercicio 2 { pruebas }
a. Documentar al menos dos (2) pruebas para la clase `Parcela` y al menos tres (3) pruebas para la clase `Bosque`. Las pruebas deben ser conceptualmente distintas (Nombre, Qué prueba, Entrada, Salida Esperada)  
b. Programar en JUnit tres (3) pruebas de las documentadas anteriormente.

## Ejercicio 3 { ordenamiento, búsqueda, mezcla }
¿Cómo pueden obtenerse los N mayores elementos de un array sin alterar el orden de los elementos?  
Describir en dos oraciones el proceso completo que debería realizar un método que reciba un array y devuelva sus N mayores. No puede modificarse el array original.

**Ejemplo**
```
[8, 3, 1, 7, 5], n = 3 -> [8, 7, 5]  
[8, 10], n = 2 -> [10, 8]
```

# Cuarto Parcial D - Junio 2026

**Ejercicio 1 { objetos, arreglos de objetos, memoria }**  
Una `ConsolaDeAudio` está compuesta por una grilla de `Perilla[][]` de tamaño nxm. La consola debe ser capaz de arrojar cuatro simples reportes:

* `double volumenTotal()`  
* `Perilla primeraPerillaApagada()`  
* `boolean tieneMenosVolumenQueVecinasEnFila(int fila, int columna)`  
* `int cantidadDePerillasSaturadasEn(int fila)`

*Aclaración:* una `Perilla` se satura al 100 de volúmen

**Requisitos:**

1. Resolver el problema programando sólamente la `ConsolaDeAudio`.  
2. Expresar pre y post condiciones de cada método público, así como parámetros y valores de retorno.  
3. Manejar la ruptura de contrato mediante Error.  
4. Realizar el diagrama de memoria para una `ConsolaDeAudio` con dos filas de tres `Perilla` cada una, de las cuales una esté apagada y el resto reporte distintos valores de volúmen cada una (ninguna saturada).

**Aclaración:** Toda `Perilla` puede:

* `double informarVolumen()` // 0 a 100  
* `boolean estaEncendida()`  
* `boolean estaSaturada()` // vol == 100

**Ejercicio 2 { pruebas }**  
a. Documentar al menos dos (2) pruebas para la clase `Perilla` y al menos tres (3) pruebas para la clase `ConsolaDeAudio`. Las pruebas deben ser conceptualmente distintas (Nombre, Qué prueba, Entrada, Salida Esperada)  
b. Programar en JUnit tres (3) pruebas de las documentadas anteriormente.

**Ejercicio 3 { ordenamiento, búsqueda, mezcla }**  
¿Cómo puede obtenerse la mediana de un array?  
Describir en dos oraciones el proceso completo que debería realizar un método que reciba un array y devuelva su mediana. No puede modificarse el array original.

**Información importante**  
*Mediana:* es el valor que queda en el centro de un conjunto de datos cuando sus elementos se ordenan de menor a mayor. Divide al conjunto en dos mitades: la misma cantidad de elementos queda por debajo que por encima. Si fueran elementos pares, es el promedio de los dos centrales.  
```
[8, 3, 1, 7, 5] -> 5  
[10, 2, 8, 4] -> (4 + 8) / 2 -> 6
```
