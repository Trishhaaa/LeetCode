class Solution {
    public boolean isNStraightHand(int[] hand, int W) {
        if (hand.length % W != 0) return false; // Quick check: if total cards not divisible by W, return false
        
        TreeMap<Integer, Integer> cardCount = new TreeMap<>();
        
        // Count the frequency of each card
        for (int card : hand) {
            cardCount.put(card, cardCount.getOrDefault(card, 0) + 1);
        }
        
        // Iterate through the sorted card values
        for (int card : cardCount.keySet()) {
            int count = cardCount.get(card);
            if (count > 0) { // If there are cards of this value left to be grouped
                for (int i = 1; i < W; i++) {
                    int nextCard = card + i;
                    if (cardCount.getOrDefault(nextCard, 0) < count) {
                        return false; // Not enough cards to form a sequence
                    }
                    cardCount.put(nextCard, cardCount.get(nextCard) - count);
                }
            }
        }
        
        return true;
    }
}