/**
 * Created by emilh on 01-11-2016.
 */
public enum Field {
    TOWER(250, 1),
    CRATER(-100, 2),
    PALACE_GATES(100, 3),
    COLD_DESERT(-20, 4),
    WALLED_CITY(180, 5),
    MONASTERY(0, 6),
    BLACK_CAVE(-70, 7),
    HUTS_IN_THE_MOUNTAIN(60, 8),
    THE_WEREWALL(-80, 9),
    THE_PIT(-50, 10),
    GOLDMINE(650, 11);

    private final int value;
    private final int fieldNumber;

    Field cName;

    Field(int value, int fieldNumber) {
        this.value = value;
        this.fieldNumber = fieldNumber;
    }

    public String getFieldName() {
        switch(cName) {
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

        }
    }
}


