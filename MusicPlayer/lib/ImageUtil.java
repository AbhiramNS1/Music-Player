import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.awt.image.BufferedImage;
public class ImageUtil{


    public static Image minimisedImage(String path,int width,int height){
        Image img=null;
        try{
            BufferedImage image = ImageIO.read(new File(path));
            img=image.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        }
        catch(Exception e){
            System.out.println("Minimisation failed");
        }
        return img;
    }

}
