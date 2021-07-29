import java.util.Scanner;

public class linkedList {

    // Node class, with data, next and prev nodes, and init method
    class Node {
        int data;
        Node prev;
        Node next;

        public Node(int data) {
            this.data = data;
        }
    }

    // our list's head and tail nodes
    Node head = null;
    Node tail = null;

    // add node to list
    public void addNode(int data) {
        // create node
        Node tmp = new Node(data);
        tmp.next = null;

        // if list empty, init
        if (head == null) {
            tmp.prev = null;
            head = tmp;
            tail = tmp;
        }
        // else append new node
        else {
            tail.next = tmp;
            tmp.prev = tail;
            tail = tmp;
        }
    }

    // delete from list, fifo method
    public void delNode() {
        // if not empty
        if (head != null) {
            head = head.next;
            head.prev = null;
        }
    }

    // print linked list
    public void printList() {
        // get head node
        Node cur = head;
        
        // stop if empty
        if (cur == null) {
            System.out.println("List is empty");
        }
        // loop through list and print each node's data
        else {
            System.out.println("Printing list");

            while (cur != null) {
                System.out.println(cur.data + " ");
                cur = cur.next;
            }
        }
    }

    // main function
    public static void main(String[] args) {
        // user's input obj
        Scanner input = new Scanner(System.in);
        // doubley linked list
        linkedList list = new linkedList();

        // loop until user is done
        while (true) {
            // ask and get comands
            System.out.println("Please enter a command\n<add> <delete> <print> <quit>");
            String command = input.nextLine();

            // add a node to list
            if (command.equals("add")) {
                // get int from user, add node to list
                System.out.println("Please enter an integer to store");
                int data = input.nextInt();
                list.addNode(data);
                input.nextLine();
            }
            // delete from list (fifo)
            else if (command.equals("delete")) {
                list.delNode();
            }
            // print contents of linked list
            else if (command.equals("print")) {
                list.printList();
            }
            // exit program
            else if (command.equals("quit")) {
                System.out.println("Goodbye!");
                input.close();
                System.exit(0);;
            }
            // bad command, prompt for a correct input
            else {
                System.out.println("invalid command, try again");
            }

            input.close();
        }
    }
}
