import java.util.*;

class Player {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);

        // Initialize variables
        int nbPts = in.nextInt(); // Number of landing points
        int lastX = 0, lastY = 0; // Previous terrain point
        int X = 0, Y = 0; // Landing coordinates (center of flat terrain)

        // Compute the landing position (flat terrain area)
        for (int i = 0; i < nbPts; i++) {
            int x = in.nextInt(); // X coordinate of the terrain point
            int y = in.nextInt(); // Y coordinate of the terrain point

            if (y == lastY) { // Check if it's a flat area
                X = (lastX + x) / 2; // Midpoint for X coordinate
                Y = lastY; // Same Y coordinate for the flat area
            }
            lastX = x;
            lastY = y;
        }

        // Game loop
        while (true) {
            // Read current game state
            int x = in.nextInt(); // X coordinate of the lander
            int y = in.nextInt(); // Y coordinate of the lander
            int vx = in.nextInt(); // Horizontal speed (velocity)
            int vy = in.nextInt(); // Vertical speed (velocity)
            int fuel = in.nextInt(); // Remaining fuel
            int rotate = in.nextInt(); // Rotation angle
            int power = in.nextInt(); // Thrust power

            // Calculate the rotation angle based on the vertical distance
            rotate = (y - Y) > 100 ? ((x - X) / 100) + (int) (vx * 0.64) : 0;

            // Adjust power based on vertical speed and horizontal speed squared
            power = (vy < -20 || vx * vx > 1600) ? 4 : 2;

            // Output the rotation and power
            System.out.println(rotate + " " + power);
        }
    }
}
