package org.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.InputStream;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;


public class IsPasswordValid {



    //TODO: PasswortListen Test


    @Test
    void isPassword_atLeast_8_Digits_Long() {
        String password = "th!sIsaV3ryL0ngPass";
        assertTrue(Main.checkPasswordLength(password));
    }

    @Test
    void hasAtLeast_1_Digit_but_max_4_Digits() {
        String password = "1234einszweidrei";
        assertTrue(Main.checkForDigitsInPassword(password ,1, 4));
    }

    @Test
    void isPasswordFilledWithUpperLowerCase(){
        String password = "mutteRtag";
        assertTrue(Main.checkForUpperLowerCase(password));
    }
}
