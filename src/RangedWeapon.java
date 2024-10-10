public class RangedWeapon extends Weapon {
    private int ammonition;
    String fireEmoji = "\uD83D\uDCA5";

    public RangedWeapon(String shortName, String longName, int damage, int ammonition, String emoji) {
        super(shortName, longName, damage, emoji);
        this.ammonition = ammonition;
    }

    @Override
    String attack(Enemy enemyName) {
        String print;
        if (ammonition > 0) {
            ammonition--;
            print = "Firing with your " + shortName + fireEmoji + "\nYou dealt: " + damage + "damage to " + enemyName.getName() + "\n Ammonition left: " + ammonition;
            return print;
        } else {
            print = "Out of ammonition!";
            return print;
        }
    }

    @Override
    int ammoLeft() {
        return ammonition;
    }
}

