public class MeleeWeapon extends Weapon {
    String swordEmoji = "⚔️";
    public MeleeWeapon(String shortName, String longName, int damage, String emoji) {
        super(shortName, longName, damage, emoji);
    }

    @Override
    String attack() {
        return "Attacking! " + swordEmoji + "\nYou dealt: " + damage + " damage with your " + shortName;
    }

    @Override
    int ammoLeft() {
        return 0;
    }
}