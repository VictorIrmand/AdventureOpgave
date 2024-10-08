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
        System.out.println("You can move North, East, West or South. To move type 'go' followed by one of the 4 compass directions");
        System.out.println("Type - 'take', followed by the 'item name' to add a item to your inventory");
        System.out.println("Type - 'drop', followed by the 'item name' to drop a item from your inventory");
        System.out.println("Type - 'invetory, inv or i' to see your inventory");
        System.out.println("Type - 'help' to get instructions or possible commands");
        System.out.println("Type - 'look' to get a description of the room your in");
        System.out.println("Type - 'equip' followed by the 'item name' to equip a item from your inventory");
        System.out.println("Type - 'attack' to attack with your equipped weapon");
        System.out.println("Type 'exit' to exit the game.");
        System.out.println("-----------------------------------------------------------------");

        System.out.println("Press enter to start the game!");

        Scanner input = new Scanner(System.in);
        String binput = input.nextLine();

        System.out.print("Please enter the characters name:");
        String playerOneNavn = input.nextLine();
        adventure.setPlayerName(playerOneNavn);
        System.out.println("-----------------------------------------------------------------");


        System.out.println("Welcome " + adventure.getPlayerName());
        System.out.println("Start health: " + adventure.getHealthBar());
        System.out.println("You are in " + adventure.getCurrentRoomDescription());

        while (!binput.equalsIgnoreCase("exit")) {
            System.out.println("-----------------------------------------------------------------");
            System.out.println("What is your next action?");
            binput = input.nextLine();
            String[] brugerinput = binput.split(" ", 2);
            String command = brugerinput[0].toLowerCase();
            String itemName = (brugerinput.length > 1) ? brugerinput[1] : null;
            switch (command) {
                case "go north", "go n", "n":
                    if (adventure.moveNorth()) {
                        System.out.println("Going North!");
                        System.out.println("You have moved to " + adventure.getCurrentRoomDescription());
                    } else {
                        System.out.println("You cannot move that way");
                    }
                    break;
                case "go east", "go e", "e":
                    if (adventure.moveEast()) {
                        System.out.println("Going East!");
                        System.out.println("You have moved to " + adventure.getCurrentRoomDescription());
                    } else {
                        System.out.println("You cannot move that way");
                    }
                    break;
                case "go south", "go s", "s":
                    if (adventure.moveSouth()) {
                        System.out.println("Going South!");
                        System.out.println("You have moved to " + adventure.getCurrentRoomDescription());
                    } else {
                        System.out.println("You cannot move that way");
                    }
                    break;
                case "go west", "go w", "w":
                    if (adventure.moveWest()) {
                        System.out.println("Going West!");
                        System.out.println("You have moved to " + adventure.getCurrentRoomDescription());
                    } else {
                        System.out.println("You cannot move that way");
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
                    System.out.println(adventure.handleAttack());
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

