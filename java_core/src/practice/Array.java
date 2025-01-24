package practice;

public class Array {
    public static void main(String[] args){
        int[] a=new int[12]; //creates an array object and initializes all values to 0.
        a[0]=0;
        a[1]=1;
        System.out.println("array elements are:");
        for(int i=0;i<12;i++) {
            System.out.println(a[i] + " ");
        }
    }
}
