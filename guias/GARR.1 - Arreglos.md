# GARR.1 - Arreglos
La guía está organizada en cuatro partes de dificultad creciente y se recomienda trabajarla de manera progresiva. La **Parte A (Fundamentos)** contiene ejercicios breves orientados a fijar las ideas básicas del tema; si aparecen dificultades aquí, conviene revisar la teoría antes de continuar. La **Parte B (Aplicación)** propone problemas más completos donde se ponen en práctica esas ideas. La **Parte C (Integración)** incluye ejercicios de mayor dificultad, similares a los que podrían aparecer en un parcial. Finalmente, la **Parte D (Desafío)** presenta un problema más abierto, pensado para quienes quieran profundizar.

Como referencia, la Parte A debería tomar aproximadamente 45–60 minutos, la Parte B alrededor de 1–1.5 horas, y la Parte C entre 1 y 1.5 horas. El Desafío es opcional y su tiempo puede variar. En total, se espera que la práctica requiera alrededor de 3 a 4 horas de trabajo. Como orientación para una buena preparación, se recomienda resolver todos los ejercicios de la Parte A y al menos tres ejercicios de las Partes B y C.

## Parte A: Fundamentos
En esta sección se ejercitan las operaciones básicas sobre arreglos: acceso por índice, uso de `length`, recorridos con `for` y `for-each`, acumulación de valores y búsquedas simples. El foco está en construir un modelo mental claro de cómo funcionan los arrays y en evitar errores comunes (límites, tipos de datos, comparación de objetos).

### A1. Límites y acceso directo
`#jshell`

Dado el siguiente arreglo de temperaturas diarias (en °C), completá las tareas indicadas sin usar un bucle:
```java
int[] temps = {22, 18, 31, 27, 15, 29, 24};
```

**Tareas:**
1. Imprimí la temperatura del primer día.
2. Imprimí la temperatura del último día (usá `.length`, no el índice literal).
3. Reemplazá el valor del día central (índice 3) por 99.
4. Intentá acceder al índice 10 y observá qué excepción lanza Java.
5. Imprimí cuántos elementos tiene el array.

> Prestá atención a qué pasa con el índice 10: leé el mensaje e identificá su significado.

### A2. Acumulador
`#jshell`

Dado un arreglo de notas enteras, calculá la suma total y el promedio. Mostrá si el promedio es promoción (>= 7.0).
```java
int[] notas = {7, 5, 8, 4, 9, 6, 5};
```

**Tareas:**
1. Recorrelo con un `for` clásico y acumulá la suma en una variable entera.
2. Calculá el `promedio` como `double`. (**Atención:** división entera vs. decimal)
3. Imprimí `suma`, `promedio` y si `aprueba`.
4. Bonus: repetilo con `for-each` y verificá que el resultado es idéntico.

> Cuidado con `(double) suma / notas.length` vs `suma / notas.length`. Probá ambas formas y observá la diferencia.

### A3. Búsqueda con bandera
Dado un arreglo de nombres de frutas, buscá si existe un valor en particular e informá su posición.
```java
String[] frutas = {
    "manzana", "banana", "naranja",
    "uva", "pera", "mango"
};
String buscar = "naranja";
```

**Tareas:**
1. Recorrelo con un `for` clásico.
2. Usá una variable `boolean encontrado` y una variable `int posicion = -1`.
3. Si encontrás el elemento, actualizá ambas variables y cortá el bucle (no uses `break` para forzar el uso de una condición de corte explícita).
4. Al final imprimí si fue encontrado y en qué índice.
5. Probá buscando `"kiwi"` y verificá que posicion queda en `-1`.

> Usá `.equals()` para comparar `Strings`, no `==`. ¿Por qué son distintos en Java?

### A4. Array de objetos
Creá una clase `Producto` con los atributos `nombre` (`String`) y `precio` (`double`). Luego trabajá con un array de productos.

```java
class Producto {
    String nombre;
    double precio;

    Producto(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
    }
}
```

```java
// En el main:
Producto[] productos = {
    new Producto("leche", 150.0),
    new Producto("pan", 80.0),
    new Producto("queso", 420.0),
    new Producto("yogur", 95.0)
};
```

