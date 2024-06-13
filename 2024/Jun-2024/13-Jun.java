public class 13-Jun {
    public int minMovesToSeat(int[] seats, int[] students) {
        int maxSeat = Arrays.stream(seats).max().getAsInt();
        int maxStudent = Arrays.stream(students).max().getAsInt();
        
        int[] seatLoc = new int[maxSeat + 1];
        int[] studentsFreq = new int[maxStudent + 1];

        for (int loc : seats) {
            seatLoc[loc]++;
        }
        for (int student : students) {
            studentsFreq[student]++;
        }

        int ans = 0, j = 0;
        for (int i = 0; i < seatLoc.length; i++) {
            if (seatLoc[i] == 0) continue;
            while (studentsFreq[j] == 0) j++;
            ans += Math.abs(i - j);
            studentsFreq[j]--;
            seatLoc[i]--;
            if (seatLoc[i] != 0) i--;
        }

        return ans;
    }
}
