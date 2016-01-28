package homework_9_1;

public enum ThingsInMyTable {
    UNKNOWN_THING("UNKNOWN_THING_description"){
        @Override
        public String toString() {
            return "It's extraterrestrial artifact";
        }
    },
    FOLDER("FOLDER_description"){
        @Override
        public String toString() {
            return "I'm a FOLDER";
        }
    },
    EXERCISE_BOOK("EXERCISE_BOOK_description"){
        @Override
        public String toString() {
            return "I'm a EXERCISE_BOOK";
        }
    },
    PEN("PEN_description"){
        @Override
        public String toString() {
            return "I'm a PEN";
        }
    },
    CAMERA("CAMERA_description"){
        @Override
        public String toString() {
            return "I'm a CAMERA";
        }
    };

    String description;

    ThingsInMyTable(String description) {
        this.description = description;
    }

    public static ThingsInMyTable getThingByDescription(String descriptionForSearch) {
        for (ThingsInMyTable thing : values()) {
            if (descriptionForSearch.equalsIgnoreCase(thing.description)) {
                return thing;
            }
        }
        return UNKNOWN_THING;
    }
}
