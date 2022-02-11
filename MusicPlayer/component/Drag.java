import javax.swing.JFrame;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;


public class Drag implements MouseListener,MouseMotionListener{

    JFrame frame;
    int initialx=0,initialy=0;

    public Drag(JFrame frame){
        this.frame=frame;
    }


    @Override
    public void mouseDragged(MouseEvent e) {
       frame.setLocation((int)frame.getLocation().getX()+e.getX()+initialx,(int)frame.getLocation().getY()+e.getY()+initialy);

    }


    @Override
    public void mousePressed(MouseEvent e) {
       initialx=-e.getX();
       initialy=-e.getY(); 
    }

    
    @Override
    public void mouseMoved(MouseEvent e) {}
    @Override
    public void mouseClicked(MouseEvent e) {}
    @Override
    public void mouseReleased(MouseEvent e) {}
    @Override
    public void mouseEntered(MouseEvent e) {}
    @Override
    public void mouseExited(MouseEvent e) {}

}
