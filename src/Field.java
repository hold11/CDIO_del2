/**
 * Created by emilh on 01-11-2016.
 */
public enum Field {
    TOWER(250),
    CRATER(-100),
    PALACE_GATES(100),
    COLD_DESERT(-20),
    WALLED_CITY(180),
    MONASTERY(0),
    BLACK_CAVE(-70),
    HUTS_IN_THE_MOUNTAIN(60),
    THE_WEREWALL(-80),
    THE_PIT(-50),
    GOLDMINE(650),

    private final int value;

    Field(int value) {
        this.value = value;
    }
}


