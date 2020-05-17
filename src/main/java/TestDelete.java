import org.junit.Test;
import org.springframework.http.HttpStatus;
import org.springframework.web.client.HttpClientErrorException;

import static org.junit.Assert.assertEquals;

public class TestDelete extends HttpTest {

    @Test
    public void check_delete_ok() {
        String petId = "12";
        Pet pet = PetCreator.fillBuilder()
                .setId(petId)
                .build();

        httpPostPet(pet);

        httpDeletePet(petId);

    }

    @Test
    public void check_delete_error() {
        String petId = "12";

        try {
            httpDeletePet(petId);
        } catch (HttpClientErrorException exception) {

        }
        try {
            httpDeletePet(petId);
        } catch (HttpClientErrorException exception) {
            System.out.println("http error " + exception.getMessage());
            HttpStatus statusCode = exception.getStatusCode();
            int httpStatusCode = statusCode.value();
            assertEquals(httpStatusCode, 404);
        }
    }
}
