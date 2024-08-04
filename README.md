# Selenium Test Automation with Gradle

Este proyecto contiene una suite de pruebas automatizadas usando Selenium y Gradle.

## Requisitos previos

- Java Development Kit (JDK) 8 o superior
- Gradle 6.0 o superior
- Navegador web (Chrome, Firefox, etc.)
- [ChromeDriver](https://sites.google.com/a/chromium.org/chromedriver/) o [GeckoDriver](https://github.com/mozilla/geckodriver/releases) en tu PATH

## Configuración del proyecto

1. Clona este repositorio:
    ```sh
    git clone https://github.com/Duvan1725/Inlaze-Qa-scripts.git
    cd selenium-gradle
    ```

2. Asegúrate de que tienes todos los drivers necesarios descargados y ubicados en tu PATH. Por ejemplo, para ChromeDriver en Linux/Mac:
    ```sh
    mv chromedriver /usr/local/bin
    ```

## Estructura del proyecto

- `src/test/java`: Contiene los archivos de prueba escritos en Java.
- `build.gradle`: Archivo de configuración de Gradle.
- `drivers`: Carpeta opcional para almacenar los drivers del navegador (si no están en el PATH).

## Ejecución de pruebas

### 1. Configuración de dependencias

Asegúrate de que tu archivo `build.gradle` incluye las dependencias necesarias:

```groovy
plugins {
    id 'java'
}

repositories {
    mavenCentral()
}

dependencies {
    testImplementation platform('org.junit:junit-bom:5.9.1')
    testImplementation 'org.junit.jupiter:junit-jupiter'
    implementation group: 'org.seleniumhq.selenium', name: 'selenium-java', version: '4.23.0'
        implementation group: 'io.github.bonigarcia', name: 'webdrivermanager', version: '5.9.1'
}

test {
    useTestNG()
}
