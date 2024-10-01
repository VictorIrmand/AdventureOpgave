import java.sql.SQLOutput;
import java.util.Locale;
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
        System.out.println("Type - 'go north' to move north");
        System.out.println("Type - 'go east' to move east");
        System.out.println("Type - 'go south' to move south");
        System.out.println("Type - 'go west' to move west");
        System.out.println("Type 'exit' to exit the game.\n"
                + "type 'help' to get instructions or possible commands.\n "
                + "Type 'look' to get a description of the room you in.\n");

        System.out.println("Press enter to start the game!");

        Scanner input = new Scanner(System.in);
        String binput = input.nextLine();

        System.out.print("Please enter the characters name:");
        String playerOneNavn = input.nextLine();
        adventure.setPlayerName(playerOneNavn);


        System.out.println("Welcome " + adventure.getPlayerName());
        System.out.println("You are in " + adventure.currentRoom().getNavn());

        while (!binput.equalsIgnoreCase("exit")) {
            System.out.println("What is your next action?");
            binput = input.nextLine();
            switch (binput) {
                case "go north", "go n", "n":
                    if (adventure.currentRoom().getModnorth() != null) {
                        System.out.println("Going North!");
                        adventure.setCurrentRoom(adventure.currentRoom().getModnorth());
                        System.out.println("You have moved to " + adventure.currentRoom().getNavn()
                                + " " + adventure.currentRoom().getBeskrivelse()
                                + adventure.currentRoom().getForbindelser());
                    } else {
                        System.out.println("You cannot move that way");
                    }
                    break;
                case "go east", "go e", "e":
                    if (adventure.currentRoom().getModeast() != null) {
                        System.out.println("Going East!");
                        adventure.setCurrentRoom(adventure.currentRoom().getModeast());
                        System.out.println("You have moved to " + adventure.currentRoom().getNavn()
                                + " " + adventure.currentRoom().getBeskrivelse()
                                + adventure.currentRoom().getForbindelser());
                    } else {
                        System.out.println("You cannot move that way");
                    }
                    break;
                case "go south", "go s", "s":
                    if (adventure.currentRoom().getModsouth() != null) {
                        System.out.println("Going South!");
                        adventure.setCurrentRoom(adventure.currentRoom().getModsouth());
                        System.out.println("You have moved to " + adventure.currentRoom().getNavn()
                                + " " + adventure.currentRoom().getBeskrivelse()
                                + adventure.currentRoom().getForbindelser());
                    } else {
                        System.out.println("You cannot move that way");
                    }
                    break;
                case "go west", "go w", "w":
                    if (adventure.currentRoom().getModwest() != null) {
                        System.out.println("Going West!");
                        adventure.setCurrentRoom(adventure.currentRoom().getModwest());
                        System.out.println("You have moved to " + adventure.currentRoom().getNavn()
                                + " " + adventure.currentRoom().getBeskrivelse()
                                + adventure.currentRoom().getForbindelser());
                    } else {
                        System.out.println("You cannot move that way");
                    }
                    break;
                case "help", "h":
                    System.out.println("Insctruction and possible commands: ");
                    break;
                case "look", "l":
                    System.out.println("Description of the room: " + adventure.currentRoom().getNavn()
                            + adventure.currentRoom().getBeskrivelse()
                            + adventure.currentRoom().getForbindelser());
                    if (!adventure.currentRoom().printItems().isEmpty()) {
                        System.out.println("Items in this room: " + adventure.currentRoom().printItems());
                    } else {
                        System.out.println("Ingen items i dette rum");
                    }
                    break;
                case "take", "t":
                    System.out.println(adventure.currentRoom().printItems());
                    System.out.println("What item you want to take?");
                    binput = input.nextLine();
                    adventure.playerOne.addItems(adventure.currentRoom().removeItems(binput));
                    System.out.println("You took: " + binput);
                    break;
                case "drop", "d":
                    if (!adventure.playerOne.getInventory().isEmpty()) {
                        System.out.println("What item do you want to drop: " + adventure.playerOne.printInventory());
                        System.out.println("Type 'cancel' to not drop anything");
                        binput = input.nextLine();
                        if (!binput.equalsIgnoreCase("cancel")) {
                            adventure.currentRoom().addItems(adventure.playerOne.removeItems(binput));
                            System.out.println("You removed: " + binput);
                        } else {
                            System.out.println("Cancelled");
                        }
                    } else {
                        System.out.println("Inventory is empty:");
                    }
                    break;
                case "inventory", "inv", "i":
                    if (!adventure.playerOne.getInventory().isEmpty()) {
                        System.out.println("Your inventory:" + adventure.playerOne.printInventory());
                    } else {
                        System.out.println("Inventory is empty");
                    }
                    break;
                case "exit":
                    System.out.println("Game ended\n" + "Thanks for playing");
                    break;

                default:
                    String[] navn = binput.split(" ");
                    String lin = binput.toLowerCase();
                    if (binput.contains("take")) {
                        if (navn.length > 1 && navn[1] != null) {
                            System.out.println("You took: " + adventure.playerOne.addItems(adventure.currentRoom().removeItems(navn[1])));
                        } else {
                            System.out.println("Wrong input");
                        }
                    }
                    else if (binput.contains("drop") && !adventure.playerOne.getInventory().isEmpty()) {
                        if (navn.length > 1 && navn[1] != null) {
                            System.out.println("You dropped: " + adventure.currentRoom().addItems(adventure.playerOne.removeItems(navn[1])));
                        } else {
                            System.out.println("Wrong input");
                        }
                    } else {
                        System.out.println("Invetory is empty");
                    }
                    break;

            }
        }
    }
}

