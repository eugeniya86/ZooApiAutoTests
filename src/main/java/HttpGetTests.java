import org.junit.Test;
import org.springframework.http.HttpStatus;
import org.springframework.web.client.HttpClientErrorException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class HttpGetTests extends HttpTest {

    @Test
    public void check_pet_id_equals() {
        String petId = "10";
        try {
            Pet pet = httpGetPet(petId);
            System.out.println("pet received");

            assertNotNull(pet);
            assertEquals(pet.id(), petId);
        } catch (HttpClientErrorException exception) {
            System.out.println("http error " + exception.getMessage());
        }

    }

    @Test
    public void check_method_not_allowed() {
        String petId = "";
        try {
            httpGetPet(petId);
        } catch (HttpClientErrorException exception) {
            System.out.println("http error " + exception.getMessage());
            HttpStatus statusCode = exception.getStatusCode();
            int httpStatusCode = statusCode.value();
            assertEquals(httpStatusCode, 405);
        }
    }
}
