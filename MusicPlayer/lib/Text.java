import javax.swing.JComponent;
import javax.swing.*;
import javax.accessibility.Accessible;
import java.awt.event.*;
import java.util.EventListener;
import java.awt.*;


public class Text extends JComponent implements MouseMotionListener{
    JLabel l;
    private final String text ="Hello world";

    Text(){
        super.setBounds(0,0,200,200);
        addMouseMotionListener(this);
    }


    public void paintComponent(Graphics g){
        T.out(getWidth()+" "+getHeight());
        g.setClip(0, 0,200, 200);
        g.fillRect(0, 0, 200, 200);
         T.out(g.getClip());
         g.setColor(Color.CYAN);
        g.setFont(new Font("Serif",Font.BOLD,15));
        g.drawString("Hello world",100,100);
        
    

    }


    @Override
    public void mouseDragged(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }


    @Override
    public void mouseMoved(MouseEvent e) {
       T.out("moved");
        
    }

    

    
}
