import javafx.scene.media.*;
import java.io.File;

public class Music {
    MediaPlayer mediaPlayer;
    boolean isPlaying;

    Music(){
        com.sun.javafx.application.PlatformImpl.startup(()->{});
    }



    public void config(String path){
        mediaPlayer = new MediaPlayer(new Media(new File(path).toURI().toString()));
    }

    public void Play(){
       if(mediaPlayer!=null && !isPlaying){
           mediaPlayer.play();
           isPlaying=true;
       }
       else{
           System.out.println("Player is not working");
       }
    }

    public void pause(){
        if(mediaPlayer!=null && isPlaying){
            mediaPlayer.pause();
            isPlaying=false;
        }
    }
    public void stop(){
        if(mediaPlayer!=null){
            mediaPlayer.stop();
            mediaPlayer.dispose();
            mediaPlayer=null;
            isPlaying=false;
        }
    }
    
}
