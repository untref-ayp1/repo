# GARR.2 - Arreglos Multidimensionales

La guía está organizada en cuatro partes de dificultad creciente y se recomienda trabajarla de manera progresiva. La **Parte A (Fundamentos)** contiene ejercicios breves orientados a fijar las ideas básicas del tema; si aparecen dificultades aquí, conviene revisar la teoría antes de continuar. La **Parte B (Aplicación)** propone problemas más completos donde se ponen en práctica esas ideas. La **Parte C (Integración)** incluye ejercicios de mayor dificultad, similares a los que podrían aparecer en un parcial. Finalmente, la **Parte D (Desafío)** presenta un problema más abierto, pensado para quienes quieran profundizar.

Como referencia, la Parte A debería tomar aproximadamente 45-60 minutos, la Parte B alrededor de 1-1.5 horas, y la Parte C entre 1 y 1.5 horas. El Desafío es opcional y su tiempo puede variar. En total, se espera que la práctica requiera alrededor de 3 a 4 horas de trabajo. Como orientación para una buena preparación, se recomienda resolver todos los ejercicios de la Parte A y al menos dos ejercicios de las Partes B y C.

---

## Parte A: Fundamentos

En esta sección se ejercitan las operaciones básicas sobre matrices: declaración e inicialización, acceso por coordenadas `(i, j)`, recorrido con doble `for` y acumulación de valores. El foco está en construir un modelo mental claro de cómo se almacenan y recorren los arreglos bidimensionales en Java, y en evitar errores comunes de índices.

### A1. Declaración, acceso y límites
#jshell

Dado el siguiente arreglo bidimensional que representa las temperaturas registradas en tres ciudades durante cuatro días:

```java
double[][] temps = {
    { 22.0, 18.5, 31.0, 27.3 },
    { 15.0, 29.0, 24.1, 20.8 },
    { 30.2, 33.0, 28.7, 25.5 }
};
```

**Tareas:**

1. Imprimí la cantidad de filas y la cantidad de columnas usando `.length`.
2. Imprimí la temperatura de la segunda ciudad (fila 1) en el tercer día (columna 2).
3. Reemplazá la temperatura de la primera ciudad en el último día por `99.9`.
4. Intentá acceder a `temps[3][0]` y observá qué excepción lanza Java. ¿En qué momento ocurre: al compilar o al ejecutar?
5. Recorrelo con un doble `for` e imprimí todos los valores con el formato `temps[<i>][<j>] = <valor>` (**Tip:** utilizar `System.out.printf`)
6. Imprimir la ciudad con la temperatura más baja.
7. Devolver un array con las temperaturas promedio de cada ciudad.

> Prestá atención a la diferencia entre `temps.length` (filas) y `temps[0].length` (columnas). ¿Qué pasaría si la matriz fuera irregular, es decir, si cada fila tuviera distinta longitud?

---

### A2. Acumulación y conteo

Implementá la clase `AnalizadorDeMatrices` con el siguiente método:

```java
public class AnalizadorDeMatrices {
    /**
     * post: devuelve la cantidad de elementos de 'matriz' que tengan valor 0.
     */
    public int contarCeros(double[][] matriz) { ... }
}
```

**Tareas:**

1. Implementá el método usando un doble `for`.
2. Verificá tu implementación con los siguientes casos:

```java
// Caso 1: ningún cero
double[][] m1 = {
    { 5.0, 3.5, 2.4 },
    { 2.1, -9.2, 5.1 },
    { 2.3, 7.9, -2.3 },
    { 1.0, 6.1, -8.5 }
};
// Esperado: 0

// Caso 2: tres ceros
double[][] m2 = {
    { 2.0, 0.0, 3.4, 0.0 },
    { 0.0, 5.7, -2.3, 9.8 }
};
// Esperado: 3

// Caso 3: matriz 1x1 sin ceros
double[][] m3 = { { 1.6 } };
// Esperado: 0
```

3. Agregá el siguiente método y sus pruebas:

```java
/**
 * post: devuelve la cantidad de elementos de 'matriz' cuyo valor
 *       esté en el rango ['desde', 'hasta'].
 */
public int contarElementosEnElRango(double[][] matriz, double desde, double hasta)
```

> ¿Qué diferencia hay entre contar ceros y contar elementos en un rango? ¿Podría `contarCeros` implementarse usando `contarElementosEnElRango`?

---

### A3. Recorrido por filas y columnas

Agregá a `AnalizadorDeMatrices` los siguientes métodos (con sus pruebas):

