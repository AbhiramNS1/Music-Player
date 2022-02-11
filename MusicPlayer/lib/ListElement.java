import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.io.File;
import java.awt.Graphics;
import java.util.Vector;
import java.awt.Dimension;
import java.awt.FlowLayout;


public class ListElement extends JPanel{

    JLabel songLabel;
    Vector<String>allsongs;
    static int i=0;

    ListElement(Vector <String>allsongs){
        System.out.print("ListElement");
        this.allsongs=allsongs;
        songLabel=new JLabel();
        add(songLabel);
        setLayout(new FlowLayout(FlowLayout.LEFT));
        setPreferredSize(new Dimension(500,30));
    }

    @Override
    public void paintComponent(Graphics g){
        g.setColor(super.getBackground());
        g.fillRect(0, 5,getWidth(), getHeight()-5);
    }
    void settext(String path){
        songLabel.setIcon(new ImageIcon("res/guitar_mini.png"));
        songLabel.setText(new File(path).getName());

    }






    
}
