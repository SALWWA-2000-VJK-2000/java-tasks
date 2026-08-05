public class ArraySum {
    public static int sumArray(int[]arr, int index) {
        if(index>= arr.length){
            return 0;
        }
        return arr[index]+ sumArray(arr, index+1);
    }

    public static void main(String[] args){
        int[] arr1= {1, 2, 3};
        int[] arr2={10, 20, 30, 40};
        int[] arr3 ={5};
        int[] arr4={};
        System.out.println("sumArray([1, 2, 3]) = " + sumArray(arr1, 0));
        System.out.println("sumArray([10, 20, 30, 40]) = " + sumArray(arr2, 0));
        System.out.println("sumArray([5]) = " + sumArray(arr3, 0));
        System.out.println("sumArray([]) = " + sumArray(arr4, 0));
    }
}
