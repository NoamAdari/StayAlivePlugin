package art.kadawi.stayalive.duration;

public class UnitTranslations {
    private UnitNames seconds = new UnitNames("שנייה", "2 שניות","שניות");
    private UnitNames minutes = new UnitNames("דקה", "2 דקות", "דקות");
    private UnitNames hours = new UnitNames("שעה", "שעתיים", "שעות");
    private UnitNames days = new UnitNames("יום", "יומיים", "ימים");
    private UnitNames months = new UnitNames("חודש", "חודשיים", "חודשים");
    private UnitNames years = new UnitNames("שנה", "שנתיים", "שנים");

    public UnitNames getSeconds() {
        return seconds;
    }

    public UnitNames getMinutes() {
        return minutes;
    }

    public UnitNames getHours() {
        return hours;
    }

    public UnitNames getDays() {
        return days;
    }

    public UnitNames getMonths() {
        return months;
    }

    public UnitNames getYears() {
        return years;
    }
}
