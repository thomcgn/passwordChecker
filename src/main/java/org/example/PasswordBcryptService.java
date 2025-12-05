package org.example;

import at.favre.lib.crypto.bcrypt.BCrypt;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class PasswordBcryptService {

    private final Set<String> weakPasswords;

    /**
     *
     * @param weakPasswords Der Service bekommt die Daten vom Test
     */
    public PasswordBcryptService(Collection<String> weakPasswords) {
        this.weakPasswords = new HashSet<>(weakPasswords);
    }

    /**
     *
     * @param password
     * @return Liefert True, wenn das Passwort in der Liste enthalten ist.
     */
    public boolean checkIfPasswordIsWeak(String password) {
        return weakPasswords.contains(password);
    }

    /**
     *
     * @param password
     * @return Gibt einen Hash zurück, wenn das Passwort stark genug ist, ansonsten wird eine Exception geworfen
     */
    public String hashOrThrow(String password) {
        if(checkIfPasswordIsWeak(password)) {
            throw new IllegalArgumentException("Passwort ist zu schwach!");

        }
        return BCrypt.withDefaults().hashToString(12,password.toCharArray());
    }

    /**
     *
     * Das Klartextpasswort wird mit dem Hash verglichen, ob beide zueinander gehören.
     * @param rawPassword
     * @param hash
     * @return Gibt True zurück wenn verifiziert ist, das der Hash zum Passwort gehört
     */
    public boolean matches(String rawPassword, String hash) {
        BCrypt.Result result = BCrypt.verifyer().verify(rawPassword.toCharArray(), hash);
        return result.verified;
    }
}
