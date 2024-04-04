import javax.swing.*;
import java.awt.*;

public class CheckBoxPanel extends JPanel {
    private JCheckBox corn;
    private JCheckBox mushroom;
    private JCheckBox olive;
    private JCheckBox salami;
    private JCheckBox tomato;
    public CheckBoxPanel(JCheckBox corn, JCheckBox mushroom, JCheckBox olive, JCheckBox salami, JCheckBox tomato){
        this.corn=corn;
        this.mushroom = mushroom;
        this.olive = olive;
        this.salami = salami;
        this.tomato = tomato;
        this.setLayout(new FlowLayout());
        this.add(corn);
        this.add(mushroom);
        this.add(olive);
        this.add(salami);
        this.add(tomato);
    }
}
