import java.util.*;
public class mostfreqword {
    static void most(String s) { // TC O(n) SC O(n)
        HashMap<String, Integer> map = new HashMap<>();
        String[] word = s.split("\\s+");
        for (String w : word) {
            w = w.toLowerCase();
            map.put(w, map.getOrDefault(w, 0)+1);
        }
        int maxfreq = Integer.MIN_VALUE;
        String max = "";
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() > maxfreq) {
                maxfreq = entry.getValue();
                max = entry.getKey();
            }
        }
        System.out.println(max + " -> " + maxfreq);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        most(s);
    }
}