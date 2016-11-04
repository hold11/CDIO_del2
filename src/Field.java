/**
 * Created by emilh on 01-11-2016.
 */
public enum Field {
    TOWER(250, 2, SpecialAttr.NONE),
    CRATER(-100, 3, SpecialAttr.NONE),
    PALACE_GATES(100, 4, SpecialAttr.NONE),
    COLD_DESERT(-20, 5, SpecialAttr.NONE),
    WALLED_CITY(180, 6, SpecialAttr.NONE),
    MONASTERY(0, 7, SpecialAttr.NONE),
    BLACK_CAVE(-70, 8, SpecialAttr.NONE),
    HUTS_IN_THE_MOUNTAIN(60, 9, SpecialAttr.NONE),
    THE_WEREWALL(-80, 10, SpecialAttr.EXTRA_TURN),
    THE_PIT(-50, 11, SpecialAttr.NONE),
    GOLDMINE(650, 12, SpecialAttr.NONE);

    public enum SpecialAttr {
        NONE, EXTRA_TURN;
    };

    private final SpecialAttr specialAttr;
    private final int scoreValue; // TODO: Rename scoreValue to something more descriptive
    private final int fieldID;

    Field(int scoreValue, int fieldID, SpecialAttr specialAttr) {
        this.scoreValue = scoreValue;
        this.fieldID = fieldID;
        this.specialAttr = specialAttr;
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

    public boolean checkSpecialAttribute(SpecialAttr specialAttr) {
        return (this.specialAttr == specialAttr);
    }
}
