import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
/*
<applet code="JToggleButtonDemo" width=200 height=80>
</applet>
*/
public class JToggleButtonDemo extends JApplet {
    JLabel jlab;
    JToggleButton jtbn;
    public void init() {
        try {
            SwingUtilities.invokeAndWait(
                new Runnable() {
                    public void run() {
                        makeGUI();
                    }
                }
            );
        } catch (Exception exc) {
            System.out.println("Can't create because of " + exc);
        }
    }
    private void makeGUI() {
        setLayout(new FlowLayout());
        jlab = new JLabel("Button is off.");
        jtbn = new JToggleButton("On/Off");
        jtbn.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent ie) {
                if(jtbn.isSelected())
                    jlab.setText("Button is on.");
                else
                    jlab.setText("Button is off.");
            }
        });
        add(jtbn);
        add(jlab);
    }
}
