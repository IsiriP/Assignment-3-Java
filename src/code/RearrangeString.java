package code;

import java.util.*;

class Pair {
    char ch;
    int freq;
    Pair(char ch, int freq) {
        this.ch = ch;
        this.freq = freq;
    }
}

public class RearrangeString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String s = sc.next();

        HashMap<Character, Integer> freqMap = new HashMap<>();
        for (char c : s.toCharArray()) {
            freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> b.freq - a.freq);
        for (char c : freqMap.keySet()) {
            pq.add(new Pair(c, freqMap.get(c)));
        }

        StringBuilder result = new StringBuilder();
        Pair prev = new Pair('#', -1);

        while (!pq.isEmpty()) {
            Pair curr = pq.poll();
            result.append(curr.ch);
            curr.freq--;

            if (prev.freq > 0) {
                pq.add(prev);
            }
            prev = curr;
        }

        if (result.length() != s.length()) {
            System.out.println("Result: None");
        } else {
            System.out.println("Result: " + result.toString());
        }
    }
}
