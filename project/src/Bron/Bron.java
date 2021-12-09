package Bron;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


public abstract class Bron {
    protected String nazwa;
    protected int obrazeniaMin, obrazeniaMax;
    protected BufferedImage zdjecie;
    protected String imageFilePath;

    protected Bron() {
        nazwa = "";
        obrazeniaMin = 0;
        obrazeniaMax = 0;

        init();
    }

    private void init() {

        try {
            zdjecie = ImageIO.read(new File("project/resources/img/"+getPath()));

        } catch (IOException e) {

            e.printStackTrace();
        }
    }

    public abstract String getPath();

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
