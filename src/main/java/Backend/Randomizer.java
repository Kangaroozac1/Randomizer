package Backend;

import java.util.List;
import java.util.UUID;

public class Randomizer {

    private final String id;
    private final String name;
    private final List<String> entries;

    private Randomizer(Builder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.entries = builder.entries;
    }

    private Randomizer(Updater updater) {
        this.id = updater.id;
        this.name = updater.name;
        this.entries = updater.entries;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<String> getEntries() {
        return entries;
    }

    public static class Builder {
        private String id;
        private String name;
        private List<String> entries;

        public Builder withName(String name) {
            this.name = name;
            return this;
        }

        public Builder withEntries(List<String> entries) {
            this.entries = entries;
            return this;
        }
        public Builder withId(String id) {
            this.id = id;
            return this;
        }

        public Randomizer build() {
            if (null == id) {
                this.id = UUID.randomUUID().toString();
            }

            return new Randomizer(this);
        }
    }

    public static class Updater {
        private String id;
        private String name;
        private List<String> entries;

        public Updater(Randomizer randomizer) {
            this.id = randomizer.getId();
            this.name = randomizer.getName();
            this.entries = randomizer.getEntries();
        }

        public Updater updateName(String name) {
            this.name = name;
            return this;
        }

        public Updater addEntry(String entry) {
            entries.add(entry);
            return this;
        }

        public Updater removeEntry(String entry) {
            entries.remove(entry);
            return this;
        }

        public Randomizer update() {
            return new Randomizer(this);
        }
    }
}
