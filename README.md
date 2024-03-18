# English

## Project_Spark

This is a data processing project using Apache Spark and Scala. The project is structured in layers (Bronze, Silver, Gold) to process and transform data.

### Description

The aim of this project is to process large volumes of data using Apache Spark. The project is written in Scala and uses the layer model (Bronze, Silver, Gold) to process and transform data.

### Project Structure

The project is divided into several packages and classes:

- `org.example`: This is the main package of the application.
- `org.example.Logger.Logging`: This is the logging utility used by the application.
- `org.example.SessionBuilder.SparkSessionBuilder`: This is the utility used to build the Spark session.
- `org.example.constants.Exampleconst`: This contains the constants used by the application.
- `org.example.Layers`: This package contains the different layers (Bronze, Silver, Gold) through which the data is processed.

Each layer has a specific responsibility in the processing of data:

- Bronze Layer: This is the input layer where data is loaded in its original format.
- Silver Layer: In this layer, data is transformed and cleaned.
- Gold Layer: This is the final layer where data is prepared for analysis.

### Usage

To run the application, use the following command:

```bash
spark-submit --class org.example.App target/scala-2.11/spark-data-processing-application_2.11-1.0.jar
```

Note: Replace `target/scala-2.11/spark-data-processing-application_2.11-1.0.jar` with the path to your compiled JAR file.

### Requirements

- Apache Spark
- Scala

# Español


## Project_Spark

Este es un proyecto de procesamiento de datos utilizando Apache Spark y Scala. El proyecto está estructurado en capas (Bronce, Plata, Oro) para procesar y transformar los datos.

### Descripción

El objetivo de este proyecto es procesar grandes volúmenes de datos utilizando Apache Spark. El proyecto está escrito en Scala y utiliza el modelo de capas (Bronce, Plata, Oro) para procesar y transformar los datos.

### Estructura del Proyecto

El proyecto se divide en varios paquetes y clases:

- `org.example`: Este es el paquete principal de la aplicación.
- `org.example.Logger.Logging`: Esta es la utilidad de registro utilizada por la aplicación.
- `org.example.SessionBuilder.SparkSessionBuilder`: Esta es la utilidad utilizada para construir la sesión Spark.
- `org.example.constants.Exampleconst`: Aquí se encuentran las constantes utilizadas por la aplicación.
- `org.example.Layers`: Este paquete contiene las diferentes capas (Bronce, Plata, Oro) a través de las cuales se procesan los datos.

Cada capa tiene una responsabilidad específica en el procesamiento de los datos:

- Capa Bronce: Esta es la capa de entrada donde los datos son cargados en su formato original.
- Capa Plata: En esta capa, los datos son transformados y limpiados.
- Capa Oro: Esta es la capa final donde los datos son preparados para el análisis.

### Cómo usar

Para ejecutar la aplicación, usa el siguiente comando:

```bash
spark-submit --class org.example.App target/scala-2.11/spark-data-processing-application_2.11-1.0.jar
```

Nota: Reemplaza `target/scala-2.11/spark-data-processing-application_2.11-1.0.jar` con la ruta a tu archivo JAR compilado.

### Requisitos

- Apache Spark
- Scala
