package example.service;

import example.model.Person;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: TTTALAKUS
 * Date: 28.05.2015
 * Time: 08:53
 * To change this template use File | Settings | File Templates.
 */
public interface PersonService
{
    public void saveOrUpdatePerson(Person person);

    public void deletePerson(int id);

    public List<Person> findAllPersonList();

    public Person findPersonById(int id);

    public List<Person> findByUsername(String username);

}
