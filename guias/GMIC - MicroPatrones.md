# GMIC - Micro-Patrones de Implementación

La guía está organizada en cuatro partes de dificultad creciente y se recomienda trabajarla de manera progresiva. La **Parte A (Reconocimiento)** contiene ejercicios breves orientados a identificar y aplicar cada patrón de forma aislada; si aparecen dificultades aquí, conviene repasar los ejemplos de clase antes de continuar. La **Parte B (Aplicación)** propone problemas más completos donde se combinan varios patrones para resolver un problema con contexto. La **Parte C (Integración)** incluye ejercicios de mayor dificultad, similares a los que podrían aparecer en un parcial. Finalmente, la **Parte D (Desafío)** presenta un problema más abierto, pensado para quienes quieran profundizar.

Como referencia, la Parte A debería tomar aproximadamente 45-60 minutos, la Parte B alrededor de 1-1.5 horas, y la Parte C entre 1 y 1.5 horas. El Desafío es opcional y su tiempo puede variar. En total, se espera que la práctica requiera alrededor de 3 a 4 horas de trabajo. Como orientación para una buena preparación, se recomienda resolver todos los ejercicios de la Parte A y al menos dos ejercicios de las Partes B y C.

---

## Parte A: Reconocimiento

En esta sección se ejercita cada micro patrón de forma aislada. El foco está en internalizar la estructura de cada uno: qué acumulador se usa, cómo se inicializa, cuándo se corta el recorrido y qué se devuelve. Muchos de estos patrones se verán combinados en las partes siguientes.

### A1. Patrones de búsqueda

Dado el siguiente arreglo:

```java
int[] ventas = { 42, 17, 85, 23, 85, 61, 4, 99, 38, 55 };
```

**Tareas:**

1. Encontrá la posición de la primera ocurrencia del valor `85`. ¿Qué se devuelve si el valor no existe?
2. Verificá si el valor `100` existe en el arreglo.
3. Contá cuántas veces aparece el valor `85`.
4. Contá cuántos elementos son mayores a `50`.
5. Verificá si el arreglo está ordenado de menor a mayor.

> En los ítems 1 y 2, ¿en qué momento conviene cortar el recorrido con `break`? ¿Cambia el resultado si no lo hacés? ¿Cambia el rendimiento?

---

### A2. Patrones de acumulación

Dado el siguiente arreglo:

```java
double[] temperaturas = { 18.5, 22.0, 31.0, 27.3, 15.0, 29.0, 24.1, 20.8 };
```

**Tareas:**

1. Calculá la suma de todos los elementos.
2. Calculá el producto acumulado de todos los elementos. ¿Qué pasa si inicializás el acumulador en `0` en lugar de `1`?
3. Calculá el promedio. ¿Qué tipo de dato debe tener el acumulador para no perder la parte decimal?
4. Encontrá el máximo usando una comparación explícita con `if`.
5. Repetí el ítem anterior usando `Math.max`. ¿Cuál te parece más legible?
6. Encontrá el mínimo y el máximo en un solo recorrido.

> ¿Por qué se inicializa el acumulador del máximo con `arr[0]` y no con `0`? Pensá en un arreglo donde todos los valores sean negativos.

---

### A3. Patrones de transformación

Dado el siguiente arreglo:

```java
int[] datos = { -5, 3, -1, 8, 0, -4, 7, 2, -9, 6 };
```

**Tareas:**

1. Filtrá los elementos positivos en un nuevo arreglo (sin usar colecciones de Java). Imprimí cuántos elementos válidos tiene el resultado.
2. Invertí el arreglo original. Verificá que después de invertirlo dos veces el arreglo es igual al original.
3. Eliminá los duplicados del arreglo `{ 3, 1, 4, 1, 5, 9, 2, 6, 5, 3 }` sin usar colecciones de Java.
4. Rotá el arreglo `{ 1, 2, 3, 4, 5 }` dos posiciones a la izquierda. ¿Cuál es el resultado esperado?

