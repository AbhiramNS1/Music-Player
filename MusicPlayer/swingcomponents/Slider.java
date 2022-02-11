package swingcomponents;
import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.Component;


public class Slider extends JPanel implements MouseMotionListener,MouseListener{
    
    //progress ranges from 0 to 100
    public interface ProgressChangeListener{
        public void onProgressChanged(int progress);
    }

    private int Progress=40;
    private boolean pressed;
    private ProgressChangeListener listener;


    private Color KnobHighLightColor =Color.CYAN;
    private Color KnobColor =Color.BLUE;
    private Color fillColor =Color.BLUE;
    private Color fillDimColor=new Color(0,0,0,200);
    private Font font=new Font("Serif",Font.BOLD,15);

    private int length=200;
    private int width=44;
    private int KnobDiameter=20;
    private double horizontalPadding=0.07;
    private int verticalPadding=20;
    private int fillerWidth=4;
    private String startLabel="00:00";
    private String endLabel="00:00";
    private Component parent;

    

    
    public Slider(Component parent){

        setLayout(new BorderLayout());
        this.parent=parent;
        addMouseListener(this);
        addMouseMotionListener(this);
        setPreferredSize(new Dimension(parent.getWidth()==0?length:parent.getWidth(),width));       
        if(parent.getBackground()!=null){

            if(parent.getBackground().getRed()+parent.getBackground().getGreen()+parent.getBackground().getBlue()<255){
                fillDimColor=new Color(255,255,255,200);
            }
            
        }
        else{
            setBackground(Color.BLACK);
        }

        
    }

   
    


//Progress Related 
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




//UI related
    public void setKnobColor(Color knobColor){
        this.KnobColor=knobColor;
        parent.repaint();
    }
    public void setKnobHighLightColor(){
        this.KnobHighLightColor=KnobColor;
        parent.repaint();
    }
    public void setFillColor(Color filColor){
        this.fillColor=filColor;
        parent.repaint();
    }
    public void setDimColor(Color dimColor){
        fillDimColor=dimColor;
        parent.repaint();
    }

    public void setStartLabel(String label){
        startLabel=label;
        parent.repaint();
    }
    public void setEndLabel(String label){
        endLabel=label;
        parent.repaint();
    }

    

    public void setPaddingPercentage(int horizontal){
        if(horizontal>=0 &&horizontal <=100){
           horizontalPadding=horizontal/100;
        }
         parent.repaint();
    }
    


    @Override
    public void paintComponent(Graphics g){

        super.paintComponent(g);
       
        int width=(int)(getWidth()*(1-horizontalPadding*2));
        
        g.setColor(fillDimColor);
        g.fillRect((int)(getWidth()*horizontalPadding),verticalPadding,width,fillerWidth);
        g.setColor(fillColor);
        g.fillRect((int)(getWidth()*horizontalPadding),verticalPadding,(int)(((float)width)*(((float)Progress)/100)),fillerWidth);
        if(pressed) g.setColor(KnobHighLightColor);
        else g.setColor(KnobColor);
        g.fillOval((int)(getWidth()*horizontalPadding)+(int)(((float)width)*(((float)Progress)/100))-KnobDiameter/2,verticalPadding/2,KnobDiameter, KnobDiameter);
        g.setFont(font);
        g.setColor(Color.BLACK);
        g.drawString(startLabel,(int)(getWidth()*horizontalPadding-startLabel.length()*4),verticalPadding+KnobDiameter);
        g.drawString(endLabel,(int)(getWidth()*horizontalPadding-endLabel.length()*4)+width,verticalPadding+KnobDiameter);
    
    }



 // EVENT related
    @Override
    public void mouseDragged(MouseEvent e) {
        if(pressed){
            setProgress((int)(((e.getX()-(getWidth()*horizontalPadding))/((getWidth()*(1-horizontalPadding*2))))*100));
        }
    }

   
    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getY()<verticalPadding+KnobDiameter/2 && e.getY()>verticalPadding-KnobDiameter/2 && (getWidth()*horizontalPadding)<e.getX() && ((getWidth()*(1-horizontalPadding)))>=e.getX()){
            setProgress((int)(((e.getX()-(getWidth()*horizontalPadding))/((getWidth()*(1-horizontalPadding*2))))*100));
           
        }
        
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if(e.getY()<verticalPadding+KnobDiameter/2 && e.getY()>verticalPadding-KnobDiameter/2 && (getWidth()*horizontalPadding-KnobDiameter/2)<e.getX() && ((getWidth()*(1-horizontalPadding))+KnobDiameter/2)>=e.getX()){
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

