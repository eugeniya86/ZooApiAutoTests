import org.junit.Test;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class PostTests extends HttpTest {

    @Test
    public void check_post_pet() {
        //создаем нового питомца
        Pet pet = PetCreator.fillBuilder()
                .build();

        //передаем питомца на сервер
        ResponseEntity<Pet> petResponseEntity = httpPostPet(pet);

        //проверяем, что ответ 200 OK
        assertEquals(petResponseEntity.getStatusCode().value(), 200);

        Pet entityBody = petResponseEntity.getBody();

        //проверяем, что id ответа и запроса одинаковы
        assertEquals(pet, entityBody);
    }
}
