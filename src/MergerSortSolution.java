package src;

public class MergerSortSolution {
    public static void main(String[] args) {
        int[] arr = {12, 11, 13, 5, 6, 7};
        mergeSort(arr, 0, arr.length-1);
        for(int i=0;i<arr.length;i++){
            System.out.println(arr[i]);
        }
    }

    private static void mergeSort(int[] arr, int left, int right){
        if(left>=right){
            return;
        }
        int mid = left + ((right-left)/2);
        mergeSort(arr, left, mid);
        mergeSort(arr, mid+1, right);
        mergeHalfArray(arr, left, mid, right);
    }

    private static void mergeHalfArray(int[] arr, int left, int mid, int right) {
        int s1 = mid-left+1;
        int s2 = right-mid;

        int i=0;
        int j=0;
        int[] leftArray = new int[s1];
        int[] rightArray = new int[s2];
        for(i=0;i<s1;i++){
            leftArray[i] = arr[left+i];
        }

        for(j=0;j<s2;j++){
            rightArray[j] = arr[mid+j+1];
        }

        i=0;
        j=0;
        int k = left;
        while(i<s1 && j<s2){
            if(leftArray[i]<=rightArray[j]){
                arr[k] = leftArray[i];
                i++;
            } else {
                arr[k] = rightArray[j];
                j++;
            }
            k++;
        }

        while(i<s1){
            arr[k] = leftArray[i];
            i++;
            k++;
        }

        while(j<s2){
            arr[k] = rightArray[j];
            j++;
            k++;
        }
    }
}
