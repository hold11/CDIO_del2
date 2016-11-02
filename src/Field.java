/**
 * Created by emilh on 01-11-2016.
 */
public enum Field {
    TOWER(250, 1, SpecialAttribute.NONE),
    CRATER(-100, 2, SpecialAttribute.NONE),
    PALACE_GATES(100, 3, SpecialAttribute.NONE),
    COLD_DESERT(-20, 4, SpecialAttribute.NONE),
    WALLED_CITY(180, 5, SpecialAttribute.NONE),
    MONASTERY(0, 6, SpecialAttribute.NONE),
    BLACK_CAVE(-70, 7, SpecialAttribute.NONE),
    HUTS_IN_THE_MOUNTAIN(60, 8, SpecialAttribute.NONE),
    THE_WEREWALL(-80, 9, SpecialAttribute.EXTRA_TURN),
    THE_PIT(-50, 10, SpecialAttribute.NONE),
    GOLDMINE(650, 11, SpecialAttribute.NONE);

    public enum SpecialAttribute {
        NONE, EXTRA_TURN;
    };

    private final SpecialAttribute specialAttribute;
    private final int scoreValue; // TODO: Rename scoreValue to something more descriptive
    private final int fieldID;

//    Field cName; // TODO: I think this is not going to be used, in that case: delete.

    Field(int scoreValue, int fieldID, SpecialAttribute specialAttribute) {
        this.scoreValue = scoreValue;
        this.fieldID = fieldID;
        this.specialAttribute = specialAttribute;
    }

    public String toString() /*throws NoSuchFieldException*/ {
        switch(this) {
            case TOWER: return "Tower";
            case CRATER: return "Crater";
            case PALACE_GATES: return "Palace gates";
            case COLD_DESERT: return "Cold desert";
            case WALLED_CITY: return "Walled city";
            case MONASTERY: return "Monastery";
            case BLACK_CAVE: return "Black cave";
            case HUTS_IN_THE_MOUNTAIN: return "Huts in the mountain";
            case THE_WEREWALL: return "The werewall";
            case THE_PIT: return "The pit";
            case GOLDMINE: return "Goldmine";
            default: return "null";
        }
    }

    public int getScoreValue() {
        return scoreValue;
    }

    public int getFieldID() {
        return fieldID;
    }

    public boolean checkSpecialAttribute(SpecialAttribute specialAttribute) {
        return (this.specialAttribute == specialAttribute);
    }
}
