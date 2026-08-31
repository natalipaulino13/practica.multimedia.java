# Gestor Multimedia — Java (POO + Interfaces)

Práctica del módulo Programación (DAW). Gestor multimedia desarrollado en **Java** utilizando **Programación Orientada a Objetos, herencia, clases abstractas e interfaces**.

## Enunciado

El programa permite gestionar diferentes tipos de contenidos multimedia.

Los contenidos disponibles son:

* Películas
* Podcasts
* Cursos online

Todos los contenidos comparten una serie de características básicas:

* ID
* Título
* Año
* Si es contenido premium

Además, dependiendo del tipo de contenido, pueden ser:

* **Reproducibles**
* **Descargables**

El programa permite registrar contenidos en memoria y realizar diferentes operaciones sobre ellos.

Se dispone de **3 huecos** para almacenar contenidos.

## Clases

### Contenido

Clase abstracta que representa el contenido multimedia genérico.

Contiene los atributos comunes:

* ID
* Título
* Año
* Premium

Además, proporciona el método:

```java
ficha()
```

que muestra la información básica del contenido.

Al ser una clase abstracta, define dos métodos que deben implementar las clases hijas:

```java
public abstract double costeMensual();

public abstract void mostrarDetalle();
```

### Pelicula

Clase que hereda de `Contenido` e implementa las interfaces:

```text
Reproducible
Descargable
```

Sus atributos específicos son:

* Director
* Duración en minutos
* Calidad en GB

Permite reproducir y descargar la película.

El tamaño de la película se calcula convirtiendo los GB a MB:

```java
return this.calidadGB * 1024;
```

El coste mensual depende de si es premium:

```text
Premium: 6.99 € + calidadGB * 0.25
No premium: 3.99 € + calidadGB * 0.25
```

### Podcast

Clase que hereda de `Contenido` e implementa:

```text
Reproducible
```

Sus atributos específicos son:

* Anfitrión
* Número de episodios
* Duración por episodio

Permite reproducir el podcast.

La duración total se calcula mediante:

```java
episodios * duracionMinPorEpisodio * 60
```

El coste mensual es:

```text
Premium: 4.99 € + episodios * 0.05
No premium: 0.00 € + episodios * 0.05
```

### CursoOnline

Clase que hereda de `Contenido` e implementa:

```text
Descargable
```

Sus atributos específicos son:

* Plataforma
* Horas
* Materiales en MB

Permite descargar el curso.

El tamaño de la descarga corresponde al valor de los materiales almacenados en MB.

El coste mensual es:

```text
Premium: 9.99 € + (materialesMB / 1024) * 0.20
No premium: 5.99 € + (materialesMB / 1024) * 0.20
```

## Interfaces

### Reproducible

Define el comportamiento de los contenidos que pueden reproducirse.

Métodos:

```java
public void reproducir();

public int duracionSegundos();
```

La implementan:

* `Pelicula`
* `Podcast`

### Descargable

Define el comportamiento de los contenidos que pueden descargarse.

Métodos:

```java
public double tamanyoMB();

public void descargar();
```

La implementan:

* `Pelicula`
* `CursoOnline`

## Clase Main

La clase `Main` contiene el programa principal y gestiona los diferentes contenidos.

Utiliza tres variables de tipo `Contenido`:

```java
static Contenido contenido1 = null;
static Contenido contenido2 = null;
static Contenido contenido3 = null;
```

Estos tres objetos representan los **3 huecos disponibles** para almacenar contenidos.

El programa utiliza polimorfismo para trabajar con diferentes tipos de contenido mediante referencias de tipo `Contenido`.

## Menú

```text
---GESTOR MULTIMEDIA---
1.-Crear/registrar contenido
2.-Mostrar ficha
3.-Mostrar detalle
4.-Reproducir
5.-Descargar
6.-Calcular coste mensual
7.-Vaciar hueco
0.-Salir
```

## Funcionalidades

### 1. Crear / registrar contenido

Permite registrar un contenido en uno de los tres huecos disponibles.

Primero se solicita:

```text
Hueco (1-3)
```

Después se selecciona el tipo:

```text
Tipo (1=Pelicula, 2=Podcast, 3=Curso)
```

A continuación se solicitan los datos correspondientes al tipo de contenido.

#### Película

Se solicitan:

* ID
* Título
* Año
* Premium
* Director
* Duración
* Calidad en GB

#### Podcast

Se solicitan:

* ID
* Título
* Año
* Premium
* Anfitrión
* Número de episodios
* Duración por episodio

#### Curso online

Se solicitan:

* ID
* Título
* Año
* Premium
* Plataforma
* Horas
* Materiales en MB

El contenido creado se guarda en el hueco seleccionado.

### 2. Mostrar ficha

Permite seleccionar uno de los tres huecos y mostrar la información básica del contenido.

Utiliza el método:

```java
contenido.ficha();
```

Ejemplo:

```text
pel01 - Matrix(1999) Premium=true
```

Si el hueco está vacío:

```text
Hueco vacío
```

### 3. Mostrar detalle

Muestra información más completa del contenido almacenado.

Utiliza el método abstracto:

```java
contenido.mostrarDetalle();
```

Cada tipo de contenido muestra sus propios datos.

Ejemplo para una película:

```text
[PELÍCULA] pel01 - Matrix(1999) Premium=true
Director: Lana Wachowski
Duración: 136 min
Tamaño aprox.: 8.0 GB.
```

### 4. Reproducir

Permite reproducir un contenido si implementa la interfaz `Reproducible`.

