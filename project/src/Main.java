import Bron.Bron;
import Bron.Lowcy.Luk;
import Bron.Maga.Rozdzka;
import Bron.Woja.Miecz;
import Bron.Woja.Mlot;
import Bron.Zabojcy.Sztylet;
import Grafika.WyborKlasy;
import Postacie.Postacie;

public class Main {

    private int test;

    public static void main(String[] args) {

        int ilosc_graczy = 2;
        Postac[] postacie = new Postacie[ilosc_graczy];
        Bron[] bronie = new Bron[ilosc_graczy];

        String[] StringBronie = new String[ilosc_graczy];
        String[] StringPostaci = new String[ilosc_graczy];

        StringPostaci[0] = WyborKlasy.wybierzKlase();
        StringBronie[0] = WyborKlasy.wybierzBron(StringPostaci[0]);

        StringPostaci[1] = WyborKlasy.generujKlasaBot();
        StringBronie[1] = WyborKlasy.generujBronBot(StringPostaci[1]);
        ;


        for (int i = 0; i < StringBronie.length; i++) {
            switch (StringBronie[i]) {
                case "Miecz":
                    bronie[i] = new Miecz();
                    break;

                case "Mlot":
                    bronie[i] = new Mlot();
                    break;

                case "Luk":
                    bronie[i] = new Luk();
                    break;

                case "Rozdzka":
                    bronie[i] = new Rozdzka();
                    break;
                case "Sztylet":
                    bronie[i] = new Sztylet();
            }
        }
        /*for (int i = 0; i < StringBronie.length; i++){
            switch (StringBronie[i]) {
                case "Wojownik":
                    postacie[i] = new Wojownik(bronie[i]);
                    break;
                case "Lowca":
                    postacie[i] = new Lowca(bronie[i]);
                    break;
                case "Zabojca":
                    postacie[i] = new Zabojca(bronie[i]);
                    break;
                case "Mag":
                    postacie[i] = new Mag(bronie[i]);
                    break;

              }

            }*/

        System.out.println(StringBronie[0]+"  "+StringBronie[1]);
        System.out.println(StringPostaci[0]+"  "+StringPostaci[1]);


        for (int i = 0; i < 2; i++) {
            System.out.println(bronie[i].getClass());
        }


    }
}
