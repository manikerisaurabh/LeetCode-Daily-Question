public class 13-Jul {
    public List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
        int n = positions.length;
        int l=0,r=0;
        ArrayList<Integer> ans = new ArrayList<Integer>();
        for(int i=0;i<n;i++){
            if(directions.charAt(i)=='R'){
                l++;
            }
            else{
                r++;
            }
        }
        if(l==0 || r==0){
            for(int i=0;i<n;i++){
                ans.add(healths[i]);
            }
            return ans;
        }
        int[][] le = new int[l][3];
        int[][] ri = new int[r][3]; 
        l=0;r=0;
        for(int i=0;i<n;i++){
            if(directions.charAt(i)=='R'){
                le[l][0]=positions[i];
                le[l][1]=healths[i];
                le[l][2]=i;
                l++;
            }
            else{
                ri[r][0]=positions[i];
                ri[r][1]=healths[i];
                ri[r][2]=i;
                r++;
            }
        }
        Arrays.sort(le,(a, b)->Integer.compare(a[0], b[0]));
        Arrays.sort(ri,(a, b)->Integer.compare(a[0], b[0]));
        int i=le.length-1,j=0;
        for(;i>=0;i--){
            for(j=0;j<ri.length;j++){
                if(le[i][0]>ri[j][0] || ri[j][1]==0){
                    continue;
                }
                if(le[i][1]>ri[j][1]){
                    le[i][1]--;
                    ri[j][1]=0;
                }
                else if(le[i][1]<ri[j][1]){
                    le[i][1]=0;
                    ri[j][1]--;
                    break;
                }
                else{
                    le[i][1]=0;
                    ri[j][1]=0;
                    break;
                }
            }
        }
        int[][] res = new int[l+r][2];
        j=0;
        for(i=0;i<ri.length;i++){
            res[j][0]=ri[i][1];
            res[j][1]=ri[i][2];
            j++;
        }
        for(i=0;i<le.length;i++){
            res[j][0]=le[i][1];
            res[j][1]=le[i][2];
            j++;
        }
        Arrays.sort(res,(a, b)->Integer.compare(a[1], b[1]));
        for(i=0;i<res.length;i++){
            if(res[i][0]!=0){
                ans.add(res[i][0]);
            }
        }
        return ans;
    }
}
