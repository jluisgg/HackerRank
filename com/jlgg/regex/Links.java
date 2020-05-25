package com.jlgg.regex;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Performs a recursive matching on a website to extract links, then print these links in the terminal.
 */
public class Links {

    public static void main(String[] args) {

        String links = "<div class=\"inner\">\n" +
                "<p><a href=\"/bundles\">Bundles</a></p>\n" +
                "<p><a href=\"/books/deal-of-the-day\">Deal of the day</a></p>\n" +
                "<p><a href=\"/packt/offers/free-learning\">Free Learning</a></p>\n" +
                "<p><a href=\"https://subscribe.packtpub.com/\">Subscription Free Trial</a></p>\n" +
                "<p><a href=\"/books/content/prefer-print-copy\">Upgrade to Print</a></p>\n" +
                "</div>" +
                "\"/books/content/another-book\"";

        // (?:<a href=") groups <a href=" without capturing it
        // ([^"]+) Capturing group 1, [^"] matches anything but ", + 1 at least one char in the set
        // (?:"{1}) groups one " without capturing
        // String regex = "(?:<a href=\")([^\"]+)(?:\"{1})";

        // Another version to remove the links with http(s) only relative links
        String regex = "(?:<a href=\")([^https][^\"]+)(?:\"{1})";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(links);

        List<String> listLinks = new ArrayList<>();
        while (matcher.find()) {
            listLinks.add(matcher.group(1));
        }

        System.out.println(listLinks);

    }
}
