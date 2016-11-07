package person.walker;

class ListNode {
    int val;
    ListNode next;
    ListNode pro;
    ListNode(int x) {
        val = x;
    }
}

public class AddTwoNum {
    public static void main(String[] args) {
        int[] l1Val = new int[]{};
        int[] l2Val = new int[]{9};
        ListNode l1 = new ListNode(1);
        ListNode lineL1 = l1;
        ListNode l2 = new ListNode(9);
        ListNode lineL2 = l2;
       for (int i : l1Val){
            lineL1.next  = new ListNode(i);
            lineL1 = lineL1.next;
        }
        for (int i : l2Val){
            lineL2.next = new ListNode(i);
            lineL2 = lineL2.next;
        }

        ListNode result = new AddTwoNum().addTwoNumbers(l1,l2);
        while (result != null){
            System.out.print(result.val);
            result = result.next;
        }
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null)
            return l2;
        if (l2 == null)
            return l1;
        int carryBit = 0;
        boolean endOfL1 = false;
        boolean endOfL2 = false;
        ListNode resultNode = new ListNode(0);

        resultNode.val = l1.val + l2.val;
        ListNode LineResult = resultNode;
        if (LineResult.val >= 10){
            LineResult.val = LineResult.val % 10;
            carryBit = 1;
        }

        while (l1.next != null || l2.next != null || carryBit > 0){
            LineResult.next = new ListNode(0);
            LineResult = LineResult.next;
            if (l1.next != null)
                l1 = l1.next;
            else
                endOfL1 = true;
            if (l2.next != null)
                l2 = l2.next;
            else
                endOfL2 = true;
            if (endOfL1 && !endOfL2){
                LineResult.val = l2.val;
                LineResult.val += carryBit;
                if (LineResult.val >= 10){
                    LineResult.val = LineResult.val % 10;
                    carryBit = 1;
                }else
                    carryBit = 0;
                continue;
            }

            if (endOfL2 && !endOfL1){
                LineResult.val = l1.val;
                LineResult.val += carryBit;
                if (LineResult.val >= 10){
                    LineResult.val = LineResult.val % 10;
                    carryBit = 1;
                }else
                    carryBit = 0;
                continue;
            }

            if (endOfL1 && endOfL2){
                LineResult.val = carryBit;
                break;
            }
            LineResult.val = l1.val + l2.val;
            LineResult.val += carryBit;
            if (LineResult.val >= 10){
                LineResult.val = LineResult.val % 10;
                carryBit = 1;
            }else
                carryBit = 0;
        }
        return resultNode;
    }
}
