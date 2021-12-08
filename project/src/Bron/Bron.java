package Bron;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


public abstract class Bron
{
    protected String nazwa;
    protected double obrazeniaMin, obrazeniaMax;
    protected BufferedImage zdjecie;

    protected Bron()
    {
        nazwa = "";
        obrazeniaMin = 0;
        obrazeniaMax = 0;

        init();
    }

    private void init()
    {

        try
        {
            zdjecie = ImageIO.read(new File("project/resources/img/"+getPath()));

            //JLabel label = new JLabel(new ImageIcon(zdjecie));
            //panelRozgrywki.add(label);  //TODO odkomentowac jak panel rozgrywki bedzie gotowy
        }
        catch (IOException e)
        {

            e.printStackTrace();
        }
    }

    public abstract String getPath();



}
