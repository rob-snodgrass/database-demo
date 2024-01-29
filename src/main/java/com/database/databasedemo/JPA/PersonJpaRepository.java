package com.database.databasedemo.JPA;

import com.database.databasedemo.entity.Person;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository //also handle transactions
@Transactional
public class PersonJpaRepository {
    //connect to database
    @PersistenceContext
    EntityManager entityManager; //manages entities (duh), all operations preformed are stored in
                                // entity manager, and is the interface for persistence context

    public List<Person> findAll(){
        //instead of select *, you use java persistence query language (JPQL)
        //give the query a name and use it
        TypedQuery<Person> namedQuery = entityManager.createNamedQuery("find_all_persons",Person.class);
        return namedQuery.getResultList();
    }


    public Person findById(int id){
        return entityManager.find(Person.class, id);
    }

    public Person update(Person person){
        return entityManager.merge(person); //knows the ID, if it exists it updates, otherwise will insert it
    }

    public Person insert(Person person){
        return entityManager.merge(person); //the same as update, logic is the literal same
    }

    public void deleteById(int id){
        Person person = findById(id);
        entityManager.remove(person);
        System.out.println("Deleted " + person.getName() + " ID: " + person.getId());
    }
}
