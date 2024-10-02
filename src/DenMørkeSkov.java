public class DenMørkeSkov {

    private Room currentRoom;


    public void buildMap() {
        //De forskellige rum
        Room room1 = new Room("Room 1 ","- The intrance,", "2 doors");
        Room room2 = new Room("Room 2 -","large area with two strange men and ", "2 doors ");
        Room room3 = new Room("Room 3 -","small pit with spiders and ", "2 exits ");
        Room room4 = new Room("Room 4 -","A dragons nest with ", "2 exits ");
        Room room5 = new Room("Room 5 -"," ", " ");
        Room room6 = new Room("Room 6 -"," ", " ");
        Room room7 = new Room("Room 7 -"," ", " ");
        Room room8 = new Room("Room 8 -"," ", " ");
        Room room9 = new Room("Room 9 -"," ", " ");

        //Items
        Items lyssværd = new Items("lyssværd","Blåt ");
        Items minigun = new Items("minigun","Pink ");
        Items bue = new Items("bue","Grøn ");
        room1.addItems(lyssværd);
        room2.addItems(minigun);
        room3.addItems(bue);

        //Room 1 muligheder
        room1.setModeast(room2);
        room1.setModsouth(room4);

        //Room 2 muligheder
        room2.setModwest(room1);
        room2.setModeast(room3);

        //Room 3 muligheder
        room3.setModwest(room2);
        room3.setModsouth(room6);

        //Room 4 muligheder
        room4.setModnorth(room1);
        room4.setModsouth(room7);

        //Room 5 muligheder
        room5.setModsouth(room8);

        //Room 6 muligheder
        room6.setModnorth(room3);
        room6.setModsouth(room9);

        //Room 7 muligheder
        room7.setModnorth(room4);
        room7.setModeast(room8);

        //Room 8 muligheder
        room8.setModwest(room7);
        room8.setModeast(room9);
        room8.setModnorth(room5);

        //Room 9 muligheder
        room9.setModwest(room8);
        room9.setModnorth(room6);

        currentRoom = room1;
    }
    public Room getCurrentRoom() {
        return currentRoom;
    }

    public void setCurrentRoom(Room room){
        this.currentRoom = room;
    }
}
