import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());
        
        int[] arr1 = new int[n];
        int[] arr2 = new int[n];
        
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            arr1[i] = Integer.parseInt(st.nextToken());
        }
        
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            arr2[i] = Integer.parseInt(st.nextToken());
        }

        while(t-- > 0){
            int temp = arr1[n-1];

            for(int i=n-1; i>=1; i--){
                arr1[i] = arr1[i-1];
            }

            arr1[0] = arr2[n-1];

            for(int i=n-1; i>=1; i--){
                arr2[i] = arr2[i-1];
            }
            arr2[0] = temp;
        }

        for(int i=0; i<n; i++){
            System.out.print(arr1[i] + " ");
        }

        System.out.println();

         for(int i=0; i<n; i++){
            System.out.print(arr2[i] + " ");
        }

        System.out.println();
    
    }
}