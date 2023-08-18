class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();
        int startIndex = 0;

        while (startIndex < words.length) {
            int endIndex = startIndex;
            int lineLength = 0;

            // Determine words for the current line
            while (endIndex < words.length && lineLength + words[endIndex].length() + (endIndex - startIndex) <= maxWidth) {
                lineLength += words[endIndex].length();
                endIndex++;
            }

            int numWords = endIndex - startIndex;
            int totalSpaces = maxWidth - lineLength;
            int baseSpaces = numWords > 1 ? totalSpaces / (numWords - 1) : totalSpaces;
            int extraSpaces = numWords > 1 ? totalSpaces % (numWords - 1) : 0;

            StringBuilder line = new StringBuilder(words[startIndex]);

            if (numWords == 1 || endIndex == words.length) {
                for(int i=startIndex+1;i<endIndex;i++){
                    line.append(' ').append(words[i]);
                }
                int spacesLeft = maxWidth - line.length();
                for (int i = 0; i < spacesLeft; i++) {
                    line.append(' ');
                }
            }

            else{

            for (int i = startIndex + 1; i < endIndex; i++) {
                int spacesToInsert = baseSpaces + (extraSpaces > 0 ? 1 : 0);
                extraSpaces--;

                for (int j = 0; j < spacesToInsert; j++) {
                    line.append(' ');
                }

                line.append(words[i]);
            }
            }

            
            
            result.add(line.toString());
            startIndex = endIndex;
        
        }

        return result;
    
    }
}