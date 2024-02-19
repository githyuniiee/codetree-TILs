import java.io.*;
import java.util.*;

public class Main {
    static int k;
    static int n;
    static ArrayList<Integer> arr = new ArrayList<>();

    public static void choose(int curNum){
        if(curNum == n+1){
            for(int i=0; i<arr.size(); i++){
                System.out.print(arr.get(i) + " ");
            }
            System.out.println();
            return;
        }

        for(int i=1; i<=k ; i++){
            arr.add(i);
            choose(curNum + 1);
            arr.remove(arr.size()-1);
        }

    }
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        k = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        choose(1);

    }
}