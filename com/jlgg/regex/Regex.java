package com.jlgg.regex;

/**
 * https://regexr.com/
 *
 * Character classes:
 * Defines the sets of characters that the patter matcher will search for.
 * There are predefined character classes i.e. the dot "." will match any character except for line breaks
 * [x-z] if matching characters that follow alphabetically you can use a range
 * <p>
 * Character Sets:
 * Matches any character defined in the set.
 * Predefined character set i.e. \w matches a word, \s matches any whitespace
 * <p>
 * Quantifiers:
 * Simple rules that allow you to define how the preceding character sets should be match
 * "+" at least one character in the preceding set must be present
 * "*" zero or more characters must be found in text
 * {2,4} The range can match a defined allowed number of matches, a range of matches, or a range without upper limit
 * "?" the preceding character should match either 0 or 1 times
 * <p>
 * Anchors:
 * Give you extra dimension of control so you can define the boundaries in a text rather than the text itself
 * ^xyz the starting anchor lets you match the start of a text
 * $ the end anchor lets you match the end of a text
 * \b\B Word boundaries represent non-word characters in a text. They are similar to negated character sets
 * <p>
 * Capturing groups:
 * Allow you to group tokens in an expression to form sub-strings. Any capturing token can be used within a group
 * including nesting other groups
 * (xyz),(x(y(z))) A common application is separating strings into substrings
 * \1, \2, \3 References a specific group and performs a match on that group. Capturing groups are indexed based on opening parenthesis
 * (?:xyz) You can exclude matched groups from a result, but still keep them as part of the relevant matching expression
 * <p>
 * Escaped Characters:
 * You can use \ to escape characters to match them in the string. It is useful for matching serialized data such as
 * XML and JSON. It is also used to match non-text characters
 * \n newline
 * \t tab
 * \0 null character
 * <p>
 * Flags:
 * Any characters placed directly after the closing marker are called flags.
 * //g global flag allows the matcher to store the indexes of the last match so that it may continue searching for more matches in text
 * //i this makes the expression to match any text, ignoring case differences
 * <p>
 * *
 */
public class Regex {
}
