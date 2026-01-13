package api.GUI.elements.appBar;

import api.GUI.styles.Padding;

import javax.swing.*;
import java.awt.*;

public class AppBar extends JPanel {

    private int parentWidht;
    private int appBarHeight;
    private Padding appBarPadding;


    public AppBar(int parentWidth, int thisHeight, Padding padding) {
        this.parentWidht =  parentWidth;
        this.appBarHeight = thisHeight;
        this.appBarPadding =  padding;
    }

    public void setUp(){
        this.setBackground(new Color(220, 220, 220));
        this.setBounds(0, 0, parentWidht, appBarHeight);
        this.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        this.setLayout(null);

        JLabel title = new JLabel("MatrixCalculator");
        JLabel appLogo =  new JLabel("♣");

        int appLogoWidht = appBarHeight - 2 * appBarPadding.X();
        int appBarChildHeight = appBarHeight - 2 * appBarPadding.X();

        appLogo.setBounds(appBarPadding.X(), appBarPadding.X(), appLogoWidht, appBarChildHeight);
        appLogo.setFont(new Font("Arial", Font.BOLD, 20));
        title.setBounds(
                appBarPadding.X() + appLogoWidht + 15,
                appBarPadding.X(),
                parentWidht - (appBarPadding.X() + appLogoWidht + 15),
                appBarChildHeight
        );

        this.add(title);
        this.add(appLogo);

    }

}
