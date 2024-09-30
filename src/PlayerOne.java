public class PlayerOne {
    private String navn;
    private DenMørkeSkov spilleren;

    public PlayerOne(DenMørkeSkov spilleren){
        this.spilleren = spilleren;
    }

    public String getNavn() {
        return navn;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }


    public void moveToNorth() {
        if (spilleren.getCurrentRoom().getModnorth() != null) {
            System.out.println("Going North!");
            spilleren.setCurrentRoom(spilleren.getCurrentRoom().getModnorth());
            System.out.println("You have moved to " + spilleren.getCurrentRoom().getNavn()
                    + " " + spilleren.getCurrentRoom().getBeskrivelse()
                    + spilleren.getCurrentRoom().getForbindelser());
        } else {
            System.out.println("You cannot move that way");
        }
    }

    public void moveTosouth() {
        if (spilleren.getCurrentRoom().getModsouth() != null) {
            System.out.println("Going South!");
            spilleren.setCurrentRoom(spilleren.getCurrentRoom().getModsouth());
            System.out.println("You have moved to " + spilleren.getCurrentRoom().getNavn()
                    + " " + spilleren.getCurrentRoom().getBeskrivelse()
                    + spilleren.getCurrentRoom().getForbindelser());
        } else {
            System.out.println("You cannot move that way");
        }
    }

    public void moveToEast() {
        if (spilleren.getCurrentRoom().getModeast() != null) {
            System.out.println("Going East!");
            spilleren.setCurrentRoom(spilleren.getCurrentRoom().getModeast());
            System.out.println("You have moved to " + spilleren.getCurrentRoom().getNavn()
                    + " " + spilleren.getCurrentRoom().getBeskrivelse()
                    + spilleren.getCurrentRoom().getForbindelser());
        } else {
            System.out.println("You cannot move that way");
        }
    }

    public void moveToWest() {
        if (spilleren.getCurrentRoom().getModwest() != null) {
            System.out.println("Going West!");
            spilleren.setCurrentRoom(spilleren.getCurrentRoom().getModwest());
            System.out.println("You have moved to " + spilleren.getCurrentRoom().getNavn()
                    + " " + spilleren.getCurrentRoom().getBeskrivelse()
                    + spilleren.getCurrentRoom().getForbindelser());
        } else {
            System.out.println("You cannot move that way");
        }
    }
}
