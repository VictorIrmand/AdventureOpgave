public class Item {
    protected String shortName;
    protected String longName;
    protected String emoji;

    public Item() {

    }

    public Item(String name, String longName, String emoji) {
        this.shortName = name;
        this.longName = longName;
        this.emoji = emoji;

    }

    public String getShortName() {
        return shortName;
    }

    public String getEmoji() {
        return emoji;
    }

    public String getLongName() {
        return longName;
    }

    @Override
    public String toString() {
        return shortName;
    }
}
