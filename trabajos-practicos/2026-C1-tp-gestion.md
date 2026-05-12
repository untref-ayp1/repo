# Trabajo Práctico: Sistema de Gestión Académica

_Modelado de datos y algoritmos en Java_:

- **Materia**: Algoritmos y Programación I
- **Carrera**: Ingeniería en Computación
- **Institución**: Universidad Nacional de Tres de Febrero (UNTREF)
- **Lenguaje**: Java 17+ (Eclipse / Terminal)
- **Modalidad**: Grupal

> **¿Por qué Java y Terminal?**
>
> Dominar la terminal y el compilador `javac` permite entender el ciclo de vida del software.
> Java nos obliga a ser estrictos con los tipos de datos y la gestión de memoria (**Stack** y **Heap**).

---

## 1. Introducción y Universo del Problema

Este Trabajo Práctico propone integrar los conceptos de la cursada en una aplicación realista: un **Sistema de Gestión Académica (SGA)** para una universidad ficticia. El objetivo es modelar entidades como "Alumnos", "Docentes" y "Comisiones", implementando operaciones de **CRUD** (ABML) y algoritmos de búsqueda y ordenamiento, todo esto gestionando la memoria de forma explícita.

### 1.1. Consigna del Dominio

Cada grupo debe elegir un "universo" para su sistema. Los "Alumnos" y "Docentes" del **SGA** pueden ser reemplazados por "Aprendices de Mago" y "Mentores" (Hogwarts), "Súper Héroes" y "Entrenadores" (Umbrella Academy), o cualquier otro dominio que respete la lógica de **Objetos** y su **Comportamiento**. Pueden dejar volar su imaginación.

---

## 2. Estructura de Entregas (Cronograma)

El Trabajo Práctico se desarrollará por **incrementos** (o fases), por lo que irá evolucionando a medida que pasen las clases.

Se espera que los grupos vayan consultando con sus tutores las dudas necesarias.

| **Entrega**       | **Fecha / Hito** | **Alcance** | **Modalidad**                        |
| ----------------- | ---------------- | ----------- | ------------------------------------ |
| **Entrega 1**     | Clase 14         | Fase 1      | Virtual - Sin exposición (con tutor) |
| **Entrega 1**     | Clase 22         | Fase 2      | Virtual - Sin exposición (con tutor) |
| **Entrega Final** | Semana 14           | Fase 3      | Presencial - Exposición oral         |

### 2.1. El Ciclo de Vida de los Datos: CRUD (ABML)

Uno de los pilares de este Trabajo Práctico es la implementación de operaciones **CRUD** (acrónimo del inglés: _Create, Read, Update, Delete_). En español, se refiere a ellas como **ABML** (_Alta, Baja, Modificación, Lectura_):

- **Alta (Create)**: Agregar un nuevo elemento a la base de datos o sistema.
- **Baja (Delete)**: Eliminar el elemento del sistema, gestionando correctamente la referencia `null` en el mismo.
- **Modificación (Update)**: Editar datos existentes del elemento (por ejemplo, actualizar el promedio de un alumno).
- **Lectura (Read)**: Visualizar la información almacenada de forma individual o listada.

---

## 3. Fases del Desarrollo

### 3.1. Fase 1: Operaciones CRUD y Lógica

> Este **incremento** incluye los temas vistos hasta la Clase 14 sin incluir.

El foco está en la manipulación de los **Tipos de Datos Abstractos (TAD)**:

#### 3.1.1 Entidades Principales

En base al universo elegido, las clases deben ser equivalentes a lo presentado.

- **Entidades**: Implementar dos clases principales (equivalentes a `Alumno` y `Docente`) y una clase contenedora (equivalente a `Comision`).
- **Encapsulamiento**: Todos los atributos deben ser `private`. Los métodos deben dividirse en **consultas** (_getters_) y **comandos** (_setters_).
- **Gestión de Memoria Estática**: Uso obligatorio de **arreglos nativos** (**no** se permite `ArrayList` o equivalentes).
- **Lógica de Negocio**: El "Alta" debe validar condiciones (por ejemplo, si la inscripción está abierta y hay cupo disponible).

##### Clase `Alumno`

Representa a los estudiantes:

- `nombre`: Debe normalizarse en el constructor (por ejemplo: "juan perez" -> "Juan Perez").
- `legajo`: Debe ser un número entero único.
- `promedio`: Debe ser un valor de punto flotante para mérito académico.

##### Clase `Docente`

Representa al cuerpo académico:

- `nombre`.
- `catedra`.
- `antiguedad` (en años).

##### Clase `Comision`

Es el núcleo del sistema:

- Contiene un arreglo de `Alumno[]` con un cupo máximo definido al instanciarla.
- Contiene un arreglo de `Docente[]`.
- `abierta`: Atributo booleano que indica si se permiten nuevas inscripciones.

### 3.2. Fase 2: Algoritmos, Arreglos y Pruebas

> Este **incremento** incluye los temas vistos hasta la Clase 22 sin incluir.

