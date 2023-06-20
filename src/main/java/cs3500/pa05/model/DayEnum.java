package cs3500.pa05.model;

/**
 * Represents the days of the week.
 */
public enum DayEnum {
    MONDAY("Monday"),
    TUESDAY("Tuesday"),
    WEDNESDAY("Wednesday"),
    THURSDAY("Thursday"),
    FRIDAY("Friday"),
    SATURDAY("Saturday"),
    SUNDAY("Sunday");

    public final String label;

    private DayEnum(String label) {
        this.label = label;
    }
}
