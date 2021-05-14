package com.whiletruelearn.datastructures.lab1;

public class DoubleLinkedList {

    Node head;
    Node tail;

    public void addSongAtHead(String songName, String duration ) {
        /*

        1. create new node with current value.
        2. mark the next reference for new node to head.
        3. If head was not null, add previousNodeRef to current node.
        4. current node should be n.
        5. If tail was null, no element in LL so far, update tail as element.
         */
        Node n = new Node();
        n.songName = songName;
        n.songDuration = duration;
        n.prevNodeRef = null;
        n.nextNodeRef = head;

        if (head!=null){
            head.prevNodeRef = n;
        }
        head = n;

        if (tail == null){
            tail = n;
        }

    }

    public void addSongAtTail(String songName, String duration){
        /*

        1,2,3 -> 4
         */

        Node n = new Node();
        n.songName = songName;
        n.songDuration = duration;
        n.prevNodeRef = tail;
        n.nextNodeRef = null;

        if (tail!=null) {
            tail.nextNodeRef = n;
        }
        tail = n;

        if (head == null){
            head = n;
        }

    }

    public int findSongByNameFromHead(String t){
        Node curr = head;
        int pos = 0;
        while (curr != null ){
            if (curr.songName.equalsIgnoreCase(t)){
                break;
            }
            curr = curr.nextNodeRef;
            pos++;
        }
        return pos;
    }

    public int findSongByNameFromTail(String t){
    Node curr = tail;
    int pos = 0;
    while (curr != null){
        if (curr.songName.equalsIgnoreCase(t)){
            break;
        }
        curr = curr.prevNodeRef;
        pos++;
    }
    return pos;
    }

    public  void deleteSongAtPositionFromHead(int position){
        /*
        Node(0),Node(1),Node(2),Node(3),Node(4)
        Delete Node(1)
        Node(0).next = Node(2)
        Node(2).prev = Node(0)
         */

        Node current = head;
        int pos = 0;
        while (current != null ){
            if (pos == position){
                Node nextNode = current.nextNodeRef;
                Node prevNode = current.prevNodeRef;
                prevNode.nextNodeRef = nextNode;
                nextNode.prevNodeRef = prevNode;
            }
            current = current.nextNodeRef;
            pos++;
        }
    }

    public  void deleteSongAtPositionFromTail(int position){
        /*
        Node(0),Node(1),Node(2),Node(3),Node(4)
        Delete Node(1)
        Node(0).next = Node(2)
        Node(2).prev = Node(0)
         */

        Node current = tail;
        int pos = 0;
        while (current != null ){
            if (pos == position){
                Node nextNode = current.nextNodeRef;
                Node prevNode = current.prevNodeRef;
                prevNode.nextNodeRef = nextNode;
                nextNode.prevNodeRef = prevNode;
            }
            current = current.prevNodeRef;
            pos++;
        }
    }

    public  String findSongAtPosFromHead(int pos){

        Node current = head;
        int position = 0 ;
        String songName = null;
        while (current != null){
             if (pos == position) {
                 songName = current.songName;
             }
             position ++;
             current = current.nextNodeRef;
        }
        return songName;
    }

    public  String findSongAtPosFromTail(int pos){

        Node current = tail;
        int position = 0 ;
        String songName = null;
        while (current != null){
            if (pos == position) {
                songName = current.songName;
            }
            position ++;
            current = current.prevNodeRef;
        }
        return songName;
    }

    public void displayFromHead(){
        int pos = 0;
        Node current = head;
        System.out.println("*********Playlist***********\n");
        while (current!= null) {

            System.out.println("\n Position : " + pos);
            System.out.print("\n Song Name : " + current.songName + " Duration : <" + current.songDuration + " >\n" );
            current = current.nextNodeRef;
            pos ++;
        }
    }

    public void displayFromTail(){
        int pos = 0;
        Node current = tail;
        System.out.println("*********Playlist***********\n");
        while (current!= null) {

            System.out.println("\n Position : " + pos);
            System.out.print("\n Song Name : " + current.songName + " Duration : <" + current.songDuration + " >\n" );
            current = current.prevNodeRef;
            pos ++;
        }
    }

    public void sortPlayList(){
        /*
        Bubble sort
        */

        Node current = head;

        Boolean sorted = false;
        while (!sorted  )
        {

            if (current.nextNodeRef != null) {
                if (current.songName.compareTo(current.nextNodeRef.songName) > 0) {


                    String tempSongName = current.songName;
                    String tempSongDuration = current.songDuration;

                    current.songName = current.nextNodeRef.songName;
                    current.songDuration = current.nextNodeRef.songDuration;

                    current.nextNodeRef.songName = tempSongName;
                    current.nextNodeRef.songDuration = tempSongDuration;

                    sorted = false;
                }
                else {
                    sorted = true;
                }

            }


            if (current.nextNodeRef == null){
                current = head;
            }
            current = current.nextNodeRef;


        }


    }

}