```java
/**
 * pre: 'matriz' es regular.
 * post: devuelve la cantidad de columnas de 'matriz' que tengan al menos un valor 0.
 */
public int contarColumnasConCeros(double[][] matriz)

/**
 * post: devuelve la cantidad de filas de 'matriz' que tengan al menos un valor 0.
 */
public int contarFilasConCeros(double[][] matriz)
```

**Tareas:**

1. Implementá ambos métodos.
2. Verificalos con la matriz `m2` del ejercicio anterior: ¿cuántas filas tienen ceros? ¿Cuántas columnas?
3. **Desafío:** probá `contarColumnasConCeros` con una matriz irregular (filas de distinta longitud). ¿Qué hay que tener en cuenta?

> La diferencia entre recorrer "por filas" y recorrer "por columnas" no cambia el código en casi nada, pero sí cambia el orden en que se visitan los elementos. Asegurate de entender cuál índice es el externo y cuál el interno en cada caso.

---

### A4. Promedio por fila

Agregá a `AnalizadorDeMatrices` el siguiente método:

```java
/**
 * post: devuelve un arreglo con tantos elementos como filas tiene 'matriz',
 *       donde cada posición contiene el promedio de esa fila.
 */
public double[] promediarFilas(double[][] matriz)
```

**Tareas:**

1. Implementá el método. Tené en cuenta que cada fila puede tener longitud distinta.
2. Verificá con el siguiente caso:

```java
double[][] matriz = {
    { 6.0, 5.0, 4.0, 3.0 },
    { 8.0, 7.0, 7.0, 8.0 }
};
// Esperado: { 4.5, 7.5 }
```

3. ¿Qué tipo debe devolver el método? ¿Por qué no puede devolver `double[][]`?

---

### Auto-diagnóstico

**1.** Sin escribir código, ¿cómo se accede al último elemento de la última fila de una matriz `m`? ¿Qué pasa si alguna fila está vacía?

> Si no podés responderla: repasá A1 y la diferencia entre `m.length` y `m[i].length`. El acceso al último elemento siempre es `m[m.length - 1][m[m.length-1].length - 1]`.

**2.** ¿Por qué en `promediarFilas` el resultado es un `double[]` y no un `double`? ¿Qué se pierde si devolvés solo el promedio total?

> Si no tenés una respuesta clara: la función produce un valor *por fila*, no un valor *global*. Un `double` colapsaría toda la información en un solo número.

---

## Parte B: Aplicación

En esta parte se aplican las operaciones básicas en problemas con contexto. Se trabaja sobre matrices que representan datos del mundo real: se recorren, se filtran, se analizan por filas/columnas y se producen resultados más elaborados que un simple conteo.

### B1. Análisis de mapa de humedad

Por cada metro cuadrado de un terreno rectangular se toman muestras de humedad del suelo (valores de `0.0` a `100.0`). Diseñá e implementá la clase `MapaDeHumedad` tal que:

- Se construya a partir de un `double[][]` que represente las muestras.
- Calcule la humedad promedio de todo el terreno.
- Encuentre el valor mínimo y el máximo de humedad.
- Calcule el promedio de humedad del **contorno** del terreno (los elementos del borde).
- Cuente la cantidad de muestras que se encuentran en un rango `[min, max]` dado.

Usá el siguiente mapa de prueba:

```java
double[][] muestras = {
    { 45.0, 60.0, 72.0, 55.0 },
    { 38.0, 91.0, 83.0, 47.0 },
    { 50.0, 66.0, 74.0, 52.0 }
};
```

> Para el contorno: ¿qué condición identifica a un elemento de borde en una matriz de `f` filas y `c` columnas? Pensalo antes de codificarlo.

---

### B2. Cuadrado mágico

Un cuadrado mágico de tamaño `n×n` es una matriz de enteros donde la suma de cada fila, cada columna y las dos diagonales principales es siempre la misma (llamada "constante mágica").

Implementá la clase `CuadradoMagico` con un único método:

```java
/**
 * post: devuelve true si 'matriz' es un cuadrado mágico válido.
 */
public boolean verificar(int[][] matriz)
```

Verificá con los siguientes casos:

```java
// Cuadrado mágico 3x3 clásico (constante = 15)
int[][] magico = {
    { 2, 7, 6 },
    { 9, 5, 1 },
    { 4, 3, 8 }
};
// Esperado: true

// No es mágico
int[][] noMagico = {
    { 1, 2, 3 },
    { 4, 5, 6 },
    { 7, 8, 9 }
};
// Esperado: false

// Matriz no cuadrada
int[][] rectangular = {
    { 1, 2 },
    { 3, 4 },
    { 5, 6 }
};
// Esperado: false
```

> Estrategia sugerida: calculá primero la suma de la primera fila como referencia. Luego verificá que todas las demás filas, columnas y diagonales tengan esa misma suma.

