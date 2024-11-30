/* Given a name n, determine its origin based on the following conditions:

If the name contains any numbers and a mix of uppercase and lowercase Latin characters, it is classified as an Alien Name.

If the name ends with an uppercase Latin character, it is classified as a Star Name (e.g., AncodingB, MonsterrX, AlpabitaB, RubinX, etc.).. if it does not qualify as an Alien Name (e.g., Ancoding12B, Monster2X, F2AlpabitaB, Rol3RubinX, etc.).

If neither of the above conditions are met, the name is classified as a Human Name.
Your task is to identify and return the type of name based on these conditions.

Happy Coding!*/

import java.util.*;
import java.io.*;
import java.math.*;

class Solution {

    public static void main(String args[]) {
        Scanner inputScanner_42 = new Scanner(System.in);
        String nameInput_X = inputScanner_42.nextLine(); // Read the input name

        // Determine and output the classification of the name
        if (isNameType_Alien_42(nameInput_X)) {
            System.out.println("Alien Name");
        } else if (isNameType_Star_42(nameInput_X)) {
            System.out.println("Star Name");
        } else {
            System.out.println("Human Name");
        }
    }

    // Method to check if the name is an Alien Name
    public static boolean isNameType_Alien_42(String nameInput_X) {
        boolean containsNumber_42 = nameInput_X.matches(".*\\d.*"); // Check if it contains a number
        boolean containsUpper_42 = nameInput_X.matches(".*[A-Z].*"); // Check if it contains an uppercase letter
        boolean containsLower_42 = nameInput_X.matches(".*[a-z].*"); // Check if it contains a lowercase letter
        return containsNumber_42 && containsUpper_42 && containsLower_42;
    }

    // Method to check if the name is a Star Name
    public static boolean isNameType_Star_42(String nameInput_X) {
        if (nameInput_X.length() == 0) return false; // Handle empty string case
        char lastCharacter_42 = nameInput_X.charAt(nameInput_X.length() - 1); // Get the last character
        boolean isUpperLatin_42 = (lastCharacter_42 >= 'A' && lastCharacter_42 <= 'Z');
        return isUpperLatin_42 && !isNameType_Alien_42(nameInput_X); // Ensure it's not an Alien Name
    }
}
