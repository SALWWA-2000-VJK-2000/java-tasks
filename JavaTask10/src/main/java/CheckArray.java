public class CheckArray {
    public static  boolean isSorted(int[] arr,int index){
        if(index >= arr.length - 1) {
            return true;
        }
        // stop
        if(arr[index] > arr[index + 1]){
            return false;
        }
        return isSorted(arr,index + 1);
    }
    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 4};
        int[] arr2 = {1, 5, 2, 8};
        int[] arr3 = {10, 20, 30};
        int[] arr4 = {3, 3, 3};

        System.out.println("isSorted([1, 2, 3, 4]) = " + isSorted(arr1, 0));
        System.out.println("isSorted([1, 5, 2, 8]) = " + isSorted(arr2, 0));
        System.out.println("isSorted([10, 20, 30]) = " + isSorted(arr3, 0));
        System.out.println("isSorted([3, 3, 3]) = " + isSorted(arr4, 0));
    }
}
