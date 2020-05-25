package com.jlgg.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Extract every part of the URL and store them in variables, starting with the protocol, then the domain,
 * and finally the path
 */
public class Domain {
    public static void main(String[] args) {
        String url = "https://www.packtpub.com/application-development/mastering-java-9";

        // Regex to find the protocol
        String regex = "(http[s]?)(?:://)([w]{0,3}\\.?[a-zA-Z]+\\.[a-zA-Z]{2,3})(?:[/])(.*)";
        // Compile the expression into a pattern object
        Pattern pattern = Pattern.compile(regex);
        // Create the Matcher
        Matcher matcher = pattern.matcher(url);

        // Attempt to find the first group
        boolean foundMatches = matcher.find();
        if (foundMatches) {
            String protocol = matcher.group(1);
            System.out.println("Protocol: " + protocol);
            String domain = matcher.group(2);
            System.out.println("Domain: " + domain);
            String path = matcher.group(3);
            System.out.println("Path: " + path);
        }

        // Before extracting the domain, we need to ignore the following characters: "://"
        // so a non capturing group was added to the regex: (?:://)

        // Another added to find the domain, www is optional: ([w]{0,3}\.?[a-zA-Z]+\.[a-zA-Z]{2,3})
        // [w]{0,3} between 0 and 3 w's
        // \. a escaped dot, ? zero or one dot
        // [a-zA-Z]+ at least one alphabetical char
        // [a-zA-Z]{2,3} two or three alphabetical chars


        // Before extracting the path, we need to ignore the slash
        // so a non grouping group is added to the regex: (?:[/])

        // Another group is added to find the path: (.*)
        // . any char except line breaks, * match 0 or more

    }
}
