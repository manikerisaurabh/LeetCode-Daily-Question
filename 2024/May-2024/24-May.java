public class 24-May {
    public int maxScoreWords(String[] words, char[] letters, int[] score) {
        int[] freqArray = new int[score.length];
        for(char ch : letters) {
            freqArray[ch - 'a']++;
        }
        return score(words,score,freqArray,0);
    }
     private static int score(String[] words, int[] score, int[] freqArray, int index) {
        if(index == words.length) return 0;
        String word = words[index];
        int scoreIfWordNotIncluded = score(words,score,freqArray,index+1);
        int scoreIfWordIncluded = 0;
        int scoreOfCurrentWord = 0;
        boolean canCurrentWordBeIncluded = true;
        for(int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if(freqArray[ch - 'a'] == 0) canCurrentWordBeIncluded = false;
            freqArray[ch - 'a']--;
            scoreOfCurrentWord += score[ch - 'a'];
        }
        if(canCurrentWordBeIncluded) {
            scoreIfWordIncluded = scoreOfCurrentWord + score(words,score,freqArray,index+1);
        }
        for(int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            freqArray[ch - 'a']++;
        }
        return Math.max(scoreIfWordNotIncluded,scoreIfWordIncluded);
    }
}
