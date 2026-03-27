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
