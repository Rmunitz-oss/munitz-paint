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

/*
     public void initialize(){
        //erase.setSelected(false);
        colorPicker.setValue(Color.BLACK);
    }

 */

    /**
     * when user drags mouse
     * if erase selected, paintCanvas erase method called
     * if not, paintCanvas paint method called
     * @param mouseDragged MouseEvent
     */
    public void onMouseDragged(MouseEvent mouseDragged) {
        if (!erase.isSelected()) {
            paintCanvas.paint(mouseDragged, colorPicker);
        } else {
            paintCanvas.erase(mouseDragged);
        }
    }
}




