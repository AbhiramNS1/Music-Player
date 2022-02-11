
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import java.awt.event.MouseEvent;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.geom.RoundRectangle2D;
import java.awt.*;


public class MusicPlayer{
    
    static JFrame mainFrame;
    static JPanel MainWindow;
    static TitleBar titleBar;
    static MusicCollector musicCollector;
    static JScrollPane listholder;
    static Music music;
    static String MODE="NORMAL";
    static SidePanel sidePanel;
    static MusicPanel musicPanel;

    public static void main(String args[]){
       
        initGUI();
        
      //  initMusic();
      
        


       
    
    
      

     
           
        
        mainFrame.setVisible(true);
    }


    static void initGUI(){
        //mainframe initialisation
        mainFrame=new JFrame();
        mainFrame.setMinimumSize(new Dimension(380,500));
        sidePanel= new SidePanel();
        MainWindow = new JPanel();
        musicPanel=new MusicPanel();



        Dimension d=Toolkit.getDefaultToolkit().getScreenSize();
        int width =(int)(d.getWidth()*0.85);
        int height=(int)(d.getHeight()*0.85);
        int x =(int)(d.getWidth()*0.072);
        int y=(int)(d.getHeight()*0.125);
        
        mainFrame.setBounds(x,y,width,height);

        //titlebar init
        if(MODE=="NORMAL"){
            mainFrame.getContentPane().setBackground(Color.decode("#313033"));
            mainFrame.setTitle("Music Player");
            mainFrame.setIconImage(new ImageIcon("res/main.png").getImage());
        }
        else{
            mainFrame.setUndecorated(true);
            Shape round =new RoundRectangle2D.Double(0,0,width,height,50,50);
            mainFrame.setShape(round);
            titleBar = new TitleBar(mainFrame);
            titleBar.addExitButton();
            titleBar.setExtras();
            titleBar.setIcon("res/main_mini1.png");
            titleBar.setTitle("Music Player");
        }

        mainFrame.add(sidePanel,BorderLayout.WEST);
        mainFrame.add(MainWindow,BorderLayout.CENTER);
        mainFrame.add(musicPanel,BorderLayout.SOUTH);

        MainWindow.setBackground(Color.decode("#ff00f0"));
        
    
        

 

       
        setExitButtonFunction();
    }

    static void setExitButtonFunction(){
        mainFrame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        mainFrame.addWindowListener(
            new WindowListener(){
                @Override
                public void windowClosing(WindowEvent e) {
                    //  if(JOptionPane.showConfirmDialog(mainFrame, "Do you want to exit ?")==0)
                        System.exit(0);
                }
                public void windowClosed(WindowEvent e){}
                public void windowIconified(WindowEvent e){}
                public void windowDeiconified(WindowEvent e){}
                public void windowActivated(WindowEvent e){}
                public void windowDeactivated(WindowEvent e){}
                public void windowOpened(WindowEvent e){}
            }
        );
    }

    static void initMusic(){


        musicCollector = new MusicCollector();
        musicCollector.collect("C:\\Users\\s\\Desktop\\folder");
        music = new Music();
        JList<String>list = new JList<String>(musicCollector.ALLSONGS);
        list.setCellRenderer(new Cell(musicCollector.ALLSONGS));

 /*
        JScrollPane listScrollPane = new JScrollPane();

        listScrollPane.setViewportView(list);
        list.setLayoutOrientation(JList.VERTICAL);
      
    list.addListSelectionListener(
            new ListSelectionListener() {

                @Override
                public void valueChanged(ListSelectionEvent e) {
                   if(!e.getValueIsAdjusting()){
                    //    if(music.isPlaying) music.stop();
                    //   music.config(list.getSelectedValue());
                    //   music.Play();
                   }
                  
                    
                }
                
            }
        );
       
       
        list.setVisibleRowCount((int)((mainFrame.getHeight()-40)/30));
        list.setLayoutOrientation(JList.VERTICAL);

        listSection.add(listScrollPane);


                */
        
       
    }

  static  void out(Object o){
        System.out.println(o);
    }

}










