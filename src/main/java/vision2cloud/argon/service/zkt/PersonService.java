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

@Service("PersonService")
public class PersonService {
    @Autowired
    @Qualifier("PersonImpl")
    PersonImpl personImpl;
    public Object create(Person person) throws URISyntaxException {
        LocalDate ld = LocalDate.now();
        System.out.println(ld);
        person.setAccStartTime(Timestamp.valueOf(ld.atStartOfDay()).toString());
        person.setAccEndTime(Timestamp.valueOf(ld.plusDays(1).atStartOfDay()).toString());
        if(person.getEmail().equals("")){
            person.setEmail("123@zkt.com");
        }
        System.out.println(Timestamp.valueOf(ld.atStartOfDay()).toString());
        System.out.println(Timestamp.valueOf(ld.plusDays(1).atStartOfDay()).toString());
        return personImpl.create(person);
    }

    public Object update(String pin) throws URISyntaxException {

        Person person = personImpl.get(pin);
        System.out.println(person.toString());
        LocalDateTime ldt = LocalDateTime.now();
        LocalDate ld = LocalDate.now();
        String nextDay = Timestamp.valueOf(ld.plusDays(1).atStartOfDay()).toString().split("\\.")[0];
        String now = String.valueOf(ldt).split("\\.")[0].replace("T", " ");
        System.out.println(ld);
        System.out.println(ldt);
        System.out.println(nextDay);

        if(person.getAccEndTime().equals(nextDay)){
            person.setAccEndTime(now);
        }
        else {
            person.setAccEndTime(nextDay);
        }

        return personImpl.create(person);
    }
}
