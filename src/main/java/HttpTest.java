import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class HttpTest {

    private final RestTemplate restTemplate = new RestTemplate();

    protected Pet httpGetPet(String petId) {
        return restTemplate.getForObject("https://petstore.swagger.io/v2/pet/" + petId, Pet.class);
    }

    protected ResponseEntity<Pet> httpPostPet(Pet pet) {
        return restTemplate.postForEntity("https://petstore.swagger.io/v2/pet", pet, Pet.class);
    }

    protected void httpDeletePet(String petId) {
        restTemplate.delete("https://petstore.swagger.io/v2/pet/" + petId);
    }
}
