[OK] La solución se debe escribir en Java.

[OK]• El motor de base de datos debe ser MySQL.
    > Es necesario probar localmente
        Crear el esquema SQL
            create database car_card;
        Setear en application.properties la clave de la base de datos

[OK]• Sentirse libre de hacer cualquier suposición que se necesite acerca de los campos requeridos, la forma de estructurar la data y las validaciones necesarias.

[FALTA]• La data debe ser persistente. Generar un lote de datos de al menos 50 registros.
    > Se agrega una colección de Postman
    > También en data.sql se cargan marcas de autos por defecto

[OK]• La solución deberá estar en un repositorio accesible para el colaborador de Temperie.

[OK]• Una vez finalizado se debe enviar al colaborador de Temperies un documento con
las suposiciones que se hicieron, qué es lo que se hizo y cómo ejecutar la solución.
    > Se realizaron validaciones sobre CarCardDTO que limitan el payload

[OK]• Adjuntar documentación de los endpoints de la API.

Requisitos deseables
Se evaluará si la resolución tiene los siguientes contenidos.
[FALTA]• Autenticación
    > falta implementar JWT con roles dentro del sistema.

[FALTA]• Filtros
    > falta hacer un filtro en el repositorio JPA con HQL o a traves de los nombres de los métodos.

[OK]• Paginado
    > se puede agregar el parametro page a /api/card/all
        /api/card/all?page=3

[FALTA]• Tests Unitarios
    > falta implementar con JUnit los test unitarios.
        También faltan test de integración con MockMvc

[FALTA]• Deploy de la API en un servicio Cloud (AWS, Azure, Google Cloud, etc.)
[FALTA]• Utilización de los servicios de AWS (API Gateway, EC2, ECS, EKS, S3, etc.)