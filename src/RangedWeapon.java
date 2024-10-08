public class RangedWeapon extends Weapon {
    private int ammonition;

    public RangedWeapon(String shortName, String longName, int damage, int ammonition, String emoji) {
        super(shortName, longName, damage, emoji);
        this.ammonition = ammonition;
    }

    @Override
    String attack() {
        if (ammonition > 0) {
            ammonition--;
            return "FIREE!!" + "You dealt: " + damage + "\n Ammonition left: " + ammonition;
        } else {
            return "Out of ammonition!";
        }
    }

    @Override
    int ammoLeft() {
        return ammonition;
    }
}

