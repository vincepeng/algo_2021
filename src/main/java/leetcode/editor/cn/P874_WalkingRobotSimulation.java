package leetcode.editor.cn;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;


//874-模拟行走机器人
public class P874_WalkingRobotSimulation {


    public static void main(String[] args) {

        Solution solution = new P874_WalkingRobotSimulation().new Solution();
        int[] a = {4, -1, 3};
        int[][] obstacles = {};
        //        System.out.println(solution.robotSim(a, obstacles));


    }


    //leetcode submit region begin(Prohibit modification and deletion)


    class Solution {


        private int changeDirection(int current, int command) {
            //-1向右旋转90(顺时针

            if (command == -1) {
                current = (current + 1) % 4;
                //-2向左旋转90(逆时针),如果变为-1,修正为正数;
            }else {
                current = current - 1 < 0 ? 3 - current : current - 1;
            }
            return current;
        }


        //标记方向,东南西北(0,1,2,3),最开始为东;
        private Pair getLocIfHasObstacle(int direction, int distance, Pair currentLoc, Set<Pair> obstacleSets) {

            Integer sumX = currentLoc.getX();
            Integer sumY = currentLoc.getY();
            //东西(y不变)
            if (direction == 0 || direction == 2) {
                for (int dx = 1; dx <= distance; dx++) {
                    //是障碍
                    int newSumX = direction == 0 ? sumX + 1 : sumX - 1;
                    if (obstacleSets.contains(new Pair(newSumX, sumY))) {
                        //直接用原来的返回即可,停止遍历
                        return new Pair(sumX, sumY);
                    }else {
                        sumX = newSumX;
                    }
                }
                return new Pair(sumX, sumY);
                //南北(x不变)
            }else if (direction == 1 || direction == 3) {
                for (int dy = 1; dy <= distance; dy++) {
                    //是障碍
                    int newSumY = direction == 3 ? sumY + 1 : sumY - 1;
                    if (obstacleSets.contains(new Pair(sumX, newSumY))) {
                        //直接用原来的返回即可,停止遍历
                        return new Pair(sumX, sumY);
                    }else {
                        sumY = newSumY;
                    }
                }
                return new Pair(sumX, sumY);
            }
            //不会出现
            throw new RuntimeException("执行失败,内部错误");
        }


        public int robotSim(int[] commands, int[][] obstacles) {
            //标记方向,东南西北(0,1,2,3),最开始为东;
            int direction = 3;
            Pair currentLoc = new Pair(0, 0);
            //转化为地址map

            Set<Pair> obstacleSets = Arrays.stream(obstacles).map(a -> new Pair(a[0], a[1])).collect(Collectors.toSet());

            int max = 0;
            for (int command : commands) {
                if (command < 0) {
                    direction = changeDirection(direction, command);
                    continue;
                }
                currentLoc = getLocIfHasObstacle(direction, command, currentLoc, obstacleSets);
                max = Math.max((int) (Math.pow(currentLoc.getX(), 2) + Math.pow(currentLoc.getY(), 2)), max);
            }
            return max;
        }


        public int robotSim2(int[] commands, int[][] obstacles) {
            int[] dir_x = {0, 1, 0, -1};
            int[] dir_y = {1, 0, -1, 0};
            int x = 0;
            int y = 0;
            //0,1,2,3分别代表北、东、南、西方向，初始为正北方；
            int status = 0;
            int max_distance = 0;
            //判断障碍物：将障碍物的x和y坐标组合成一个字符串用set保存障碍物，查找的时候只要判断当前坐标组成的串是否在set里即可。
            HashSet<String> blockSet = new HashSet<>();
            for (int i = 0; i < obstacles.length; i++) {
                blockSet.add(obstacles[i][0] + "," + obstacles[i][1]);
            }
            for (int i = 0; i < commands.length; i++) {
                if (commands[i] == -1) {
                    status += 1;
                }
                if (commands[i] == -2) {
                    status += 3;
                }
                if (commands[i] > 0) {
                    for (int j = 0; j < commands[i]; j++) {
                        int next_x = x + dir_x[status % 4];
                        int next_y = y + dir_y[status % 4];
                        if (blockSet.contains(next_x + "," + next_y)) {
                            break;
                        }else {
                            x = next_x;
                            y = next_y;
                            max_distance = Math.max(max_distance, x * x + y * y);
                        }
                    }
                }
            }
            return max_distance;
        }
    }


    class Pair {

        Integer x;

        Integer y;


        public Pair(Integer x, Integer y) {
            this.x = x;
            this.y = y;
        }


        @Override
        public boolean equals(Object obj) {
            if (obj instanceof Pair) {
                return x.equals(((Pair) obj).x) && y.equals(((Pair) obj).y);
            }
            return false;
        }


        public int getX() {
            return x;
        }


        public int getY() {
            return y;
        }


        @Override
        public int hashCode() {
            return (x << 16) ^ y;
        }


        //
        @Override
        public String toString() {
            return "x:" + x + "; y:" + y;
        }

    }
    //leetcode submit region end(Prohibit modification and deletion)

}