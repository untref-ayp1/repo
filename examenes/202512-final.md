# Final - Diciembre 2025

## Ejercicio único { arreglos, objetos, subrutinas, contrato }
Una `EmbotelladoraDeAgua` tiene una gran pared llena de botellas. Esto puede modelarse con un array bidimensional `Botella[][] botellas`, donde cada fila representa un estante y cada columna será una botella. Esta `EmbotelladoraDeAgua` tiene la peculiar cualidad de que cada estante tiene la misma cantidad de `botellas`.

Una botella puede estar llena, parcialmente con agua o vacía. 

Se nos pide que informemos si el agua disponible alcanza para llenar todas las botellas.

```java
public boolean alcanzaElAguaDisponible(int aguaDisponible)
```

**Restricciones:**  
- 0 < estante < N  
- 0 < botella < M

Cuestiones que se evaluarán:

1. Uso de arrays/matrices  
2. Uso de objetos y su debido encapsulamiento  
3. Uso de subrutinas  
4. Implementación de un método propio  
5. Documentación de pre y post-condiciones  
6. Manejo de la ruptura del contrato mediante errores

Se asume que existe la clase Botella, con el método:

```java
public int aguaNecesariaParaLlenarla()
```

Se deberá crear un método auxiliar dentro de EmbotelladoraDeAgua que calcule el agua necesaria para llenar las botellas de un estante:

```java
private int aguaNecesariaEnEstante(int estante)
```

```java
public class Botella {
  // ...
  private int maxDeAgua = 0;
  private int cantAguaActual= 0;

  public Botella(int maxDeAgua, int cantAguaActual) {
    this.maxDeAgua = maxDeAgua;
    this.cantAguaActual = cantAguaActual;
  }
  // ...
  public int aguaNecesariaParaLlenarla() {
    return this.maxDeAgua - this.cantAguaActual ;
  }
}

public class EmbotelladoraDeAgua {
  private Botella[][] botellas;
  // ...
  private int aguaNecesariaEnEstante(int estante){
    // completar
  }
  // ...
  public boolean alcanzaElAguaDisponible(int aguaDisponible) {
    // completar
  }
}
```
