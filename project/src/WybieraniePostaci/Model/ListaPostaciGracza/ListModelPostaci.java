package WybieraniePostaci.Model.ListaPostaciGracza;

import Postacie.Postac;

import javax.swing.*;
import javax.swing.event.ListDataListener;
import java.util.ArrayList;

public class ListModelPostaci implements ListModel {
    private ArrayList<Postac> listaPostaci;

    public ListModelPostaci(){};

    public ListModelPostaci(ArrayList<Postac> listaPostaci){
        this.listaPostaci = listaPostaci;
    }
    @Override
    public int getSize() {
        return listaPostaci.toArray().length;
    }

    @Override
    public Object getElementAt(int index) {
        return listaPostaci.get(index);
    }

    @Override
    public void addListDataListener(ListDataListener l) {

    }

    @Override
    public void removeListDataListener(ListDataListener l) {

    }

    public ArrayList<Postac> getListaPostaci() {
        return listaPostaci;
    }

    public void setListaPostaci(ArrayList<Postac> listaPostaci) {
        this.listaPostaci = listaPostaci;
    }
}
