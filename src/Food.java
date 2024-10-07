public class Food extends Item {
   private int healthPoint;
   private int healthGain;
   private String emojis;



   public Food(){

}
    public Food(String name, int healthPoint, String emojis) {
        super(name);
        this.healthPoint = healthPoint;
        this.emojis = emojis;
    }

    public String getEmojis() {
        return emojis;
    }

    public int getHealthPoint() {
       return healthPoint;
    }

    public int getHealthGain(Food foodItem){
    return foodItem.getHealthPoint();
    }
    public void setHealthbar(int healthbar){
        this.healthGain += healthbar;
    }

    @Override
    public String toString(){
        return super.toString() + healthPoint + emojis;
    }
}
