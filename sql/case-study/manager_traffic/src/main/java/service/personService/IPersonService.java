package service.personService;

import model.Person;

import java.util.List;

public interface IPersonService {
    Person findPersonById(int id);
    List<Person> showAllPersons();
    boolean createPerson(Person province);
    boolean updatePerson(Person province);
    boolean deletePerson(int id);
}
