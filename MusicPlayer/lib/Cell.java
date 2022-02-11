import java.awt.Color;
import java.awt.Component;
import java.util.Vector;

import javax.swing.JList;
import javax.swing.ListCellRenderer;


public class Cell extends ListElement implements ListCellRenderer<Object>{
   
    Cell(Vector<String> allsongs){
        super(allsongs);
        setOpaque(true);
     
    }
    @Override
    public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected,
            boolean cellHasFocus) {
                    settext((String)value);
                    if(isSelected) setBackground(Color.MAGENTA);
                    else setBackground(Color.GREEN);
                   
                   
                    

                
        return  this;
    }



    
}
