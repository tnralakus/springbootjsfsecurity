package example.controller;

import com.google.common.base.Preconditions;
import lombok.Getter;
import lombok.Setter;
import example.model.Person;
import example.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import java.io.Serializable;
import java.util.List;

@Controller
@Scope("view")
public class PersonController implements Serializable
{
    @Getter
    @Setter
    private List<Person> personList;

    @Setter
    @Autowired
    private PersonService personService;

    @Getter
    @Setter
    private String username;

    @PostConstruct
    public void init()
    {
        personList = personService.findAllPersonList();
    }

    public String editSelectedPerson(int id)
    {
        return "/secure/person.xhtml?faces-redirect=true&id=" + id;
    }

    public String deletePerson(int id)
    {
        personService.deletePerson(id);
        return "/secure/personList.xhtml?faces-redirect=true";
    }

    public void search()
    {
        Preconditions.checkNotNull(username, "Enter a keyword!!!");
        personList = personService.findByUsername(username);
    }

}