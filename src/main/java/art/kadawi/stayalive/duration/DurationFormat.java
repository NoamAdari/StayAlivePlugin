package art.kadawi.stayalive.duration;

import java.util.ArrayList;
import java.util.List;

public class DurationFormat {
    private UnitTranslations units = new UnitTranslations();
    private String and = "ו";
    private String forever = "לתמיד";
    private String forSomething = "ל";

    public String format(long duration, boolean prependFor) {
        if (duration < 0) return forever;
        List<String> segments = new ArrayList<>();
        long seconds = duration / 1000;
        if (seconds < 60) {
            segments.add(units.getSeconds().format(seconds));
            return contact(segments, prependFor);
        }
        long minutes = seconds / 60;
        seconds %= 60;
        if (minutes < 60) {
            segments.add(units.getMinutes().format(minutes));
            if (seconds > 0 && minutes < 10) {
                segments.add(units.getSeconds().format(seconds));
            }
            return contact(segments, prependFor);
        }
        long hours = minutes / 60;
        minutes %= 60;
        if (hours < 24) {
            segments.add(units.getHours().format(hours));
            if (minutes > 0 && hours < 3) {
                segments.add(units.getMinutes().format(minutes));
            }
            return contact(segments, prependFor);
        }
        long days = hours / 24;
        hours %= 24;
        if (days < 30) {
            segments.add(units.getDays().format(days));
            if (hours > 0 && days == 1) {
                segments.add(units.getHours().format(hours));
            }
            return contact(segments, prependFor);
        }
        long months = days / 30;
        if (days < 365) {
            days %= 30;
            segments.add(units.getMonths().format(months));
            if (days > 0 && months == 1) {
                segments.add(units.getDays().format(days));
            }
            return contact(segments, prependFor);
        }
        long years = days / 365;
        months %= 12;
        segments.add(units.getYears().format(years));
        if (months > 0) {
            segments.add(units.getMonths().format(months));
        }
        return contact(segments, prependFor);
    }

    private String contact(List<String> segments, boolean prependFor) {
        if (segments.size() == 1) {
            return (prependFor ? forSomething : "") + segments.get(0);
        }
        return (prependFor ? forSomething : "") + segments.get(0) + " " + and + segments.get(1);
    }

}
