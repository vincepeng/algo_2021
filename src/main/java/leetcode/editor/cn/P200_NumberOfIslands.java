package leetcode.editor.cn;

//200-岛屿数量
public class P200_NumberOfIslands {

    public static void main(String[] args) {

        Solution solution = new P200_NumberOfIslands().new Solution();
        char[][] grid = {//
                {'1', '1', '1', '1', '0'},//
                {'1', '1', '0', '1', '0'},//
                {'1', '1', '0', '0', '0'},//
                {'0', '0', '0', '0', '0'}};
        System.out.println(solution.numIslands(grid));
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        private void dfs(char[][] grid, int i, int j) {
            if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length) {
                return;
            }
            //可能为0或者2(遍历过)
            if (grid[i][j] != '1') {
                return;
            }

            //染色,通过染色然后让无法连通的即使小岛
            grid[i][j] = '2';

            dfs(grid, i, j - 1);
            dfs(grid, i, j + 1);
            dfs(grid, i - 1, j);
            dfs(grid, i + 1, j);

        }


        public int numIslands(char[][] grid) {
            if (grid.length == 0) {
                return 0;
            }
            int height = grid.length;
            int weight = grid[0].length;
            int total = 0;
            for (int i = 0; i < height; i++) {
                for (int j = 0; j < weight; j++) {
                    if (grid[i][j] == '1') {
                        dfs(grid, i, j);
                        total++;
                    }
                }
            }
            return total;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}