import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.Component;

interface ProgressChangeListener{
    public void onProgressChanged(int progress);
}


public class Slider extends JPanel implements MouseMotionListener,MouseListener{
    
    //progress ranges from 0 to 100
    private int Progress=40;
    private boolean pressed;
    private ProgressChangeListener listener;
    private Color KnobHighLightColor =Color.CYAN;
    private Color KnobColor =Color.BLUE;
    private double relativeSize=0.9;
    Component parent;
    Slider(Component parent){
        this.parent=parent;
        addMouseListener(this);
        addMouseMotionListener(this);  
    }
    

    public int getProgress() {
        return Progress;
    }
    public void setProgress(int progress) {
        if(progress<=100 && progress>=0){
             Progress = progress;
             parent.repaint();
             if(listener!=null) listener.onProgressChanged(progress);
        }
    }
    public void setProgressChangeListener(ProgressChangeListener listener){
            this.listener=listener;
    }

    public void setKnobColor(Color knobColor){
        this.KnobColor=knobColor;
        parent.repaint();
    }
    public void setKnobHighLightColor(){
        this.KnobHighLightColor=KnobColor;
        parent.repaint();
    }

    //length of seekbar relative to parent
    public void setPercentagelength(int percentage){
        if(percentage>=0 && percentage <=100){

        }
    }


    @Override
    public void paintComponent(Graphics g){
        
        int size=(int)(getWidth()*relativeSize);
        g.setColor(new Color(255,255,255,50));
        g.fillRect((int)(getWidth()*0.05),20,size,3);
        g.setColor(KnobColor);
        g.fillRect((int)(getWidth()*0.05),20,(int)(((float)size)*(((float)Progress)/100)),3);
       if(pressed) g.setColor(KnobHighLightColor);
        g.fillOval((int)(getWidth()*0.044)+(int)(((float)size)*(((float)Progress)/100)),10,20, 20);

     }
    @Override
    public void mouseDragged(MouseEvent e) {
        if(pressed){
            setProgress((int)(((e.getX()-(getWidth()*0.05))/(getWidth()*0.9))*100));
        }   
    }

   
    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getY()<27 && e.getY()>12 && (getWidth()*0.05)<e.getX() && ((getWidth()*0.05)+(getWidth()*0.9)+1)>=e.getX()){
            setProgress((int)(((e.getX()-(getWidth()*0.05))/(getWidth()*0.9))*100));
           
        }
        
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if(e.getY()<27 && e.getY()>12 && (getWidth()*0.05)<e.getX() && ((getWidth()*0.05)+(getWidth()*0.9)+1)>=e.getX()){
            pressed=true;
        }
        
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        pressed=false;
        parent.repaint();
    }
    public void mouseEntered(MouseEvent e) {}
    public void mouseExited(MouseEvent e) {}
    public void mouseMoved(MouseEvent e) {}

}

