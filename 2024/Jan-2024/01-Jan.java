package CompetitiveCoding.LeetCode-Daily-Question.2024.Jan-2024;
/*
====================================================== 455. Assign Cookies    ======================================================


Problem Statement : Assume you are an awesome parent and want to give your children some cookies. But, you should give each child at most one cookie.

                    Each child i has a greed factor g[i], which is the minimum size of a cookie that the child will be content with; and each cookie j has a size s[j]. If s[j] >= g[i], we can assign the cookie j to the child i, and the child i will be content. Your goal is to maximize the number of your content children and output the maximum number.


Examples : 

Example 1:
Input: g = [1,2,3], s = [1,1]
Output: 1
Explanation: You have 3 children and 2 cookies. The greed factors of 3 children are 1, 2, 3. 
And even though you have 2 cookies, since their size is both 1, you could only make the child whose greed factor is 1 content.
You need to output 1.


Example 2:
Input: g = [1,2], s = [1,2,3]
Output: 2
Explanation: You have 2 children and 3 cookies. The greed factors of 2 children are 1, 2. 
You have 3 cookies and their sizes are big enough to gratify all of the children, 
You need to output 2.
*/

public class 01-Jan {

    //fuction
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        PriorityQueue<Integer> pq = new PriorityQueue(Collections.reverseOrder());
        for (int i=0; i< s.length; i++) {
            pq.add(s[i]);
        }
        int j = s.length - 1;
        int res = 0;
        for (int i = g.length - 1; i >= 0; i--) {
            int cn = g[i];
            if (pq.size() == 0) {
                break;
            }
            int maxCookieInStore = pq.peek();
            if (cn <= maxCookieInStore) {
                pq.remove();
                maxCookieInStore -= cn;
                res++;
                if (maxCookieInStore > 0) {
                    pq.add(maxCookieInStore);
                }
            }
        }

        return res;
        
    }
}
