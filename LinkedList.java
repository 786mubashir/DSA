import java.util.*;
import java.io.*;

//class is the node class of linked list
class Node{
    int value;
    Node nxt;

    void CreateNode(int val){
        value =val;
        nxt = null;
    }
}
public class LinkedList {
    Node head = null;
    //this is the main function
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkedList obj = new LinkedList();
        for(int i = 0;i<5;i++){
            obj.LinkedList( i+1);        }
            obj.PrintNode();
            System.out.print("Which number you want to delete : ");
            int data = scanner.nextInt();
            if(obj.RemoveBySearch(data, obj.head, obj.head)){
                obj.PrintNode();
            }else{
                System.out.println("Data is not Found");
            }
            
    }

    //Linked List creation and print in this function
    void LinkedList( int data){
        Node nl = new Node();
        Node temp ;
        nl.value = data;
        if(head == null){
            head = nl;
        }else{
            temp = head;
            while(temp.nxt != null){
                temp = temp.nxt; 
            }
            temp.nxt = nl; 
        }

    }
    
    //this function is use to print the link list
    void PrintNode (){
        Node temp = head;
        System.out.println("your Linked list is :");
        while (temp != null) {
            System.out.print(temp.value+"   ");
            temp = temp.nxt;
        }
        System.out.println("");
    }
    
    //this function is used to remove the node form linked list 
    //first this function find the data and then remove the node from linked list with recursion
    boolean RemoveBySearch(int data,Node headNode,Node prevNode){
        if(headNode == null){
            return false;
        }
        if(headNode.value == data){
            if(headNode==prevNode){
                head = headNode.nxt;
            }else{
                prevNode.nxt=headNode.nxt;
            }
            return true;
        }
        return RemoveBySearch(data, headNode.nxt, headNode);
    }
}