> Para el ítem 1, ¿cuántos elementos tiene el arreglo resultado? ¿Cómo sabés cuál es el "tamaño útil" si el arreglo tiene la longitud del original?

---

### A4. Patrones sobre números y strings

**Tareas:**

1. Dado un valor `x` y un rango `[min, max]`, verificá si `x` está dentro del rango. Luego "clameá" el valor al rango usando `Math.min` y `Math.max` en una sola línea.
2. Dado un arreglo de strings `{ "hola", "mundo", "java" }`, concatenalos en un único string usando `StringBuilder`. ¿Por qué es preferible a usar `+=`?


---

### Auto-diagnóstico

**1.** Sin escribir código, ¿cuál es la diferencia entre "encontrar posición" y "verificar existencia"? ¿Podría implementarse uno usando el otro?

> Si no podés responderla: "encontrar posición" devuelve un índice (o `-1`); "verificar existencia" devuelve un booleano. Sí, `existe = (encontrarPosicion(arr, x) != -1)`, aunque es ligeramente menos eficiente si el tipo de retorno obliga a calcular el índice de todas formas.

**2.** ¿Por qué el patrón de inversión de un arreglo solo recorre la mitad de los elementos? ¿Qué pasaría si recorrieras el arreglo completo?

> Si no tenés una respuesta clara: recorrer el arreglo completo haría cada intercambio dos veces, dejando el arreglo igual que al principio.

---

## Parte B: Aplicación

En esta parte se aplican los micro patrones en problemas con contexto real. El foco está en identificar qué patrones intervienen en cada problema y combinarlos de manera eficiente, idealmente en un solo recorrido.

### B1. Análisis de notas de un curso

Un profesor tiene las notas finales de sus alumnos en un arreglo. Las notas van de `0` a `10`.

```java
double[] notas = { 7.5, 4.0, 9.0, 6.5, 3.0, 8.5, 5.0, 9.5, 6.0, 4.5 };
```

Implementá la clase `AnalizadorDeNotas` con los siguientes métodos:

```java
/**
 * post: devuelve el promedio de todas las notas.
 */
public double promedio(double[] notas)

/**
 * post: devuelve la nota más alta.
 */
public double notaMaxima(double[] notas)

/**
 * post: devuelve la cantidad de alumnos que aprobaron (nota >= 6.0).
 */
public int aprobados(double[] notas)

/**
 * post: devuelve un arreglo con las notas de los alumnos que desaprobaron (nota < 6.0).
 *       El tamaño útil del arreglo resultado se indica por el valor de retorno de un
 *       segundo método auxiliar, o puede inferirse del contenido.
 */
public double[] notasDesaprobados(double[] notas)

/**
 * post: devuelve el promedio de los alumnos que aprobaron.
 */
public double promedioAprobados(double[] notas)
```

> Para `promedioAprobados`, ¿podés resolverlo en un solo recorrido en lugar de llamar a `aprobados` y luego acumular por separado? ¿Qué patrones combinás?

---

### B2. Validación y corrección de datos de sensores

Un sensor industrial registra lecturas de presión en un arreglo. Los valores válidos están entre `0.0` y `100.0`; cualquier valor fuera de ese rango se considera un error de medición.

```java
double[] lecturas = { 45.0, -3.0, 72.0, 110.5, 38.0, 91.0, -1.0, 52.0 };
```

**Tareas:**

1. Contá cuántas lecturas son inválidas.
2. Verificá si el arreglo contiene al menos una lectura válida.
3. Calculá el promedio considerando solo las lecturas válidas. Si no hay ninguna válida, devolvé `0.0`.
4. Reemplazá cada lectura inválida por el promedio de las lecturas válidas (calculado previamente). ¿Importa el orden en que hacés las dos operaciones?

> En el ítem 4, ¿qué problema surge si calculás el promedio de válidas *después* de hacer los reemplazos?

