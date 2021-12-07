package Bron.Zabojcy;



public class Sztylet extends BronZabojcy {

    public Sztylet() {
        nazwa = "Sztylet";
        obrazeniaMin = 15;
        obrazeniaMax = 20;
    }
    public String getPath(){
        return "/png/sztylet.png";
    }
}
