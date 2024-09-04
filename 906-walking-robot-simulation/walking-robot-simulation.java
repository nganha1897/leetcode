class Solution {
    public int robotSim(int[] commands, int[][] obstacles) {
        int[] dir = {0, 1, 0, -1};
        int x = 0, y = 0, d = 0, ans = 0, offset = 30000;
        Map<Integer, Set<Integer>> obs = new HashMap<>();

        for (int i=0; i<obstacles.length; i++) {
            obs.computeIfAbsent(obstacles[i][0], v -> new HashSet<>());
            obs.get(obstacles[i][0]).add(obstacles[i][1]);
        }

        for (int i=0; i<commands.length; i++) {
            if (commands[i] == -2) {
                d = (d + 3) % 4;
            } else if (commands[i] == -1) {
                d = (d + 1) % 4;
            } else {
                for (int f=0; f<commands[i]; f++) {
                    int nextX = x + dir[d]; 
                    int nextY = y + dir[(d + 1) % 4];
                    if (obs.containsKey(nextX) && obs.get(nextX).contains(nextY)) {
                        break;
                    }
                    x = nextX;
                    y = nextY;
                    ans = Math.max(ans, x * x + y * y);
                }
            }
        }
        return ans;
    }
}