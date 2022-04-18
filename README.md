## **Spring Boot JPA**

## **Software stack**
* JPA
* Hibernate
* MySQL Server & Workbench
* Dependencies
    - Spring Data JPA
    - Lombok
    - MySQL Driver
    - Spring Web
    - Junit and Mockito
    
## **DB Structure Mapping**
* Student table
    - Guardian table
    - Course table
        - Teacher table
        - CourseMaterial table

* Constrains
* Repositories
    - Operations to deal with the entities
    - Uses a repository interface to extend JpaRepository
* Entity
* Repository
* Embedded entity - mapping primary entity to parent
* Custom JPA methods in repository