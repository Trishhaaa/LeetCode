class Solution {
    public String reorganizeString(String s) {
         int[] charCount = new int[26];
        for (char c : s.toCharArray()) {
            charCount[c - 'a']++;
        }

        PriorityQueue<Character> maxHeap = new PriorityQueue<>((a, b) -> charCount[b - 'a'] - charCount[a - 'a']);
        for (int i = 0; i < 26; i++) {
            if (charCount[i] > 0) {
                maxHeap.offer((char) ('a' + i));
            }
        }

        StringBuilder result = new StringBuilder();
        while (!maxHeap.isEmpty()) {
            char current = maxHeap.poll();
            if (result.length() == 0 || current != result.charAt(result.length() - 1)) {
                result.append(current);
                if (charCount[current - 'a'] > 1) {
                    maxHeap.offer(current);
                }
                charCount[current - 'a']--;
            } else {
                if (maxHeap.isEmpty()) {
                    return "";
                }
                char next = maxHeap.poll();
                result.append(next);
                if (charCount[next - 'a'] > 1) {
                    maxHeap.offer(next);
                }
                charCount[next - 'a']--;
                maxHeap.offer(current);
            }
        }

        return result.toString();
        
    }
}