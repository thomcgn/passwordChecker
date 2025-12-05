package org.example;

public class Main {


    /**
     * Prüfung auf Passwortlänge von mindestens 8
     *
     * @param password Übergabe des Passworts
     * @return Zählt die länge des Strings und gibt TRUE zurück, wenn Länge größer oder gleich 8 ist.
     */
    public static boolean checkPasswordLength(String password) {
        return password.length() >= 8;
    }

    /**
     * Prüfung auf vorhandene Zahlen im Passwort
     *
     * @param password Passwort das übergeben wird
     * @return zerlegt den String in eine Charsequence, filtert nach Zahlen, zählt diese und prüft die Min Max Werte
     * und nur wenn beide Werte passen '&&' liefert der return TRUE
     */
    public static long checkForDigitsInPassword(String password) {
        return password.chars().filter(Character::isDigit).count();
    }

    /**
     * Prüfung auf Groß UND Kleinschreibung im Passwort
     *
     * @param password
     * @return
     */
    public static boolean checkForUpperLowerCase(String password) {
        return password.matches(".*[A-Z].*") && password.matches(".*[a-z].*");
    }

    public static void main(String[] args) {
        boolean valid = false;
        String testPassword = "paAs3swaqs";

        while (!valid) {
            if (checkPasswordLength(testPassword)
                    && checkForDigitsInPassword(testPassword) > 0
                    && checkForUpperLowerCase(testPassword)) {
                valid = true;
            } else {
                System.out.println("Passwort erfüllt nicht die Vorgaben!");
                break;
            }
            System.out.println("Passwort akzeptiert!");
        }

    }
}
