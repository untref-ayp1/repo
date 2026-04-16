# GLOGICA - Lógica
La guía está organizada en cuatro partes de dificultad creciente y se recomienda trabajarla de manera progresiva. La **Parte A (Fundamentos)** contiene ejercicios breves orientados a fijar las ideas básicas del tema; si aparecen dificultades aquí, conviene revisar la teoría antes de continuar. La **Parte B (Aplicación)** propone problemas más completos donde se ponen en práctica esas ideas. La **Parte C (Integración)** incluye ejercicios de mayor dificultad, similares a los que podrían aparecer en un parcial. Finalmente, la **Parte D (Desafío)** presenta un problema más abierto, pensado para quienes quieran profundizar.

Como referencia, la Parte A debería tomar aproximadamente 45–60 minutos, la Parte B alrededor de 1–1.5 horas, y la Parte C entre 1 y 1.5 horas. El Desafío es opcional y su tiempo puede variar. En total, se espera que la práctica requiera alrededor de 3 a 4 horas de trabajo. Como orientación para una buena preparación, se recomienda resolver todos los ejercicios de la Parte A y al menos tres ejercicios de las Partes B y C.

## Parte A: Fundamentos
En esta sección se ejercitan los conceptos básicos de la lógica booleana: operadores lógicos, evaluación de expresiones, negación y leyes fundamentales como De Morgan. El foco está en comprender cómo se construyen y evalúan las condiciones, incluyendo el comportamiento de la evaluación por cortocircuito, y en evitar errores frecuentes de interpretación.

### A1. Operadores y evaluaciones simples
¿Cuáles de los siguientes operadores no se aplican a las variables de tipo **boolean**? Justificar para cada caso.

* `&&`  
* `!`  
* `-`  
* `==`  
* `=`  
* `<=`

Indique el valor de verdad de las siguientes expresiones lógicas:

* `1 < 10`  
* `5 == 5`  
* `6 < 3`  
* `8 <= 8`  
* `800 == 80`  
* `25 != 52`  
* `!(5 < 8)`  
* `!(10 == 10)`  
* `!( !(4 > 8) )`

### A2. Evaluación por cortocircuito (I)
Identificar en las siguientes expresiones booleanas su valor de verdad y qué parte de la misma se ejecuta y qué parte no debido a la evaluación por cortocircuito (la evaluación por cortocircuito se produce cuando el resultado de la expresión completa es evidente).

```java
int primero = 5;  
int segundo = 10;  
int tercero = 20;
```

1. `6 > segundo && primero < 10`  
2. `6 > segundo && primero > 10`  
3. `12 > primero || segundo < tercero`  
4. `8 < tercero || tercero < 3`  
5. `(3 < primero && segundo >= 10) || (6 < segundo && tercero > primero)`  
6. `(6 > primero || segundo < 10) && (primero < tercero)`  
7. `! ((primero < segundo-6) && (4 + 8 < tercero))`

### A3. Leyes de De Morgan
Dada la siguiente expresión, reescribirla aplicando las leyes de De Morgan

`!(a && b) || !(b || c)`

### A4. Evaluación por cortocircuito (II)

Dadas las siguientes declaraciones:

```java
int numerador = 10;
int divisor = 0;
```

Analizar las siguientes expresiones:

- `divisor != 0 && (numerador / divisor > 2)`
- `(numerador / divisor > 2) && divisor != 0`
- `divisor == 0 || (numerador / divisor > 2)`

Para cada caso:

1. Indicar el valor de verdad de la expresión.
2. Indicar si ocurre o no un error en tiempo de ejecución.
3. Explicar qué parte de la expresión se evalúa y cuál no, y por qué.
4. Identificar en cuáles casos el uso del cortocircuito evita el error.

## Parte B: Aplicación
En esta sección se aplican los conceptos de lógica a situaciones más concretas, donde las expresiones booleanas modelan condiciones del mundo real. Se trabaja en la construcción, lectura y evaluación de expresiones más complejas, combinando múltiples variables y prestando especial atención al orden de evaluación y al significado de cada condición.

### B1. Construír la expresión booleana
A partir de las siguientes variables:

