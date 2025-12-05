package org.example;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    //TODO:
//        Muss-Kriterien (Basis):
//        mindestens 8 Zeichen, => CHECK
//        mindestens eine Ziffer (0–9), CHECK
//        Groß- und Kleinbuchstaben (beides muss vorkommen), CHECK
//        nicht in einer Liste häufiger/schwacher Passwörter. CHECK
//        Optional (Bonus-Policy):
//        mindestens ein Sonderzeichen (definiere erlaubte Menge),
//        Mindestanzahl unterschiedlicher Zeichengruppen (z. B. 3 von 4: Groß, Klein, Ziffer, Sonderzeichen).
    // MAVEN CI


    public static boolean checkForWeakPassword()  {
    return false;
    }

    /**
     *
     * @param args
     */
    public static void main(String[] args) {


    }

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
     * @param password  Passwort das übergeben wird
     * @param minDigits Minimum an Zahlen die im Passwort sein müssen
     * @param maxDigits Maximum an Zahlen die im Passwort sein dürfen
     * @return zerlegt den String in eine Charsequence, filtert nach Zahlen, zählt diese und prüft die Min Max Werte
     * und nur wenn beide Werte passen '&&' liefert der return TRUE
     */
    public static boolean checkForDigitsInPassword(String password, int minDigits, int maxDigits) {
        return password.chars().filter(Character::isDigit).count() >= minDigits
                && password.chars().filter(Character::isDigit).count() <= maxDigits;
    }

    /**
     * Prüfung auf Groß UND Kleinschreibung im Passwort
     *
     * @param password
     * @return
     */
    public static boolean checkForUpperLowerCase(String password) {
        return password.chars().anyMatch(Character::isUpperCase) && password.chars().anyMatch(Character::isLowerCase);
    }
}
