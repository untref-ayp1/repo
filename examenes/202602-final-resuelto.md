# Final - Febrero 2026

## Ejercicio único { arreglos, objetos, subrutinas, contrato }
Una `Librería` tiene una gran pared llena de libros. Esto puede modelarse con un array bidimensional `Libro[][] libros`, donde cada fila representa un estante y cada columna será un libro. Esta Librería tiene la peculiar cualidad de que cada estante tiene la misma cantidad de libros.

Un libro, puede ya estar leído o no, y se sabe la cantidad de páginas que tiene. 

Se nos pide que informemos si leímos el porcentaje de páginas (pasado por parámetro) de todos los libros.

```java
public boolean leiPorcentajeDePaginas(double porcentajeLeido)
```

> **Ejemplo:**  
Imaginá una librería con dos estantes, cada uno con dos libros. En el primero hay un libro de 100 páginas leído y uno de 200 sin leer. En el segundo, uno de 50 páginas leído y uno de 150 sin leer.  
En total son 500 páginas, de las cuales leímos 150, es decir un 30%. Si nos preguntan si leímos al menos el 25%, la respuesta es `true`, porque aunque no leímos los libros más grandes, la suma de páginas leídas igual supera el umbral pedido.

Cuestiones que se evaluarán:

1. Uso de arrays/matrices  
2. Uso de objetos y su debido encapsulamiento  
3. Uso de subrutinas  
4. Implementación de un método propio  
5. Documentación de pre y post-condiciones  
6. Manejo de la ruptura del contrato mediante errores

Se asume que existe la clase Libro, con los métodos:

```java
public boolean estaLeido()  
public int cantidadDePaginas()
```

Se deberá crear dos métodos auxiliares dentro de Libreria uno que calcule la cantidad de páginas leídas y otro con la cantidad total de páginas de los libros en ese estante (ver debajo).

```java
public class Libro {
  // ...
  private int cantPaginas = 0;
  private boolean leido = false;
  // ...
  public int cantidadDePaginas() {
    return this.cantPaginas;
  }
  public boolean estaLeido() {
    return this.leido;
  }
}

public class Libreria {
  private Libro[][] libros;
  // ...
  private int cantPaginasTotalesEnEstante(int estante){
    // completar
  }
  private int cantPaginasLeidasEnEstante(int estante){
    // completar
  }
  // ...
  public boolean leiPorcentajeDePaginas(double porcentajeLeido) {
    // completar
  }
}
```

---

> [!CAUTION]
> La solución del examen se presenta a continuación.  
> Se recomienda intentar resolverlo previamente sin consultarla.

<details>
  <summary>Ver solución</summary>

```java
public class Libreria {
  private Libro[][] libros;

  /**
   * Calcula el total de páginas en un estante dado.
   * @pre estante >= 0 && estante < libros.length
   * @post retorna la suma de páginas de todos los libros del estante
   */
  private int cantPaginasTotalesEnEstante(int estante) {
    int total = 0;
    for (int col = 0; col < libros[estante].length; col++) {
      total += libros[estante][col].cantidadDePaginas();
    }
    return total;
  }

  /**
   * Calcula las páginas leídas en un estante dado.
   * @pre estante >= 0 && estante < libros.length
   * @post retorna la suma de páginas de los libros leídos en el estante
   */
  private int cantPaginasLeidasEnEstante(int estante) {
    int leidas = 0;
    for (int col = 0; col < libros[estante].length; col++) {
      if (libros[estante][col].estaLeido()) {
        leidas += libros[estante][col].cantidadDePaginas();
      }
    }
    return leidas;
  }

  /**
   * Informa si la proporción de páginas leídas supera el umbral dado.
   * @pre porcentajeLeido >= 0.0 && porcentajeLeido <= 100.0
   * @pre libros != null && libros.length > 0
   * @post retorna true si (paginasLeidas / paginasTotales * 100) >= porcentajeLeido
   * @throws Error si porcentajeLeido está fuera del rango [0, 100]
   * @throws Error si la librería no tiene libros cargados
   */
  public boolean leiPorcentajeDePaginas(double porcentajeLeido) {
    if (porcentajeLeido < 0.0 || porcentajeLeido > 100.0) {
      throw new Error(
        "El porcentaje debe estar entre 0 y 100. Se recibió: " + porcentajeLeido
      );
    }
    if (libros == null || libros.length == 0) {
      throw new Error("La librería no tiene libros cargados.");
    }

    int totalPaginas = 0;
    int totalLeidas = 0;

    for (int estante = 0; estante < libros.length; estante++) {
      totalPaginas += cantPaginasTotalesEnEstante(estante);
      totalLeidas  += cantPaginasLeidasEnEstante(estante);
    }

    if (totalPaginas == 0) {
      throw new Error("La librería no tiene páginas cargadas.");
    }

    double porcentajeReal = (totalLeidas * 100.0) / totalPaginas;
    return porcentajeReal >= porcentajeLeido;
  }
}
```
Se destaca:
- **Subrutinas auxiliares.** `cantPaginasTotalesEnEstante` y `cantPaginasLeidasEnEstante` recorren cada columna del estante recibido, delegando la lógica de acumulación fuera del método principal.
- **Método principal.** `leiPorcentajeDePaginas` sólo orquesta: valida, itera estantes llamando a las auxiliares, y compara el porcentaje real contra el umbral.
- **Contrato.** Las pre y postcondiciones están documentadas en los `@pre/@post`, y las roturas del contrato se manejan con Error (parámetro inválido o estado interno inválido).
- **División por cero.** Se verifica que `totalPaginas > 0` antes de dividir, cubriendo el caso borde de una librería con libros de 0 páginas.

Cumple con las consignas ya que:
La solución recorre `libros[][]` mediante índices de `fila` y `columna` (1), accediendo a cada celda solo a través de los métodos públicos `estaLeido()` y `cantidadDePaginas()` sin tocar los atributos privados (2), delegando el cálculo de páginas totales y leídas a dos subrutinas privadas auxiliares (3) que son invocadas desde el método principal `leiPorcentajeDePaginas` (4), el cual está documentado con `@pre` y `@post` junto a las auxiliares (5), y lanza `Error` ante un porcentaje fuera de rango, o si la librería está vacía o sin páginas (6).

</details>