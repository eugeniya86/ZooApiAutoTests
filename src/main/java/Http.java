import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class Http {

    private static final RestTemplate restTemplate = new RestTemplate();

    public static Pet getPet(String petId) {
        return restTemplate.getForObject("https://petstore.swagger.io/v2/pet/" + petId, Pet.class);
    }

    public static ResponseEntity<Pet> postPet(Pet pet) {
        return restTemplate.postForEntity("https://petstore.swagger.io/v2/pet", pet, Pet.class);
    }

    public static void deletePet(String petId) {
        restTemplate.delete("https://petstore.swagger.io/v2/pet/" + petId);
    }
}
