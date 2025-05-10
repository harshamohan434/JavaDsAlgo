package LinkedList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NodePractice {
    public static void main(String[] args) {
        NodePractice nodePractice = new NodePractice();
        List<Integer> values= new ArrayList<>(Arrays.asList(1,2,3));
        Node node = nodePractice.registerNode(values);
        nodePractice.printLinkedList(node);
        Node reverseNode = nodePractice.reverseNode(node);
        nodePractice.printLinkedList(reverseNode);

    }

    private Node reverseNode(Node node){
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

    private Node registerNode(List<Integer> values){
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

    private void printLinkedList(Node head){
        while (head !=null){
            System.out.println("currentVal : "+head.val);
            head = head.next;
        }
    }
}