El programa utiliza `instanceof` para comprobar si el contenido se puede reproducir:

```java
if (contenido instanceof Reproducible)
```

Los contenidos reproducibles son:

* Películas
* Podcasts

También muestra la duración en segundos.

Si el contenido no es reproducible:

```text
Este contenido no es reproducible.
```

### 5. Descargar

Permite descargar un contenido si implementa la interfaz `Descargable`.

Se comprueba mediante:

```java
if (contenido instanceof Descargable)
```

Los contenidos descargables son:

* Películas
* Cursos online

También muestra el tamaño de la descarga en MB.

Si el contenido no es descargable:

```text
Este contenido no es descargable.
```

### 6. Calcular coste mensual

Calcula el coste mensual del contenido seleccionado.

Utiliza el método:

```java
contenido.costeMensual();
```

Este método es abstracto en `Contenido` y cada clase hija realiza su propio cálculo.

El resultado se redondea a dos decimales:

```java
Math.round(coste * 100.0) / 100.0
```

Ejemplo:

```text
Coste mensual: 7.99 €
```

### 7. Vaciar hueco

Permite eliminar el contenido almacenado en uno de los tres huecos.

Se solicita:

```text
Hueco (1-3)
```

y se establece el contenido del hueco a `null`.

Ejemplo:

```text
Hueco 2 vaciado.
```

### 0. Salir

Finaliza la ejecución del programa.

Mensaje mostrado:

```text
Saliendo del gestor...
```

## Ejemplo de ejecución

```text
---GESTOR MULTIMEDIA---
1.-Crear/registrar contenido
2.-Mostrar ficha
3.-Mostrar detalle
4.-Reproducir
5.-Descargar
6.-Calcular coste mensual
7.-Vaciar hueco
0.-Salir

Elige una opción: 1

Hueco (1-3): 1

Tipo (1=Pelicula, 2=Podcast, 3=Curso): 1

ID: P01
Título: Matrix
Año: 1999
Premium (s/n): s

Director: Lana Wachowski
Duración(min): 136
Calidad(GB): 8

Contenido guardado en hueco 1.
```

Ejemplo de reproducción:

```text
Hueco (1-3): 1

Reproduciendo película: Matrix...
Duración (segundos): 8160
```

Ejemplo de descarga:

```text
Hueco (1-3): 1

Descargando película Matrix (8192.0 MB)...
Tamaño (MB):8192.0
```

Ejemplo de coste:

```text
Hueco (1-3): 1

Coste mensual: 8.99 €
```

## Estructura de clases

```text
📦 paq1
 ├── 📜 Contenido.java
 ├── 📜 Pelicula.java
 ├── 📜 Podcast.java
 ├── 📜 CursoOnline.java
 ├── 📜 Reproducible.java
 └── 📜 Descargable.java

📦 paq
 └── 📜 Main.java
```

## Relación entre clases

```text
                 ┌─────────────────────┐
                 │      Contenido      │
                 │     <<abstract>>    │
                 └──────────┬──────────┘
                            │
             ┌──────────────┼──────────────┐
             │              │              │
             ▼              ▼              ▼
       ┌───────────┐  ┌───────────┐  ┌─────────────┐
       │ Pelicula  │  │  Podcast  │  │ CursoOnline │
       └─────┬─────┘  └─────┬─────┘  └──────┬──────┘
             │              │               │
             │              │               │
       ┌─────▼─────┐  ┌─────▼─────┐   ┌─────▼──────┐
       │Reproducible│  │Reproducible│   │Descargable │
       └────────────┘  └────────────┘   └────────────┘
             │
             │
       ┌─────▼──────┐
       │Descargable │
       └────────────┘
```

## Conceptos utilizados

* Java
* Programación Orientada a Objetos (POO)
* Herencia
* Polimorfismo
* Clase abstracta
* Métodos abstractos
* Interfaces
* `instanceof`
* Casting
* Encapsulación
* Constructores
* Getters y setters
* Sobrescritura de métodos (`@Override`)
* `ArrayList`
* `Scanner`
* `System.out.println`
* Tipos primitivos
* Cálculos matemáticos
* Gestión de objetos en memoria

## Polimorfismo

El programa utiliza una referencia de tipo:

```java
Contenido contenido
```

que puede almacenar diferentes objetos:

```java
new Pelicula(...)
new Podcast(...)
new CursoOnline(...)
```

Esto permite utilizar los métodos comunes definidos en `Contenido` sin necesidad de conocer previamente el tipo concreto del objeto.

Por ejemplo:

```java
contenido.costeMensual();
contenido.mostrarDetalle();
```

Cada clase proporciona su propia implementación.

## Interfaces y `instanceof`

Para comprobar si un contenido tiene determinadas funcionalidades se utilizan interfaces.

Para reproducir:

```java
if (contenido instanceof Reproducible) {
    Reproducible repro = (Reproducible) contenido;
    repro.reproducir();
}
```

Para descargar:

```java
if (contenido instanceof Descargable) {
    Descargable descarga = (Descargable) contenido;
    descarga.descargar();
}
```

De esta forma, una película puede ser **reproducible y descargable**, un podcast solamente **reproducible** y un curso online solamente **descargable**.

## Almacenamiento

Los contenidos se mantienen en memoria mediante tres variables:

```java
contenido1
contenido2
contenido3
```

No se utiliza una base de datos ni un fichero para guardar los contenidos de forma permanente.

Al cerrar el programa, los contenidos registrados se pierden.

## Autor

[Nataly Github](https://github.com/natalipaulino13) — DAW 2025/2026

