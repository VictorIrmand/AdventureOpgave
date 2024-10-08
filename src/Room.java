import java.util.ArrayList;

public class Room {

    private String navn;
    private String beskrivelse;
    private String forbindelser;
    private Room modeast, modsouth, modnorth, modwest;
    private ArrayList<Item> items = new ArrayList<>();


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

    public ArrayList<Item> getItems() {
        return items;
    }

    //Adder items til room
    public Item addItems(Item i) {
        items.add(i);
        return i;

    }

    public String printItems() {
        String itemsList = "";
        for (Item r : items) {
            itemsList = itemsList + r.getShortName() + r.getEmoji() + " - " + r.getLongName() + "\n";
        }
        return itemsList;
    }

    //Remover items fra et room
    public Item removeItems(String name) {
        for (Item r : items) {
            if (r.getShortName().equalsIgnoreCase(name)) {
                items.remove(r);
                return r;
            }
        }
        return null;
    }

    public void removeItem(Item item) {
        items.remove(item);

    }

    public Item findItem(String name) {
        for (Item item : items) {
            if (item.getShortName().equalsIgnoreCase(name)) {
                return item;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        if (!items.isEmpty()) {
            return navn;
        } else {
            return "There is nothing to pick up here.";
        }
    }
}

