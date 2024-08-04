package ua.Ivan.springcourse.DAO;

import org.springframework.stereotype.Component;
import ua.Ivan.springcourse.Model.Person;

import java.util.ArrayList;
import java.util.List;

@Component
public class PersonDAO {
    private static int PEOPLE_COUNT;
    private List<Person> people;

    {
        people = new ArrayList<>();

        people.add(new Person(++PEOPLE_COUNT, "Lox"));
        people.add(new Person(++PEOPLE_COUNT, "Kaka"));
        people.add(new Person(++PEOPLE_COUNT, "Ronaldo"));
        people.add(new Person(++PEOPLE_COUNT, "Ronaldihno"));
    }

    public List<Person> index() {
        return people;
    }

    public Person show(int id) {
        return people.stream().filter(person -> person.getId() == id).findAny().orElse(null);
    }
    public void save(Person person) {
        person.setId(++PEOPLE_COUNT);
        people.add(person);
    }
    public void update(int id, Person updatedPerson) {
        Person personToUpdate = show(id);
        personToUpdate.setName(updatedPerson.getName());
    }

}