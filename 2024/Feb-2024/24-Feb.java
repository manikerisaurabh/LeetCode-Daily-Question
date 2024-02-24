/*
====================================================== 2092. Find All People With Secret    ======================================================


Problem Statement : You are given an integer n indicating there are n people numbered from 0 to n - 1. You are also given a 0-indexed 2D integer array meetings where meetings[i] = [xi, yi, timei] indicates that person xi and person yi have a meeting at timei. A person may attend multiple meetings at the same time. Finally, you are given an integer firstPerson.

                    Person 0 has a secret and initially shares the secret with a person firstPerson at time 0. This secret is then shared every time a meeting takes place with a person that has the secret. More formally, for every meeting, if a person xi has the secret at timei, then they will share the secret with person yi, and vice versa.

                    The secrets are shared instantaneously. That is, a person may receive the secret and share it with people in other meetings within the same time frame.

                    Return a list of all the people that have the secret after all the meetings have taken place. You may return the answer in any order. 


Examples : 

                    Example 1:
                    Input: n = 6, meetings = [[1,2,5],[2,3,8],[1,5,10]], firstPerson = 1
                    Output: [0,1,2,3,5]
                    Explanation:
                    At time 0, person 0 shares the secret with person 1.
                    At time 5, person 1 shares the secret with person 2.
                    At time 8, person 2 shares the secret with person 3.
                    At time 10, person 1 shares the secret with person 5.​​​​
                    Thus, people 0, 1, 2, 3, and 5 know the secret after all the meetings.


                    Example 2:
                    Input: n = 4, meetings = [[3,1,3],[1,2,2],[0,3,3]], firstPerson = 3
                    Output: [0,1,3]
                    Explanation:
                    At time 0, person 0 shares the secret with person 3.
                    At time 2, neither person 1 nor person 2 know the secret.
                    At time 3, person 3 shares the secret with person 0 and person 1.
                    Thus, people 0, 1, and 3 know the secret after all the meetings.


                    Example 3
                    Input: n = 5, meetings = [[3,4,2],[1,2,1],[2,3,1]], firstPerson = 1
                    Output: [0,1,2,3,4]
                    Explanation:
                    At time 0, person 0 shares the secret with person 1.
                    At time 1, person 1 shares the secret with person 2, and person 2 shares the secret with person 3.
                    Note that person 2 can share the secret at the same time as receiving it.
                    At time 2, person 3 shares the secret with person 4.
                    Thus, people 0, 1, 2, 3, and 4 know the secret after all the meetings.
*/



public class 24-Feb {
    private class DisjointSet{
       private int parent[] = null, rank[] = null;
       public DisjointSet(int size){
           parent = new int[size];
           rank = new int[size];
           for(int node = 0; node < parent.length; node++){
               parent[node] = node;
           }
       }
       public int find(int node){
           if(this.parent[node] != node){
               parent[node] = find(parent[node]);
           }
           return parent[node];
       } 
       public void union(int node1, int node2){
           int oneRep = find(node1), twoRep = find(node2);
           if(oneRep == twoRep){
               return;
           }
           if(rank[oneRep] < rank[twoRep]){
               parent[oneRep] = twoRep;
           }else if(rank[twoRep] < rank[oneRep]){
               parent[twoRep] = oneRep;
           }else{
               parent[oneRep] = twoRep;
               rank[twoRep]++;
           }
       }
       public void breakBond(int node){
           this.parent[node] = node;
       } 
       public boolean isConnectedToSecretKnower(int node1){
           int originPer = 0;
           return find(node1) == find(originPer);
       }
    }
    private HashSet<Integer> scrtKnowers = new HashSet<>();
    private DisjointSet dSet = null;
    public List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) {
        Arrays.sort(meetings, (a, b)-> a[2] - b[2]);
        
        scrtKnowers.add(0);
        scrtKnowers.add(firstPerson); 
        dSet = new DisjointSet(n);
         dSet.union(0, firstPerson);
        haveMeetings(meetings, n);        
        return scrtKnowers.stream().collect(Collectors.toList());
    }
    
     private void haveMeetings(int meetings[][], int totalPersons){
        int len = meetings.length;
        for(int indx = 0; indx<len; indx++){
            int currMeetId = indx, currMeetTime = meetings[indx][2];
            while(currMeetId < len && meetings[currMeetId][2]== currMeetTime){
                int per1 = meetings[currMeetId][0], per2 = meetings[currMeetId][1];
                dSet.union(per1, per2);
                currMeetId++;
            }
            currMeetId = indx;
             while(indx < len && meetings[indx][2] == currMeetTime){
                    int per1 = meetings[indx][0], per2 = meetings[indx][1];
                 if(dSet.isConnectedToSecretKnower(per1) || dSet.isConnectedToSecretKnower(per2)){
                  scrtKnowers.add(per1);
                  scrtKnowers.add(per2);
                 }else{
                     dSet.breakBond(per1);
                     dSet.breakBond(per2);
                 }    
                 indx++;
            }          
            indx--;
        }
    }
}
