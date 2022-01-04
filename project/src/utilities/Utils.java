package utilities;

import gra.model.bron.lowcy.Luk;
import gra.model.bron.maga.Rozdzka;
import gra.model.bron.woja.Miecz;
import gra.model.bron.woja.Mlot;
import gra.model.bron.zabojcy.Sztylet;
import gra.model.postacie.Postac;
import gra.model.postacie.dystansowe.Lowca;
import gra.model.postacie.dystansowe.Mag;
import gra.model.postacie.wZwarciu.Wojownik;
import gra.model.postacie.wZwarciu.Zabojca;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

public abstract class Utils {
	public static ArrayList<Postac> readArrayListFromTXTFile(File file){
		ArrayList<Postac> arr = new ArrayList<>();
		try (BufferedReader breader = new BufferedReader(new FileReader(file))){

			String wiersz;
			String[] staty;

			while ((wiersz = breader.readLine()) != null){
				staty = wiersz.split(";");

				for (int i = 0; i < staty.length; i++) {
					staty[i] = staty[i].trim();
					if (i == 1) continue;
					staty[i] = staty[i].toLowerCase();
				}

				switch (staty[0]){
					case "zabojca":
						if(staty[2].equals("sztylet")) {
							arr.add(new Zabojca(staty[1], new Sztylet()));
						}
					case "lowca":
						if (staty[2].equals("luk")) {
							arr.add(new Lowca(staty[1], new Luk()));
						}
					case "wojownik":
						if(staty[2].equals("miecz")) {
							arr.add(new Wojownik(staty[1], new Miecz()));
						}
						if(staty[2].equals("mlot")) {
							arr.add(new Wojownik(staty[1], new Mlot()));
						}
					case "mag":
						if (staty[2].equals("rozdzka")) {
							arr.add(new Mag(staty[1], new Rozdzka()));
						}
				}
			}
		} catch (Exception ignored){
		}
		return arr;
	}
}
