package person.walker.link_list;

import org.junit.Test;

/**
 * Created by Administrator on 2017/3/24 0024.
 */
public class LinkedListCycleII {
    @Test
    public void test(){
        ListNode head = new ListNode(-1);
        ListNode head2 = head;
        for (int count = 0; count < 5;count++){
            head2.next = new ListNode(count);
            if (count == 4)
                break;
            head2 = head2.next;
        }
        head2.next = head.next;
        System.out.println(detectCycle(head));
    }
    public boolean hashCycle(ListNode head) {
        ListNode fastNode = head;
        try{
            while (true){
                fastNode = fastNode.next.next;
                head = head.next;
                if (fastNode.equals(head)){
                    return true;
                }
            }
        }catch (NullPointerException e){
            return false;
        }
    }

    public ListNode detectCycle(ListNode head) {
        ListNode fastNode = head;
        ListNode start = head;
        try{
            while (true){
                fastNode = fastNode.next.next;
                head = head.next;
                if (fastNode.equals(head)){
                    return head;
                }
            }
        }catch (NullPointerException e){
            return null;
        }
    }
}
class LinkedListCycle {

}
