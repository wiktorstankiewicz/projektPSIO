package Bron.Zabojcy;

public class Sztylet extends BronZabojcy {

    public Sztylet() {
        nazwa = "Sztylet";
        obrazeniaMin = 12;
        obrazeniaMax = 20;
        imageFilePath = "project/resources/img/sztylet.png";
    }

    public String getPath(){
        return "sztylet.png";
    }
}
