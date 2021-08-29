package leetcode.editor.cn;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;


//874-模拟行走机器人
public class P874_WalkingRobotSimulation {


    public static void main(String[] args) {

        Solution solution = new P874_WalkingRobotSimulation().new Solution();
        int[] a = {4, -1, 3};
        int[][] obstacles = {};
        //        System.out.println(solution.robotSim(a, obstacles));


        int[] a2 = {4, -1, 4, -2, 4};
        int[][] obstacles2 = {{2, 4}};
        //        System.out.println(solution.robotSim(a2, obstacles2));

        int[] a3 = {1, 2, -2, 5, -1, -2, -1, 8, 3, -1, 9, 4, -2, 3, 2, 4, 3, 9, 2, -1, -1, -2, 1, 3, -2, 4, 1, 4, -1, 1, 9, -1, -2, 5, -1, 5, 5, -2, 6, 6, 7, 7, 2, 8, 9, -1, 7, 4, 6, 9, 9, 9, -1, 5
                , 1, 3, 3, -1, 5, 9, 7, 4, 8, -1, -2, 1, 3, 2, 9, 3, -1, -2, 8, 8, 7, 5, -2, 6, 8, 4, 6, 2, 7, 2, -1, 7, -2, 3, 3, 2, -2, 6, 9, 8, 1, -2, -1, 1, 4, 7};
        int[][] obstacles3 = {{-57, -58}, {-72, 91}, {-55, 35}, {-20, 29}, {51, 70}, {-61, 88}, {-62, 99}, {52, 17}, {-75, -32}, {91, -22}, {54, 33}, {-45, -59}, {47, -48}, {53, -98}, {-91, 83},
                {81, 12}, {-34, -90}, {-79, -82}, {-15, -86}, {-24, 66}, {-35, 35}, {3, 31}, {87, 93}, {2, -19}, {87, -93}, {24, -10}, {84, -53}, {86, 87}, {-88, -18}, {-51, 89}, {96, 66}, {-77,
                -94}, {-39, -1}, {89, 51}, {-23, -72}, {27, 24}, {53, -80}, {52, -33}, {32, 4}, {78, -55}, {-25, 18}, {-23, 47}, {79, -5}, {-23, -22}, {14, -25}, {-11, 69}, {63, 36}, {35, -99},
                {-24, 82}, {-29, -98}, {-50, -70}, {72, 95}, {80, 80}, {-68, -40}, {65, 70}, {-92, 78}, {-45, -63}, {1, 34}, {81, 50}, {14, 91}, {-77, -54}, {13, -88}, {24, 37}, {-12, 59}, {-48,
                -62}, {57, -22}, {-8, 85}, {48, 71}, {12, 1}, {-20, 36}, {-32, -14}, {39, 46}, {-41, 75}, {13, -23}, {98, 10}, {-88, 64}, {50, 37}, {-95, -32}, {46, -91}, {10, 79}, {-11, 43}, {-94,
                98}, {79, 42}, {51, 71}, {4, -30}, {2, 74}, {4, 10}, {61, 98}, {57, 98}, {46, 43}, {-16, 72}, {53, -69}, {54, -96}, {22, 0}, {-7, 92}, {-69, 80}, {68, -73}, {-24, -92}, {-21, 82},
                {32, -1}, {-6, 16}, {15, -29}, {70, -66}, {-85, 80}, {50, -3}, {6, 13}, {-30, -98}, {-30, 59}, {-67, 40}, {17, 72}, {79, 82}, {89, -100}, {2, 79}, {-95, -46}, {17, 68}, {-46, 81},
                {-5, -57}, {7, 58}, {-42, 68}, {19, -95}, {-17, -76}, {81, -86}, {79, 78}, {-82, -67}, {6, 0}, {35, -16}, {98, 83}, {-81, 100}, {-11, 46}, {-21, -38}, {-30, -41}, {86, 18}, {-68, 6}
                , {80, 75}, {-96, -44}, {-19, 66}, {21, 84}, {-56, -64}, {39, -15}, {0, 45}, {-81, -54}, {-66, -93}, {-4, 2}, {-42, -67}, {-15, -33}, {1, -32}, {-74, -24}, {7, 18}, {-62, 84}, {19,
                61}, {39, 79}, {60, -98}, {-76, 45}, {58, -98}, {33, 26}, {-74, -95}, {22, 30}, {-68, -62}, {-59, 4}, {-62, 35}, {-78, 80}, {-82, 54}, {-42, 81}, {56, -15}, {32, -19}, {34, 93}, {57
                , -100}, {-1, -87}, {68, -26}, {18, 86}, {-55, -19}, {-68, -99}, {-9, 47}, {24, 94}, {92, 97}, {5, 67}, {97, -71}, {63, -57}, {-52, -14}, {-86, -78}, {-17, 92}, {-61, -83}, {-84,
                -10}, {20, 13}, {-68, -47}, {7, 28}, {66, 89}, {-41, -17}, {-14, -46}, {-72, -91}, {4, 52}, {-17, -59}, {-85, -46}, {-94, -23}, {-48, -3}, {-64, -37}, {2, 26}, {76, 88}, {-8, -46},
                {-19, -68}};
        System.out.println(solution.robotSim(a3, obstacles3));

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
            throw new RuntimeException("执行失败");
        }


        public int robotSim(int[] commands, int[][] obstacles) {
            //标记方向,东南西北(0,1,2,3),最开始为东;
            int direction = 3;
            Pair currentLoc = new Pair(0, 0);
            //转化为地址map

            Set<Pair> obstacleSets = Arrays.stream(obstacles).map(a -> new Pair(a[0], a[1])).collect(Collectors.toSet());


            for (int command : commands) {
                if (command < 0) {
                    direction = changeDirection(direction, command);
                    continue;
                }
                currentLoc = getLocIfHasObstacle(direction, command, currentLoc, obstacleSets);
            }
            return (int) (Math.pow(currentLoc.getX(), 2) + Math.pow(currentLoc.getY(), 2));
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