/*Goal
In a house there are X rooms , and in each room there are Y windows . How many windows in the house ?
You should print the total number of windows in this house.
Input
Line 1: Two space-separated integers X and Y for the number of rooms and the number of windows in each room respectively.
Output
One line: The total number of windows in this house.
Constraints
0 ≤ X ≤ 100
0 ≤ Y ≤ 100" */

import java.util.*;
import java.io.*;
import java.math.*;

class Solution {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int X = in.nextInt(); // Number of rooms
        int Y = in.nextInt(); // Number of windows per room

        // Calculate the total number of windows
        int totalWindows = X * Y;

        // Output the result
        System.out.println(totalWindows);
    }
}
