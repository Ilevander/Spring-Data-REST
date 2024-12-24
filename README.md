I. Project Objective
• Use the Spring Data Rest starter to expose a model via the Rest architecture.
• Use Spring Data JPA to generate CRUD methods.
• Use the H2 database.
• Configure the OpenAPIi version 3 API to make your web service understandable to everyone.
• Use the Swagger interface to test your web service.

II. Prerequisites
• IntelliJ IDEA ;
• JDK version 17 ;
• An Internet connection to allow Maven to download the libraries.
• Postman to perform the tests.

NB: This project was carried out with IntelliJ IDEA 2023.2.3 (Ultimate Edition).
III. What is Spring Data Rest
• Spring Data REST is part of the Spring Data project and facilitates the creation of "hypermedia-driven REST" web services.
• Spring Data REST relies on Spring Data repositories, analyzes the domain model of your application and exposes HTTP resources for the aggregates contained in the model.
• Among the features provided by Spring Data Rest:
◦ Exposes a REST API for your model class using HAL (Hypertext Application Language) as the media type.
◦ Exposes collections and associations representing your model.
◦ Supports pagination via navigation links.
◦ Currently supports JPA, MongoDB, Neo4j and Cassandra.

• The official website of Spring Data Rest is https://spring.io/projects/spring-data-rest.
◦ Several samples are available on the official website: https://spring.io/projects/spring-data-rest#samples.

IV. Developing the WS with Spring Data Rest

• We will develop a web service that allows to perform CRUD operations on the articles contained in an H2 database.
