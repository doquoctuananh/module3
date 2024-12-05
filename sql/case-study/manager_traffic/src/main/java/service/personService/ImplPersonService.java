package service.personService;

import model.Person;
import repository.personRepository.ImplPersonRepository;

import java.util.List;

public class ImplPersonService implements IPersonService{
    private ImplPersonRepository personRepository = new ImplPersonRepository();
    @Override
    public Person findPersonById(int id) {
        Person person =null;
        person = personRepository.findPersonById(id);
        return person;
    }

    @Override
    public List<Person> showAllPersons() {
        List<Person> personList = personRepository.showAllPersons();
        return personList;
    }

    @Override
    public boolean createPerson(Person province) {
        boolean result = false;
        result = personRepository.createPerson(province);
        return result;
    }

    @Override
    public boolean updatePerson(Person person) {
        boolean result = false;
        result = personRepository.updatePerson(person);
        return result;
    }

    @Override
    public boolean deletePerson(int id) {
        boolean result = personRepository.deletePerson(id);
        return result;
    }
}
