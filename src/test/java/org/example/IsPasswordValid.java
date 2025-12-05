package org.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class IsPasswordValid {


    @ParameterizedTest
    @CsvFileSource(resources = "/weak_passwords.txt")
    void isPasswordWeak(String weakPassword) {

        PasswordBcryptService service = new PasswordBcryptService(List.of(weakPassword));

        assertThat(service.checkIfPasswordIsWeak(weakPassword))
                .as("Erwartet wird, das '%s' als Passwort zu schwach ist", weakPassword)
                .isTrue();

    }

    @Test
    void hashStrongPassword() {
        PasswordBcryptService service = new PasswordBcryptService(List.of());
        String strongPassword = "password";
        String passwordHash = service.hashOrThrow(strongPassword);
        assertThat(passwordHash).isNotNull();

        assertThat(service.matches(strongPassword, passwordHash)).isTrue();
        assertThat(service.checkIfPasswordIsWeak(strongPassword)).isFalse();
    }


    @Test
    void isPassword_atLeast_8_Digits_Long() {
        String password = "th!sIsaV3ryL0ngPass";
        assertThat(Main.checkPasswordLength(password)).isTrue();
    }

    @Test
    void hasAtLeast_1_Digit_but_max_4_Digits() {
        String password = "1234einszweidrei";
        assertThat(Main.checkForDigitsInPassword(password))
                .isGreaterThan(0)
                .isLessThan(5);

    }

    @Test
    void isPasswordFilledWithUpperLowerCase() {
        String password = "Passwort";
        assertThat(Main.checkForUpperLowerCase(password))
                .isTrue();
    }

    @Test
    void has_min_1_Digits_max4_UpperCase_LowerCase() {
        String password = "Mutt3rTag";
        long digitCount = password.chars()
                .filter(Character::isDigit)
                .count();

        assertThat(password)
                .matches(".*[A-Z].*")
                .matches(".*[a-z].*");
        assertThat(digitCount)
                .isGreaterThan(0)
                .isLessThan(5);
    }
}
