import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;
/*
<applet code="JListDemo" width=200 height=120>
</applet>
*/
public class JListDemo extends JApplet {
    JList jlst;
    JLabel jlab;
    JScrollPane jscrlp;
    String Cities[] = { "New York", "Chicago", "Houston",
    "Denver", "Los Angeles", "Seattle",
    "London", "Paris", "New Delhi",
    "Hong Kong", "Tokyo", "Sydney" };
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
        jlst = new JList(Cities);
        jlst.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        jscrlp = new JScrollPane(jlst);
        jscrlp.setPreferredSize(new Dimension(120, 90));
        jlab = new JLabel("Choose a City");
        jlst.addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent le) {
                int idx = jlst.getSelectedIndex();
                if(idx != -1)
                    jlab.setText("Current selection: " + Cities[idx]);
                else
                    jlab.setText("Choose a City");
            }
        });
        add(jscrlp);
        add(jlab);
    }
}
