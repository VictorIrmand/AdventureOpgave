//import java.util.Scanner;

import java.util.ArrayList;

public class Adventure {
    PlayerOne playerOne;
    DenMørkeSkov denMørkeSkov;
    UI ui;
    Food food;
    Enemy enemy;


    public Adventure() {
        denMørkeSkov = new DenMørkeSkov();
        denMørkeSkov.buildMap();
        playerOne = new PlayerOne(denMørkeSkov);
        food = new Food();
        enemy = new Enemy();
        ui = new UI(denMørkeSkov, playerOne, this);

    }

    public void adventureGame() {
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


    public String getCurrentRoomDescription() {
        return currentRoom().getNavn() + " " + currentRoom().getBeskrivelse() + " " + currentRoom().getForbindelser();
    }

    public String getCurrentRoomName() {
        return currentRoom().getNavn();
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


    public ArrayList<Item> getPlayerInventory() {
        return playerOne.getInventory();
    }

    public String printInventory() {
        return playerOne.printInventory();
    }

    public String printEquippedWeapon() {
        return playerOne.printEquippedWeapon();
    }

    public int getHealthBar() {
        return playerOne.getHealthBar();
    }

    public String getEnemyDescription() {
        return enemy.getName() + enemy.getBeskrivelse() + enemy.getHealth();
    }

    public String getCurrentRoomEnemies() {
        String print;
        print = denMørkeSkov.getCurrentRoom().printEnemy();
        return print;
    }


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

    public String handleDrop(String itemName) {
        if (playerOne.getInventory().isEmpty() && playerOne.getEquipped().isEmpty()) {
            return itemName + " is not equipped or found in inventory" + "\nType 'inventory' to look again in your inventory";
        }
        Item found = playerOne.findItemInInventory(itemName);
        if (itemName != null && !itemName.isEmpty()) {
            if (found != null && playerOne.getInventory().contains(found)) {
                denMørkeSkov.getCurrentRoom().addItems(playerOne.removeItemsFromInventory(itemName));
                return "You dropped: " + itemName;
            }
            Item foundEquipped = playerOne.findItemInEquipped(itemName);
            if (foundEquipped != null && playerOne.getEquipped().contains(foundEquipped)) {
                denMørkeSkov.getCurrentRoom().addItems(playerOne.removeItemsFromEquipped((itemName)));
                return "You dropped: " + itemName;
            }
        }
        return "Item not found, try look for it...";
    }

    public String handleEat(String foodName) {
        return playerOne.eat(foodName);
    }

    public String handleEquip(String itemName) {
        return playerOne.equip(itemName);
    }

    public String handleSwap(String itemName) {
        return playerOne.swap(itemName);
    }

    public String handleAttack(String enemyName) {
        if (playerOne.getEquipped().isEmpty()) {
            return "You need to equip an item to attack";
        }

        String exitMessage = "";
        Enemy enemyFound = denMørkeSkov.getCurrentRoom().findEnemy(enemyName);
        if (enemyFound == null) {
            enemyFound = denMørkeSkov.getCurrentRoom().getEnemies().getFirst();
        }
        enemyName = enemyFound.getName();
        if (enemyFound != null) {
            exitMessage = exitMessage + playerOne.attack(enemyName);
            if (enemyFound.getHealth() <= 0) {
                enemyFound.dropLoot();
                denMørkeSkov.getCurrentRoom().removeEnemy(enemyName);
                if (enemyName.equals("Drakthor")) {
                    exitMessage = exitMessage + enemyName + " is dead!" + "\nCongratulations, brave adventurer!\n" +
                            "\n" +
                            "You have defeated Drakthor, the Devourer, and restored peace to the dark forest. The skies clear, and the land begins to heal.\nYour name will be remembered as the hero who saved the woods. Thank you for your courage!";
                    return exitMessage;

                }
                exitMessage = exitMessage + "\nCongrats, " + enemyName + " is dead. His items is now usable. Can be locate in the room";

            } else {
                exitMessage = exitMessage + "\n" + enemyName + "Health: " + enemyFound.getHealth();
                playerOne.decreaseHealth(enemyFound.getDamage());
                exitMessage = exitMessage + "\n" + enemyName + " hit you with his " + enemyFound.getWeaponName() + " for " + enemyFound.getDamage();
                if (playerOne.getHealthBar() <= 0) {
                    exitMessage = exitMessage + "\n" + enemyName + "'s attack was to powerfull... your are dead.";
                }
            }

            return exitMessage;

        }
        return "No enemies here to fight!";
    }

    public void endGame() {
        System.exit(0);
    }
}





