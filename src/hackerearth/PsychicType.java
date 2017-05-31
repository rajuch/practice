package hackerearth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class PsychicType {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        int i =0;
        for(String val : br.readLine().split(" ")) {
            arr[i] = Integer.parseInt(val);
            i++;
        }

        int[] pos = new int[2];
        i = 0;
        for(String val : br.readLine().split(" ")) {
            pos[i] = Integer.parseInt(val);
            i++;
        }
        int key = pos[0];
        Set<Integer> visited = new HashSet();
        for(i=0; i<n; i++) {
            if(!visited.add(key)) {
                break;
            }
            if(arr[key-1] == pos[1]) {
                System.out.print("Yes");
                return;
            } else {
                key = arr[key];
            }
        }
        System.out.print("No");
    }
}
