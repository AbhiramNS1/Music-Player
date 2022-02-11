import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Dimension;



public class MyMusicScreen extends JPanel{
   
    MyMusicScreen(){
        setPreferredSize(new Dimension(400,400));
        setBackground(Color.RED);
        
    }
   
    public void validate(){
        System.out.println(MusicPlayer.mainFrame.getWidth()
    );
    System.out.println(MusicPlayer.mainFrame.getHeight()
    );
        super.validate();
    }
   


}
