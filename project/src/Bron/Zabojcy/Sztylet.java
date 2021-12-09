package Bron.Zabojcy;

public class Sztylet extends BronZabojcy {

    public Sztylet() {
        nazwa = "Sztylet";
        obrazeniaMin = 15;
        obrazeniaMax = 20;
        imageFilePath = "project/resources/img/sztylet.png";
    }

    public String getPath(){
        return "sztylet.png";
    }
}
