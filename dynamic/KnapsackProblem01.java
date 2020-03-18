package dynamic;

import java.util.Arrays;

/**
 * 01背包问题
 * <p>
 * created by it_hushuai
 * 2020/3/18 20:45
 */
public class KnapsackProblem01 {
    static int[] W = {2, 2, 1};//A B C三个物品的重量，单位kg
    static int[] V = {1, 2, 3};//A B C三个物品的价格，单位元
    static int C = 3;//设背包容量C，单位kg
    static int[][] dynamicTable = new int[W.length + 1][C + 1];//动态规划表，第一行和第一列都为0
    static int[] path = new int[W.length];

    public static void main(String[] args) {
        dynamicPlan();
        findPath(W.length, C);
        System.out.println(Arrays.toString(path));
    }

    public static void dynamicPlan() {
        /**
         * 表格的第i行就表示第i个物品，而不用每次都考虑索引从0开始的问题而-1
         * 表格的第j列就表示当前容量为j（kg）
         */
        for (int i = 1; i <= W.length; i++) {
            for (int j = 1; j <= C; j++) {
                /**
                 * dynamicTable[i][j]记录的是前i个物品放入容量为j的背包中能够得到的最大价值
                 */
                if (W[i - 1] > j) {
                    /**
                     * 第i个物品的重量为W[i-1],如果比当前限定容量大，则不能放入第i个物品，
                     * 所以最大价值仍为前i-1个物品放入容量j的包中最优解
                     */
                    dynamicTable[i][j] = dynamicTable[i - 1][j];
                } else {//W[i - 1] <= j，说明第i个物品可以放入背包，但是第i个物品放入背包中得到的价值是不是最大？仍需判断
                    dynamicTable[i][j] = Math.max(dynamicTable[i - 1][j], V[i - 1] + dynamicTable[i - 1][j - W[i - 1]]);
                }
            }
        }

        for (int i = 0; i < dynamicTable.length; i++) {
            System.out.println(Arrays.toString(dynamicTable[i]));
        }
    }

    public static void findPath(int i, int j) {
        if(i >= 1){
            if (W[i - 1] <= j && dynamicTable[i][j] == V[i - 1] + dynamicTable[i - 1][j - W[i - 1]]) {//说明第i个物品放入了背包
                path[i - 1] = 1;
                findPath(i - 1, j - W[i - 1]);//path中记录的第i个物品已放入背包，因此继续从背包剩余容量中找到后加入的物品
            } else if (dynamicTable[i][j] == dynamicTable[i - 1][j]) {//说明前i-1个物品中才能找到最优解
                findPath(i - 1, j);
            }
        }
    }
}
