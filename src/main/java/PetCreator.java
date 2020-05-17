import java.util.ArrayList;
import java.util.List;

public class PetCreator {

    public static Pet.Builder fillBuilder() {
        String petName = "bobik";
        String petId = "42";

        List<Pet.Tag> tags = new ArrayList<>();
        tags.add(new Pet.Tag("2", "tag2"));
        tags.add(new Pet.Tag("3", "tag3"));

        Pet.Category category = new Pet.Category("0", "category");

        List<String> photoUrls = new ArrayList<>();
        photoUrls.add("https://avatars.mds.yandex.net/get-zen_doc/1804213/pub_5c6aff1841446200af5e05e8_5c6b006ba4b16500aec93ad2/scale_1200");

        return Pet.newPet()
                .setId(petId)
                .setName(petName)
                .setStatus("available")
                .setPhotoUrls(photoUrls)
                .setCategory(category)
                .setTags(tags);
    }
}
