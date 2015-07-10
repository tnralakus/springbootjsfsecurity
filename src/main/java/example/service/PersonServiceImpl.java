package example.service;

import lombok.Setter;
import example.model.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import example.repository.PersonJPADAO;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: TTTALAKUS
 * Date: 28.05.2015
 * Time: 08:41
 * To change this template use File | Settings | File Templates.
 */
@Service("personService")
public class PersonServiceImpl implements PersonService, Serializable
{
    private static final Logger logger = LoggerFactory.getLogger(PersonServiceImpl.class);

    @Setter
    @Resource(name = "personJPADAO")
    private PersonJPADAO personJPADAO;

    @Override
    public void saveOrUpdatePerson(Person person)
    {
        logger.debug("saveOrUpdatePerson");
        personJPADAO.save(person);
    }

    @Override
    public void deletePerson(int id)
    {
        logger.debug("deletePerson");
        Person person = findPersonById(id);
        personJPADAO.delete(person);
    }

    @Override
    public List<Person> findAllPersonList()
    {
        return personJPADAO.findAll();
    }

    @Override
    public Person findPersonById(int id)
    {
        return personJPADAO.findOne(id);
    }

    @Override
    public List<Person> findByUsername(String username)
    {
        return personJPADAO.findByUsername(username);
    }
}
