import org.junit.Test;
import org.springframework.http.HttpStatus;
import org.springframework.web.client.HttpClientErrorException;

import static org.junit.Assert.assertEquals;

public class TestDelete extends HttpTest {

    @Test
    // Проверка API на удаление животного по ID Test-3— PET
    public void check_delete_ok() {
        // создаем животное для теста
        String petId = "12";

        Pet pet = PetCreator.fillBuilder()
                .setId(petId)
                .build();

        httpPostPet(pet);

        //удаляем созданное животное
        httpDeletePet(petId);

    }

    @Test
    //  Проверка API на удаление животного по ID отсутствующему в базе Test-60— PET
    public void check_delete_error() {
        String petId = "12";

        //удаляем созданного животного
        try {
            httpDeletePet(petId);
        } catch (HttpClientErrorException exception) {

        }

        //проверяем что при попытке удалить несуществующее животное получаем ошибку 404
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
