package ro.sda.webui.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import ro.sda.webui.person.Person;
import ro.sda.webui.person.PersonService;

import java.util.Optional;

//http://localhost:8080/person/first
@Controller
@RequestMapping("person")
public class PersonController {
    private final PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping("first")
    public ModelAndView showFirstPerson(){
        Person firstPerson = personService.getFirstPerson();

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("person.html");
        modelAndView.addObject("person", firstPerson);
        return modelAndView;
    }

    @GetMapping("demo")
    public String demo(){
        return "items.html";
    }

    //http://localhost:8080/person/first
    @GetMapping("search/{name}")
    public ModelAndView search(@PathVariable("name") String personName){
        ModelAndView modelAndView = new ModelAndView();
        Optional<Person> foundPerson = personService.findByName(personName);
        if(foundPerson.isPresent()){
            modelAndView.setViewName("person/person.html");
            modelAndView.addObject("person", foundPerson.get());
        }else{
            modelAndView.setViewName("person/unknown.html");
            modelAndView.addObject("name", personName);
        }
        return modelAndView;
    }

}
