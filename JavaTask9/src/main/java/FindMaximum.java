public class FindMaximum {
    public static int findMax(int[]arr, int index) {
        if(index ==arr.length -1){
            return arr[index];
        }
        int Max= findMax(arr, index+1);
        return Math.max(arr[index], Max);
    }
    public static void main(String[] args) {
        int[] arr1 = {3, 7, 2, 9, 4};
        int[] arr2 = {1, 1, 1};
        int[] arr3 = {-5, -2, -8};
        int[] arr4 = {42};

        System.out.println("findMax([3, 7, 2, 9, 4]) = " + findMax(arr1, 0));
        System.out.println("findMax([1, 1, 1]) = " + findMax(arr2, 0));
        System.out.println("findMax([-5, -2, -8]) = " + findMax(arr3, 0));
        System.out.println("findMax([42]) = " + findMax(arr4, 0));
    }
}