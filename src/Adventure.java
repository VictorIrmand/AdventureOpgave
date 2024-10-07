//import java.util.Scanner;

import java.util.ArrayList;

public class Adventure {
    PlayerOne playerOne;
    DenMørkeSkov denMørkeSkov;
    UI ui;
    Food food;
    Item item;


    public Adventure() {
        denMørkeSkov = new DenMørkeSkov();
        denMørkeSkov.buildMap();
        playerOne = new PlayerOne(denMørkeSkov, denMørkeSkov.getCurrentRoom());
        food = new Food();
        ui = new UI(denMørkeSkov, playerOne, this);

    }

    public void adventureGame() {
        //denMørkeSkov.buildMap();
        ui.setGame();
    }

    public void setPlayerName(String name) {
        playerOne.setNavn(name);
    }

    public String getPlayerName() {
        return playerOne.getNavn();
    }

    public Room currentRoom() {
        return denMørkeSkov.getCurrentRoom();
    }

    public void setCurrentRoom(Room room) {
        denMørkeSkov.setCurrentRoom(room);
    }

    public String getItemDescription() {
        return currentRoom().printItems();
    }

    public String getCurrentRoomDescription() {
        return currentRoom().getNavn() + " " + currentRoom().getBeskrivelse() + " " + currentRoom().getForbindelser();
    }

    public boolean moveNorth() {
        if (currentRoom().getModnorth() != null) {
            setCurrentRoom(currentRoom().getModnorth());
            return true;
        }
        return false;
    }

    public boolean moveSouth() {
        if (currentRoom().getModsouth() != null) {
            setCurrentRoom(currentRoom().getModsouth());
            return true;
        }
        return false;
    }

    public boolean moveEast() {
        if (currentRoom().getModeast() != null) {
            setCurrentRoom(currentRoom().getModeast());
            return true;
        }
        return false;
    }

    public boolean moveWest() {
        if (currentRoom().getModwest() != null) {
            setCurrentRoom(currentRoom().getModwest());
            return true;
        }
        return false;
    }

    public String getCurrentRoomItems() {
        String print;
        print = denMørkeSkov.getCurrentRoom().printItems();
        return print;
    }

    public void takeItem(String name) {
        playerOne.addItems(name);
        currentRoom().removeItems(name);
    }

    public void dropItem(String itemName) {
        currentRoom().addItems(playerOne.removeItemsFromInventory(itemName));
    }

    public ArrayList<Item> getPlayerInventory() {
        return playerOne.getInventory();
    }

    public String printInventory() {
        return playerOne.printInventory();
    }

   /*public Item handleEat(Item item){
       Food food = playerOne.findItem(item);
        if (food instanceof Food){
            playerOne.eatFood(food);
            return food;
        }
        return null;
   }

    */

    public boolean handleTake(String itemName) {
        if (itemName != null && !itemName.isEmpty()) {
            Item itemToTake = currentRoom().findItem(itemName);
            if (itemToTake != null) {
                playerOne.addItems(itemName);
                currentRoom().removeItems(itemName);
                return true;
            }
        }
        return false;
    }

    public boolean handleDrop(String itemName) {
        if (playerOne.getInventory().isEmpty()) {
            return false;
        }
        if (itemName != null && !itemName.isEmpty()) {
            currentRoom().addItems(playerOne.removeItemsFromInventory(itemName));
            return true;
        }
        return false;
    }

    public int getHealthBar() {
        return playerOne.getHealthBar();
    }

    public String handleEat(String foodName) {
        Item itemToEat = denMørkeSkov.getCurrentRoom().findItem(foodName);
        if (itemToEat == null) {
            itemToEat = playerOne.findItemInInventory(foodName);
        }
        if (itemToEat instanceof Food) {
            Food food = (Food) itemToEat;

            FoodStatus status = playerOne.eat(foodName);
            switch (status) {
                case GOOD:
                    return "You ate " + foodName + "!" + " You gained " + food.getHealthPoint() + " healthpoints";

                case BAD:
                    return "Not good, you just lost health!" + " Current health " + playerOne.getHealthBar() + " healthpoints";

                case NOT_FOOD:
                    return "You cannot eat that!";

                case NOT_HERE:
                    return foodName + " is not in this room or your inventory";

                default:
                    return "Unknown command, please try again!";
            }

        } else {
            return "The item is not food";
        }
    }

}



