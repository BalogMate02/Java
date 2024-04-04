import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.Objects;
//A pizza futási időben történő felépítését JCheckBox komponensek segítségével oldjuk meg. A megfelelő checkbox-ok
// kijelölésével a felhasználó kiválaszthatja azon hozzávalókat, melyeket el szeretne helyezni a pizzán. Ennek hatására
// a kért hozzávalók, futási időben, fel is kell kerüljenek az éppen betöltött pizzára és természetesen módosul ilyenkor
// a pizza receptje és ára is. A felhasználó ugyanakkor le is vehet egy már felhelyezett hozzávalót, amennyiben egy
// checkbox-ról leveszi a jelölést.
//A mentést és betöltést menük segítségével oldjuk meg. A felhasználó kérheti az éppen megjelenített pizza "receptjének",
// azaz a hozzávalóknak az elmentését, illetve betöltését is. A betöltött hozzávalók alapján jelenítsük is meg az új pizzát,
// valamint jelöljük ki a megfelelő hozzávalók checkbox-ait is.
//
//Segítség:Menük megvalósítása swing-ben JMenuBar, JMenu, JMenuItem komponensek segítségével lehetséges.
//
//A cél- és forrásállományok kiválasztásában JFileChooser komponensek szolgáltatnak segítséget.
public class PizzaFrame extends JFrame {
    /*regi
    private PizzaPanel panel;
    public PizzaFrame(){
        setBounds(100, 100, 500, 500);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        Pizza p = new Mushroom( new Olive(new Corn(new Tomato(new Salami(new PizzaBase())))));
        panel = new PizzaPanel(p);
        this.add(panel);
        setVisible(true);
        System.out.println(panel.getP().getprice()+" lej");
        System.out.println(panel.getP().getingredients());}*/
    private PizzaPanel pizzapanel;
    private CheckBoxPanel checkboxpanel;
    private JCheckBox corn, mushroom, olive, salami, tomato;
    private JMenu menu;
    private JMenuBar menuBar;
    private JMenuItem save, load;
    private JLabel price, ingredients;
    public void createPizza() {
        Pizza p = new PizzaBase();
        if (salami.isSelected()) {
            p = new Salami(p);
        }
        if (tomato.isSelected()) {
            p = new Tomato(p);
        }
        if (olive.isSelected()) {
            p = new Olive(p);
        }
        if (mushroom.isSelected()) {
            p = new Mushroom(p);
        }
        if (corn.isSelected()) {
            p = new Corn(p);
        }
        this.pizzapanel.setP(p);
        pizzapanel.repaint();
        price.setText(Integer.toString(pizzapanel.getP().getprice()));
        ingredients.setText(pizzapanel.getP().getingredients());
    }
    public PizzaFrame() {
        setBounds(100, 100, 500, 550);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        corn = new JCheckBox("Corn");
        corn.addActionListener(e -> createPizza());
        mushroom = new JCheckBox("Mushroom");
        mushroom.addActionListener(e -> createPizza());
        olive = new JCheckBox("Olive");
        olive.addActionListener(e -> createPizza());
        salami = new JCheckBox("Salami");
        salami.addActionListener(e -> createPizza());
        tomato = new JCheckBox("Tomato");
        tomato.addActionListener(e -> createPizza());
        checkboxpanel = new CheckBoxPanel(corn, mushroom, olive, salami, tomato);
        pizzapanel = new PizzaPanel(new PizzaBase());
        JPanel textboxPanel = new JPanel();
        textboxPanel.setLayout(new GridLayout());
        price = new JLabel();
        ingredients = new JLabel();
        textboxPanel.add(price);
        textboxPanel.add(ingredients);
        this.setLayout(new BorderLayout());
        this.add(pizzapanel, BorderLayout.CENTER);
        this.add(checkboxpanel, BorderLayout.SOUTH);
        this.add(textboxPanel, BorderLayout.NORTH);

        menu = new JMenu("Menu");
        menuBar = new JMenuBar();
        save = new JMenuItem("Mentes");
        load = new JMenuItem("Betoltes");
        save.addActionListener(l -> {
            JFileChooser file = new JFileChooser();
            if (file.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
                File f = file.getSelectedFile();
                try {
                    BufferedWriter bw = new BufferedWriter(new FileWriter(f));
                    bw.write(ingredients.getText());
                    bw.close();
                } catch (IOException e) {
                    System.out.println("Hiba a mentesnel");
                }
            }
        });
        load.addActionListener(l -> {
            corn.setSelected(false);
            mushroom.setSelected(false);
            olive.setSelected(false);
            salami.setSelected(false);
            tomato.setSelected(false);
            JFileChooser file = new JFileChooser();
            if (file.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
                File f = file.getSelectedFile();
                try {
                    BufferedReader br = new BufferedReader(new FileReader(f));

                    if (br.ready()) {
                        String s = br.readLine();
                        String[] ing = s.split(",");
                        for (String ingredient : ing) {
                            switch (ingredient.trim()) {
                                case "Tomato":
                                    tomato.setSelected(true);
                                    break;
                                case "Salami":
                                    salami.setSelected(true);
                                    break;
                                case "Corn":
                                    corn.setSelected(true);
                                    break;
                                case "Olive":
                                    olive.setSelected(true);
                                    break;
                                case "Mushroom":
                                    mushroom.setSelected(true);
                                    break;
                                default:
                                    break;
                            }
                        }
                        createPizza();
                    }

                } catch (IOException ex) {
                    ex.printStackTrace();
                    System.out.println("Hiba a pizza betoltesenel");
                }
            }
        });
        menu.add(save);
        menu.add(load);
        menuBar.add(menu);
        this.setJMenuBar(menuBar);
        setVisible(true);
    }
    public static void main(String[] args){
        new PizzaFrame();
    }
}
