/* *****************************************
 * CSCI205 - Software Engineering and Design
 * Fall 2019
 * Instructor: Prof. Brian King
 *
 * Name: Michael Heller and Sami Dunn
 * Section: 11 am
 * Date: 9/26/19
 * Time:
 *
 * Project: csci205_labs
 * Package: lab09
 * Class: HRDateUtils
 *
 * Description:  contains all data and methods for managing a
 * standard date format.
 *
 * ****************************************
 */

package lab10;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Class to maintain methods dealing with date formatting
 * @authors Michael Heller and Sami Dunn
 * @version 0.1
 *
 */
public final class HRDateUtils {


    /** Our date formatter to ensure we have a common date */
    static SimpleDateFormat empDateFormatter = new SimpleDateFormat("yyyy-MM-dd");

    /**
     * Helper method to parse a date string into a date object. This is
     * really here just to show how to deal with an exception that may
     * be thrown in a method.
     *
     * @param sDate - a date string
     * @return a <code>Date</code> object
     * @throws ParseException if the string cannot be parse correctly.
     */
    static Date strToDate(String sDate) throws ParseException {
        return empDateFormatter.parse(sDate);
    }

    /**
     * Converts date to user-friendly String date
     * @param date
     * @return dateStr
     */
    static String dateToStr(Date date) {
        String dateStr = empDateFormatter.format(date);
        return dateStr;
    }
}