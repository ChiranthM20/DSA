import java.util.HashSet;
import java.util.Set;

class Solution {
    public int robotSim(int[] commands, int[][] obstacles) {
        Set<String> blocked = new HashSet<>();

        for (int[] obs : obstacles) {
            blocked.add(obs[0] + "," + obs[1]);
        }

        // North, East, South, West
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};

        int dir = 0; // starts facing North
        int x = 0, y = 0;
        int maxDist = 0;

        for (int cmd : commands) {
            if (cmd == -2) {
                dir = (dir + 3) % 4; // turn left
            } else if (cmd == -1) {
                dir = (dir + 1) % 4; // turn right
            } else {
                for (int step = 0; step < cmd; step++) {
                    int nx = x + dx[dir];
                    int ny = y + dy[dir];

                    if (blocked.contains(nx + "," + ny)) {
                        break;
                    }

                    x = nx;
                    y = ny;
                    maxDist = Math.max(maxDist, x * x + y * y);
                }
            }
        }

        return maxDist;
    }
}