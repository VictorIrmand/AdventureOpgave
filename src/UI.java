import java.util.Scanner;
public class UI {
    private String displayMenu;

    public void setDisplayMenu(){
        System.out.println("Press any button to start the game!");

        Scanner input = new Scanner(System.in);
        String binput = input.next();

        System.out.println("Welcome to Adventure!");
        System.out.println("You have following options and commands");
        System.out.println("Type - 'go north' to move north");
        System.out.println("Type - 'go east' to move east");
        System.out.println("Type - 'go south' to move south");
        System.out.println("Type - 'go west' to move west");
        System.out.println("Type 'exit' to exit the game.\n"
                + "type 'help' to get instructions or possible commands.\n "
                + "Type 'look' to get a description of the room you in.\n");
        System.out.println("");





    }
}
