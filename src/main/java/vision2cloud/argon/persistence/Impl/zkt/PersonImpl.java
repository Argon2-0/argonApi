package vision2cloud.argon.persistence.Impl.zkt;

import com.google.gson.Gson;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import vision2cloud.argon.model.zkt.Person;
import vision2cloud.argon.model.zkt.ResponsePerson;
import vision2cloud.argon.persistence.zkt.PersonPersistence;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URISyntaxException;
import java.util.Date;
import java.util.Objects;

@Service("PersonImpl")
public class PersonImpl implements PersonPersistence {
    private String basicUri = "https://v2cbloc-biosec-02.eastus2.cloudapp.azure.com:8098/api/";
    private String token = "7A7CBAA816F05D6CCE07803766B5E9E0FAB6ACCB3B2DFB8CCC3FE490F987C2FC";
    private String accLevelId = "8a8080887dc2880f017e06d4c68e2b05";
    private String dptCode = "16";

    private HttpHeaders CreateHttpHeaders() {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(org.springframework.http.MediaType.APPLICATION_JSON);
        return httpHeaders;
    }

    @Override
    public Object create(Person person) throws URISyntaxException {
        try {
            person.setAccLevelIds(accLevelId);
            person.setDeptCode(dptCode);
            System.out.println(new Date());
            System.out.println("GrabarPerson");
            final Gson gson = new Gson();
            final String pedido = gson.toJson(person);
            System.out.println(pedido);
            RestTemplate restTemplate = new RestTemplate();
            String urlTemplate = basicUri + "person/add?access_token=7A7CBAA816F05D6CCE07803766B5E9E0FAB6ACCB3B2DFB8CCC3FE490F987C2FC";
            System.out.println("A grabar");
            HttpEntity<?> httpEntity = new HttpEntity<>(pedido, CreateHttpHeaders());
            ResponseEntity<String> response = restTemplate.postForEntity(urlTemplate, httpEntity, String.class);
            System.out.println("grabo");
            System.out.println(response);
            return true;
            //return response.getBody();
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public Person get(String pin) throws URISyntaxException {
        try {
            System.out.println("GrabarPerson");
            final Gson gson = new Gson();
            RestTemplate restTemplate = new RestTemplate();
            HttpEntity<?> requestEntity = new HttpEntity<>(CreateHttpHeaders());

            String urlTemplate = UriComponentsBuilder.fromHttpUrl(basicUri + "person/get/"+pin)
                    .queryParam("access_token", token)
                    .encode()
                    .toUriString();
            System.out.println(urlTemplate);
            ResponseEntity<ResponsePerson> response = restTemplate.exchange(
                    urlTemplate, HttpMethod.GET, requestEntity, ResponsePerson.class);
            Person person = Objects.requireNonNull(response.getBody()).getData();
            System.out.println("A grabar");
            System.out.println("grabo");
            System.out.println(person);
            //return response.getBody();
            return person;
        }
        catch (Exception e){
            System.out.println(e.getMessage()); ;
        }
        return null;
    }
}
