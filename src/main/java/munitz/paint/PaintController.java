package munitz.paint;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;

public class PaintController {
    @FXML
    PaintCanvas paintCanvas;
    @FXML
    ColorPicker colorPicker;
    @FXML
    ToggleButton erase;
    @FXML
    TextField brushSize;

    //private boolean erase = false;
    private int size = 10;
   // private boolean erase;
    //int size;

    //Attempt Dependency Injection
   // public PaintController(int size){
      //  this.erase = false;
      //  this.size= 10;
        //}

    public void onMouseDragged(MouseEvent mouseDragged){
        if(!erase.isSelected()){
            paintCanvas.paint(mouseDragged,colorPicker,size);
        }
        else{
            paintCanvas.erase(mouseDragged,size);
        }
    }

    public void onBrushSizeChanged(MouseEvent event){
        try{
            size = Integer.parseInt(brushSize.getText());
        }
        catch (Exception e){
            size=10;

        }

    }
}

