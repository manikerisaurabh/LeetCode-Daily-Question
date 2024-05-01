
public class 01-May {
    public String reversePrefix(String word, char ch) {
        
        char ans[] = word.toCharArray();
        int left = 0;

        for(int right = 0; right < word.length(); right++) {

            if(ans[right] == ch) {
                while(left <= right) {
                    swap(ans, left, right);
                    left++;
                    right--;
                }
                return new String(ans);
            }
        }
        return word;
    }

    private void swap(char chars[], int idx1, int idx2) {
        char temp = chars[idx2];
        chars[idx2] = chars[idx1];
        chars[idx1] = temp;
    }
}