---

### B3. Comparación de dos registros

Se tienen dos arreglos del mismo tamaño que representan las ventas diarias de dos sucursales durante un mes.

```java
int[] sucursal1 = { 120, 95, 140, 88, 102, 115, 99, 130, 110, 125 };
int[] sucursal2 = { 110, 100, 135, 92, 108, 112, 105, 128, 115, 120 };
```

**Tareas:**

1. Verificá si los dos arreglos son iguales elemento a elemento, sin importar su posición.
2. Contá cuántos días la sucursal 1 superó a la sucursal 2.
3. Encontrá el día (índice) en que la diferencia entre ambas sucursales fue mayor.
4. Calculá el total de ventas de cada sucursal y determiná cuál fue más rentable en el período.

> Para el ítem 3, ¿qué patrón usás? ¿Es una variante de "hallar máximo" o de "encontrar posición"? ¿O ambos?

---

### Auto-diagnóstico

**1.** En `promedioAprobados`, ¿qué pasa si ningún alumno aprobó? ¿Cómo protegés el código de una división por cero?

> Si no podés responderla: antes de dividir, verificá que `cantidad > 0`. Si es cero, devolvé un valor centinela como `0.0` o lanzá una excepción según el contrato del método.

**2.** En B2 ítem 4, ¿por qué es importante calcular el promedio de válidas *antes* de reemplazar? ¿Qué valor incorrecto se obtendría si lo hacés al revés?

> Si no tenés una respuesta clara: si reemplazás primero, los valores inválidos se convierten en el promedio *anterior*, que aún no incluía esa corrección. El promedio posterior ya no reflejaría solo las lecturas originalmente válidas.

---

## Parte C: Integración

Esta sección presenta problemas donde los patrones aparecen en contextos menos obvios. Ya no se trata de aplicarlos mecánicamente sino de reconocerlos dentro de un problema más complejo y decidir cómo combinarlos. Algunos ejercicios introducen variantes sutiles que obligan a ajustar la estructura clásica.

### C1. Codificación Run-Length

La codificación Run-Length (RLE) es una técnica de compresión simple: en lugar de guardar `{ 3, 3, 3, 7, 7, 1 }`, se guarda la cantidad de veces que aparece cada valor consecutivo: `{ 3, 3, 2, 7, 1, 1 }` (valor, cantidad, valor, cantidad...).

Dado el siguiente arreglo de entrada:

```java
int[] original = { 5, 5, 5, 2, 2, 8, 8, 8, 8, 1 };
```

**Tareas:**

1. Implementá `int[] comprimir(int[] arr)` que devuelve la codificación RLE del arreglo. Para el ejemplo, el resultado esperado es `{ 5, 3, 2, 2, 8, 4, 1, 1 }`.
2. Implementá `int[] descomprimir(int[] rle)` que reconstruye el arreglo original a partir de su codificación RLE.
3. Verificá que `descomprimir(comprimir(original))` produce un arreglo igual a `original`.
4. ¿Qué pasa si el arreglo original está vacío? ¿Y si tiene un solo elemento?

> `comprimir` combina dos patrones: uno para detectar cuándo cambia el valor (similar a "verificar si está ordenado") y otro para contar cuántos consecutivos hay. ¿Podés identificarlos antes de escribir el código?

---

### C2. Competencia con desempate

En una competencia de programación, cada participante resolvió una serie de problemas. Cada problema tiene un puntaje y un tiempo de resolución en segundos. En caso de empate en puntaje, gana quien haya tardado menos tiempo en total.

```java
public class Participante {
    private String nombre;
    private int[] puntajes;
    private int[] tiempos;  // tiempo en segundos por problema

    public Participante(String nombre, int[] puntajes, int[] tiempos) {
        this.nombre = nombre;
        this.puntajes = puntajes;
        this.tiempos = tiempos;
    }
}
```

