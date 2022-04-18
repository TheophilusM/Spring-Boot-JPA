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
    - Native SQL query
    - JPQL query 
* JPA Annotations
    - @Query
    - @Repository
    - @Entity
    - @Param
    - @Transactional
    - @Modifying
* Name Parameter Values
* Relationships
    - One to One
    - One to Many
* Cascading
    - Pass information to parent element
* Fetch types on mapped tables
    - Lazy
    - Eager
* Uni & Bi directional mapping
* Optionality and Manditory relationship