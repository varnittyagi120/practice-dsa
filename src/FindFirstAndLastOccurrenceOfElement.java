package src;

class FindFirstAndLastOccurrenceOfElement {
    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[2];
        if(nums.length==0){
            result[0] = -1;
            result[1] = -1;
            return result;
        }
        findFirstOccurrence(target, nums, result);
        if(result[0]==-1){
            return result;
        } else {
            findLastOccurrence(target, nums, result);
        }
        return result;
    }

    private static void findFirstOccurrence(int target, int[] integerList, int[] result) {
        int low = 0;
        int high = integerList.length-1;
        boolean flag = true;
        while(low<=high){
            int mid = low + ((high-low)/2);
            if(target == integerList[mid] && (mid == 0 || integerList[mid] != integerList[mid-1])){
                result[0]=mid;
                flag = false;
                break;
            } else if(target>integerList[mid]){
                low = mid+1;
            } else if(target<=integerList[mid]){
                high = mid-1;
            }
        }

        if(flag){
            result[0] = -1;
            result[1] = -1;
        }
    }

    private static void findLastOccurrence(int target, int[] listOfIntegers, int[] result) {
        int low = 0;
        int high = listOfIntegers.length-1;
        while(low<=high){
            int mid = low + ((high-low)/2);
            if(target == listOfIntegers[mid] && (mid == listOfIntegers.length-1 || listOfIntegers[mid] != listOfIntegers[mid+1])){
                result[1]=mid;
                break;
            } else if(target<listOfIntegers[mid]){
                high = mid-1;
            } else if(target>=listOfIntegers[mid]){
                low = mid+1;
            }
        }
    }

}