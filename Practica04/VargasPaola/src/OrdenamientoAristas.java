/**
 * Clase OrdenaminetoAristas
 * @author Vargas Bravo Paola
 * @version 1.0 (08 Dic 2022)
 * @since Analsis de Algortimos (2023-1)
 */

public class OrdenamientoAristas {
 
/**
 * Se encarga de la dividision del arreglo 
 * en dos mitades recursivamente
 * @param arr --- Tupla [] arreglo a ordenar
 * @param left  --- int primera posicion de arr
 * @param right  --- int segunda posicion de arr
 */
public void sort3(Tupla arr[], int left, int right){
    if(left < right){
      //Encuentra el punto medio del vector.
      int m = (left + right) / 2;
      
      //Divide la primera y segunda mitad (llamada recursiva).
      sort3(arr, left, m);
      sort3(arr, m + 1, right);

      //Une las mitades.
      merge3(arr, left, m, right);
    }
}
/**
 * Ordena el arreglo usando la logia de Merge
 * @param arr --- Tupla [] arreglo a ordenar
 * @param left -- int primer pocision de arr
 * @param middle -- int posicion de enmedio
 * @param right -- int ulitma pocision de arr
 */
public void merge3(Tupla arr[], int left, int middle, int right) {
    //Encuentra el tamaño de los sub-vectores para unirlos.
    int n1 = middle - left + 1;
    int n2 = right - middle;
  
    //Vectores temporales.
    Tupla leftArray[] = new Tupla [n1];
    Tupla rightArray[] = new Tupla [n2];

    Tupla aux;
  
    //Copia los datos a los arrays temporales.
    for (int i=0; i < n1; i++) {
      leftArray[i] = arr[left+i];
    }
    for (int j=0; j < n2; j++) {
      rightArray[j] = arr[middle + j + 1];
    }
    /* Une los vectorestemporales. */
  
    //Índices inicial del primer y segundo sub-vector.
    int i = 0, j = 0;
  
    //Índice inicial del sub-vector arr[].
    int k = left;
  
    //Ordenamiento.
    while (i < n1 && j < n2) {
      if (leftArray[i].getValue() <= rightArray[j].getValue()) {
        arr[k] = leftArray[i];
        i++;
      } else {
          arr[k] = rightArray[j];
          j++;
      }
      k++;
    }//Fin del while.
  
    /* Si quedan elementos por ordenar */
    //Copiar los elementos restantes de leftArray[].
    while (i < n1) {
      arr[k] = leftArray[i];
      i++;
      k++;
    }
    //Copiar los elementos restantes de rightArray[].
    while (j < n2) {
      arr[k] = rightArray[j];
      j++;
      k++;
    }
  }
  /**
   * Imprime el arreglo de Tuplas
   * @param arr -- Tupla arr[] arreglo a
   *               imprimir
   */
  public void printArray(Tupla arr[]) {
    int n = arr.length;
    for (int i=0; i<n; ++i) {

        System.out.println("<" + arr[i].getKey() + "," + arr[i].getValue() + ">");
    }
    System.out.println();
}
}
