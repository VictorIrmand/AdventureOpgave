//import java.util.Scanner;

public class Adventure {
    PlayerOne playerOne;
    DenMørkeSkov denMørkeSkov;
    UI ui;
    public Adventure(){
        denMørkeSkov = new DenMørkeSkov();
        playerOne = new PlayerOne(denMørkeSkov);
        ui = new UI(denMørkeSkov,playerOne);

    }

    public void adventureGame(){
    denMørkeSkov.buildMap();
    ui.setGame();
    }

}



