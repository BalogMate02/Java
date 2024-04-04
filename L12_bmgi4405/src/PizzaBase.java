import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class PizzaBase implements  Pizza{
    private BufferedImage img;
    public PizzaBase() {
        try {
            this.img = ImageIO.read(new File("img/pizza_base.png"));
        }
        catch (IOException e)
        {
            System.out.println("Hiba!!!!pizzabase!!!!");
        }
    }
    @Override
    public void bake(Graphics g) {
        g.drawImage(img, 0, 0, null);
    }

    @Override
    public int getprice() {
        return 15;
    }

    @Override
    public String getingredients() {
        return getClass().getName();
    }
}
