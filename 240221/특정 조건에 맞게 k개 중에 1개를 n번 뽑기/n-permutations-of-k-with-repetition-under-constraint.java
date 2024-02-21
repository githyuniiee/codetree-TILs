import java.util.*;
import java.io.*;

public class Main {
    public static int k;
    public static int n;
    public static ArrayList<Integer> arr = new ArrayList<>();

    public static void choose(int num) {
        if (num == n) {
            for (int i = 0; i < arr.size(); i++) {
                System.out.print(arr.get(i) + " ");
            }
            System.out.println();
            return;
        }

        for (int i = 1; i <= k; i++) {
            if (num >= 2 &&
                i == arr.get(arr.size() - 1) &&
                i == arr.get(arr.size() - 2))
                continue;

            arr.add(i);
            choose(num + 1);
            arr.remove(arr.size() - 1);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        k = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        choose(0);
    }
}