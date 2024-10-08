public abstract class Weapon extends Item {
    protected int damage;

    public Weapon(String shortName, String longName, int damage, String emoji) {
        super(shortName, longName, emoji);
        this.damage = damage;
    }

    abstract String attack();

    abstract int ammoLeft();

}