---

### B3. Corrección de muestras inválidas

Volviendo a `MapaDeHumedad`, agregá la siguiente operación:

```java
/**
 * post: reemplaza el valor de la muestra en (f, c) por el promedio
 *       de sus vecinos contiguos (arriba, abajo, izquierda, derecha).
 *       Ignora los vecinos que estén fuera de los límites.
 */
public void reemplazarPorPromedioContiguos(int f, int c)
```

Luego, agregá:

```java
/**
 * post: reemplaza todas las muestras cuyo valor esté fuera del rango [0.0, 100.0]
 *       por el promedio de sus valores contiguos.
 */
public void corregirMuestrasInvalidas()
```

Probá con un mapa que tenga valores negativos o mayores a 100:

```java
double[][] muestrasConErrores = {
    {  45.0, -5.0,  72.0 },
    {  38.0, 110.0, 47.0 },
    {  50.0,  66.0, 74.0 }
};
```

> ¿En qué orden conviene corregir las muestras inválidas? ¿Importa si corregís primero la de la fila 0 y eso afecta a la de la fila 1?

---

### Auto-diagnóstico

**1.** Para verificar un cuadrado mágico, ¿alcanza con revisar solo filas y columnas? ¿Qué pasa si olvidás las diagonales?

> Si la respuesta no es clara: un cuadrado que tiene todas las filas y columnas con suma igual pero diagonales distintas no es mágico. La condición es sobre *todas* las líneas.

**2.** En `reemplazarPorPromedioContiguos`, ¿cómo sabés que un vecino existe antes de acceder a él? ¿Qué pasa si la celda está en una esquina?

> Si te cuesta: los vecinos de `(f, c)` son `(f-1,c)`, `(f+1,c)`, `(f,c-1)`, `(f,c+1)`. Cada uno existe solo si su fila está en `[0, filas-1]` y su columna en `[0, cols-1]`.

---

## Parte C: Integración

Esta sección integra matrices con diseño orientado a objetos. Se ejercita el modelado de problemas reales usando clases con responsabilidades claras, y la implementación de operaciones matemáticas sobre matrices. El foco está en escribir código bien organizado y comprensible.

### C1. Clase Matriz matemática

Implementá la clase `Matriz` a partir del siguiente código inicial:

```java
public class Matriz {
    private double[][] valores;

    public Matriz(double[][] valores) {
        this.valores = valores;
    }
}
```

Implementá los siguientes métodos **en orden**, ya que algunos se apoyan en los anteriores:

1. `int filas()` - cantidad de filas.
2. `int columnas()` - cantidad de columnas (asumí que es regular).
3. `double obtener(int i, int j)` - valor en la posición `(i, j)`.
4. `boolean esCuadrada()` - `true` si tiene igual cantidad de filas y columnas.
5. `boolean esIdentidad()` - `true` si es cuadrada, tiene `1.0` en la diagonal y `0.0` en el resto.
6. `boolean esDiagonal()` - `true` si todos los elementos fuera de la diagonal principal son `0.0`.
7. `double traza()` - suma de los elementos de la diagonal principal. Requiere que sea cuadrada.
8. `boolean esSimetrica()` - `true` si `valores[i][j] == valores[j][i]` para todo `(i, j)`.
9. `boolean equals(Matriz otra)` - `true` si tienen las mismas dimensiones y valores posición a posición.
10. `Matriz copiar()` - devuelve una nueva `Matriz` con los mismos valores (copia profunda).
11. `void multiplicarFila(int fila, double escalar)` - multiplica in-place todos los valores de una fila.
12. `Matriz escalar(double k)` - devuelve una nueva `Matriz` con todos los valores multiplicados por `k`. Reutilizá el método anterior.
13. `void multiplicarColumna(int col, double escalar)` - análogo a `multiplicarFila`.
14. `Matriz sumar(Matriz otra)` - devuelve la suma de ambas matrices. Lanzá una excepción si las dimensiones no coinciden.
15. `Matriz restar(Matriz otra)` - análogo a `sumar`.
16. `Matriz transpuesta()` - devuelve la traspuesta (filas y columnas intercambiadas).
17. `void intercambiarFilas(int f1, int f2)` - intercambia in-place dos filas.
18. **Desafío:** `void intercambiarColumnas(int c1, int c2)` - análogo a `intercambiarFilas`.

Escribí pruebas unitarias para cada método. Prestá especial atención a los casos borde: matriz 1×1, matrices no cuadradas, dimensiones incompatibles.

> Para el método `escalar`, ¿conviene modificar la matriz original o devolver una nueva? ¿Qué pasa si la modificás in-place y alguien quería conservar el original?

---

