import java.awt.*;
import java.awt.event.*;
import java.applet.*;
/*
<applet code="WindowEvents" width=300 height=50>
</applet>
*/

class SampleFrame extends Frame implements MouseListener, MouseMotionListener {
    String msg = "";
    int mouseX=10, mouseY=40;
    int movX=0, movY=0;
    SampleFrame(String title) {
        super(title);
        addMouseListener(this);
        addMouseMotionListener(this);
        MyWindowAdapter adapter = new MyWindowAdapter(this);
        addWindowListener(adapter);
    }
    public void mouseClicked(MouseEvent me) {
    }
    public void mouseEntered(MouseEvent evtObj) {
        mouseX = 10;
        mouseY = 54;
        msg = "Mouse just entered child.";
        repaint();
    }
    public void mouseExited(MouseEvent evtObj) {
        mouseX = 10;
        mouseY = 54;
        msg = "Mouse just left child window.";
        repaint();
    }
    public void mousePressed(MouseEvent me) {
        mouseX = me.getX();
        mouseY = me.getY();
        msg = "Down";
        repaint();
    }
    public void mouseReleased(MouseEvent me) {
        mouseX = me.getX();
        mouseY = me.getY();
        msg = "Up";
        repaint();
    }
    public void mouseDragged(MouseEvent me) {
        mouseX = me.getX();
        mouseY = me.getY();
        movX = me.getX();
        movY = me.getY();
        msg = "*";
        repaint();
    }
    public void mouseMoved(MouseEvent me) {
        movX = me.getX();
        movY = me.getY();
        repaint(0, 0, 100, 60);
    }
    public void paint(Graphics g) {
        g.drawString(msg, mouseX, mouseY);
        g.drawString("Mouse at " + movX + ", " + movY, 10, 40);
    }
}
class MyWindowAdapter extends WindowAdapter {
    SampleFrame sampleFrame;
    public MyWindowAdapter(SampleFrame sampleFrame) {
        this.sampleFrame = sampleFrame;
    }
    public void windowClosing(WindowEvent we) {
        sampleFrame.setVisible(false);
    }
}
public class WindowEvents extends Applet implements MouseListener, MouseMotionListener {
    SampleFrame f;
    String msg = "";
    int mouseX=0, mouseY=10;
    int movX=0, movY=0;
    public void init() {
        f = new SampleFrame("Handle Mouse Events");
        f.setSize(300, 200);
        f.setVisible(true);
        addMouseListener(this);
        addMouseMotionListener(this);
    }
    public void stop() {
        f.setVisible(false);
    }
    public void start() {
        f.setVisible(true);
    }
    public void mouseClicked(MouseEvent me) {
    }
    public void mouseEntered(MouseEvent me) {
        mouseX = 0;
        mouseY = 24;
        msg = "Mouse just entered applet window.";
        repaint();
    }
    public void mouseExited(MouseEvent me) {
        mouseX = 0;
        mouseY = 24;
        msg = "Mouse just left applet window.";
        repaint();
    }
    public void mousePressed(MouseEvent me) {
        mouseX = me.getX();
        mouseY = me.getY();
        msg = "Down";
        repaint();
    }
    public void mouseReleased(MouseEvent me) {
        mouseX = me.getX();
        mouseY = me.getY();
        msg = "Up";
        repaint();
    }
    public void mouseDragged(MouseEvent me) {
        mouseX = me.getX();
        mouseY = me.getY();
        movX = me.getX();
        movY = me.getY();
        msg = "*";
        repaint();
    }
    public void mouseMoved(MouseEvent me) {
        movX = me.getX();
        movY = me.getY();
        repaint(0, 0, 100, 20);
    }
    public void paint(Graphics g) {
        g.drawString(msg, mouseX, mouseY);
        g.drawString("Mouse at " + movX + ", " + movY, 0, 10);
    }
}

