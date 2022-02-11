import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


interface OnClickListener{
    public void onClick(MouseEvent e);
}

public class SidePanelButton extends JPanel implements MouseListener{

    private OnClickListener listener;

    
    SidePanelButton(String imagepath){
        JLabel image = new JLabel(new ImageIcon(imagepath));
        add(image);
        setBackground(new Color(0,0,0,255));
        addMouseListener(this);
    }
    
    public void setOnClickListener(OnClickListener listener){
        this.listener =listener;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
       if(listener!=null)
        listener.onClick(e);
    }

    @Override
    public void mousePressed(MouseEvent e){}
    @Override
    public void mouseReleased(MouseEvent e){}
    @Override
    public void mouseEntered(MouseEvent e){
        setBackground(new Color(255,255,255,100));}
    @Override
    public void mouseExited(MouseEvent e){setBackground(new Color(0,0,0,255));}

   
    
}
