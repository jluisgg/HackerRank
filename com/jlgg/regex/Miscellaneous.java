package com.jlgg.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Miscellaneous {

    public static void removeConsonants(String text) {
        String regex = "([^aeiouAEIOU0-9\\W]+)";
        String replaced = text.replaceAll(regex, "");
        System.out.println(replaced);
    }

    /**
     * https://owasp.org/www-community/OWASP_Validation_Regex_Repository
     */
    public static void isValidEmail(String email) {
        String regex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);
        if (matcher.matches()) {
            System.out.println("Email: " + email + " is valid.");
        } else {
            System.out.println("Email: " + email + " is not valid.");
        }
    }

    public static void main(String[] args) {
        removeConsonants("Hello there this a program to remove consonants");
        isValidEmail("guerrero.guzman@gmail.com");
    }
}
