package example.controller;

import example.model.Person;
import example.service.PersonService;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;

import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;

@Controller
@Scope("view")
public class PersonDetailController
{
    @Setter
    @Autowired
    private PersonService personService;

    @Getter
    @Setter
    private Person selectedPerson;

    @PostConstruct
    public void init()
    {
        if (FacesContext.getCurrentInstance() != null && !FacesContext.getCurrentInstance().isPostback())
        {
            initializePerson();
        }
    }

    private void initializePerson()
    {
        java.util.Map<String, String> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        String id = params.get("id");
        if (StringUtils.isEmpty(id))
        {
            selectedPerson = new Person();
        }
        else
        {
            selectedPerson = personService.findPersonById(Integer.parseInt(id));
        }
    }

    public String saveOrUpdatePerson()
    {
        personService.saveOrUpdatePerson(selectedPerson);
        return "/secure/personList.xhtml";
    }
}