```java
boolean aproboPrimerParcial;
boolean aproboSegundoParcial;
boolean aproboTercerParcial;
boolean aproboCuartoParcial;
boolean aproboRecuperatorio1;
boolean aproboRecuperatorio2;
boolean aproboTrabajoPractico;
boolean aproboFinal;
```    

1. Escribir en lenguaje natural, paso a paso, cada condición intermedia que aparece en el enunciado.
2. Definir variables booleanas auxiliares para cada una de esas condiciones.
3. Construir la expresión booleana final utilizando esas variables.

### B2. Evaluación por cortocircuito (I)
Indique el valor de verdad de las siguientes expresiones lógicas considerando las declaraciones dadas a continuación. Señalar además qué partes de las expresiones no son ejecutadas debido a la evaluación por cortocircuito.

```java
int ganados = 50;
int perdidos = 26;
int empatados = 12;
boolean esGanador = (ganados > (perdidos + empatados));
boolean esRevelacion = (empatados > perdidos);
```

1. `!((esGanador && (perdidos != ganados)) || (esRevelacion && ! esGanador));`  
2. `!((ganados > empatados) || !((ganados > 25) && esRevelacion));`  
3. `esRevelacion || (( perdidos <= 20) && (ganados > 45));`  
4. `(perdidos > empatados) && (empatados > 10) && (perdidos <= 30);`  
5. `!(esRevelacion || (perdidos > 40) || (ganados < 20));`

### B3. Evaluaciones más complejas
Considerando las siguientes declaraciones e inicializaciones:

```java
int posicion = 12;
int maximo = 50;
int minimo = 1;
boolean fueEncontrado = false;
boolean enRango = (posicion <= maximo) && (posicion >= minimo);
boolean esRegular = (posicion >= 23);
```

Indicar el valor de verdad de las variables: `expresion1`, `expresion2`, `expresion3`, `expresion4`, `expresion5` y `expresionFinal`

```java
boolean expresion1;
expresion1 = !enRango || esRegular || (posicion == 12);
boolean expresion2;
expresion2 = (posicion > 0) && (maximo < 20) && esRegular;
boolean expresion3;
expresion3 = ((enRango && esRegular) || (! esRegular && !enRango)) && (posicion > 12);
boolean expresion4;
expresion4 = ! ((maximo > minimo) && (enRango || !esRegular)) && (fueEncontrado || enRango);
boolean expresion5;
expresion5 = !(!(!(fueEncontrado && enRango) || (esRegular && enRango)) && (posicion > minimo));
boolean expresionFinal;
expresionFinal = (((expresion5 && expresion2) || !expresion3)) && (expresion4 || !expresion1);
```

## Parte C: Integración
En esta sección se integran los distintos conceptos en problemas más desafiantes, similares a los de evaluación. El foco está en analizar expresiones complejas, razonar sobre precedencia de operadores, detectar errores de modelado lógico y reescribir condiciones para que reflejen correctamente un requerimiento dado.

### C1. Riesgo crediticio
Un banco utiliza una fórmula lógica para decidir si aprueba un crédito personal. El orden en que Java evalúa los símbolos es vital para que el banco no pierda dinero.

Analizar la siguiente línea de código y responda las preguntas:

```java
int sueldo = 1000;
int deuda = 500;
boolean esCliente = true;

boolean creditoAprobado = esCliente || sueldo - deuda > 800 && sueldo > 1500;
```

1. ¿Cuál es el valor de verdad de `creditoAprobado`?  
2. Indique el orden en que se evaluaron los operadores. ¿Qué se ejecutó primero?  
   * Opciones: La resta `-`, la comparación `>`, el `&&` o el `||`.  
3. El gerente del banco dice: "El crédito solo se debe dar si la persona es cliente, o tiene un sueldo neto (sueldo menos deuda) mayor a 800. Y además, en cualquiera de esos dos casos, el sueldo bruto debe ser mayor a 1500".  
   * ¿La expresión de arriba cumple con lo que pide el gerente?  
   * Si la respuesta es NO, reescribir la expresión para que refleje la voluntad del gerente.  
4. ¿Cómo cambia el resultado final con su nueva expresión?

### C2. Despegando
Un ingeniero debe programar la lógica que autoriza el despegue de un cohete. El sistema de control abortará la misión y el cohete **NO** despegará si ocurre **alguna de estas dos situaciones principales**:

