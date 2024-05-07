public class 07-May {
    public ListNode doubleIt(ListNode head) {
        ListNode rev=reverse(head);
        ListNode curr=rev;
        ListNode prev=null;
        int carry=0,data=0;
        while(curr!=null){
            data=(curr.val*2+carry)%10;
            carry=(curr.val*2+carry)/10;
            curr.val=data;
            prev=curr;
            curr=curr.next;
        }
        if(carry!=0){
            ListNode newNode=new ListNode(carry);
            prev.next=newNode;
        }
        ListNode res=reverse(rev);
        return res;
    }
    public ListNode reverse(ListNode node){
        ListNode curr=node;
        ListNode prev=null;
        while(curr!=null){
            ListNode temp=curr.next;
            curr.next=prev;
            prev=curr;
            curr=temp;
        }
        return prev;
    }
}
