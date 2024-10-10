import java.util.ArrayList;

public class Enemy {
    private String name;
    private String beskrivelse;
    private int health;
    private Weapon weapon;
    DenMørkeSkov denMørkeSkov;

public Enemy(){

}
    public Enemy(String name, String beskrivelse, int health, DenMørkeSkov denMørkeSkov, Weapon weapon) {
        this.name = name;
        this.beskrivelse = beskrivelse;
        this.health = health;
        this.denMørkeSkov = denMørkeSkov;
        this.weapon = weapon;
    }

    public String getName() {
        return name;
    }

    public void setWeapon(Item whatWeapon) {
        this.weapon = weapon;
    }

    public String getBeskrivelse() {
        return beskrivelse;
    }

    public int getHealth() {
        return health;
    }

    public void takeDamage(int damageTaken) {
        health -= damageTaken;
    }


    public void dropLoot() {
            denMørkeSkov.getCurrentRoom().addItems(weapon);

    }

    public int getDamage() {
        return weapon.damage;
    }
    public String getWeaponName(){
    return weapon.shortName;
    }
}



