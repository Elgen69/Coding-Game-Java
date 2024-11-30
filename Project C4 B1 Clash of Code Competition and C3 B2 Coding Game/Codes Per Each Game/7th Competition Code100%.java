/*You must reverse the input and swap the cases!
Input
Line 1 : A string string to process.
Output
Line 1: The reversed string with swapped cases.*/

import java.util.*;

class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println(new StringBuilder(sc.nextLine())
                            .reverse()
                            .toString()
                            .chars()
                            .map(c -> Character.isLowerCase(c) ? Character.toUpperCase(c) : Character.toLowerCase(c))
                            .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                            .toString());
    }
}


// Or

import java.util.*;

class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine(); // Read the input string
        StringBuilder sb = new StringBuilder(s); // Use StringBuilder to reverse the string
        // Reverse and swap the case for each character
        StringBuilder result = new StringBuilder();
        for (int i = sb.length() - 1; i >= 0; i--) {
            char c = sb.charAt(i);
            if (Character.isLowerCase(c)) result.append(Character.toUpperCase(c));
            else result.append(Character.toLowerCase(c));
        }
        System.out.println(result.toString()); 
    }
}
