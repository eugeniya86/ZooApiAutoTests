import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

import java.util.List;
import java.util.Objects;

public class Pet {

    public static final String STATUS_AVAILABLE = "available";
    public static final String STATUS_SOLD = "sold";
    public static final String STATUS_PENDING = "pending";

    @JsonProperty("id")
    public String id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("status")
    private String status;

    @JsonProperty("category")
    private Category category;

    @JsonProperty("photoUrls")
    private List<String> photoUrls;

    @JsonProperty("tags")
    private List<Tag> tags;

    public Pet() {}

    public Pet(String id, String name, String status, Category category, List<String> photoUrls, List<Tag> tags) {
        this.id = id;
        this.name = name;
        this.status = status;
        this.category = category;
        this.photoUrls = photoUrls;
        this.tags = tags;
    }

    public String id() {
        return id;
    }

    public String name() {
        return name;
    }

    public String getStatus() {
        return status;
    }

    public Category getCategory() {
        return category;
    }

    public List<String> getPhotoUrls() {
        return photoUrls;
    }

    public static Pet.Builder newPet() {
        return new Builder();
    }

    public static class Category {
        private String id;
        private String name;

        public Category() { }

        public Category(String id, String name) {
            this.id = id;
            this.name = name;
        }

        public String getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Category category = (Category) o;
            return id.equals(category.id) &&
                    name.equals(category.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(id, name);
        }
    }

    public static class Tag {
        private String id;
        private String name;

        public Tag() {}

        public Tag(String id, String name) {
            this.id = id;
            this.name = name;
        }

        public String getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public static Tag.Builder newTag() {
            return new Tag.Builder();
        }

        public static class Builder {
            private String id;
            private String name;

            public Tag.Builder setId(String id) {
                this.id = id;
                return this;
            }

            public Tag.Builder setName(String name) {
                this.name = name;
                return this;
            }

            public Tag build() {
                Tag tag = new Tag();
                tag.id = id;
                tag.name = name;
                return tag;
            }
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Tag tag = (Tag) o;
            return id.equals(tag.id) &&
                    name.equals(tag.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(id, name);
        }
    }

    public static class Builder {
        private String id;
        private String name;
        private String status;
        private Category category;
        private List<String> photoUrls;
        private List<Tag> tags;

        public Builder setId(String id) {
            this.id = id;
            return this;
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setStatus(String status) {
            this.status = status;
            return this;
        }

        public Builder setCategory(Category category) {
            this.category = category;
            return this;
        }

        public Builder setPhotoUrls(List<String> photoUrls) {
            this.photoUrls = photoUrls;
            return this;
        }

        public Builder setTags(List<Tag> tags) {
            this.tags = tags;
            return this;
        }

        public Pet build() {
            return new Pet(id, name, status, category, photoUrls, tags);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pet pet = (Pet) o;
        return Objects.equals(id, pet.id) &&
                Objects.equals(name, pet.name) &&
                Objects.equals(status, pet.status) &&
                Objects.equals(category, pet.category) &&
                Objects.equals(photoUrls, pet.photoUrls) &&
                Objects.equals(tags, pet.tags);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, status, category, photoUrls, tags);
    }

    @Override
    public String toString() {
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        String json = "";
        try {
            json = ow.writeValueAsString(this);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return json;
    }
}
