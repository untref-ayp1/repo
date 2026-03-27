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
