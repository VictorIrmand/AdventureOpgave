//import java.util.Scanner;

import java.util.ArrayList;

public class Adventure {
    PlayerOne playerOne;
    DenMørkeSkov denMørkeSkov;
    UI ui;



    public Adventure(){
        denMørkeSkov = new DenMørkeSkov();
        playerOne = new PlayerOne(denMørkeSkov);
        ui = new UI(denMørkeSkov,playerOne,this);

    }

    public void adventureGame(){
    denMørkeSkov.buildMap();
    ui.setGame();
    }

    public void setPlayerName(String name){
        playerOne.setNavn(name);
    }
    public String getPlayerName() {
        return playerOne.getNavn();
    }
    public Room currentRoom(){
        return denMørkeSkov.getCurrentRoom();
    }
    public void setCurrentRoom(Room room){
        denMørkeSkov.setCurrentRoom(room);
    }
    public String getCurrentRoomDescription(){
        return currentRoom().getNavn() + " " + currentRoom().getBeskrivelse() + " " + currentRoom().getForbindelser();
    }
    public boolean moveNorth(){
        if (currentRoom().getModnorth() != null) {
            setCurrentRoom(currentRoom().getModnorth());
            return true;
        }
        return false;
    }
    public boolean moveSouth(){
        if (currentRoom().getModsouth() != null) {
            setCurrentRoom(currentRoom().getModsouth());
            return true;
        }
        return false;
    }
    public boolean moveEast(){
        if (currentRoom().getModeast() != null) {
            setCurrentRoom(currentRoom().getModeast());
            return true;
        }
        return false;
    }
    public boolean moveWest(){
        if (currentRoom().getModwest() != null) {
            setCurrentRoom(currentRoom().getModwest());
            return true;
        }
        return false;
    }
   public String getCurrentRoomItems(){
        String printItems;
        printItems = denMørkeSkov.getCurrentRoom().printItems();
        return printItems;
   }
   public void takeItem(String name){
        playerOne.addItems(currentRoom().removeItems(name));
   }
   public void dropItem(String itemName){
        currentRoom().addItems(playerOne.removeItems(itemName));
   }
   public ArrayList<Items> getPlayerInventory(){
        return playerOne.getInventory();
   }
   public String printInventory(){
        String printInventory;
        printInventory = playerOne.printInventory();
        return printInventory;
   }
   public boolean handleTake(String itemName){
        if (itemName != null && !itemName.isEmpty()) {
            playerOne.addItems(currentRoom().removeItems(itemName));
            return true;
        }
        return false;
   }
   public boolean handleDrop(String itemName){
        if (itemName != null && !itemName.isEmpty()){
            currentRoom().addItems(playerOne.removeItems(itemName));
            return true;
        }
        return false;
   }





}



