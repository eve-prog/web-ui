package ro.sda.webui.person;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PersonService {
    private final List<Person> persons = new ArrayList<>();

    public PersonService(){
        persons.add(new Person("Andrei", 18));
        persons.add(new Person("Maria", 20));
        persons.add(new Person("Darius", 14));
    }
    public Person getFirstPerson(){
        return persons.get(0);
    }

    public Optional<Person> findByName(String name) {
        return persons.stream()
                .filter(p -> p.getName().toLowerCase().equals(name.toLowerCase()))
                .findFirst();
    }
}
