import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Mushroom extends PizzaIngredient {
    private BufferedImage img;
    public Mushroom(Pizza p)
    {
        super(p);
        try {
            this.img = ImageIO.read(new File("img/mushroom.png"));
        }
        catch (IOException e)
        {
            System.out.println("Hiba!!!!fujgomba!!!!");
        }
    }

    @Override
    public void bake(Graphics g) {
        super.bake(g);
        g.drawImage(img,0,0,null);
    }

    @Override
    public int getprice() {
        return super.getprice()+4;
    }

    @Override
    public String getingredients() {
        return super.getingredients()+" + "+getClass().getName();
    }
}