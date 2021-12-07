package Bron;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Objects;


public abstract class Bron
{
    protected String nazwa;
    protected double obrazenia_min, obrazenia_max;
    protected BufferedImage zdjecie;
    protected String path;



    protected Bron()
    {
        nazwa = "";
        obrazenia_min = 0;
        obrazenia_max = 0;

        File file = new File(path);
        try
        {
            zdjecie = ImageIO.read(Objects.requireNonNull(getClass().getResource(path)));

            JLabel label = new JLabel(new ImageIcon(zdjecie));
            //panelRozgrywki.add(label);  //TODO odkomentowac jak panel rozgrywki bedzie gotowy
        }
        catch (IOException e)
        {

            e.printStackTrace();
        }
    }

    public String getNazwa()
    {
        return nazwa;
    }

    public Image getZdjecie()
    {
        return zdjecie;
    }

    public double getObrazenia_min() {return obrazenia_min; }

    public double getObrazenia_max() {return obrazenia_max;}

}
