import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;



public class Button extends JPanel implements MouseListener{

    interface OnClickListener{
        public void onClick(MouseEvent e);
    }
    private OnClickListener clickListener;
    JPanel Parent;
    JLabel imgLabel;
    String small,large;
    Button(String small,String large,JPanel parent,int size)  {
        this.small=small;
        this.large=large;
        this.Parent=parent;
        imgLabel=new JLabel(new ImageIcon(small));
        add(imgLabel);
        setBackground(new Color(0,0,0,255));
        addMouseListener(this);
        setPreferredSize(new Dimension(size,100));


    }

    void setIcon(String small,String large){
        this.small=small;
        this.large=large;
        mouseEntered(new MouseEvent(this, 500, 10, 0,3, 3,1,false));
    }
    

   

   
    public void setOnClickListener(OnClickListener clickListener) {
        this.clickListener = clickListener;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        // circular guard for button
       // if(Math.pow((30-e.getX()),2)+Math.pow((30-e.getY()), 2)<=Math.pow(24, 2))
           
            if(clickListener!=null) clickListener.onClick(e);
    }

    public void mousePressed(MouseEvent e) {}
    public void mouseReleased(MouseEvent e) {}

    @Override
    public void mouseEntered(MouseEvent e) {
        imgLabel.setIcon(new ImageIcon(large));

    }

    @Override
    public void mouseExited(MouseEvent e) {
        imgLabel.setIcon(new ImageIcon(small));
    }
    
}
