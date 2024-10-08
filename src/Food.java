public class Food extends Item {
    private int healthPoint;

    public Food() {

    }

    public Food(String shortName, String longName, int healthPoint, String emoji) {
        super(shortName, longName, emoji);
        this.healthPoint = healthPoint;

    }


    public int getHealthPoint() {
        return healthPoint;
    }


    @Override
    public String toString() {
        return super.toString() + healthPoint;
    }
}
