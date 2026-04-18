# AP1 - Primer Parcial (Mayo 2025)

## Primer Parcial C1
### Ejercicio 1 { arrays }
[cite_start]Escribir un método en Java que reciba un array de decimales por parámetro, y devuelva otro array con la diferencia de cada elemento con el mayor del array original.

**Firma del método:**
```java
double[] diferenciaAlMaximo (double[] valores)
```

**Ejemplo:**
```java
[1.0, 3.0, 4.0, 8.5] -> [7.5, 5.5, 4.5, 0.0]
```


### Ejercicio 2 { código }

Reescribir el siguiente código, mejorando los nombres, agregando la documentación correspondiente (pre-condición, post-condición, parámetros y retorno), y simplificando el código:

```java
int x(int y, int z) {
    int w = y;
    for (int i = 0; i < z; i++)
        w = w + 1;
    return w;
}
```


### Ejercicio 3 { sintaxis, semántica }
**Escribir la sintaxis para:**
* **a.** Si la variable `x` contiene un valor mayor a diez se imprime por pantalla su valor, si no se incrementa en 1.
* **b.** Se envía el mensaje `comer` a un objeto referenciado por la variable `comensal`, enviándole como parámetro un nuevo objeto de tipo `Comida` pasándole como parámetro el String "lasagna".

**Describir la semántica para:**
* **c.** ```java Comida fideos = new Comida ("fideos"); ```
* **d.** ```java int suma = calculadora.sumar (10, 5); ```
* **e.** Escriba una sentencia válida en Java que tenga 6 elementos o más, y luego describa su semántica.


### Ejercicio 4 { lógica }
Aplicar las Leyes de De Morgan para transformar la siguiente expresión booleana. Luego, construir las tablas de verdad (señalando cortocircuitos) para verificar la equivalencia:

```java
puedeImprimir = tieneTinta && (!faltanHojas || !estaConectada)
```
