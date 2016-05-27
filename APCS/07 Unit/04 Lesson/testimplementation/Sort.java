// Selection sort implementation from the Wikipedia page

class SortImp {
    
    int[] arr = {9, 8, 2, 3, 5, 1, 0, 6, 4, 7};
    int i, j;
    
    
    protected void sort() {
        
        System.out.print("unsorted arr: ");
        for(int k = 0; k < arr.length; k++) {
            System.out.print(arr[k] + ", ");
        }
        
        // For every item in arr
        for(j = 0; j < arr.length; j++) {
            // Find min element in unsorted arr
            
            // Assume the min is the first element
            int iMin = j;
            
            // Test against elements after j to find the smallest
            for(i = j+1; i < arr.length; i++) {
                // if this element is less, then it is the new minimum.
                if(arr[i] > arr[iMin]) {
                    // remember new minimum's index
                    iMin = i;
                }
            }
            
            if(iMin != j) {
                int tmp = arr[j];
                arr[j] = arr[iMin];
                arr[iMin] = tmp;
                
                System.out.println("");
                for(int k = 0; k < arr.length-1; k++) {
                    System.out.print(arr[k] + ", ");
                }
            }      
        }
        
        System.out.print("\nsorted arr: ");
        for(int k = 0; k < arr.length; k++) {
            System.out.print(arr[k] + ", ");
        }
    }
}


class Sort {
    public static void main(String[] args) {
        SortImp s =  new SortImp();
        
        s.sort();
    }
}