### C2. Nanograma (Picross)

El Picross es un juego de lógica donde se revela una imagen en una cuadrícula según pistas numéricas. Las pistas indican cuántas celdas consecutivas deben estar pintadas en cada fila o columna.

**Ejercicio C2.1 - Dibujar**

Dada una matriz de booleanos, dibujá el nanograma usando el carácter `■` (`\u25A0`) para las celdas llenas y un espacio para las vacías.

```java
boolean t = true, f = false;
boolean[][] calavera = {
    {f, t, t, t, f},
    {t, t, t, t, t},
    {t, f, t, f, t},
    {t, t, t, t, t},
    {f, t, f, t, f}
};
dibujar(calavera);
```

Salida esperada:
```
 ■■■ 
■■■■■
■ ■ ■
■■■■■
 ■ ■ 
```

**Ejercicio C2.2 - Dibujar con pistas**

Extendé el método anterior para mostrar también las pistas de cada fila a la derecha, separadas por ` | `.

Las pistas de una fila son los tamaños de cada bloque contiguo de celdas llenas. Por ejemplo, `{t, f, t, f, t}` tiene pistas `1 1 1`.

Salida esperada para la calavera:
```
 ■■■  | 3
■■■■■ | 5
■ ■ ■ | 1 1 1
■■■■■ | 5
 ■ ■  | 1 1
```

> ¿Cuántas pistas puede tener como máximo una fila de `n` celdas? El peor caso es una alternancia perfecta entre llenas y vacías.

---

### Auto-diagnóstico

**1.** En la clase `Matriz`, cuando implementás `escalar(double k)`, ¿por qué es mejor devolver una nueva `Matriz` en lugar de modificar `this`? ¿Qué problemas puede causar modificar el objeto receptor?

> Si no podés responderla: pensá en el principio de menor sorpresa. Si alguien hace `Matriz b = a.escalar(2)`, probablemente espera que `a` no cambie.

**2.** Para calcular las pistas de una fila en el Picross, ¿alcanza con un solo recorrido? ¿Cómo sabés cuándo termina un bloque?

> Si te cuesta: un bloque termina cuando encontrás `false` después de uno o más `true`, o cuando llegás al final de la fila. Llevá un contador del bloque actual y guardalo cuando se cierre.

---

## Parte D: Desafío

En esta sección se propone un problema más abierto que integra los conceptos trabajados a lo largo de la guía. El foco está en diseñar una estrategia propia, razonar sobre la complejidad y explorar soluciones parciales o aproximadas.

### D1. Resolver un Picross

Dadas las pistas de filas y columnas, encontrá la matriz de booleanos que las satisface, y mostrala con el método desarrollado en C2.

```java
int[][] pistasFilas = {
    {3},
    {5},
    {1, 1, 1},
    {5},
    {1, 1}
};

int[][] pistasColumnas = {
    {3},
    {2, 2},
    {4},
    {2, 2},
    {3}
};
```

Salida esperada:
```
 ■■■  | 3
■■■■■ | 5
■ ■ ■ | 1 1 1
■■■■■ | 5
 ■ ■  | 1 1
-----
3 2 4 2 3
  2   2  
```

**Aclaraciones:**
- Podés asumir que el nanograma tiene solución única.
- No es necesario encontrar la solución óptima: alcanza con que sea correcta.
- Recomendamos representar la solución como `boolean[][]` y mostrarla con los métodos ya desarrollados.

> **Sugerencia:** este problema es considerablemente más difícil de lo que aparenta. Una estrategia de fuerza bruta -probar todas las combinaciones posibles de celdas- es válida para tamaños pequeños. En Algoritmos y Programación 2 veremos técnicas para resolverlo eficientemente con backtracking. No hay vergüenza en intentarlo y abandonarlo: en el camino habrá muchos descubrimientos valiosos.

---

### Auto-diagnóstico

**1.** ¿Cuántas matrices `boolean[][]` de 5×5 existen? ¿Por qué la fuerza bruta se vuelve impracticable rápidamente al crecer el tamaño?

> Si no podés responderla: cada celda puede ser `true` o `false`, así que hay `2^(n*m)` matrices posibles. Para 5×5 son `2^25 ≈ 33 millones`. Para 10×10 serían `2^100`, un número astronómico.

**2.** ¿Podés identificar al menos una celda de la solución antes de explorar? Por ejemplo, si una pista de fila es `{5}` en una cuadrícula de 5 columnas, ¿qué podés afirmar de inmediato?

> Esta observación es la base de las técnicas de resolución inteligente: a veces hay celdas que *deben* estar llenas o vacías sin importar el resto de la solución. Identificarlas reduce el espacio de búsqueda drásticamente.
