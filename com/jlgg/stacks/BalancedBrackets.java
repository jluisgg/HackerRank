package com.jlgg.stacks;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Two Brackets are considered a matched pair if an opening bracket occurs to the left of a closing bracket
 * A matching pair of brackets is not balanced if the set of brackets it encloses are not matched
 */
public class BalancedBrackets {

    private static Map<Character, Character> map;

    private static void populateMap() {
        map.put('{', '}');
        map.put('[', ']');
        map.put('(', ')');
    }

    /**
     * O(N) - linear complexity
     */
    private static boolean isBalanced(String s) {
        // Stack for Opening brackets
        Stack<Character> stack = new Stack<>();
        char[] sArr = s.toCharArray();

        char current;
        for (int i = 0; i < sArr.length; i++) {
            current = sArr[i];
            // If current char is a opening bracket, push it to the stack
            if (map.containsKey(current)) {
                stack.push(current);
            } else { // current char is a closing bracket
                if (stack.isEmpty()) { // There is a closing bracket unmatched
                    return false;
                }
                // pop the opening bracket from the stack and see if matches
                if (map.get(stack.pop()) != current) {
                    return false;
                }
            }
        }
        // If empty then balanced, otherwise there is an opening bracket unmatched
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        // Map for matching brackets
        map = new HashMap<Character, Character>();
        populateMap();

        String s1 = "{[()]}";
        System.out.println("The String: " + s1 + " is balanced?: " + isBalanced(s1));
        String s2 = "{[(])}";
        System.out.println("The String: " + s2 + " is balanced?: " + isBalanced(s2));
        String s3 = "{{[[(([]))]]}}";
        System.out.println("The String: " + s3 + " is balanced?: " + isBalanced(s3));
        String s4 = "[()]{}{[()()]()}";
        System.out.println("The String: " + s4 + " is balanced?: " + isBalanced(s4));
    }
}
