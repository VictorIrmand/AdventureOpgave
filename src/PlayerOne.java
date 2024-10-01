import java.util.ArrayList;

public class PlayerOne {
    private String navn;
    private DenMørkeSkov spilleren;
    private ArrayList<Items> inventory = new ArrayList<>();

    public ArrayList<Items> getInventory() {
        return inventory;
    }

    public String printInventory(){
        String inventoryList = "";
        for (Items r : inventory){
            inventoryList = inventoryList + r.getBeskrivelse() + r.getName() + ". ";
        }
        return inventoryList;
    }

    public Items addItems(Items i){
        inventory.add(i);
        return i;
    }
    public Items removeItems(String name){
        for (Items r : inventory){
            if (r.getName().equalsIgnoreCase(name)){
                inventory.remove(r);
                return r;
            }
        }
        return null;
    }


    public PlayerOne(DenMørkeSkov spilleren) {
        this.spilleren = spilleren;
    }

    public String getNavn() {
        return navn;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

}
