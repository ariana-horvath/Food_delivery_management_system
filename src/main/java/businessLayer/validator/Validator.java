package businessLayer.validator;

import exception.InputValidationFailedException;
import java.time.LocalDateTime;

/**
 * The type Validator.
 * - validates the input data that is passed to the delivery service.
 * @author Ariana Horvath
 */
public class Validator {

    /**
     * Validate text field.
     *
     * @param string the string
     */
    public void validateTextField(String string) {
        if(string.compareTo("") == 0)
            throw new InputValidationFailedException("Input cannot be empty.");
    }

    /**
     * Validate double.
     *
     * @param string the string
     */
    public void validateDouble(String string) {
        try {
            validateTextField(string);
            if(Double.parseDouble(string) < 0 || Double.parseDouble(string) > 5)
                throw  new InputValidationFailedException("Rating has to be between 0 and 5.");
        } catch (NumberFormatException exception) {
            throw new InputValidationFailedException("Rating is not a double.");
        }
    }

    /**
     * Validate int.
     *
     * @param string the string
     */
    public void validateInt(String string) {
        try {
            validateTextField(string);
            if(Integer.parseInt(string) < 0)
                throw  new InputValidationFailedException("Input cannot be negative.");
        } catch (NumberFormatException exception) {
            throw new InputValidationFailedException("Input is not an integer number.");
        }
    }

    /**
     * Validate number text fields.
     *
     * @param s1 the s 1
     * @param s2 the s 2
     * @param s3 the s 3
     * @param s4 the s 4
     * @param s5 the s 5
     * @param s6 the s 6
     */
    public void validateNumberTextFields(String s1, String s2, String s3, String s4, String s5, String s6) {
        validateDouble(s1);
        validateInt(s2);
        validateInt(s3);
        validateInt(s4);
        validateInt(s5);
        validateInt(s6);
    }

    /**
     * Validate hour int.
     *
     * @param hour the hour
     * @return the int
     */
    public int validateHour(String hour) {
        try {
            String[] sHour = hour.split(":");
            if(sHour.length != 2) throw new InputValidationFailedException("Invalid hour format!");
            int hours = Integer.parseInt(sHour[0]);
            if (hours < 0 || hours > 23) throw new InputValidationFailedException("Invalid hour!");
            int minutes = Integer.parseInt(sHour[1]);
            if (minutes < 0 || minutes > 59) throw new InputValidationFailedException("Invalid hour!");
            return hours * 60 + minutes;
        } catch (NumberFormatException exception) {
            throw new InputValidationFailedException("Invalid hour!");
        }
    }

    /**
     * Validate hours in minutes.
     *
     * @param start the start
     * @param end   the end
     */
    public void validateHoursInMinutes(int start, int end) {
        if (start > end)
            throw new InputValidationFailedException("Start hour is after end hour!");
    }

    /**
     * Validate date int [ ].
     *
     * @param dateString the date string
     * @return the int [ ]
     */
    public int[] validateDate(String dateString) {
        int[] dateSeparated = new int[3];
        try {
            String[] DMY = dateString.split("/");
            if (DMY.length != 3) throw new InputValidationFailedException("Invalid date format!");
            int day = Integer.parseInt(DMY[0]);
            int month = Integer.parseInt(DMY[1]);
            int year = Integer.parseInt(DMY[2]);
            if (day < 1 || day > 31 || month < 1 || month > 12 || year < 0 || year > LocalDateTime.now().getYear())
                throw new InputValidationFailedException("Invalid date!");
            if (year == LocalDateTime.now().getYear())
                if (month > LocalDateTime.now().getMonthValue() || (month == LocalDateTime.now().getMonthValue() &&
                        day > LocalDateTime.now().getDayOfMonth()))
                    throw new InputValidationFailedException("Date cannot be in the future!");

            dateSeparated[0] = day;
            dateSeparated[1] = month;
            dateSeparated[2] = year;
            return dateSeparated;
        } catch (NumberFormatException exception) {
            throw new InputValidationFailedException("Invalid date!");
        }
    }
}
