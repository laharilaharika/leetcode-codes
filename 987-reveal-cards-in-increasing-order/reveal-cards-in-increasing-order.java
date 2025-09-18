import java.util.*;
class Solution {
    public int[] deckRevealedIncreasing(int[] deck) {
        int n = deck.length;
        int[] res = new int[n];
        
        // sort deck to reveal in increasing order
        Arrays.sort(deck);
        
        // queue of indices 0..n-1
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            q.offer(i);
        }
        
        // place each card in correct position
        for (int i = 0; i < n; i++) {
            // pick index from queue and assign card
            int idx = q.poll();
            res[idx] = deck[i];
            
            // simulate "move next top to bottom"
            if (!q.isEmpty()) {
                q.offer(q.poll());
            }
        }
        
        return res;
    }
}
