package fenzhi;

/**
 * created by it_hushuai
 * 2020/3/9 22:26
 */
public class HanoiTower {
    /**
     * 汉诺塔可以通过分治算法的思想来解决
     * 分治算法：就是把一个复杂的问题分成两个或更多的相同或相似的子问题，再把子问题分成更小的子问题
     * 例如在汉诺塔这个游戏中，我们可以把n个盘子看成两个部分：最底层的盘子Pn和上面所有的盘子P1_n-1，模拟只有两个盘子的操作
     * 我们可以把问题看成每次都是将上面所有盘子P1_n-1整体从A柱移动到B柱，再把最下面的盘子Pn从A移动到C，最后把P1_n-1从B移动到C
     * 这种将复杂问题拆成重复的简单问题的思想，就是分治
     *
     * @param n 表示有n个盘子
     * @param A 表示一个盘子从某个柱子离开
     * @param B 表示未使用到的柱子，临时使用的柱子
     * @param C 表示一个盘子要放置的位置
     */
    public static void move(int n, char A, char B, char C) {
        if (n == 1) {
            System.out.println("第1个盘子从" + A + "->" + C);
        } else {
            move(n - 1, A, C, B);//将上面n-1个盘子整体从A移动到B
            System.out.println("第" + n + "个盘子从" + A + "->" + C);//将最下面第n个盘子从A移动C
            move(n - 1, B, A, C);//将上面n-1个盘子整体从B移动到C
        }
    }

    public static void main(String[] args) {
        move(3, 'A', 'B', 'C');
    }
}
