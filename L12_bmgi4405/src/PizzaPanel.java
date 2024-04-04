import javax.swing.*;
import java.awt.*;

public class PizzaPanel extends JPanel {
    private Pizza p;
    public PizzaPanel(Pizza p){
        this.p=p;
    }

    public Pizza getP() {
        return p;
    }

    public void setP(Pizza p) {
        this.p = p;
    }

    @Override
    public void paintComponent(Graphics g) {
        //super.paintComponent(g);
        p.bake(g);
    }
}
