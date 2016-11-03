/**
 * Created by emilh on 01-11-2016.
 */
public enum Field {
    TOWER(250, 2, SpecialAttribute.NONE),
    CRATER(-100, 3, SpecialAttribute.NONE),
    PALACE_GATES(100, 4, SpecialAttribute.NONE),
    COLD_DESERT(-20, 5, SpecialAttribute.NONE),
    WALLED_CITY(180, 6, SpecialAttribute.NONE),
    MONASTERY(0, 7, SpecialAttribute.NONE),
    BLACK_CAVE(-70, 8, SpecialAttribute.NONE),
    HUTS_IN_THE_MOUNTAIN(60, 9, SpecialAttribute.NONE),
    THE_WEREWALL(-80, 10, SpecialAttribute.EXTRA_TURN),
    THE_PIT(-50, 11, SpecialAttribute.NONE),
    GOLDMINE(650, 12, SpecialAttribute.NONE);

    public enum SpecialAttribute {
        NONE, EXTRA_TURN;
    };

    private final SpecialAttribute specialAttribute;
    private final int scoreValue; // TODO: Rename scoreValue to something more descriptive
    private final int fieldID;

    Field(int scoreValue, int fieldID, SpecialAttribute specialAttribute) {
        this.scoreValue = scoreValue;
        this.fieldID = fieldID;
        this.specialAttribute = specialAttribute;
    }

    public String toString() /*throws NoSuchFieldException*/ {
        switch(this) {
            case TOWER: return Lang.msg("Tower");
            case CRATER: return Lang.msg("Crater");
            case PALACE_GATES: return Lang.msg("PalaceGates");
            case COLD_DESERT: return Lang.msg("ColdDesert");
            case WALLED_CITY: return Lang.msg("WalledCity");
            case MONASTERY: return Lang.msg("Monastery");
            case BLACK_CAVE: return Lang.msg("BlackCave");
            case HUTS_IN_THE_MOUNTAIN: return Lang.msg("HutsInTheMountain");
            case THE_WEREWALL: return Lang.msg("TheWerewall");
            case THE_PIT: return Lang.msg("ThePit");
            case GOLDMINE: return Lang.msg("Goldmine");
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