**Tareas:**
1. Recorrelo con `for-each` e imprimí `nombre` y `precio` de cada producto.
2. Calculá el precio total del carrito.
3. Encontrá el producto más caro (guardá referencia al objeto, no solo precio).
4. Reemplazá el precio de "pan" por 90.0 accediendo por índice directamente.

> En el punto 3: la variable para "el más caro" debería ser de tipo `Producto`, no `double`. ¿Cuál es la diferencia?

## Parte B: Aplicación
En esta parte se aplican las operaciones básicas en problemas con contexto, donde es necesario combinar recorridos, condiciones y acumuladores para producir resultados más elaborados. Se trabaja especialmente en el procesamiento de datos: filtrar, contar, reorganizar e interpretar información contenida en un arreglo.

### B1. Control de calidad
Una fábrica de piezas metálicas registra el peso (en gramos) de cada pieza producida en un turno. Una pieza se considera defectuosa si su peso es menor a 95g o mayor a 105g. Las piezas con peso exactamente igual a 100 g son perfectas.

Dado el siguiente arreglo de pesos, escribí un programa que informe:
1. La cantidad de piezas defectuosas.
2. La cantidad de piezas perfectas.
3. El peso promedio de las piezas no defectuosas (si las hay).
4. Si más del 20% de las piezas son defectuosas, imprimí el mensaje "ALERTA: revisar línea de producción".

```java
int[] pesos = {102, 98, 100, 87, 105, 100, 111, 99, 103, 94, 100, 101};
```

### B2. Depuración del registro sísmico
Una estación sismológica registra lecturas de actividad cada hora. Los valores 0 son errores del sensor: lecturas que no se grabaron correctamente y deben eliminarse del registro antes de publicarlo.

Dado el siguiente arreglo con lecturas (algunos valores son 0), generá un nuevo array que contenga únicamente las lecturas válidas (distintas de 0), manteniendo el orden original. Luego imprimí el array original, el array depurado y cuántas lecturas inválidas se eliminaron.

```java
int[] lecturas = {4, 0, 7, 0, 0, 3, 9, 0, 2, 6, 0, 1};
```

### B3. Reporte financiero de sucursales
Una cadena de tiendas registra la ganancia mensual de cada sucursal (puede ser negativa si tuvo pérdidas). Para el reporte ejecutivo, se necesita mostrar primero todas las sucursales rentables y al final las que perdieron dinero.

Dado el siguiente arreglo de ganancias, reorganizalo en un nuevo array donde todos los valores no negativos aparezcan primero y los negativos al final. Imprimí el array original y el reorganizado.

```java
int[] ganancias = {120, -45, 300, -10, 85, -200, 60, 40, -5};
```

## Parte C: Integración
Esta sección integra el uso de arreglos con objetos y organización del código en clases. Se ejercita el diseño de soluciones más estructuradas, separando datos y lógica, e implementando métodos que recorren colecciones de objetos para obtener distintos resultados. El foco está en resolver problemas más completos manteniendo claridad y control sobre la complejidad.

### C1. Maratón de cine
Un cineclub programa una maratón con varias películas en orden. Cada película tiene un título, un género y una duración en minutos.

Definí la clase `Pelicula` con los atributos `titulo` (`String`), `genero` (`String`) y `duracion` (`int`). Resolvé el ejercicio desde un `App.java` que contenga el método `main`. En `App` deberás crear el `Pelicula[] cartelera` de ejemplo y escribir los métodos necesarios como funciones estáticas de la clase `App` (o directamente implementarlos dentro de `main` si preferís). Implementá las siguientes tareas y llamalas desde `main`:

- Imprimí el título y la duración de todas las películas que superen los 100 minutos.
- Calculá y mostrá la duración total de la maratón.
- Encontrá y mostrá el título de la película más corta.
- Encontrá la racha más larga de películas contiguas del mismo género e informá el género y cuántas películas la forman.

La idea es que el alumno practique organizar código en `App.java` y en el `main` maneje el arreglo de `Pelicula` y las llamadas a las funciones de reporte.

