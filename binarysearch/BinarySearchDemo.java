package binarysearch;

/**
 * created by it_hushuai
 * 2020/3/8 20:26
 */
public class BinarySearchDemo {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 5, 8, 13};
//        int index = binarySearchRecur(arr, 0, 5, 3);
        int index = binarySearchNoRecur(arr, 0);
        System.out.println(index);
    }

    /**
     * 递归方式实现二分查找
     * @param arr
     * @param min 数组的最小索引
     * @param max 数组的最大索引
     * @param target 目标值
     * @return
     */
    public static int binarySearchRecur(int[] arr, int min, int max, int target){
        if (max >= min){
            int mid = (min + max) / 2;
            if(arr[mid] == target){
                return mid;
            }else if(arr[mid] > target){
                return binarySearchRecur(arr, min, mid - 1, target);
            }else {
                return binarySearchRecur(arr, mid + 1, max, target);
            }
        }
        return -1;
    }

    /**
     * 非递归方式实现二分查找
     * @param arr
     * @param target
     * @return
     */
    public static int binarySearchNoRecur(int[] arr, int target){
        int min = 0;
        int max = arr.length - 1;
        int mid;
        while (min <= max){
            mid = (min + max) / 2;
            if(arr[mid] == target){
                return mid;
            }else if (arr[mid] > target){
                max = mid - 1;
            }else {
                min = mid + 1;
            }
        }
        return -1;
    }
}