**Tareas:**

1. Implementá `int puntajeTotal()` y `int tiempoTotal()`.
2. Implementá `boolean superaA(Participante otro)` considerando el desempate por tiempo: gana quien tenga más puntaje; si empatan en puntaje, gana quien tenga menos tiempo.
3. Implementá en la clase `Competencia` el método `Participante ganador()` usando `superaA`.
4. Implementá `Participante[] rankingParcial(int umbralPuntaje)` que devuelve los participantes con puntaje total mayor al umbral, en el orden en que aparecen.

> En el ítem 3, ¿el patrón de "hallar máximo" funciona directamente si reemplazás la comparación numérica por `superaA`? ¿Qué hay que cambiar en la estructura?

---

### Auto-diagnóstico

**1.** En `comprimir`, ¿cómo sabés cuántos elementos va a tener el arreglo resultado antes de recorrer el original? ¿Podés saberlo, o necesitás una estrategia distinta?

> Si no podés responderla: no podés saberlo de antemano sin recorrer el arreglo primero. Una estrategia es hacer dos pasadas: una para contar los grupos y otra para llenar el resultado. Otra es sobredimensionar el resultado y llevar un índice de escritura, igual que en el patrón de filtrado.

**2.** En `superaA` con desempate, ¿podés expresar la lógica completa con un solo `return` usando operadores lógicos? ¿O es más claro con `if`?

> Si no tenés una respuesta clara: `return puntajeTotal() > otro.puntajeTotal() || (puntajeTotal() == otro.puntajeTotal() && tiempoTotal() < otro.tiempoTotal())` es correcto pero denso. Ambas formas son válidas; la legibilidad importa tanto como la corrección.

---

## Parte D: Desafío

En esta sección se propone un problema más abierto que integra los micro patrones trabajados a lo largo de la guía. El foco está en diseñar una estrategia propia, combinar patrones no trivialmente y razonar sobre los casos borde.

### D1. Análisis de una serie temporal

Una serie temporal es un arreglo de valores numéricos registrados en intervalos regulares de tiempo (por ejemplo, el precio de una acción por día).

```java
double[] precios = {
    100.0, 102.5, 98.0, 105.0, 110.0,
    107.5, 115.0, 112.0, 120.0, 118.0,
    125.0, 122.5, 130.0, 128.0, 135.0
};
```

Implementá la clase `SerieTemporal` con las siguientes operaciones:

1. `double variacion(int i)` - variación entre el elemento `i` y el anterior (`precios[i] - precios[i-1]`).
2. `int diasEnAlza()` - cantidad de días donde el precio subió respecto al anterior.
3. `int diasEnBaja()` - ídem para días donde bajó.
4. `int rachaMaximaAlza()` - cantidad máxima de días consecutivos en alza.
5. `double rendimientoTotal()` - variación porcentual entre el primer y el último precio.
6. **Desafío:** `int mejorMomentoDeCompra()` - índice del día en que conviene comprar para maximizar la ganancia si se vende en el último día. ¿Qué patrón usás?

> Para `rachaMaximaAlza`, llevá dos contadores: uno para la racha actual y otro para la máxima encontrada hasta el momento. ¿Qué micro patrones reconocés ahí?

---

### Auto-diagnóstico

**1.** En `rachaMaximaAlza`, ¿qué pasa si los precios son siempre decrecientes? ¿Qué devuelve el método?

> Si no podés responderla: si nunca hay un día en alza, la racha actual nunca supera cero y el máximo tampoco. El método debería devolver `0`.

**2.** Para `mejorMomentoDeCompra`, ¿alcanza con buscar el mínimo del arreglo? ¿O hay casos donde el mínimo no es el mejor momento de compra?

> Si te cuesta: si el mínimo aparece *después* del último precio, comprar ahí no es rentable porque no hay días futuros para vender. El mejor momento de compra es el mínimo considerando solo los elementos anteriores al último.

---
