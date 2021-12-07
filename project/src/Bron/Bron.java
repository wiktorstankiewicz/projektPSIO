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
    protected double obrazenia;
    protected BufferedImage zdjecie;


    protected Bron()
    {
        nazwa = "";
        obrazenia = 0;

        String path = "";
        File file = new File(path);
        try
        {
            zdjecie = ImageIO.read(Objects.requireNonNull(getClass().getResource(path)));

            //JLabel label = new JLabel(new ImageIcon(zdjecie));
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

    public double getObrazenia()
    {
        return obrazenia;
    }

    public Image getZdjecie()
    {
        return zdjecie;
    }
}
