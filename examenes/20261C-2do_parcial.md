# Segundo Parcial A - Mayo 2026

## Ejercicio 1 { estructuras de control }
La `NaveDeAtaque` está en una posición de origen. En cierta direccion, y a una distancia desconocida se encuentra una nave enemiga; en otra direccion, pero a una distancia de 10 pasos se encuentra un asteroide.

1. Dibujar el escenario
2. Realizar un método que destruya la nave enemiga y el asteroide, y vuelva al mismo punto de partida.

```java
void mision(NaveDeAtaque nave, Direccion direccionNaveEnemiga, Direccion direccionAsteroide)
```

## Ejercicio 2 { lógica }
En una bóveda el acceso se bloquea si: hay clave errónea o cerradura forzada, y además falla la huella biométrica; o, en cambio, si el sensor de movimiento está activo.

*Variables:* claveErronea, cerraduraForzada, huellaOk, sensorMovimiento.  

1. Escribir la expresión booleana de bloquearAcceso.
2. Definir autorizarAcceso como su negación y aplicar Leyes de De Morgan hasta eliminar negaciones externas a paréntesis.
3. Realizar la tabla de verdad para ambos casos

**Ejercicio 3 { teoría }**  
Según el texto de Pete Goodliffe, ¿qué distingue a un programador excelente y qué implica que el código "le importe"? (Seleccionar todas las correctas). *Opciones:*

a. El dominio de algoritmos complejos y el estándar del lenguaje garantizan la creación de un buen software.  
b. La actitud profesional prioriza la legibilidad para el equipo por sobre el lucimiento individual.  
c. El gran código es una artesanía que requiere cuidado, rechazando la improvisación y la suerte.  
d. El aprendizaje de nuevos lenguajes debe aplicarse siempre de inmediato para modernizar el código.  
e. El compromiso con la calidad exige crear código claramente correcto en lugar de algo que solo "parezca funcionar".  
f. La regla del Boy Scout obliga a reescribir desde cero cualquier módulo que no sea comprensible.

# Segundo Parcial B - Mayo 2026

## Ejercicio 1 { estructuras de control }
La `NaveDeAtaque` está en una posición de orígen. Hacia el NORTE hay una fila de asteroides infranqueables. Inmediatamente detrás de esa fila y tres casilleros al OESTE de la posición de origen, hay un ítem de combustible.

1. Dibujar el escenario.
2. Realizar un método que destruya un asteroide, obtenga el ítem y vuelva al mismo punto de partida.

```java
void mision(NaveDeAtaque nave)
```

## Ejercicio 2 { lógica }
Asociar cada descripción con uno de los siguientes operadores: `AND`, `OR`, `NOT`, `XOR`.  

a. Invierte completamente el valor de verdad recibido.  
b. El resultado será verdadero únicamente cuando ambas afirmaciones lo sean.  
c. El resultado será verdadero solo cuando las afirmaciones tengan valores distintos.  
d. El resultado será verdadero cuando al menos una afirmación sea verdadera.

Explicar brevemente por qué corresponde cada operador. Realizar las tablas de verdad correspondientes. Ejemplificar.

**Ejercicio 3 { teoría }**  
Completar los espacios. Justificar y ejemplificar:

a. La estructura de control ******** consiste en resolver un problema reconociendo que coincide con otro problema (a menudo de naturaleza más general) para el cual ya se conoce una solución.  
b. La estructura de control ******** consiste en dividir el conjunto de situaciones iniciales posibles, K, en dos o más dominios disjuntos, de modo que resulte más fácil resolver el problema por separado en cada uno de esos dominios.  
c. La estructura de control ********, es la estrategia de resolver el problema sobre un subconjunto (posiblemente trivial) de su dominio y extender la solución repetidamente hasta cubrir todo el dominio.  
d. Puede aplicar la estructura de control ******** si encuentra un objetivo intermedio I tal que ambos problemas nuevos sean más simples que el original (alcanzar G directamente desde K): alcanzar I desde K; y alcanzar G desde I.

# Segundo Parcial C - Mayo 2026

## Ejercicio 1 { estructuras de control }
La `NaveDeAtaque` está en la base. Al OESTE de ésta y a una distancia desconocida, existe una secuencia vertical (de NORTE a SUR) de asteroides. No se conoce la longitud de la secuencia, pero se sabe que en dirección SUR, entre los asteroides (como parte de la secuencia) hay un hueco. Al OESTE del mismo, a una distancia desconocida existe un item que la nave necesita para regresar a la base; delante del ítem hay una nave enemiga impidiendo el acceso.

1.  Dibujar el escenario.  
2.  Implementar la misión para que la nave la cumpla y regrese a la base.

```java
void mision(NaveDeAtaque nave)
```

## Ejercicio 2 { lógica }
El sistema de enfriamiento de emergencia de un reactor nuclear se activa si: la temperatura es crítica o la presión supera el límite, y además el sistema de bombeo manual no está operando; o, alternativamente, si se detecta una fuga de refrigerante.

*Variables:* `tempCritica`, `presionExcedida`, `bombeoManualOk`, `fugaDetectada`.  

1. Escribir la expresión booleana para `activarEmergencia`.  
2. Definir operacionNormal como la negación de activarEmergencia. Aplicar las Leyes de De Morgan hasta que no queden negaciones fuera de los paréntesis.  
3. Realizar la tabla de verdad para ambos casos

**Ejercicio 3 { teoría }**   
Analizar el siguiente diseño de subrutinas y responder:  

```java
void calcular() {
    int total = 100;
    duplicar(total);
    mostrar(total);
}
void duplicar(int n) {
    n = n * 2;
}
void mostrar(int valor) {
    System.out.println(valor);
}
```

1. Si al ejecutar `calcular()`, la consola muestra `100` y no `200`. ¿Cuál es el problema? ¿Por qué?  

a. Los parámetros actuales no están correctamente vinculados a los parámetros formales.  
b. La subrutina `duplicar` no devuelve el resultado; el cambio en el parámetro `n` es local y no afecta a la variable `total`.  
c. El ámbito de la variable `total` es global, por lo que no debería pasarse como parámetro.  
d. Falta una subrutina intermedia que coordine el paso de datos entre `duplicar` y `mostrar`.
