package example.repository;


import example.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("personJPADAO")
public interface PersonJPADAO extends JpaRepository<Person, Integer>
{
    // @Query(name = "Person.findByUsername")
    @Query(value = "select p from Person p where upper(p.username) like upper(:name)")
    public List<Person> findByUsername(@Param("name") String name);
}
