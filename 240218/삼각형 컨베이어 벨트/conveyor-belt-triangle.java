import java.util.*;
import java.io.*;

public class Main {


    
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());
        int[][] arr = new int[3][n];

        for(int i=0; i<3; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<arr[0].length; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=0; i<t; i++){
            int temp = arr[0][n-1];
            for(int j=n-2; j>=0; j--){
                arr[0][j+1] = arr[0][j];
            }
            arr[0][0] = arr[2][n-1];

            for(int j=n-2; j>=0; j--){
                arr[2][j+1] = arr[2][j];
            }

            arr[2][0] = arr[1][n-1];

            for(int j=n-2; j>=0; j--){
                arr[1][j+1] = arr[1][j];
            }

            arr[1][0] = temp;


        }



        for(int i=0; i<3; i++){
            for(int j=0; j<n; j++){
                System.out.print(arr[i][j] + " ");
            }

            System.out.println();
        }


    }
}