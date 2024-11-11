import java.util.*;
import java.io.*;
import java.math.*;

class Player {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int surfaceN = in.nextInt(); // the number of points used to draw the surface of Mars.

        // Read the surface points but ignore them for now (they are not necessary for the logic here)
        for (int i = 0; i < surfaceN; i++) {
            int landX = in.nextInt(); // X coordinate of a surface point
            int landY = in.nextInt(); // Y coordinate of a surface point
        }

        // Game loop
        while (true) {
            // Read the player's current position and state
            int X = in.nextInt();
            int Y = in.nextInt();
            int hSpeed = in.nextInt(); // horizontal speed
            int vSpeed = in.nextInt(); // vertical speed
            int fuel = in.nextInt(); // remaining fuel
            int rotate = in.nextInt(); // rotation angle
            int power = in.nextInt(); // thrust power

            // Adjust power based on vertical speed (if vSpeed < -35, increase power)
            if (vSpeed < -35 && power < 4) {
                power = power + 1;
            }
            // Decrease power if vertical speed is less than -30
            if (vSpeed > -30 && power > 0) {
                power = power - 1;
            }

            // Output the desired rotation (always 0 for this level) and the thrust power
            System.out.println("0 " + power);
        }
    }
}
