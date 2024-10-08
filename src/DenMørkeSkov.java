public class DenMørkeSkov {

    private Room currentRoom;


    public void buildMap() {
        //De forskellige rum
        //Room 1
        Room room1 = new Room("Room 1 ", "- The intrance,", "2 doors");


        //Room 2
        Room room2 = new Room("Room 2 -", "large area with two strange men and ", "2 doors ");
        Item sword = new MeleeWeapon("sword", "Made out of valkyrian steel - damage 20", 20, "\u2694\uFE0F");
        room2.addItems(sword);
        Item herb = new Food("Herb", "Is a fragrant herb that heals wounds and soothes the soul - health 40", 40, "\uD83C\uDF3F");
        room2.addItems(herb);


        //Room 3
        Room room3 = new Room("Room 3 -", "small pit with spiders and ", "2 exits ");
        Item bow = new RangedWeapon("bow", "Green bow with magic arrows - damage 25", 25, 3, "\uD83C\uDFF9");
        room3.addItems(bow);

        //Room 4
        Room room4 = new Room("Room 4 -", "A dragons nest with ", "2 exits ");
        Food redBull = new Food("Redbull", "Might be good, might be bad, drink if you dare...", -10, "⚡");
        room4.addItems(redBull);
        Item lightSaber = new MeleeWeapon("lightsaber", "Cuts through everything - damage 50", 50, "\uD83D\uDFE6\u2694\uFE0F");
        room4.addItems(lightSaber);

        //Room 5
        Room room5 = new Room("Room 5 -", " ", " ");

        //Room 6
        Room room6 = new Room("Room 6 -", " ", " ");
        Item miniGun = new RangedWeapon("minigun", "Legendary minigun with rapidfire - damage 10", 5, 7, "\uD83D\uDD2B\uD83D\uDCA5");
        room6.addItems(miniGun);
        Item eliksir = new Food("Eliksir", "Is a shimmering elixir that restores vitality with every sip - damage 25", 25, "\uD83C\uDF7B");
        room6.addItems(eliksir);

        //Room 7
        Room room7 = new Room("Room 7 -", " ", " ");
        Item stormAxe = new MeleeWeapon("Hammer", "Stormhammer is a mighty hammer that unleashes thunderous blows - damage 40", 40, "\u2692\u26A1");
        room7.addItems(stormAxe);

        //Room 8
        Room room8 = new Room("Room 8 -", " ", " ");
        Item shadowDagger = new MeleeWeapon("Dagger", "Shadow Dagger is a sleek dagger that whispers secrets of the night with every strike - damage 30", 30, "\uD83D\uDDE1");
        room8.addItems(shadowDagger);

        //Room 9
        Room room9 = new Room("Room 9 -", " ", " ");
        Item apple = new Food("Apple", "Is a radiant apple that grants a burst of energy, invigorating the spirit - health +15", 15, "\uD83C\uDF4F");
        room9.addItems(apple);


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
        if (currentRoom == null) {
            System.out.println("Dette rum er null");

        }
        return this.currentRoom;
    }

    public void setCurrentRoom(Room room) {
        this.currentRoom = room;
    }

}
