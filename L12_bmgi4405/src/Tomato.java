import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Tomato extends PizzaIngredient {
    private BufferedImage img;
    public Tomato(Pizza p)
    {
        super(p);
        try {
            this.img = ImageIO.read(new File("img/tomato.png"));
        }
        catch (IOException e)
        {
            System.out.println("Hiba!!!!tomato!!!!");
        }
    }

    @Override
    public void bake(Graphics g) {
        super.bake(g);
        g.drawImage(img,0,0,null);
    }

    @Override
    public int getprice() {
        return super.getprice()+5;
    }

    @Override
    public String getingredients() {
        return super.getingredients()+" + "+getClass().getName();
    }
}
