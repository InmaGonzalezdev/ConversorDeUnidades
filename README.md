# Conversor de Unidades

Una aplicación Android sencilla e intuitiva para realizar conversiones entre diferentes unidades de medida. La aplicación permite convertir unidades de longitud, masa y temperatura a través de una interfaz limpia y moderna.

## 🚀 Características

*   **Pantalla de Bienvenida (Splash Screen):** Inicio fluido con una imagen personalizada.
*   **Selector de Categorías:** Pantalla principal con botones de opción (`RadioButtons`) para elegir el tipo de conversión.
*   **Conversiones Soportadas:**
    *   **Longitud:** Kilómetros a metros y viceversa.
    *   **Masa:** Kilogramos a gramos y viceversa.
    *   **Temperatura:** Celsius a Fahrenheit y viceversa.
*   **Persistencia de Datos:** Permite guardar el último resultado obtenido utilizando `SharedPreferences` para consultarlo más tarde.
*   **Gestión de Errores:** Validaciones integradas con avisos visuales (`AlertDialog`) si no se ingresan valores o no se selecciona una unidad.
*   **Interfaz Moderna:** Uso de `Edge-to-Edge` para aprovechar toda la pantalla, botones de borrado y recuperación de datos, y componentes de Material Design.
*   **Tipografía Personalizada:** Implementación de la fuente *Inter* para una mejor legibilidad.

## 🛠️ Tecnologías Utilizadas

*   **Lenguaje:** Java 11.
*   **Plataforma:** Android (SDK Mínimo: 24, SDK Objetivo: 36).
*   **Interfaz de Usuario:** XML Layouts con `ConstraintLayout` y Material Components.
*   **Gestor de Dependencias:** Gradle (Kotlin DSL).

## 📂 Estructura del Proyecto

El proyecto sigue la estructura estándar de una aplicación Android:

*   `app/src/main/java`: Contiene la lógica en Java (Activities, Helpers).
*   `app/src/main/res/layout`: Definición de las pantallas en XML.
*   `app/src/main/res/values`: Recursos de cadenas, colores, temas y estilos.
*   `app/src/main/res/font`: Fuentes personalizadas (Inter).

## 📸 Capturas de Pantalla

| Splash Screen | Menú Principal | Conversión | Gestión de Errores |
|:---:|:---:|:---:|:---:|
| ![Splash](app/screenshots/splash_screen.png) | ![Principal](app/screenshots/main_screen.png) | ![Conversión](app/screenshots/conversion_screen.png) | ![Aviso](app/screenshots/alert_screen.png) |
## 📦 Instalación y Uso

1.  Clona este repositorio.
2.  Abre el proyecto en **Android Studio**.
3.  Sincroniza el proyecto con los archivos Gradle.
4.  Ejecuta la aplicación en un emulador o dispositivo físico con Android 7.0 (API 24) o superior.

---
Desarrollado por **Inma González**.
