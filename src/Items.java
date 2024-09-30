public class Items {
    private String name;
    private String beskrivelse;
    private UI items;


    public Items(String beskrivelse, String name){
        this.name = name;
        this.beskrivelse = beskrivelse;
    }

    public String getName() {
        return name;
    }

    public String getBeskrivelse() {
        return beskrivelse;
    }
}
