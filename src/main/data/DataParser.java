package main.data;

/**
 * Created by Leo on 26-Jun-16.
 */
public class DataParser
{
    public static double parseTurboCharger(String tCharger) {
        if (tCharger == null || tCharger.equals(""))
            return 0;
        else if (tCharger.equals("T"))
            return 1;
        else
            throw new IllegalArgumentException("Illegal tCharger value: " + tCharger);
    }

    public static double parseSuperCharger(String sCharger) {
        if (sCharger == null || sCharger.equals(""))
            return 0;
        else if (sCharger.equals("S"))
            return 1;
        else
            throw new IllegalArgumentException("Illegal sCharger value: " + sCharger);
    }

    public static double parseStartStop(String startstop) {
        if (startstop == null || startstop.equals("") || startstop.equals("N"))
            return 0;
        else if (startstop.equals("Y"))
            return 1;
        else
            throw new IllegalArgumentException("Illegal startstop value: " + startstop);
    }
}
