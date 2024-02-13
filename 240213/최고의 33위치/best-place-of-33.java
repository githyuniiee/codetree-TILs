import java.util.*;
import java.io.*;

public class Main {

    static int[][] arr;
    static int getMoney;
    static int max;

    public static int calcul(int row, int colS, int colE){
        getMoney = 0;

        for(int col=colS; col<=colE; col++){
            getMoney += arr[row][col];
        }

        return getMoney;

    }


    public static void main(String[] args) throws IOException{
    
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    arr = new int[N][N];
    StringTokenizer st;
   

    for(int i=0; i<N; i++){
        st = new StringTokenizer(br.readLine(), " ");
        for(int j=0; j<N; j++){
            arr[i][j] = Integer.parseInt(st.nextToken());
        }
    }
    
   
    for(int row=0; row<N; row++){
        for(int col=0; col<N; col++){

            if(col +2 > N){
                continue;
            }

            getMoney = calcul(row, col, col+2);
             max = Math.max(max, getMoney);
        }
    }

    System.out.println(max);

    }
}