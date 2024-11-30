/* To study the thickness of a layer of rock before a new layer of rock is deposited on top (layers settle with weight), this past thickness is calculated as a function of the evolution of the rock's porosity, according to the following formula:

initial_thickness = current_thickness / ( 1-(log₁₀(current_porosity)-log₁₀(initial_porosity)))

You have to calculate this initial thickness of a given rock layer.
Input
Line 1 : An integer CT current thickness
Line 2 : A float CP current porosity
Line 3 : A float IP initial porosity
Output
Line 1 : An integer IT truncated initial thickness */

import java.util.*;

class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Read current thickness, current porosity, and initial porosity
        int ct = sc.nextInt();  // Current thickness
        double cp = sc.nextDouble();  // Current porosity
        double ip = sc.nextDouble();  // Initial porosity

        // Calculate initial thickness using the formula
        double logDiff = Math.log10(cp) - Math.log10(ip);
        double it = ct / (1 - logDiff);

        // Print the truncated result as an integer
        System.out.println((int) it);
    }
}
