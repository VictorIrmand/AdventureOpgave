public class PlayerOne {
    private String navn;
    private DenMørkeSkov spilleren;

    public PlayerOne(DenMørkeSkov spilleren) {
        this.spilleren = spilleren;
    }

    public String getNavn() {
        return navn;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

}
