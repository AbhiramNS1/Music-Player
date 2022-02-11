import java.io.File;
import java.util.Vector;

public class MusicCollector {

    int totalSongs;
    int wav;
    Vector<String> ALLSONGS=new Vector<String>();
    
     
    public  void collect(String folder){
    
        File files[]=new File(folder).listFiles();
        
        
        for(File i : files){

            if(i==null)continue;
            if(i.isDirectory()){
                collect(i.getPath());
            }
            else{
                if(i.getName().endsWith(".mp3")){
                    ALLSONGS.add(i.getPath());
                    totalSongs++;
                }
                else if(i.getName().endsWith(".wav")){
                        wav++;
                }
                 
                 
            }
        }
    }
    
}
