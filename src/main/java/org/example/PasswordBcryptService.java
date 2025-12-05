package org.example;

import at.favre.lib.crypto.bcrypt.BCrypt;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class PasswordBcryptService {

    private final Set<String> weakPasswords;

    public PasswordBcryptService(Collection<String> weakPasswords) {
        this.weakPasswords = new HashSet<>(weakPasswords);
    }

    public boolean checkIfPasswordIsWeak(String password) {
        return weakPasswords.contains(password);
    }

    public String hashOrThrow(String password) {
        if(checkIfPasswordIsWeak(password)) {
            throw new IllegalArgumentException("Passwort ist zu schwach!");

        }
        return BCrypt.withDefaults().hashToString(12,password.toCharArray());
    }

    public boolean matches(String rawPassword, String hash) {
        BCrypt.Result result = BCrypt.verifyer().verify(rawPassword.toCharArray(), hash);
        return result.verified;
    }
}
