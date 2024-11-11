import java.util.Scanner;

enum DIR {
    RIGHT, BOT, LEFT, TOP
}

enum SIDE {
    LEFTW, RIGHTW
}

class Player {

    static char[][] line = new char[103][103];
    static char[] directions = { '>', 'v', '<', '^' };
    static char[] sides = { 'L', 'R' };
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int w = scanner.nextInt();
        int h = scanner.nextInt();
        scanner.nextLine(); // Move scanner to next line
        
        int posX = 0, posY = 0;
        DIR dir = DIR.RIGHT;
        SIDE side;

        // Initialize the grid with '#'
        for (int i = 0; i < 103; i++) {
            for (int j = 0; j < 103; j++) {
                line[i][j] = '#';
            }
        }

        // Read the map and find the initial direction and position
        for (int i = 1; i <= h; i++) {
            String tmp = scanner.nextLine();
            for (int t = 0; t < w; t++) {
                line[i][t + 1] = tmp.charAt(t);
            }
            for (int j = 1; j <= w; j++) {
                for (int d = 0; d < 4; d++) {
                    if (line[i][j] == directions[d]) {
                        posX = i;
                        posY = j;
                        dir = DIR.values()[d];
                        break;
                    }
                }
            }
        }

        // Read the side input
        String sd = scanner.nextLine();
        side = (sd.charAt(0) == sides[0]) ? SIDE.LEFTW : SIDE.RIGHTW;

        // Starting position
        int curX = posX, curY = posY;
        line[curX][curY] = '0';

        // If the initial position is surrounded by walls
        if (isSurroundedByWalls(curX, curY)) {
            printGrid(h, w);
            return;
        }

        // Main loop for movement
        do {
            if (side == SIDE.LEFTW) {
                dir = moveLeftWall(dir, curX, curY);
            } else {
                dir = moveRightWall(dir, curX, curY);
            }

            // Move to the new coordinates
            switch (dir) {
                case RIGHT -> curY++;
                case BOT -> curX++;
                case LEFT -> curY--;
                case TOP -> curX--;
            }

            line[curX][curY]++;
        } while (curX != posX || curY != posY);

        printGrid(h, w);
    }

    // Check if the current position is surrounded by walls
    private static boolean isSurroundedByWalls(int x, int y) {
        return line[x - 1][y] == '#' && line[x + 1][y] == '#' && 
               line[x][y - 1] == '#' && line[x][y + 1] == '#';
    }

    // Movement function for left wall following
    private static DIR moveLeftWall(DIR dir, int x, int y) {
        switch (dir) {
            case RIGHT:
                if (line[x - 1][y] != '#') return DIR.TOP;
                else if (line[x][y + 1] != '#') return DIR.RIGHT;
                else if (line[x + 1][y] != '#') return DIR.BOT;
                else return DIR.LEFT;
            case BOT:
                if (line[x][y + 1] != '#') return DIR.RIGHT;
                else if (line[x + 1][y] != '#') return DIR.BOT;
                else if (line[x][y - 1] != '#') return DIR.LEFT;
                else return DIR.TOP;
            case LEFT:
                if (line[x + 1][y] != '#') return DIR.BOT;
                else if (line[x][y - 1] != '#') return DIR.LEFT;
                else if (line[x - 1][y] != '#') return DIR.TOP;
                else return DIR.RIGHT;
            case TOP:
                if (line[x][y - 1] != '#') return DIR.LEFT;
                else if (line[x - 1][y] != '#') return DIR.TOP;
                else if (line[x][y + 1] != '#') return DIR.RIGHT;
                else return DIR.BOT;
        }
        return dir;
    }

    // Movement function for right wall following
    private static DIR moveRightWall(DIR dir, int x, int y) {
        switch (dir) {
            case RIGHT:
                if (line[x + 1][y] != '#') return DIR.BOT;
                else if (line[x][y + 1] != '#') return DIR.RIGHT;
                else if (line[x - 1][y] != '#') return DIR.TOP;
                else return DIR.LEFT;
            case BOT:
                if (line[x][y - 1] != '#') return DIR.LEFT;
                else if (line[x + 1][y] != '#') return DIR.BOT;
                else if (line[x][y + 1] != '#') return DIR.RIGHT;
                else return DIR.TOP;
            case LEFT:
                if (line[x - 1][y] != '#') return DIR.TOP;
                else if (line[x][y - 1] != '#') return DIR.LEFT;
                else if (line[x + 1][y] != '#') return DIR.BOT;
                else return DIR.RIGHT;
            case TOP:
                if (line[x][y + 1] != '#') return DIR.RIGHT;
                else if (line[x - 1][y] != '#') return DIR.TOP;
                else if (line[x][y - 1] != '#') return DIR.LEFT;
                else return DIR.BOT;
        }
        return dir;
    }

    // Function to print the final grid
    private static void printGrid(int h, int w) {
        for (int i = 1; i <= h; i++) {
            for (int j = 1; j <= w; j++) {
                System.out.print(line[i][j]);
            }
            System.out.println();
        }
    }
}
