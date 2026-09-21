# TP1 - Ejercicio Evento Universitario

Implementación del **Trabajo Práctico N.º 1** de Programación, desarrollado en **Java** utilizando conceptos fundamentales de **Programación Orientada a Objetos (POO)**.

El proyecto modela la organización de eventos universitarios, permitiendo crear eventos, asignar salas, agregar actividades e inscribir estudiantes.

## 📋 Descripción

El sistema representa un escenario de gestión de eventos universitarios.

Cada evento cuenta con información como:

- Identificador.
- Título.
- Costo base.
- Condición de gratuidad.
- Sala asignada.
- Actividades asociadas.

A su vez, las actividades permiten gestionar sus inscripciones y estudiantes participantes.

El programa principal (`App.java`) contiene un ejemplo de uso del sistema, donde se crean estudiantes y eventos, se asigna una sala, se agregan actividades y se realizan distintas inscripciones.

## 🛠️ Tecnologías utilizadas

- **Java**
- **Programación Orientada a Objetos**
- **IntelliJ IDEA** como entorno de desarrollo
- **Git / GitHub** para control de versiones

El proyecto está configurado como un módulo Java y utiliza la carpeta `src` como directorio de código fuente.

## 📁 Estructura del proyecto

```text
PP_TP1_50520/
│
├── .idea/
│
├── src/
│   ├── Actividad.java
│   ├── App.java
│   ├── Charla.java
│   ├── Estudiante.java
│   ├── EventoUniversitario.java
│   ├── Inscripcion.java
│   ├── Sala.java
│   └── Taller.java
│
├── .gitignore
└── Tp1_Ejercicio_Evento.iml
```

Las clases principales del dominio se encuentran dentro de `src/`, incluyendo `EventoUniversitario`, `Actividad`, `Estudiante`, `Inscripcion`, `Sala`, `Charla` y `Taller`.

## 🧩 Modelo del sistema

### EventoUniversitario

Representa un evento universitario y administra sus datos principales y actividades.

Entre sus responsabilidades se encuentran:

- Crear eventos.
- Generar identificadores.
- Administrar el costo base.
- Determinar si el evento es gratuito.
- Asignar una sala.
- Crear actividades.
- Mostrar la información del evento.
- Mantener un contador de eventos creados.

La clase utiliza además una variable estática para llevar el conteo de los eventos generados.

### Actividad

Representa una actividad que forma parte de un evento.

El sistema contempla distintos tipos de actividades, entre ellas:

- **Charlas**
- **Talleres**

Cada actividad puede administrar sus inscripciones y establecer un cupo máximo.

### Estudiante

Representa a un estudiante que puede participar en las actividades disponibles.

Los estudiantes son identificados mediante un código y un nombre.

### Inscripcion

Representa la relación entre un estudiante y una actividad.

Permite modelar la participación de los estudiantes en las distintas actividades del evento.

### Sala

Representa el espacio físico asignado a un evento.

### Charla y Taller

Son especializaciones de `Actividad` que permiten representar los diferentes tipos de actividades ofrecidas durante un evento.

## ▶️ Ejecución

### Requisitos

Para ejecutar el proyecto se necesita:

- **JDK** instalado.
- Un IDE compatible con Java, como IntelliJ IDEA, o un entorno que permita compilar y ejecutar proyectos Java.

### Desde IntelliJ IDEA

1. Clonar el repositorio:

```bash
git clone https://github.com/facufrau/PP_TP1_50520.git
```

2. Abrir el proyecto en IntelliJ IDEA.
3. Verificar que el proyecto utilice un JDK válido.
4. Abrir:

```text
src/App.java
```

5. Ejecutar el método `main`.

### Desde consola

Ubicándose en la raíz del proyecto:

```bash
javac -d out src/*.java
```

Luego:

```bash
java -cp out App
```

## 🧪 Ejemplo de funcionamiento

El programa de prueba crea una lista de estudiantes y varios eventos universitarios.

Por ejemplo, se crean estudiantes como:

- Lionel Messi
- Luis Scola
- Luciana Aymar
- Paula Pareto
- Emanuel Ginobili

También se crea un evento denominado **"Evento de Linux y Software Libre"**, al cual se le asigna una sala y se agregan actividades relacionadas con Linux y programación en Bash.

Entre las actividades creadas se encuentran:

```text
¿Qué es Linux?
Instalando Linux en Cloud
Usando la consola y programación en bash
```

Finalmente, se realizan las inscripciones de los estudiantes a las diferentes actividades y se muestran los datos del evento y el total de eventos creados.

## 🎯 Conceptos de POO aplicados

El proyecto permite poner en práctica diferentes conceptos de Programación Orientada a Objetos:

- **Clases y objetos**
- **Encapsulamiento**
- **Constructores**
- **Constructores copia**
- **Atributos y métodos**
- **Getters y setters**
- **Composición y relaciones entre objetos**
- **Herencia**
- **Polimorfismo**
- **Atributos y métodos estáticos**
- **Validación de datos**
- **Colecciones (`List` / `ArrayList`)**

Por ejemplo, `EventoUniversitario` mantiene una colección de actividades y utiliza un contador estático para registrar la cantidad de eventos creados.

## 📚 Objetivo académico

El objetivo del trabajo es aplicar los fundamentos de la Programación Orientada a Objetos mediante el desarrollo de un pequeño sistema de gestión de eventos universitarios.

El ejercicio busca reforzar el diseño de clases, las relaciones entre objetos, la reutilización de código y la implementación de reglas de negocio mediante métodos y atributos encapsulados.

## 👨‍💻 Autor

**Facundo Frau**

Repositorio:  
https://github.com/facufrau/PP_TP1_50520