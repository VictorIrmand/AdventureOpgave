//import java.util.Scanner;

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

}



