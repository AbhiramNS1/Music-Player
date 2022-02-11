import javax.swing.*;
import javax.swing.BorderFactory;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.*;



public class TitleBar {
    JPanel titleBar,iconPanel;
    JFrame frame;


    public TitleBar(JFrame frame){

        this.frame =frame;

       
        titleBar = new JPanel();
        titleBar.setBackground(Color.decode("#00ff00"));
        titleBar.setBounds(0,0,frame.getWidth(),30);
        FlowLayout layout = new FlowLayout();
        titleBar.setLayout(layout);

        Drag drag = new Drag(frame);
        titleBar.addMouseListener(drag);
        titleBar.addMouseMotionListener(drag);

        frame.add(titleBar,BorderLayout.NORTH);

    }

    
    public void addExitButton(){

        JPanel exit=new JPanel();
        exit.setToolTipText("Exit");
        exit.setPreferredSize(new Dimension(50,25));
            exit.addMouseListener(
                new MouseListener(){
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        frame.dispatchEvent(
                            new WindowEvent(frame,WindowEvent.WINDOW_CLOSING)
                        );   
                    }
                    @Override
                    public void mousePressed(MouseEvent e) {}
                    @Override
                    public void mouseReleased(MouseEvent e) {}
                    @Override
                    public void mouseEntered(MouseEvent e) {

                    exit.setBackground(Color.decode("#FF0000"));

                    }
                    @Override
                    public void mouseExited(MouseEvent e) {

                        exit.setBackground(Color.decode("#ffffff"));
                        
                    }
                    
                }
            );
        titleBar.add(exit);

    }

    public void setExtras(){
       
        JPanel minimise=new JPanel();
        minimise.setPreferredSize(new Dimension(50,25));
       
        JPanel maximise=new JPanel();
        maximise.setPreferredSize(new Dimension(50,25));
        titleBar.add(maximise);
        titleBar.add(minimise);
        
       

        iconPanel=new JPanel();
        iconPanel.setPreferredSize(new Dimension(titleBar.getWidth()-330,30));
        iconPanel.setBackground(Color.decode("#00ff00"));
        titleBar.add(iconPanel,FlowLayout.LEFT);

       
    }
    
    public void setIcon(String path){
            JLabel iconlLabel=new JLabel(new ImageIcon(path));
            iconlLabel.setBorder(BorderFactory.createEmptyBorder(0,0,0,100));
            titleBar.add(iconlLabel,FlowLayout.LEFT);
    }
    public void setTitle(String title){
        iconPanel.add(new JLabel(title));
        
    }
  
}
