class Solution {
    public String replaceWords(List<String> dictionary, String sentence) {
        TrieNode root = new TrieNode();
        
        // Insert all dictionary words into the Trie
        for (String word : dictionary) {
            TrieNode current = root;
            for (char c : word.toCharArray()) {
                if (current.children[c - 'a'] == null) {
                    current.children[c - 'a'] = new TrieNode();
                }
                current = current.children[c - 'a'];
            }
            current.isWord = true;
        }
        
        // Split the sentence into words
        String[] words = sentence.split(" ");
        StringBuilder result = new StringBuilder();
        
        // Process each word in the sentence
        for (String word : words) {
            if (result.length() > 0) {
                result.append(" ");
            }
            TrieNode current = root;
            StringBuilder replacement = new StringBuilder();
            for (char c : word.toCharArray()) {
                if (current.children[c - 'a'] == null || current.isWord) {
                    break;
                }
                replacement.append(c);
                current = current.children[c - 'a'];
            }
            if (current.isWord) {
                result.append(replacement);
            } else {
                result.append(word);
            }
        }
        
        return result.toString();
    }
}
    
    // Trie Node class
    class TrieNode {
        TrieNode[] children;
        boolean isWord;
        
        TrieNode() {
            children = new TrieNode[26]; // 26 letters in the English alphabet
            isWord = false;
    }
}