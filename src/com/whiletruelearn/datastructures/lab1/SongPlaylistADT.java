package com.whiletruelearn.datastructures.lab1;
import java.util.*;

public class SongPlaylistADT {

    public static void sampleTests(){
        DoubleLinkedList dl = new DoubleLinkedList();

        dl.addSongAtHead("Believer","3:23");
        dl.addSongAtHead("Shotgun", "3:21");
        dl.addSongAtHead("Avicci", "5:00");
        dl.addSongAtHead("Titatnium","4:07");

        dl.deleteSongAtPositionFromTail(1);

        dl.displayFromTail();
        dl.displayFromHead();
        dl.displayFromHead();
        dl.sortPlayList();
        dl.displayFromHead();
        dl.displayFromTail();

    }
    public static void main(String[] args){

        //sampleTests();
        Scanner sc= new Scanner(System.in);
        DoubleLinkedList dl = new DoubleLinkedList();
        String playlistMenu = " Playlist Operations:\n" +
                "          1. Add a song to the playlist\n" +
                "          2. Delete a song from the playlist\n" +
                "          3. Find a song by name\n" +
                "          4. Next track / Previous track\n" +
                "          5. Sort playlist by song title\n" +
                "          6. Display playlist\n" +
                "          7. Exit\n";

        while (true){
            System.out.println(playlistMenu);
            int option = Integer.parseInt(sc.nextLine());

            if (option == 1) {
                System.out.print("Enter Song name ");
                String songName = sc.nextLine();
                System.out.print("Enter Song duration:");
                String songDuration = sc.nextLine();
                dl.addSongAtHead(songName, songDuration);
                System.out.println("Song Added!");

            }
            else if (option ==2){
                System.out.println("Enter position of song to delete");
                int songPosition = Integer.parseInt(sc.nextLine());
                try {
                    dl.deleteSongAtPositionFromHead(songPosition);
                    System.out.println("Song at the given position is deleted");
                }catch (Exception e){
                    System.out.println("Position Entered is not valid");
                }

            }
            else if (option == 3){
                System.out.println("Enter exact SongName");
                String songName = sc.nextLine();
                try {
                    int songPosition = dl.findSongByNameFromHead(songName);
                    System.out.println("Song is found at Position " + songPosition);
                }
                catch (Exception e) {
                    System.out.println("Coudln't find the given songName!!");
                }
            }
            else if (option == 4){
                System.out.println("Which song should you want to start with. Enter position");
                int songPosition = Integer.parseInt(sc.nextLine());
                System.out.println("Currently Playing "  + dl.findSongAtPosFromHead(songPosition));
                while (true) {
                    int currentSongPosition = songPosition;

                    System.out.println("Press 1 for next , 2 for prev , 3 for exit");
                    int subMenuOption = Integer.parseInt(sc.nextLine());
                    try{
                    if (subMenuOption == 1){
                        System.out.println("Currently Playing " + dl.findSongAtPosFromHead(currentSongPosition + 1));
                    }
                    else if (subMenuOption == 2){
                        System.out.println("Currently Playing " + dl.findSongAtPosFromHead(currentSongPosition - 1));
                    }}
                    catch (Exception e) {
                        System.out.println("Next/ Prev operation is not valid");
                    }
                    if (subMenuOption == 3){
                       break;
                    }
                }
            }
            else if(option == 5){
                System.out.println("Sorted playlist is as below");
                dl.sortPlayList();
                dl.displayFromHead();
            }
            else if(option ==6){
                dl.displayFromHead();
            }
            else {
                break;
            }

        }

    }
}
