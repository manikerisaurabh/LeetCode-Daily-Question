/*
======================================================  1239. Maximum Length of a Concatenated String with Unique Characters   ======================================================


Problem Statement : You are given an array of strings arr. A string s is formed by the concatenation of a subsequence of arr that has unique characters.

                    Return the maximum possible length of s.

                    A subsequence is an array that can be derived from another array by deleting some or no elements without changing the order of the remaining elements.


Examples : 

                    Example 1:
                    Input: arr = ["un","iq","ue"]
                    Output: 4
                    Explanation: All the valid concatenations are:
                    - ""
                    - "un"
                    - "iq"
                    - "ue"
                    - "uniq" ("un" + "iq")
                    - "ique" ("iq" + "ue")
                    Maximum length is 4.


                    Example 2:
                    Input: arr = ["cha","r","act","ers"]
                    Output: 6
                    Explanation: Possible longest valid concatenations are "chaers" ("cha" + "ers") and "acters" ("act" + "ers").


                    Example 3:
                    Input: arr = ["abcdefghijklmnopqrstuvwxyz"]
                    Output: 26
                    Explanation: The only string in arr has all 26 characters.
*/



public class 23-Jan {
    public boolean check(String str){
        int ch[]=new int[26];
        for(int i=0;i<str.length();i++){
            if(ch[str.charAt(i)-'a']==1){
            return false;
            }
        ch[str.charAt(i)-'a']=1;
        }
        return true;
    }
    public void helper(List<String> arr,String str,int ans[],int i){
        if(i==arr.size()){
         if(check(str)){
             ans[0]=Math.max(ans[0],str.length());
         }   
         return ;
        }
        helper(arr,str+arr.get(i),ans,i+1);
        helper(arr,str,ans,i+1);
    }
    public int maxLength(List<String> arr) {
        int ans[]={0};
        helper(arr,"",ans,0);
        return ans[0];
    }
}
