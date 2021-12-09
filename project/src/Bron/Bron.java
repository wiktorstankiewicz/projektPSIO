package Bron;

public abstract class Bron {
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
}
