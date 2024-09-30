import java.util.Locale;
import java.util.Scanner;

public class UI {
    private DenMørkeSkov denMørkeSkov;
    private PlayerOne playerOne;

    public UI(DenMørkeSkov denMørkeSkov, PlayerOne playerOne) {
        this.denMørkeSkov = denMørkeSkov;
        this.playerOne = playerOne;
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
        playerOne.setNavn(playerOneNavn);


        System.out.println("Welcome " + playerOne.getNavn());
        System.out.println("You are in " + denMørkeSkov.getCurrentRoom().getNavn());

        while (!binput.equalsIgnoreCase("exit")) {
            binput = input.nextLine();
            switch (binput) {
                case "go north", "go n", "n":
                    playerOne.moveToNorth();
                    break;
                case "go east", "go e", "e":
                    playerOne.moveToEast();
                    break;
                case "go south", "go s", "s":
                    playerOne.moveTosouth();
                    break;
                case "go west", "go w", "w":
                    playerOne.moveToWest();
                    break;
                case "help", "h":
                    System.out.println("Insctruction and possible commands: ");
                    break;
                case "look", "l":
                    System.out.println("Descriptions of the room: " + denMørkeSkov.getCurrentRoom().getNavn()
                            + denMørkeSkov.getCurrentRoom().getBeskrivelse()
                            + denMørkeSkov.getCurrentRoom().getForbindelser());
                    break;
                case "exit":
                    System.out.println("Game ended\n" + "Thanks for playing");
                    break;
                default:
                    System.out.println("Wrong input");
                    break;
            }
        }
    }
}


