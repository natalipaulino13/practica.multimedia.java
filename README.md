# 🔷 Gestor Multimedia — Java

![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge\&logo=openjdk\&logoColor=white)
![POO](https://img.shields.io/badge/POO-Programación%20Orientada%20a%20Objetos-4CAF50?style=for-the-badge)
![Interfaces](https://img.shields.io/badge/Interfaces-POO-2196F3?style=for-the-badge)

Práctica del módulo de **Programación del ciclo de Desarrollo de Aplicaciones Web (DAW)**.

Proyecto desarrollado en **Java** para gestionar diferentes tipos de contenidos multimedia mediante **Programación Orientada a Objetos (POO)**, herencia, clases abstractas e interfaces.

El programa permite registrar **películas, podcasts y cursos online**, mostrar sus características, reproducir o descargar contenidos y calcular su coste mensual.

---

## 🎯 Objetivo del proyecto

El objetivo principal es practicar los fundamentos de la **Programación Orientada a Objetos en Java**, trabajando con:

* Clases y objetos.
* Herencia.
* Polimorfismo.
* Clases abstractas.
* Métodos abstractos.
* Interfaces.
* Encapsulación.
* Sobrescritura de métodos.
* Constructores.
* Métodos `get` y `set`.
* Uso de `instanceof` y casting.
* Gestión de objetos en memoria.

---

## 🎬 Contenidos multimedia

El programa trabaja con tres tipos de contenidos:

* 🎥 **Películas**
* 🎙️ **Podcasts**
* 🎓 **Cursos online**

Todos heredan de la clase abstracta:

```java
Contenido
```

Cada contenido dispone de información común:

* ID.
* Título.
* Año.
* Si es premium.

Además, cada tipo de contenido incorpora sus propias características.

| Contenido    | Características                 |
| ------------ | ------------------------------- |
| Película     | Director, duración y calidad    |
| Podcast      | Anfitrión, episodios y duración |
| Curso online | Plataforma, horas y materiales  |

---

## 🧩 Interfaces

El proyecto utiliza dos interfaces para definir funcionalidades específicas:

### 🔊 Reproducible

Define los contenidos que pueden reproducirse.

```java
reproducir()
duracionSegundos()
```

La implementan:

* 🎥 Película.
* 🎙️ Podcast.

### 📥 Descargable

Define los contenidos que pueden descargarse.

```java
tamanyoMB()
descargar()
```

La implementan:

* 🎥 Película.
* 🎓 Curso online.

Una película puede implementar **ambas interfaces**, mientras que un podcast solamente es reproducible y un curso online solamente es descargable.

---

## 🧬 Herencia y polimorfismo

La estructura principal del proyecto parte de la clase abstracta:

```text
             Contenido
            /    |     \
           /     |      \
    Pelicula  Podcast  CursoOnline
```

Las diferentes clases heredan los atributos y métodos comunes de `Contenido` y proporcionan su propia implementación de los métodos abstractos.

Los contenidos se almacenan mediante referencias de tipo:

```java
Contenido contenido
```

Esto permite utilizar **polimorfismo** con diferentes tipos de contenido.

---

## 💾 Gestión de contenidos

El programa dispone de **tres huecos** para almacenar contenidos:

```java
contenido1
contenido2
contenido3
```

El usuario puede registrar un contenido en cualquiera de ellos.

Los contenidos se mantienen únicamente **en memoria**, por lo que al cerrar el programa se pierde la información registrada.

---

## ⚙️ Funcionalidades

El menú principal permite realizar las siguientes operaciones:

1. ➕ Crear y registrar contenido.
2. 📋 Mostrar ficha.
3. 🔎 Mostrar detalle.
4. ▶️ Reproducir contenido.
5. 📥 Descargar contenido.
6. 💰 Calcular coste mensual.
7. 🗑️ Vaciar un hueco.
8. 🚪 Salir.

Al reproducir o descargar un contenido, el programa comprueba si implementa la interfaz correspondiente mediante `instanceof`.

Por ejemplo:

```java
if (contenido instanceof Reproducible)
```

o:

```java
if (contenido instanceof Descargable)
```

---

## 💶 Coste mensual

Cada tipo de contenido calcula su coste mensual de forma diferente mediante el método abstracto:

```java
costeMensual()
```

Por ejemplo, el coste de una película depende de:

* Si es premium.
* Su calidad en GB.

El resultado se redondea a dos decimales.

---

## 📦 Estructura del proyecto

```text
📦 paq1
 ┣ 📜 Contenido.java
 ┣ 📜 Pelicula.java
 ┣ 📜 Podcast.java
 ┣ 📜 CursoOnline.java
 ┣ 📜 Reproducible.java
 ┗ 📜 Descargable.java

📦 paq
 ┗ 📜 Main.java
```

---

## 🧠 Conceptos utilizados

* ☕ Java.
* 🧩 Programación Orientada a Objetos (POO).
* 🧬 Herencia.
* 🔄 Polimorfismo.
* 🏛️ Clases abstractas.
* 📌 Métodos abstractos.
* 🔌 Interfaces.
* `instanceof` y casting.
* 🔒 Encapsulación.
* 🏗️ Constructores.
* 🔄 Métodos `get` y `set`.
* `@Override`.
* 📋 Gestión de objetos en memoria.
* 📝 `Scanner`.
* 🧮 Cálculos matemáticos.

---

## 👤 Autor

**Nataly Github** — DAW 2025/2026
