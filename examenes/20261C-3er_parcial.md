# Tercer Parcial A - Mayo 2026

## Ejercicio 1 { arrays, micro-patrones, contrato }
Se dispone de un array de objetos Libro, almacenado en la clase Estante. Un libro se considera destacado si:

* posee entre **min** y **max** páginas inclusive,  
* su cantidad de páginas es múltiplo de **k**,  
* y no tiene la menor cantidad de páginas del estante.

Implementar un método que determine si existe al menos un libro destacado.

**Requisitos:**

1. Resolver el problema utilizando subrutinas auxiliares.  
2. El método principal no debe contener condiciones compuestas complejas.  
3. Identificar todos los micro-patrones utilizados.  
4. Expresar pre y post condiciones de cada método.  
5. Documentar parámetros y valores de retorno.

**Aclaración:** La clase Libro tiene como atributos título:String y cantidadDePáginas:int, ambos accesibles mediante sus correspondientes *getters*. No es necesario programarla, se asume dada.

## Ejercicio 2 { sintaxis y semántica }
a. Escribir en sintaxis Java la siguiente sentencia:  
"Mientras el **colectivo** (de tipo **Colectivo**) tenga una cantidad de pasajeros menor a 30, se debe invocar el método **subirPasajero** pasándole como parámetro el primer pasajero de la cola, el cual se obtiene invocando el método **obtenerPrimero** sobre el objeto **colaDeEspera** (de tipo **Cola**). Al finalizar el ciclo, se debe cambiar el estado del colectivo invocando **cerrarPuertas**."

b. Escribir la semántica de cada línea del siguiente fragmento de código.  
c. Luego, escribir con tus palabras y en una frase la idea principal de lo que hace.

```java
int c = 0;
for (int i = 0; i < criaturas.length; i++) {
    if (criaturas[i].esPeligrosa())
        c++;
```

## Ejercicio 3 { teoría }
¿Es lo mismo encapsulamiento que ocultamiento de la información? Definir ambas y justificar su respuesta.

# Tercer Parcial B - Mayo 2026

## Ejercicio 1 { arrays, micro-patrones, contrato }
Se dispone de un array de objetos Criatura, almacenado en la clase Bestiario. Una criatura se considera despertable si cumple con dos condiciones:

* su nivel de poder es par  
* y su nivel de horror supera al promedio de horror de todo el bestiario.

Implementar un método que determine cuántas criaturas del bestiario son despertables.

**Requisitos:**

1. Resolver el problema utilizando subrutinas auxiliares.  
2. El método principal no debe contener condiciones compuestas complejas.  
3. Identificar todos los micro-patrones utilizados.  
4. Expresar pre y post condiciones de cada método.  
5. Documentar parámetros y valores de retorno.

**Aclaración:** La clase Criatura tiene como atributos nombre:String, nivelDePoder:int y nivelDeHorror:double, todos accesibles mediante sus correspondientes *getters*. No es necesario programarla, se asume dada.

## Ejercicio 2 { sintaxis y semántica }
a. Escribir en sintaxis Java la siguiente sentencia:  

"Si el objeto **invocador** (de tipo **Mago**) posee una cantidad de energía astral mayor o igual a 150, se debe invocar el método **realizarSacrificio** sobre el objeto **altar** (de tipo **Altar**), pasándole como parámetro la reliquia actual que se obtiene invocando **obtenerArtefacto** sobre el **mago**. En caso contrario, se debe alertar la falla invocando el método **desatarMaldicion** sobre el mismo **altar**."

b. Escribir la semántica de cada línea del siguiente fragmento de código.  
c. Luego, escribir con tus palabras y en una frase la idea principal de lo que hace.

```java
boolean x =  true;  
for (int i = 0; i < a.length; i+=2)  
    if (a1[i] != a2[i])  
        x = false;
```

## Ejercicio 3 { teoría }
Diferenciar los modificadores de acceso public y private. ¿Es cierto que no debe usarse nunca el modificador public? En ambos casos, justificar y ejemplificar.

# Tercer Parcial C - Mayo 2026

## Ejercicio 1 { arrays, micro-patrones, contrato }
Se dispone de un array de objetos Artefacto, almacenado en la clase CamaraSecreta. La clase Artefacto representa una reliquia y expone el método int getAntiguedad() que retorna su antigüedad en años. Debido a una maldición, solo se pueden inspeccionar los artefactos ubicados en las posiciones impares del array. Un artefacto se considera Sagrado si:

* su antigüedad está entre **min** y **max** años,  
* y además esa antigüedad es divisible por un factor **k**

Implementar un método que determine si existen al menos dos artefactos sagrados entre las posiciones evaluadas.

**Requisitos:**

1. Resolver el problema utilizando subrutinas auxiliares.  
2. El método principal no debe contener condiciones compuestas complejas.  
3. Identificar todos los micro-patrones utilizados.  
4. Expresar pre y post condiciones de cada método.  
5. Documentar parámetros y valores de retorno.

## Ejercicio 2 { sintaxis y semántica }

a. Escribir en sintaxis Java la siguiente sentencia:
"Mientras el **monstruo** (de tipo **Criatura**) se encuentre consciente (lo cual se verifica invocando el método **estaConsciente**), se debe invocar el método **recibirDaño** sobre el objeto **monstruo** pasándole como parámetro el valor de ataque del héroe actual, el cual se obtiene invocando **getFuerza** sobre el objeto **paladin** (de tipo **Heroe**). Al salir del bucle, se debe actualizar el entorno invocando **destruirMazmorra** sobre el objeto **paladin**."

b. Escribir la semántica de cada línea del cuerpo de la siguiente función, que recibe `int[]` a como parámetro  
b. Escribir con tus palabras y en una frase la idea principal de lo que hace.

```java
boolean e = true;  
for (int i = 0; i < a.length / 2; i++)  
    if (a[i] != a[a.length - 1 - i])  
        e = false;
```

## Ejercicio 3 { teoría }
Explicar brevemente (< 30 palabras c/u) y ejemplificar las siguientes palabras reservadas:

* public
* void
* return
* class
* new
