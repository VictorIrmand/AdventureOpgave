import java.util.ArrayList;

public class PlayerOne {
    private String navn;
    private DenMørkeSkov denMørkeSkov;
    private ArrayList<Item> inventory = new ArrayList<>();
    private ArrayList<Item> equipped = new ArrayList<>();
    private int healthBar = 100;


    public PlayerOne(DenMørkeSkov denMørkeSkov) {
        this.denMørkeSkov = denMørkeSkov;
    }


    public ArrayList<Item> getInventory() {
        return inventory;
    }

    public ArrayList<Item> getEquipped() {
        return equipped;
    }

    public String printInventory() {
        String inventoryList = "";
        for (Item r : inventory) {
            inventoryList = inventoryList + r.getShortName() + r.getEmoji() + " - " + r.getLongName() + "\n";
        }
        return inventoryList;
    }

    public String printEquippedWeapon() {
        String equippedWeapon = "";
        for (Item r : equipped) {
            equippedWeapon = equippedWeapon + r.getShortName() + r.getEmoji() + " - " + r.getLongName();
        }
        return equippedWeapon;
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
            if (item.getShortName().equalsIgnoreCase(name)) {
                return item;
            }
        }
        return null;
    }

    public Item findItemInEquipped(String name) {
        for (Item item : equipped) {
            if (item.getShortName().equalsIgnoreCase(name)) {
                return item;
            }
        }
        return null;
    }

    public Item removeItemsFromEquipped(String name) {
        Item found = findItemInEquipped(name);
        equipped.remove(found);
        return found;
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

    public void decreaseHealth(int decrease) {
        healthBar = healthBar - decrease;
        if (healthBar <= 0) {

        }
    }


    public String eat(String foodName) {
        Item itemToEat = denMørkeSkov.getCurrentRoom().findItem(foodName);
        if (itemToEat == null) {
            itemToEat = findItemInInventory(foodName);
            if (itemToEat == null) {
                return foodName + " is not in this room or your inventory";
            }
        }
        if (itemToEat instanceof Food) {
            Food food = (Food) itemToEat;
            if (food.getHealthPoint() > 0) {
                increaseHealth(food.getHealthPoint());
                inventory.remove(food);
                denMørkeSkov.getCurrentRoom().removeItem(food);
                return "You ate " + foodName + "!" + " You gained " + food.getHealthPoint() + " healthpoints";
            } else if (food.getHealthPoint() < 0) {
                decreaseHealth(food.getHealthPoint());
                inventory.remove(food);
                denMørkeSkov.getCurrentRoom().removeItem(food);
                return "Not good, you just lost health!" + " Current health " + healthBar + " healthpoints";
            }
        }
        return "You cannot eat that!";
    }

    public String equip(String itemName) {
        Item itemToEquip = findItemInInventory(itemName);
        if (!equipped.isEmpty()) {
            return "Sorry, you already have a weapon equipped, try 'swap' instead";
        }
        if (itemToEquip == null) {
            return "Sorry, item has to be in your inventory";
        }
        if (itemToEquip instanceof Weapon) {
            inventory.remove(itemToEquip);
            equipped.add(itemToEquip);
            return "Equipped: " + itemToEquip;

        }
        return "Sorry, cannot equip that type of item";
    }

    public String swap(String itemName) {
        Item itemToSwap = findItemInInventory(itemName);
        Item itemEquipped = equipped.getFirst();
        if (equipped.isEmpty()) {
            return "Sorry, cannot swap with a empty slot";
        }
        if (itemToSwap == null) {
            return "Sorry, item has to be in your inventory to swap";
        }
        if (itemToSwap instanceof Weapon) {
            equipped.remove(itemEquipped);
            equipped.add(itemToSwap);
            inventory.add(itemEquipped);
            inventory.remove(itemToSwap);
            return "Swapped - weapon equipped: " + itemToSwap;
        }
        return "Sorry, item cannot be swapped";
    }

    public String attack(String enemyName) {
            Weapon weaponEquipped = (Weapon) equipped.getFirst();
            Enemy enemyToAttack = denMørkeSkov.getCurrentRoom().findEnemy(enemyName);
            return weaponEquipped.attack(enemyToAttack);
        }
    }






