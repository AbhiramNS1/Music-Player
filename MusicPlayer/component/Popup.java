
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
public class Popup extends JFrame{
    JLabel jl;
    JFrame parent;
    boolean alreadyCreated;
    Popup(JFrame parent,String message){
       jl = new JLabel(message);
       this.parent=parent;
    }

    int Show(){
        create();
        super.setVisible(true);
        
        return 0;
    }

    void create(){
        if(!alreadyCreated){
            alreadyCreated=true;
            JButton jb = new JButton("hellow");
            super.add(jb);
            super.setBounds(parent.getWidth()/2,parent.getHeight()/2,200,200);
            super.setAlwaysOnTop(true);
            super.setAutoRequestFocus(true);
            



        }
    }


   

    

    

    
}
