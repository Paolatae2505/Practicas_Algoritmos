public class OrdenamientoQuick {


    public void QuickSortFirst(int A [],int a , int b){
        int j = 0;
        if(a <= b){
            j = this.Partition(A,a,b);
            QuickSortFirst(A,a,j-1);
            QuickSortFirst(A,j+1,b);
        }

       // imprimirA(A);

    }

    public int Partition(int A [],int a,int b){
        int i = a +1;
        int j = b ;

        while (A[i-1] < A[j-1] ){
            i = i +1  ; 
        }

        while (A[j-1] > A[i-1]){
            j = j - 1;
        }
        
        while (i < j ){
            int temp = A[i-1];
            A[i-1] = A[j-1];
            A[j-1] = temp;

            i = i +1 ;
            j = j -1;

            while (A[i-1] < A[a-1]) {
                i = i + 1;
            }
            while (A[j-1] > A[a-1]){
                j = j -1;
            } 
        }
        if (a < j) {
            int temp2 = A[a-1];
            A[a-1] = A[j-1];
            A[j-1] = temp2;
        }
        
        return j;

    }

    public void imprimirA(int [] A){
        for(int i = 0 ; i < A.length;i++){
               String cadena = A[i] + ",";
            System.out.print(cadena);
        }
        
    }

    public int[] sortArray(int[] nums) {
        quickSortWithRecursion(0, nums.length - 1, nums);
        
        return nums;
    }
    
    public void quickSortWithRecursion(int low, int high, int[] work) {
        if (low >= high) return;

        int left = low, right = high;
        int pivot = work[(low + high) / 2];

        while (left <= right) {
            while (work[left] < pivot) left++;
            while (work[right] > pivot) right--;
            if (left > right) break;

            swap(left, right, work);
            left++;
            right--;
        }
        String cadena = "\n QuickSort ( S ," + low + "," + right + ")";
        System.out.println(cadena);
        quickSortWithRecursion(low, right, work);
       // imprimirA(work);
       String cadena2 = "\n QuickSort ( S, " + left + "," + high + ")";
       System.out.println(cadena2);
        quickSortWithRecursion(left, high, work);
        //imprimirA(work);
    }
    
    public void swap(int i, int j, int[] array) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

/// SEPARACIONNN

  public int [] quickSort(int[] intArray) {
    recQuickSort(intArray, 0, intArray.length - 1);
    return intArray;
  }

  public  void recQuickSort(int[] intArray, int left, int right) {
    int size = right - left + 1;
    if (size <= 3)
      manualSort(intArray, left, right);
    else {
      double median = medianOf3(intArray, left, right);
      int partition = partitionIt(intArray, left, right, median);
      
      recQuickSort(intArray, left, partition - 1);
      String cadena = "\n QuickSort ( S ," + left + "," + partition + ")";
      System.out.println(cadena);
     // imprimirA(intArray);
      recQuickSort(intArray, partition + 1, right);
      String cadena2 = "\n QuickSort ( S ," + partition + "," + right + ")";
      System.out.println(cadena2);
      //imprimirA(intArray);
    }
  }

  public int medianOf3(int[] intArray, int left, int right) {
    int center = (left + right) / 2;

    if (intArray[left] > intArray[center])
      swap(intArray, left, center);

    if (intArray[left] > intArray[right])
      swap(intArray, left, right);

    if (intArray[center] > intArray[right])
      swap(intArray, center, right);

    swap(intArray, center, right - 1);
    return intArray[right - 1];
  }

  public  void swap(int[] intArray, int dex1, int dex2) {
    int temp = intArray[dex1];
    intArray[dex1] = intArray[dex2];
    intArray[dex2] = temp;
  }

  public  int partitionIt(int[] intArray, int left, int right, double pivot) {
    int leftPtr = left;
    int rightPtr = right - 1;

    while (true) {
      while (intArray[++leftPtr] < pivot)
        ;
      while (intArray[--rightPtr] > pivot)
        ;
      if (leftPtr >= rightPtr)
        break;
      else
        swap(intArray, leftPtr, rightPtr);
    }
    swap(intArray, leftPtr, right - 1);
    return leftPtr;
  }

  public  void manualSort(int[] intArray, int left, int right) {
    int size = right - left + 1;
    if (size <= 1)
      return;
    if (size == 2) {
      if (intArray[left] > intArray[right])
        swap(intArray, left, right);
      return;
    } else {
      if (intArray[left] > intArray[right - 1])
        swap(intArray, left, right - 1);
      if (intArray[left] > intArray[right])
        swap(intArray, left, right);
      if (intArray[right - 1] > intArray[right])
        swap(intArray, right - 1, right);
    }
}
}