public class 06-Jul {
    public int passThePillow(int n, int time) {
        int cycleLength = (n - 1) * 2;
        int positionInCycle = time % cycleLength;
        if (positionInCycle < n) {
            return positionInCycle + 1;
        } else {
            return cycleLength - positionInCycle + 1;
        }
    }
}
