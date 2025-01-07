package day1;
import java.util.Scanner;

/*
 * Q4. Create pascal triangle using 2D array
1
1 2
1 2 3
1 2 3 4
1 2 3 4 5
1 2 3 4 5 6
1 2 3 4 5 6 7
1 2 3 4 5 6 7 8

 */
public class Pascal {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n, i, j, a[][];

        System.out.println("Height of triangle");
        n = sc.nextInt();
        a = new int[n][n];

        for (i = 0; i < n; i++) {
            for (j = 0; j <= i; j++)
                if (j == 0 || j == i)
                    a[i][j] = 1;
                else
                    a[i][j] = a[i - 1][j - 1] + a[i - 1][j];
        }

        System.out.println("\nOUTPUT:\n");
        for (i = 0; i < n; i++) {
            for (j = 0; j <= i; j++)
                System.out.print(a[i][j] + "\t");

            System.out.println();
        }
    }
}
