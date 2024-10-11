import java.sql.SQLOutput;
import java.util.Scanner;

public class UI {
    private DenMørkeSkov denMørkeSkov;
    private PlayerOne playerOne;
    private Adventure adventure;


    public UI(DenMørkeSkov denMørkeSkov, PlayerOne playerOne, Adventure adventure) {
        this.denMørkeSkov = denMørkeSkov;
        this.playerOne = playerOne;
        this.adventure = adventure;

    }

    public void setGame() {
        denMørkeSkov.buildMap();
        System.out.println("Welcome to Adventure!");
        System.out.println("You have following options and commands");
        System.out.println("You can move North, East, West or South. To move type one of the 4 compass directions");
        System.out.println("Type - 'take', followed by the 'item name' to add a item to your inventory");
        System.out.println("Type - 'drop', followed by the 'item name' to drop a item from your inventory");
        System.out.println("Type - 'invetory, inv or i' to see your inventory");
        System.out.println("Type - 'help' to get instructions or possible commands");
        System.out.println("Type - 'look' to get a description of the room your in");
        System.out.println("Type - 'equip' followed by the 'item name' to equip a item from your inventory");
        System.out.println("Type - 'attack' to attack with your equipped weapon - but be careful, the enemy hits back!");
        System.out.println("Type 'exit' to exit the game.");
        System.out.println("-----------------------------------------------------------------");

        System.out.println("Press enter to start the game!");

        Scanner input = new Scanner(System.in);
        String binput = input.nextLine();

        System.out.println("Shadows of the Dark Forest!");
        System.out.println("In the heart of the Dark Forest, a realm shrouded in mystery and shadow, the fearsome dragon Drakthor reigns supreme.\nOnce a vibrant land, the forest is now cursed, twisted by dark magic and inhabited by restless spirits and fierce creatures.\nDrakthor, with scales as black as night and eyes like molten gold, terrorizes nearby villages, demanding tribute and spreading fear.\n" +
                "\n" +
                "However, hope remains. Whispers of an ancient prophecy speak of a hero destined to venture into the forest, overcome its dangers, and confront Drakthor.");
        System.out.println("\nYour quest!");
        System.out.println("As the chosen hero, your mission is to traverse the treacherous paths of the Dark Forest, gathering powerful weapons, magical foods, and other treasures along the way.\n" +
                "\n" +
                "Objective: Defeat Drakthor and restore peace to the realm.\n" +
                "Your journey will test your bravery and cunning. Will you rise as the savior of the forest or fall victim to its darkness? The fate of the realm is in your hands!");

        System.out.print("Please enter the heroes name:");
        String playerOneNavn = input.nextLine();
        adventure.setPlayerName(playerOneNavn);
        System.out.println("-----------------------------------------------------------------");


        System.out.println("Welcome " + adventure.getPlayerName());
        System.out.println("You are at " + adventure.getCurrentRoomDescription());

        while (!binput.equalsIgnoreCase("exit")) {
            System.out.println("-----------------------------------------------------------------");
            System.out.println("What is your next action?");
            binput = input.nextLine();
            String[] brugerinput = binput.split(" ", 2);
            String command = brugerinput[0].toLowerCase();
            String itemName = (brugerinput.length > 1) ? brugerinput[1] : null;
            String enemyName = (brugerinput.length > 1) ? brugerinput[1] : null;
            switch (command) {
                case "north", "n":
                    if (adventure.moveNorth()) {
                        System.out.println("Going North!");
                        System.out.println("You have moved to " + adventure.getCurrentRoomDescription());
                    } else {
                        System.out.println("You cannot move that way");
                    }
                    if (!adventure.getCurrentRoomEnemies().isEmpty()){
                        System.out.println("Watch out, enemies in this room...");
                    } else {
                        System.out.println("No enemies in this rooom");
                    }
                    break;
                case "east","e":
                    if (adventure.moveEast()) {
                        System.out.println("Going East!");
                        System.out.println("You have moved to " + adventure.getCurrentRoomDescription());
                    } else {
                        System.out.println("You cannot move that way");
                    }
                    if (!adventure.getCurrentRoomEnemies().isEmpty()){
                        System.out.println("Watch out, enemies in this room...");
                    } else {
                        System.out.println("No enemies in this rooom");
                    }
                    break;
                case "south", "s":
                    if (adventure.moveSouth()) {
                        System.out.println("Going South!");
                        System.out.println("You have moved to " + adventure.getCurrentRoomDescription());
                    } else {
                        System.out.println("You cannot move that way");
                    }
                    if (!adventure.getCurrentRoomEnemies().isEmpty()){
                        System.out.println("Watch out, enemies in this room...");
                    } else {
                        System.out.println("No enemies in this rooom");
                    }
                    break;
                case "west", "w":
                    if (adventure.moveWest()) {
                        System.out.println("Going West!");
                        System.out.println("You have moved to " + adventure.getCurrentRoomDescription());
                    } else {
                        System.out.println("You cannot move that way");
                    }
                    if (!adventure.getCurrentRoomEnemies().isEmpty()){
                        System.out.println("Watch out, enemies in this room...");
                    } else {
                        System.out.println("No enemies in this rooom");
                    }
                    break;
                case "help", "h":
                    System.out.println("Insctruction and possible commands: ");
                    System.out.println("You are in " + adventure.getCurrentRoomName() + "\n To move type 'go' followed by one of the 4 compass directions");
                    System.out.println("To look at your surroundings - type 'look' ");
                    System.out.println("To exit the game - type 'exit'");
                    break;
                case "look", "l":
                    System.out.println("Description of the room: " + adventure.getCurrentRoomDescription());
                    if (!adventure.currentRoom().printItems().isEmpty()) {
                        System.out.println("Items in this room:\n" + adventure.getCurrentRoomItems());
                    } else {
                        System.out.println("No items in this room");
                    }
                    if (!adventure.currentRoom().printEnemy().isEmpty()){
                        System.out.println("Enemies in this room: \n" + adventure.getCurrentRoomEnemies());
                    } else {
                        System.out.println("No enemies in this room");
                    }
                    break;
                case "take", "t":
                    if (adventure.handleTake(itemName)) {
                        System.out.println("You took: " + itemName);
                    } else {
                        System.out.println("Item not found in the room\n"
                                + "Type 'look' to look again what items there are in this room");
                    }
                    break;
                case "drop", "d":
                    System.out.println(adventure.handleDrop(itemName));
                    break;
                case "inventory", "inv", "i":
                    if (!adventure.printEquippedWeapon().isEmpty()) {
                        System.out.println("Weapon equipped:\n" + adventure.printEquippedWeapon());
                    } else {
                        System.out.println("No weapon equipped");
                    }
                    if (!adventure.getPlayerInventory().isEmpty()) {
                        System.out.println("Your inventory: \n" + adventure.printInventory());
                    } else {
                        System.out.println("Inventory is empty");
                    }
                    break;
                case "health":
                    if (adventure.getHealthBar() < 50) {
                        System.out.println("Your health is low, avoid fighting: " + adventure.getHealthBar());
                    } else {
                        System.out.println("Health: " + adventure.getHealthBar());
                    }
                    break;
                case "eat":
                    System.out.println(adventure.handleEat(itemName));
                    break;
                case "equip":
                    System.out.println(adventure.handleEquip(itemName));
                    break;
                case "swap":
                    System.out.println(adventure.handleSwap(itemName));
                    break;
                case "attack":
                    System.out.println(adventure.handleAttack(enemyName));
                    if (playerOne.getHealthBar() <= 0){
                        adventure.endGame();
                    }
                    if(adventure.enemy.equals("Drakthor")){
                        adventure.endGame();

                    }
                    break;
                case "exit":
                    System.out.println("Game ended\n" + "Thanks for playing " + adventure.getPlayerName() + "!");
                    break;

                default:
                    System.out.println("Unkown command, please try again!");
                    break;

            }
        }
    }
}