#### Situación 1: Problema Técnico o de Control
* La presión de combustible es baja (menor a 150 psi), **O** la temperatura del motor es crítica (mayor a 2000°C).
* **Y ADEMÁS**, en el mismo momento, no se ha recibido la señal de "Listo" desde la torre de control.

#### Situación 2: Restricción Ambiental

* Existe una alerta de clima severo activa (esto cancela el despegue inmediatamente, sin importar el estado del cohete o la torre).

Consignas:
1. Escribir la expresión booleana para `boolean cancelarDespegue`. Utilizar paréntesis para separar claramente la "Situación 1" de la "Situación 2". *(Variables a usar: `int presion`, `int temperatura`, `boolean torreLista`, `boolean climaSevero`)*.

2. Por estándares de legibilidad, queremos reescribir la condición anterior a lógica positiva: `boolean autorizarDespegue`. Negar la expresión anterior y escribir la expresión resultante. Luego aplicar las **Leyes de De Morgan** para eliminar la negación externa. Mostrar el paso a paso hasta llegar a una expresión donde se verifiquen las condiciones en positivo.

3. La expresión obtenida para `autorizarDespegue` puede resultar difícil de leer:
    - Simplificar la expresión utilizando propiedades del álgebra booleana.
    - Indicar si la expresión resultante es equivalente a la original para todos los casos posibles.
    - Explicar brevemente si la versión simplificada mejora la legibilidad o no, y por qué.

## Parte D: Desafío
En esta sección se propone un problema más abierto que requiere manipulación avanzada de expresiones booleanas. Se trabaja con simplificación algebraica, razonamiento formal y análisis del comportamiento del sistema, incluyendo aspectos como cortocircuito y equivalencias lógicas. El objetivo es profundizar la comprensión y desarrollar precisión en el razonamiento.

### D1. El Sistema de Acceso del Laboratorio
En un laboratorio de investigación, el sistema de seguridad controla el acceso a tres zonas restringidas. Cada zona tiene su propia condición de apertura, programada por distintos desarrolladores a lo largo de los años. Antes de una auditoría, el equipo de seguridad necesita entender exactamente cómo se comporta el sistema — y si tiene fallas.

Las variables representan el estado de las credenciales del visitante:

- `admin`: tiene credenciales de administrador
- `bio`: tiene habilitación biológica
- `guest`: está registrado como visitante temporal
- `emergency`: hay una alerta de emergencia activa

#### Zona 1: Sala de Servidores

```java
boolean acceso = !(!admin || bio) || (!admin && guest) || (admin && !bio && !guest);
```

a) Simplificar la expresión usando **Leyes de De Morgan** y **álgebra booleana**, mostrando cada paso.

b) ¿Puede un visitante `guest` (sin ser `admin` ni tener `bio`) acceder a la sala? Justificar con la expresión simplificada, no con la original.

#### Zona 2: Laboratorio Biológico

El sistema evalúa el siguiente fragmento de código:

```java
boolean acceso = (admin || bio) && (!bio || !guest) && !(admin && !bio);
```

c) Simplificar la expresión. ¿A qué condición mínima equivale?

d) Un técnico afirma: "si tenés `bio`, siempre entrás". ¿Tiene razón? Identificar el contraejemplo si lo hay.

#### Zona 3: Centro de Control

Esta zona usa la siguiente evaluación, donde el orden de las condiciones importa:

```java
boolean acceso = !emergency && (admin || (bio && !guest)) && (!admin || bio);
```

e) El sistema usa cortocircuito. Si `emergency = true`, ¿qué subexpresiones se evalúan? ¿Cuáles no, y por qué?

f) Considerando cortocircuito, identificar para qué combinación de valores el sistema evita la mayor cantidad de evaluaciones. ¿Cuántas operaciones se ahorran respecto al peor caso?

g) Simplificar la expresión asumiendo `emergency = false` y determinar quiénes pueden acceder.

#### Integración final

h) Se quiere agregar una regla global:

> "durante una emergencia, solo los administradores con habilitación biológica pueden acceder a cualquier zona".

Reescribir las tres condiciones incorporando esta restricción de la forma más compacta posible.

i) ¿Es posible que las tres zonas sean accesibles simultáneamente para un mismo visitante (sin emergencia)? Si es así, encontrar los valores que lo permiten. Si no, demostrar por qué no.
