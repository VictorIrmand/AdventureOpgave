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
        System.out.println("Type - 'go north, go n or n' to move north");
        System.out.println("Type - 'go east, go e or e' to move east");
        System.out.println("Type - 'go south, go s or s' to move south");
        System.out.println("Type - 'go west, go w or w' to move west");
        System.out.println("Type - 'take', space 'item' to add a item to your inventory");
        System.out.println("Type - 'drop', space 'item' to drop a item from your inventory");
        System.out.println("Type - 'invetory, inv or i' to see your inventory");
        System.out.println("Type - 'help' to get instructions or possible commands");
        System.out.println("Type - 'look' to get a description of the room your in");
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
        //System.out.println("Health: " + adventure.getHealthBar());
        System.out.println("You are in " + adventure.getCurrentRoomDescription());

        while (!binput.equalsIgnoreCase("exit")) {
            System.out.println("-----------------------------------------------------------------");
            System.out.println("What is your next action?");
            binput = input.nextLine();
            String[] brugerinput = binput.split(" ",2);
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
                    break;
                case "look", "l":
                    System.out.println("Description of the room: " + adventure.getCurrentRoomDescription());
                    if (!adventure.currentRoom().printItems().isEmpty()) {
                        System.out.println("Items in this room: " + adventure.getCurrentRoomItems());
                    } else {
                        System.out.println("No items in this room:");
                    }
                    break;
                case "take", "t":
                    if (adventure.handleTake(itemName)){
                        System.out.println("You took: " + itemName);
                    } else {
                        System.out.println("Item not found in the room\n"
                                + "Type 'look' to look again what items there are in this room");
                    }
                    break;
                case "drop", "d":
                    if (adventure.handleDrop(itemName)){
                        System.out.println("You dropped: " + itemName);
                    } else {
                        System.out.println(itemName + " not found in your inventory"
                                + "\nType 'inventory' to look again in your inventory");
                    }
                    break;
                case "inventory", "inv", "i":
                    if (!adventure.getPlayerInventory().isEmpty()) {
                        System.out.println("Your inventory: " + adventure.printInventory());
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
                case "eat", "drink":
                    System.out.println(adventure.handleEat(itemName));
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

