package duke.task;

import java.text.SimpleDateFormat;  // for formatting and parsing dates
import java.util.Date;  // allows interpretation of dates as year, month, day, hour, minute and second values
import java.time.LocalDate; // description of the date
import java.time.ZoneId;    // time zone id
import java.text.ParseException;

public class DukeDateFormat {

    /**
     * Converts String s into date.
     * @param s String to convert into date.
     * @return returns date format of given String s.
     */
    public static String convertStringToDate(String s) {
        try {
            SimpleDateFormat format = new SimpleDateFormat("d/M/yyyy HHmm");
            Date date = format.parse(s);
            SimpleDateFormat formatter = new SimpleDateFormat("d'suffix' 'of' MMMM yyyy h.mma");
            LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            return formatter.format(date).replace("suffix", getDaySuffix(localDate.getDayOfMonth()))
                    .replace(".00", "")
                    .replace("AM", "am")
                    .replace("PM", "pm");
        } catch (ParseException exception) {
            return s;
        }
    }

    /**
     * Returns suffix of int n eg. st, nd, rd, th.
     * @param n Value of the month.
     * @return returns suffix of n.
     */
    private static String getDaySuffix(int n) {   // to return suffix
        if (!(n >= 1 && n <= 31)) {
            return "";
        }
        if (n >= 11 && n <= 13) {
            return "th";
        }
        switch (n % 10) {
        case 1: return "st";    // first
        case 2: return "nd";    // second
        case 3: return "rd";    // third
        default: return "th";   // the rest
        }
    }
}
