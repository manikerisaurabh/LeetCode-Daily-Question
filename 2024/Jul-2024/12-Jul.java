class Result {
    int gain;
    String remainingString;

    Result(int gain, String remainingString) {
        this.gain = gain;
        this.remainingString = remainingString;
    }

}

    public class 12-Jul{

    public int maximumGain(String s, int x, int y) {
        Result cal_ba;
        Result cal_ab;
        if (y > x) {
            cal_ba = calculateGains(s, y, 'b', 'a');
            cal_ab = calculateGains(cal_ba.remainingString, x, 'a', 'b');
            return cal_ba.gain + cal_ab.gain;
        } else {
            cal_ab = calculateGains(s, x, 'a', 'b');
            cal_ba = calculateGains(cal_ab.remainingString, y, 'b', 'a');
            return cal_ab.gain + cal_ba.gain;
        }
    }

    public Result calculateGains(String s, int g, Character first, Character second) {
        int gain = 0;
        Stack<Character> s1 = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (!s1.isEmpty() && s1.peek() == first && ch == second) {
                s1.pop();
                gain += g;
            } else {
                s1.push(ch);
            }
        }

        // Reconstruct the remaining string from the stack
        StringBuilder remaining = new StringBuilder();
        while (!s1.isEmpty()) {
            remaining.insert(0, s1.pop());
        }

        return new Result(gain, remaining.toString());
    }

}
