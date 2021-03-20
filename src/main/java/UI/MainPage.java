package UI;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.swing.*;

import Backend.Randomizer;

public class MainPage extends JFrame {

    List<Randomizer> savedRandomizers = new ArrayList<>();

    public MainPage(){
        this.setTitle("Randomizer");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(600,600);
        this.setLayout(new FlowLayout(FlowLayout.CENTER,10,10));

        //change to icon of the frame
        //ImageIcon imageIcon = new ImageIcon("")
        //this.setIconImage(image.getImage());

        List<String> buttons = new ArrayList<>();
        buttons.add("apex");
        buttons.add("league adc");
        buttons.add("witcher 3");
        buttons.add("pokemon");

        this.getContentPane().setBackground(Color.WHITE);

        this.add(MainPageComponents.label("test"));

        buttons.forEach( button -> {
            this.add(MainPageComponents.button(button));
        });

        this.setVisible(true);
    }

    /*
    private JPanel savedRandomizers(){

    }

    private JPanel mainPageHeader(){

    }

    private JPanel randomizer(String randomizerID){

    }
    */
}
