public class 23-May {
    Integer d[][];
    public int kPalindrome(String str, int n, int k) {
    d = new Integer[n][n];
        
        
        StringBuilder s = new StringBuilder(str);
        String st = s.reverse().toString();
        return tab(str,st,n)<=2*k?1:0;
    }
    int tab(String s1,String s2,int n){
        int d[][] = new int[n+1][n+1];
        
        for(int i=0;i<=n;i++){
            for(int j=0;j<=n;j++){
                if(i==0)
                
                d[i][j]=j;
                
                else if(j==0)
                
                d[i][j]=i;
                
                else if(s1.charAt(i-1)==s2.charAt(j-1))
                
                d[i][j]=d[i-1][j-1];
                
                else
                
                d[i][j] = Math.min(d[i-1][j],d[i][j-1])+1;
            }
        }
        
        return d[n][n];
    }
    
    int solve(int i,int j,String s){
        
        if(i>=j)  
        
        return 0;
        
        if(d[i][j]!=null)  
        
        return d[i][j];
        
        if(s.charAt(i)==s.charAt(j))   
        
        return d[i][j] = solve(i+1,j-1,s);
        
        return d[i][j] = Math.min(solve(i+1,j,s), solve(i,j-1,s)) +1;
        
    }
}