```java
Pelicula[] cartelera = {
    new Pelicula("Dune",         "ciencia ficción", 155),
    new Pelicula("Alien",        "terror",          117),
    new Pelicula("Hereditary",   "terror",          127),
    new Pelicula("Get Out",      "terror",          104),
    new Pelicula("Parasite",     "thriller",        132),
    new Pelicula("Clue",         "thriller",         94),
    new Pelicula("Interstellar", "ciencia ficción", 169)
};
```

Salida esperada

    Películas de más de 100 min:
        Dune (155)
        Alien (117)
        Hereditary (127)
        Get Out (104)
        Parasite (132)
        Interstellar (169)
    Duración total: 898 minutos
    Más corta: Clue
    Racha más larga: "terror", 3 películas consecutivas

> Para la racha, tené en cuenta que puede haber empates: si dos géneros tienen la misma racha máxima, alcanza con devolver el primero encontrado.

### C2. Inventario de una librería
Una librería lleva el registro de sus libros en stock. Cada libro tiene un `título`, un `autor` y una cantidad de `ejemplares` disponibles.
Definí la clase `Libro` con los atributos anteriormente dichos. A continuación, definí una clase `Libreria` que contenga un array de `Libro` (por ejemplo, un atributo `libros`) y un constructor que reciba ese array. Implementá en la clase `Libreria` los siguientes métodos para generar los reportes:

- Listá los títulos de los libros con stock crítico: menos de 3 ejemplares.
- Calculá el total de ejemplares en la librería.
- Identificá el autor con más títulos distintos en el inventario. Si hay empate, mostrá el primero encontrado.
- Mostrá el título del libro con más ejemplares disponibles.

Desde el `main`, creá una `Libreria` con los libros de ejemplo y llamá a sus métodos para producir la salida requerida.

```java
Libro[] inventario = {
    new Libro("Ficciones",              "Borges",         5),
    new Libro("El Aleph",               "Borges",         2),
    new Libro("Rayuela",                "Cortázar",       4),
    new Libro("Bestiario",              "Cortázar",       1),
    new Libro("Final del juego",        "Cortázar",       3),
    new Libro("Cien años de soledad",   "García Márquez", 7),
    new Libro("El amor en los tiempos", "García Márquez", 2)
};
```

Salida esperada

    Stock crítico: El Aleph, Bestiario, El amor en los tiempos
    Total de ejemplares: 24
    Autor con más títulos: Cortázar (3 títulos)
    Más ejemplares: Cien años de soledad

> Para el autor con más títulos, no hay colecciones disponibles: tenés que resolver el conteo usando solo el array y variables auxiliares.

## Parte D: Desafío
En esta sección se propone un problema más abierto que integra los conceptos trabajados. El foco está en diseñar una estrategia propia para recorrer el arreglo y detectar condiciones, priorizando el razonamiento por sobre la aplicación directa de técnicas.

### D1. La cuenta bancaria del viajero
Un viajero registra los gastos diarios de su viaje en un arreglo de números enteros positivos. Cada valor representa cuánto dinero gastó en un día.

En un control de gastos, quiere saber si hubo un período contiguo de días en el que el gasto total fue mayor o igual a un monto `x`.

Escribí un método con la siguiente firma:

```java
boolean existeSubarray(int[] gastos, int x)
```

El método debe devolver `true` si existe algún subarray contiguo cuya suma sea mayor o igual a `x`, y `false` en caso contrario.

Aclaraciones:
- Todos los valores del arreglo son positivos.
- El subarray debe estar formado por elementos contiguos.
- No se puede modificar el arreglo original.

Desde el main, probá el método con estos casos:

```java
int[] gastos = {3, 5, 2, 7, 1, 4, 6};

int x1 =  9; // 3 + 5 + 2 = 10 >= 9
int x2 =  7; // existe un elemento exacto
int x3 = 14; // 5 + 2 + 7
int x4 = 20; // no existe
```

Salida esperada

    x=10 → true
    x=7  → true
    x=14 → true
    x=20 → false

> **Sugerencia:** Este problema es relativamente simple, si no se restringe la cantidad de veces que puede recorrerse el array. Se puede realizar recorriendo los datos una única vez... ¿Cuándo conviene dejar de sumar?
