public class Items {
    private String name;
    private String beskrivelse;
    private UI items;


    public Items(String name, String beskrivelse){
        this.beskrivelse = beskrivelse;
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
        return beskrivelse + name;
    }
}
