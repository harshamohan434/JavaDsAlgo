package LinkedList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NodePractice {
    public static void main(String[] args) {
        NodePractice nodePractice = new NodePractice();
        List<Integer> l1_values= new ArrayList<>(Arrays.asList(7,2,4,3));
        List<Integer> l2_values= new ArrayList<>(Arrays.asList(5,6,4));
        Node l1 = nodePractice.registerNode(l1_values);
        Node l2 = nodePractice.registerNode(l2_values);
        AddLinkedList addLinkedList = new AddLinkedList();

        Node result = addLinkedList.addTwoNumbers(l1, l2);
        nodePractice.printLinkedList(result);

    }

    protected Node reverseNode(Node node){
        Node previous = null;
        Node current = node;
        while (current != null){
            Node temp = current.next;
            current.next = previous;
            previous = current;
            current = temp;
        }
        return previous;
    }

    protected Node registerNode(List<Integer> values){
        Node head = null;
        for (int val : values){
            Node newNode = new Node(val);
            if (head == null){
                head = newNode;
                continue;
            }
            Node current = head;
            while (current.next != null){
                current = current.next;
            }
            current.next = newNode;
        }
        return head;
    }

    protected void printLinkedList(Node head){
        while (head !=null){
            System.out.print(head.val + ",");
            head = head.next;
        }
    }


}
