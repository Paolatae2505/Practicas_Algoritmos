public class Main {
    public static void main(String[] args) {
        
        OrdenamientoQuick ord = new OrdenamientoQuick();
        int [] A = {35,34,33,32,31,30,29,28,27,26,25,24,23,22,21,20,19,18,17,16,15,
        14,13,12,11,10,9,8,7,6,5,4,3,2,1};
       // int [] C = {1,2,54,3,67};
        
        int [] B = ord.quickSort(A);
       // int  [] D = ord.quickSort(C);
        ord.imprimirA(B);
       // System.out.println("Separacion");
       // ord.imprimirA(D);




    }
}
