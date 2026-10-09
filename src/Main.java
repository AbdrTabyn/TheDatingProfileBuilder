import java.util.ArrayList;
import java.util.List;

    class DatingProfile {
        private final String name;
        private final String bio;
        private final List<String> hobbies;
        private final String redFlag;

        public DatingProfile(String name, String bio, List<String> hobbies, String redFlag) {
            this.name = name;
            this.bio = bio;
            this.hobbies = List.copyOf(hobbies);
            this.redFlag = redFlag;
        }
        @Override
        public String toString() {
            return "Dating Profile:\n" +
                    "Name: " + name + "\n" +
                    "Bio: " + bio + "\n" +
                    "Hobbies: " + hobbies + "\n" +
                    "Red flag: " +
                    (redFlag == null ? "None" : redFlag);
        }
    }

    class DatingProfileBuilder {
        private String name;
        private String bio;
        private final List<String> hobbies = new ArrayList<>();
        private String redFlag;

        public DatingProfileBuilder setName(String name) {
            this.name = name;
            return this;
        }
        public DatingProfileBuilder setBio(String bio) {
            this.bio = bio;
            return this;
        }
        public DatingProfileBuilder addHobby(String hobby) {
            hobbies.add(hobby);
            return this;
        }
        public DatingProfileBuilder setRedFlag(String redFlag) {
            this.redFlag = redFlag;
            return this;
        }
        public DatingProfile build() {
            if (hobbies.isEmpty()) {
                throw new IllegalStateException(
                        "A profile must have at least one hobby!"
                );
            }
            return new DatingProfile(name, bio, hobbies, redFlag);
        }
    }
    public class Main {
        public static void main(String[] args) {

            DatingProfile profile1 = new DatingProfileBuilder()
                    .setName("Alex")
                    .setBio("I love programming")
                    .addHobby("Gaming")
                    .addHobby("Music")
                    .setRedFlag("He thinks that women should be only at home")
                    .build();
            System.out.println(profile1);
            System.out.println();

            DatingProfile profile2 = new DatingProfileBuilder()
                    .addHobby("Traveling")
                    .setRedFlag("Always late")
                    .setBio("I enjoy adventures")
                    .setName("Sam")
                    .build();
            System.out.println(profile2);
            System.out.println();

            //test
            try {
                new DatingProfileBuilder()
                        .setName("Chris")
                        .setBio("I like movies")
                        .build();
            } catch (IllegalStateException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
