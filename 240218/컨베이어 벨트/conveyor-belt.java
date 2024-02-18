import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] arr = new int[2][n];

        for(int i=0; i<2; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<arr[0].length; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        //이동
        for(int i=0; i<m; i++){
            int temp = arr[0][n-1];

            for(int j=n-1; j>0; j--){
                arr[0][j] = arr[0][j-1];
            }

            arr[0][0] = arr[1][n-1];

            for(int j=n-1; j>0; j--){
                arr[1][j] = arr[1][j-1];
            }

            arr[1][0] = temp;
        }


        //출력
        for(int i=0; i<2; i++){
            for(int j=0; j<n; j++){
                System.out.print(arr[i][j] + " ");
            }

            System.out.println();
        }
    }
}