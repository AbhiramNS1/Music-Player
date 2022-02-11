import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Color;
import swingcomponents.Slider;
import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;



public class MusicPanel extends JPanel implements ComponentListener{

    static boolean Playing;
    private JPanel LeftPanel;
    private JPanel rightPanel;
    public MusicPanel(){
        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(MusicPlayer.mainFrame.getWidth(),120));
        setBackground(Color.BLACK);
        Slider slider = new Slider(this);
        slider.setPreferredSize(new Dimension(MusicPlayer.mainFrame.getWidth(),40));
        addComponentListener(this);
        add(slider,BorderLayout.NORTH);

        Button button = new Button("res/play-button_mini.png","res/play-button_mini2.png",this,60);
        Button button2 = new Button("res/next-button_mini.png","res/next-button_mini2.png",this,60);
        Button button3= new Button("res/previous_mini2.png","res/previous_mini.png",this,55);
        JPanel bottomPanel = new JPanel(new FlowLayout());




        LeftPanel =new JPanel();
        LeftPanel.setPreferredSize(new Dimension(200,120));
        JLabel songImage = new JLabel(new ImageIcon("res/main_mini.png"));
        JLabel SongNameLabel =new JLabel("Somg Name GOes Here");
        SongNameLabel.setFont(new Font("Ariel",Font.BOLD,15));
        LeftPanel.add(songImage);
        LeftPanel.add(SongNameLabel);



        rightPanel = new JPanel();
        rightPanel.setPreferredSize(new Dimension(200,120));
        Slider volumeSlider = new Slider(this);
        volumeSlider.setPreferredSize(new Dimension(200,120));
        rightPanel.add(volumeSlider,BorderLayout.NORTH);
        JLabel volLabel = new JLabel("volume");
        JLabel more = new JLabel(new ImageIcon("res/main_mini1.png"));
        rightPanel.add(volLabel,BorderLayout.CENTER);
        rightPanel.add(more,BorderLayout.CENTER);

        


        bottomPanel.setPreferredSize(new Dimension(getWidth(),80));
        bottomPanel.add(button3);
        bottomPanel.add(button);
        bottomPanel.add(button2);
        bottomPanel.setBackground(new Color(200,0,0,100));

        add(LeftPanel,BorderLayout.WEST);
        add(bottomPanel,BorderLayout.CENTER);
        add(rightPanel,BorderLayout.EAST);

        volumeSlider.setProgressChangeListener(
          new Slider.ProgressChangeListener() {

            @Override
            public void onProgressChanged(int progress) {
              T.out(progress);
              
            }
            
          }
        );


        button.setOnClickListener(
          new Button.OnClickListener() {

            @Override
            public void onClick(MouseEvent e) {
              if(Playing){
                button.setIcon("res/play-button_mini.png","res/play-button_mini2.png");
                Playing=false;
                T.out(LeftPanel.getWidth());
              }  
              else{
                button.setIcon("res/pause-mini.png", "res/pause-mini2.png");
                Playing=true;
              }
               

              
            }
            
          }
        );

    }
    @Override
    public void componentResized(ComponentEvent e) {
       LeftPanel.setVisible(getWidth()>620);
       rightPanel.setVisible(getWidth()>620);
      
    }
    @Override
    public void componentMoved(ComponentEvent e){}
    @Override
    public void componentShown(ComponentEvent e){}
    @Override
    public void componentHidden(ComponentEvent e) {
      // TODO Auto-generated method stub
      
    }

  
    

    
}
