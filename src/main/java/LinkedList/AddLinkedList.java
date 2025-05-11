package LinkedList;

public class AddLinkedList {
    public Node addTwoNumbers(Node l1, Node l2) {
        NodePractice nodePractice = new NodePractice();
        Node l1_reverse = nodePractice.reverseNode(l1);
        Node l2_reverse = nodePractice.reverseNode(l2);
        Node result = new Node(0);
        int sum = 0;
        int carry = 0;

        while (l1_reverse != null || l2_reverse != null) {
            if (l1_reverse != null) {
                sum += l1_reverse.val;
                l1_reverse = l1_reverse.next;
            }
            if (l2_reverse != null) {
                sum += l2_reverse.val;
                l2_reverse = l2_reverse.next;
            }

            result.val = sum % 10;
            carry = sum/10;
            Node cr = new Node(carry);
            cr.next = result;
            result = cr;
            sum = carry;
        }

        return (carry == 0) ? result.next : result ;
    }
}
