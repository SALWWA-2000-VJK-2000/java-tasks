public class SumEvenIndex {
    public static int sumEvenIndex(int[] arr, int index) {
        if (index >= arr.length) {
            return 0;
        }
        return arr[index] + sumEvenIndex(arr, index + 2);
    }

    public static void main(String[] args) {
        int[] arr1 = {10, 5, 20, 5, 30};
        int[] arr2 = {1, 2, 3, 4};
        int[] arr3 = {7};
        int[] arr4 = {2, 9};

        System.out.println("sumEvenIndex([10, 5, 20, 5, 30]) = " + sumEvenIndex(arr1, 0));
        System.out.println("sumEvenIndex([1, 2, 3, 4]) = " + sumEvenIndex(arr2, 0));
        System.out.println("sumEvenIndex([7]) = " + sumEvenIndex(arr3, 0));
        System.out.println("sumEvenIndex([2, 9]) = " + sumEvenIndex(arr4, 0));
    }
}
