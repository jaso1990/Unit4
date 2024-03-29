package Lesson10Sort;

public class SortNums {

    public static void main(String[] args) {
        int nums[] = new int[100];
        for (int i = 0; i < 100; i++) {
            nums[i] = (int) (Math.random() * 1000) + 1;
            if (i % 20 == 0 && i != 0) {
                System.out.println(nums[i] + ", ");
            } else {
                System.out.print(nums[i] + ", ");
            }
        }
        //selectionSort(nums)
        //bubbleSort(nums);
        insertionSort(nums);
        System.out.println("\n\n=====Selection Sort======\n\n");
        for (int i = 0; i < 100; i++) {
            if (i % 20 == 0 && i != 0) {
                System.out.println(nums[i] + ", ");
            } else {
                System.out.print(nums[i] + ", ");
            }
        }
    }

    //selection sort (aka penguin sort)
    public static void selectionSort(int[] a) {
        for (int i = 0; i < a.length - 1; i++) {
            int minIndex = findMinimum(a, i);
            if (minIndex != i) //if lowest is not already in place
            {
                swap(a, i, minIndex);
            }
        } //end loop
    }

    //supporting findMinimum method for selection sort
    public static int findMinimum(int[] a, int first) {
        //first=where to start looking from
        //assume first is also the smallest for now
        int minIndex = first;
        for (int i = first + 1; i < a.length; i++) {
            if (a[i] < a[minIndex]) {
                minIndex = i;
            }
        }
        return minIndex;
    }

    //bubble sort (aka bully sort)
    public static void bubbleSort(int[] a) {
        int k = 0;
        boolean exchangeMade = true;
        // Make up to n - 1 passes through array, exit 
        //early if no exchanges are made on previous pass

        while ((k < a.length - 1) && exchangeMade) {
            exchangeMade = false;
            k++;
            for (int j = 0; j < a.length - k; j++) {
                if (a[j] > a[j + 1]) {
                    swap(a, j, j + 1);
                    exchangeMade = true;
                }//end if
            }//end for
        }//end while
    }

    //insertion sort (human sort)
    public static void insertionSort(int a[]) {
        int itemToInsert, j;
        boolean stillLooking;

        for (int k = 1; k < a.length; k++) {
            //move backwards through list, looking for
            //the right place to insert a[k];
            itemToInsert = a[k];
            j = k - 1;
            stillLooking = true;
            while (j >= 0 && stillLooking) {
                if (itemToInsert < a[j]) {
                    //move item higher
                    a[j + 1] = a[j];
                    j--;
                } else {
                    //we have found new home for a[k];
                    stillLooking = false;
                }//end else// j+1 is where the item goes
                a[j + 1] = itemToInsert;
            }//end while
        }//end for
    }//end method

//supporting swap method (same as bubble sort swap)
    public static void swap(int[] a, int x, int y) {
        int temp = a[x];
        a[x] = a[y];
        a[y] = temp;
    }

}
