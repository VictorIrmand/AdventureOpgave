public class MeleeWeapon extends Weapon {
    String swordEmoji = "⚔️";
    public MeleeWeapon(String shortName, String longName, int damage, String emoji) {
        super(shortName, longName, damage, emoji);
    }

    @Override
    String attack(Enemy enemyName) {
        String print;
        enemyName.takeDamage(damage);
        print = "Attacking with your " + shortName + swordEmoji + "\nYou dealt: " + damage + " damage to " + enemyName.getName();

        return print;
    }

    @Override
    int ammoLeft() {
        return 0;
    }
}