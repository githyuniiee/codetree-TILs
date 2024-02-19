import java.util.*;
import java.io.*;

public class Main {
    public static int n;
    public static int ans;
    public static ArrayList<Integer> seq = new ArrayList<>();

    public static boolean isBeautiful() {
        //연달아 같은 숫자가 나오는 위치 잡기
        for(int i=0; i<n; i+= seq.get(i)){

            //연속하여 해당 숫자가 못나오면 
            if(i + seq.get(i) - 1 >= n) return false;

            //하나라도 다른 숫자가 있다면
            for(int j = i; j< i+ seq.get(i); j++){
                if(seq.get(j) != seq.get(i)) return false;
            }

        }
        return true;
    }

    public static void cntBeautifulSeq(int cnt){
        if(cnt == n){
            if(isBeautiful())
            ans++;
            return;
        }

        for(int i=1; i<=4; i++){
            seq.add(i);
            cntBeautifulSeq(cnt+1);
            seq.remove(seq.size()-1);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        cntBeautifulSeq(0);

        System.out.print(ans);

    }
}