package Gra.Model.Bron;

import java.io.Serial;
import java.io.Serializable;

public abstract class Bron implements Serializable {
    //Version as of 11.12.2021 16:45
    @Serial
    private static final long serialVersionUID = -7461761631633339168L;
    protected String nazwa;
    protected int obrazeniaMin;
    protected int obrazeniaMax;
    protected String imageFilePath;

    protected Bron() {
        nazwa = "";
        obrazeniaMin = 0;
        obrazeniaMax = 0;
    }

    public int getObrazeniaMin() {
        return obrazeniaMin;
    }

    public int getObrazeniaMax() {
        return obrazeniaMax;
    }

    public String getImageFilePath() {
        return imageFilePath;
    }

    public void setImageFilePath(String imageFilePath) {
        this.imageFilePath = imageFilePath;
    }

    //this == b jezeli
    //this.nazwa == b.nazwa
    //this.obrazeniaMix == b.obrazeniaMin
    //this.obrazeniaMax == b.obrazeniaMax
    public boolean equals (Object b){
        if (!(b instanceof Bron)) return false;

        Bron bron = (Bron) b;
        if (!this.nazwa.equals(bron.nazwa)) return false;
        if (this.obrazeniaMin != bron.obrazeniaMin) return false;
        if (this.obrazeniaMax != bron.obrazeniaMax) return false;

        return true;
    }
}
