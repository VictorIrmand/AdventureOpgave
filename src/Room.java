import java.util.ArrayList;

public class Room {

    private String navn;
    private String beskrivelse;
    private String forbindelser;
    private Room modeast, modsouth, modnorth, modwest;


    public String getNavn() {
        return navn;
    }

    public String getBeskrivelse() {
        return beskrivelse;
    }

    public String getForbindelser() {
        return forbindelser;
    }

    public Room(String navn, String beskrivelse, String forbindelser) {
        this.navn = navn;
        this.beskrivelse = beskrivelse;
        this.forbindelser = forbindelser;
    }

    public void setModeast(Room east) {
        this.modeast = east;
    }

    public void setModsouth(Room south) {
        this.modsouth = south;
    }

    public void setModnorth(Room north) {
        this.modnorth = north;
    }

    public void setModwest(Room west) {
        this.modwest = west;
    }

    public Room getModeast() {
        return modeast;
    }

    public Room getModnorth() {
        return modnorth;
    }

    public Room getModsouth() {
        return modsouth;
    }

    public Room getModwest() {
        return modwest;
    }


}