El foco está en la incorporación de lógica algorítmica y validación mediante **Diseño por Contrato**.

La forma de implementación tendría pequeñas variaciones según el universo elegido (por ejemplo, un identificador, un criterio, etc).

- **Búsqueda Lineal**: Para localizar elementos por un identificador único.
- **Ordenamiento**: Implementar el algoritmo **BubbleSort** para listar elementos por un criterio de mérito.
- **Arreglos Bidimensionales**: Implementar un cronograma o matriz de asignación.
- **Pruebas Unitarias**: Es obligatorio testear con **JUnit** la lógica de las clases, tanto en los casos felices como los casos que no deberían pasar. Algunos ejemplos son:
  - **Tests de Alta**: Verificar que no se supere el cupo máximo.
  - **Tests de Baja**: Asegurar que el `Alumno` (o su equivalente) ya no exista en el arreglo después de eliminarlo.
  - **Tests de Ordenamiento**: Validar la jerarquía de promiedos.

### 3.3. Fase 3: Gestión de Memoria y Defensa (Final)

> Este último **incremento** incluye los últimos temas vistos.

El foco está en el refinamiento de las fases anteriores y la presentación oral del trabajo práctico.

> Esta etapa es la más importante, debido a que tanto el grupo como los alumnos individualmente, deberán demostrar no solo que el sistema funciona, si no que entienden lo que hace, y cómo funciona.

- **Snapshot de Memoria**: Presentar un diagrama que identifique qué elementos residen en el **Stack** (referencias locales) y cuáles en el **Heap** (instancias de objetos y arreglos).
- **Estado de Referencias**: Representar gráficamente el estado de una referencia tras una **Baja** (uso de `null`).

---

## 4. Interfaz de Usuario y Ejecución

Para facilitar la corrección con los tutores, el programa se ejecutará mediante un menú interactivo en la **terminal** dado por la cátedra (PENDIENTE), permitiendo la interacción directa con el **SGA** mediante el compilador `javac` y la máquina virtual de **Java**.

El programa tendrá el siguiente menú interactivo:

```output
╔═══════════════════════════════════════╗
║      SGA - Gestión Académica UNTREF   ║
╠═══════════════════════════════════════╣
║ 1. Alta de Alumno (Inscripción)       ║
║ 2. Baja de Alumno (Por Legajo)        ║
║ 3. Modificación (Editar Alumno)       ║
║ 4. Leer Datos de Alumno Específico    ║
║ 5. Listar Alumnos (Ordenados)         ║
║ 6. Asignar Cronograma (Arreglo 2D)    ║
║ 7. Ver Snapshot de Memoria            ║
║ 0. Salir                              ║
╚═══════════════════════════════════════╝
```

---

## 5. Puntos Extra (Camino a la Excelencia)

Para los alumnos que busquen aprender algo más, se les propone los siguientes módulos, los cuales están
ordenados por dificultad:

- **Herencia**: Crear una clase `Persona` y heredar de ella para `Alumno` y `Docente`.
- **Polimorfismo**: Implementar un método `obtenerIdentificacion()` que devuelva el Legajo para alumnos y
  la Cátedra para docentes.
- **Git/GitHub**: Entregar el TP en un repositorio con un `README.md` bien documentado y mensajes de
  commits descriptivos.
- **TDD (Test Driven Development)**: Demostrar mediante el historial de Git que los tests se escribieron
  antes que la funcionalidad.

> **¡IMPORTANTE!**  
> Los módulos **NO** son parte del contenido de la materia, sino que servirán para aprender a trabajar como programador, así como son cosas que se ven en la carrera.
> Los cuatro temas son cosas para buscar por cuenta propia en caso de querer implementarlos, no restará puntos el no aplicarlos, pero en caso de hacerlo y quedar incompleto, puede afectar al TP.
> En caso de mostrar interés por estos temas, se puede consultar al respecto para recibir guía.

---

## 6. Criterios de Evaluación y Entrega

| **Criterio**   | **Insuficiente (recursa)**       | **Regular (cursada)**                   | **Bien (promoción)**                        | **Sobresaliente (por la gloria)**                       |
| -------------- | ---------------------- | ----------------------------- | ------------------------------- | ----------------------------------- |
| **POO**        | No usa bien las clases | Clases sin encapsular         | Uso correcto de clases y `this` | Uso de Herencia/Polimorfismo        |
| **Entorno**    | Solo usa el IDE        | Compila pero con errores      | Uso fluido de `javac`/`java`    | Script de automatización            |
| **AMBL**       | No implementa bajas    | Baja/Modificación con errores | AMBL completo y validado        | AMBL con lógica de negocio compleja |
| **Algoritmos** | No busca ni ordena     | Ordenamiento inestable        | Algoritmos correctos            | Uso de TDD y optimización           |
| **Memoria**    | No entiende el Heap    | Diagrama incompleto           | Snapshot de memoria claro       | Explicación técnica de referencias  |
