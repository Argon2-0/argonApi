package vision2cloud.argon.service.zkt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import vision2cloud.argon.model.zkt.Person;
import vision2cloud.argon.persistence.Impl.zkt.PersonImpl;

import java.net.URISyntaxException;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

@Service("PersonService")
public class PersonService {
    @Autowired
    @Qualifier("PersonImpl")
    PersonImpl personImpl;
    public Object create(Person person) throws URISyntaxException {
        if(person.getAccStartTime().isEmpty() || person.getAccEndTime().isEmpty()){
            LocalDate ld = LocalDate.now();
            System.out.println(ld);
            person.setAccStartTime(Timestamp.valueOf(ld.atStartOfDay()).toString());
            person.setAccEndTime(Timestamp.valueOf(ld.plusDays(1).atStartOfDay()).toString());
        }
        else
            person.setAccStartTime(Timestamp.valueOf(new Timestamp(Long.parseLong(person.getAccStartTime())).toLocalDateTime().minusHours(5)).toString());{
            person.setAccEndTime(Timestamp.valueOf(new Timestamp(Long.parseLong(person.getAccEndTime())).toLocalDateTime().plusDays(1).minusHours(5)).toString());
        }
        if(person.getEmail().isEmpty()){
            person.setEmail("123@zkt.com");
        }
        return personImpl.create(person);
    }

    public Object update(String pin, String estado) throws URISyntaxException {

        System.out.println("---------------------------------------");
        System.out.println("updatePrestamoService");
        System.out.println("---------------------------------------");
        Person person = personImpl.get(pin);
        System.out.println("---------------------------------------");
        System.out.println(person.toString());
        System.out.println("---------------------------------------");
        LocalDateTime ldt = LocalDateTime.now();
        LocalDate ld = LocalDate.now();
        String nextDay = Timestamp.valueOf(ld.plusDays(1).atStartOfDay()).toString().split("\\.")[0];
        String now = String.valueOf(ldt).split("\\.")[0].replace("T", " ");
        System.out.println(ld);
        System.out.println(ldt);
        System.out.println(nextDay);

        if(estado.equals("Préstado")){
            person.setAccEndTime(now);
        }
        else {
            person.setAccEndTime(nextDay);
        }

        return personImpl.create(person);
    }

    public Object createMasive(ArrayList<Person> persons) throws URISyntaxException {
        try {
            for (Person person : persons) {
                person.setAccStartTime(Timestamp.valueOf(new Timestamp(Long.parseLong(person.getAccStartTime())).toLocalDateTime().minusHours(5)).toString());
                person.setAccEndTime(Timestamp.valueOf(new Timestamp(Long.parseLong(person.getAccEndTime())).toLocalDateTime().plusDays(1).minusHours(5)).toString());
                if (person.getEmail().equals("")) {
                    person.setEmail("123@zkt.com");
                }
                personImpl.create(person);
            }
            return true;
        }
        catch (Exception e) {
            return false;
        }
    }
}
