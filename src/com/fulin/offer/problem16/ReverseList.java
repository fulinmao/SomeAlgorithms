import com.fulin.utils.ListNode;

public class ReverseList {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        ListNode.printListNode(head);
        ListNode result = reverseList(head);
        ListNode.printListNode(result);
    }


    public static ListNode reverseList(ListNode head){
        if(head == null || head.next == null){
            return head;
        }
        ListNode firstNode = head;
        ListNode currentNode = head.next;
        firstNode.next = null;
        ListNode temp = null;
        while(currentNode != null){
            temp = currentNode.next;
            currentNode.next = firstNode;
            firstNode = currentNode;
            currentNode = temp;
        }

        return firstNode;
    }
}