import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.FlowLayout;




public class SidePanel extends JPanel{

    /** Represent the state of the Side panel
        it can be either 
            1 => Normal
            2 => Expaned
                        */
    public static final int NORMAL=60;
    public static final int EXPANEDED=300;
    public static final int INVISIBLE=0;
   
    private int State=NORMAL;  
    SidePanelButton listicon,PlayLists,settings,Recents,Nowplaying,search,Extend,newPlaylists,about;

    JPanel namePanel;
    SidePanel(){
        setBackground(new Color(0,0,0,255));
        ((FlowLayout)getLayout()).setVgap(0);
        namePanel=new JPanel();
        namePanel.add(new JLabel(new ImageIcon("res/main_mini.png")));
        namePanel.add(new JLabel("Music Player"));
        namePanel.setPreferredSize(new Dimension(0,0));
        namePanel.setVisible(false);
        setPreferredSize(new Dimension(NORMAL,MusicPlayer.mainFrame.getHeight()));
        sidePanelGUI(); 
        System.out.println(getLayout() instanceof FlowLayout);
        
    }
    int getState(){
        return State;
    }

    void setState(int State){
        if(this.State==State) return;
        if(State==EXPANEDED || State==NORMAL || State==INVISIBLE){
            TransformTo(State);
            this.State=State;
        }  
    }

    private void TransformTo(int State){
        int step=this.State<State?1:-1;
        float Factor=140.0f/(State-this.State);
        if(State==EXPANEDED)
            namePanel.setVisible(true);
        new Thread(){
            public void run(){
                float height =namePanel.getHeight();
                for(int i=getWidth();step>0?i<State:i>State;i+=step){
                        setPreferredSize(new Dimension(i,MusicPlayer.sidePanel.getHeight()));
                        namePanel.setPreferredSize(new Dimension(300,(int)(height+Factor)));
                        height+=Factor;
                        revalidate();
                        try{Thread.sleep(1);}catch (Exception e){}  //laging
                    
                }
                setVisible(State!=INVISIBLE);
                if(State!=EXPANEDED) namePanel.setVisible(false);
            }
    
        }.start();

            
    }

    void sidePanelGUI(){


        listicon = new SidePanelButton("res/musical-notes_mini.png");
        PlayLists = new SidePanelButton("res/musical-notes_mini.png");
        settings = new SidePanelButton("res/musical-notes_mini.png");
        Recents = new SidePanelButton("res/musical-notes_mini.png");
        Nowplaying = new SidePanelButton("res/musical-notes_mini.png");
        search = new SidePanelButton("res/musical-notes_mini.png");
        Extend = new SidePanelButton("res/musical-notes_mini.png");
        newPlaylists = new SidePanelButton("res/musical-notes_mini.png");
        about= new SidePanelButton("res/musical-notes_mini.png");







        add(namePanel);
        add(listicon);
        add(PlayLists);
        add(settings);
        add(Recents);
        add(Nowplaying);
        add(search);
        add(Extend);
        add(newPlaylists);

        Dimension  dimension= new Dimension(300,40);
        
        listicon.setPreferredSize(dimension);
        PlayLists.setPreferredSize(dimension);
        settings.setPreferredSize(dimension);
        Recents.setPreferredSize(dimension);
        Nowplaying.setPreferredSize(dimension);
        search.setPreferredSize(dimension);
        Extend.setPreferredSize(dimension);
        newPlaylists.setPreferredSize(dimension);
       
    listicon.setOnClickListener(
            new OnClickListener() {
                @Override
                public void onClick(MouseEvent e) {
                    if(State==NORMAL)
                        setState(EXPANEDED);
                        
                    else setState(NORMAL);   
                }
                
            }
        );


    PlayLists.setOnClickListener(
        new OnClickListener(){

            @Override
            public void onClick(MouseEvent e) {
         
            }
            
        }
    );
    }

}
