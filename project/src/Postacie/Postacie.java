package Postacie;

import AtakiInterfejs.*;
import java.util.*;

public class Postacie {

    //Skladowe potrzebne do Interfesow AtakInterfejs_I
    protected int Hp;
    protected Postacie Przeciwnik;
    protected int Armor; //Procentowe pochlanianie obrazeni 0-100
    protected int DodgeChance;
    protected int Dmg;
    protected AtakiInterfejs_I AtakInterfejs;
    //************************************************

    public void TakeDmg(int Dmg)
    {
        Random los = new Random();
        if(DodgeChance < los.nextInt(100))
        {
            //Uzupelnijcie co sie dzieje jezeli jest unik
        }
        else
        {
            Hp = Hp-((100-Armor)/100)*Dmg;
        }
    }

    public void WykonajAtak()
    {
        AtakInterfejs.Atak(this);
    }

    public void ZadajObrazenia()
    {
        Random los = new Random();
        int MinDMG = 20; // TUTAJ TESTUJEMY DLA ROZRZUTU BRONI
        int MaxDMG = 60; // UZUPELNIJCIE TO POTEM JAKO SKLADOWE KLASY BRONI
        Przeciwnik.TakeDmg(Dmg + MinDMG + los.nextInt(MaxDMG-MinDMG+1));
    }

    //Setery i getery Skladowe potrzebne do Interfesow AtakInterfejs_I
    public int getHp() {
        return Hp;
    }

    public Postacie getPrzeciwnik() {
        return Przeciwnik;
    }

    public int getArmor() {
        return Armor;
    }

    public int getDodgeChance() {
        return DodgeChance;
    }

    public void setHp(int hp) {
        Hp = hp;
    }

    public void setPrzeciwnik(Postacie przeciwnik) {
        Przeciwnik = przeciwnik;
    }

    public void setArmor(int armor) {
        Armor = armor;
    }

    public void setDodgeChance(int dodgeChance) {
        DodgeChance = dodgeChance;
    }
    //*******************************************************************

}
