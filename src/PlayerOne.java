import java.util.ArrayList;

public class PlayerOne {
    private String navn;
    private Room currentRoom;
    private DenMørkeSkov denMørkeSkov;
    private int healthGain;
    private ArrayList<Item> inventory = new ArrayList<>();
    private int healthBar = 100;


    public PlayerOne(DenMørkeSkov denMørkeSkov, Room currentRoom) {
        this.currentRoom = currentRoom;
        this.denMørkeSkov = denMørkeSkov;
    }

    public void healthGain(){

    }


    public ArrayList<Item> getInventory() {
        return inventory;
    }

    public String printInventory() {
       String inventoryList = "";
        for (Item r : inventory) {
               inventoryList = inventoryList + r.getName() + ". ";
        }
        return inventoryList;
    }

    public void addItems(String itemName) {
        Item it = denMørkeSkov.getCurrentRoom().findItem(itemName);
        if (it != null) {
           inventory.add(it);

        }
    }
    public Item removeItemsFromInventory(String name) {
        Item found = findItemInInventory(name);
        inventory.remove(found);
        return found;
    }


    public Item findItemInInventory(String name) {
        for (Item item : inventory) {
            if (item.getName().equalsIgnoreCase(name)) {
                return item;
            }
        }
return null;
    }

    public String getNavn() {
        return navn;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

    public int getHealthBar() {
        return healthBar;
    }

    public void increaseHealth(int increase) {
        if (healthBar + increase > 100) {
            healthBar = 100;
        } else {
            healthBar += increase;
        }
    }
        public void decreaseHealth(int decrease){
        healthBar = healthBar + decrease;
        }

    public FoodStatus eat(String foodName) {
       Item itemToEat = denMørkeSkov.getCurrentRoom().findItem(foodName);
       if (itemToEat == null){
           itemToEat  = findItemInInventory(foodName);
           if (itemToEat == null){
               return FoodStatus.NOT_HERE;
           }
       }
       if (itemToEat instanceof Food) {
           Food food = (Food) itemToEat;
        if (food.getHealthPoint() > 0) {
            increaseHealth(food.getHealthPoint());
            inventory.remove(food);
            denMørkeSkov.getCurrentRoom().removeItem(food);
            return FoodStatus.GOOD;
        }
        else if (food.getHealthPoint() < 0) {
            decreaseHealth(food.getHealthPoint());
            inventory.remove(food);
            denMørkeSkov.getCurrentRoom().removeItem(food);
            return FoodStatus.BAD;
        } else if (!(itemToEat instanceof Food)){
            return FoodStatus.NOT_FOOD;
        }
       }
return FoodStatus.NOT_FOOD;
    }

}




