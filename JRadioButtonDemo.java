import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
/*
<applet code="JRadioButtonDemo" width=300 height=50>
</applet>
*/
public class JRadioButtonDemo extends JApplet implements ActionListener {
    JLabel jlab;
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
        JRadioButton b1 = new JRadioButton("A");
        b1.addActionListener(this);
        add(b1);
        JRadioButton b2 = new JRadioButton("B");
        b2.addActionListener(this);
        add(b2);
        JRadioButton b3 = new JRadioButton("C");
        b3.addActionListener(this);
        add(b3);
        ButtonGroup bg = new ButtonGroup();
        bg.add(b1);
        bg.add(b2);
        bg.add(b3);
        jlab = new JLabel("Select One");
        add(jlab);
    }
    public void actionPerformed(ActionEvent ae) {
        jlab.setText("You selected " + ae.getActionCommand());
    }
}
