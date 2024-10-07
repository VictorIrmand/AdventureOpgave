public class Item {
    protected String name;
    protected String beskrivelse;
    private UI items;

    public Item(){

    }

    public Item(String name){
        this.name = name;

    }

    public String getName() {
        return name;
    }

    public String getBeskrivelse() {
        return beskrivelse;
    }
    @Override
    public String toString(){
        return name;
    }
}
