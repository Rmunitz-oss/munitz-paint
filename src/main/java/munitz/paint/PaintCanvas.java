package munitz.paint;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ColorPicker;
import javafx.scene.input.MouseEvent;

public class PaintCanvas extends Canvas {
    double x;
    double y;
    int size = 10;
    GraphicsContext graphicsContext;

    /**
     * paints canvas according to mouse dragged
     * and color picked by user
     *
     * @param mouseDragged MouseEvent
     * @param colorPicker ColorPicker
     */
    public void paint (MouseEvent mouseDragged, ColorPicker colorPicker) {
        graphicsContext = getGraphicsContext2D();
        x = mouseDragged.getX();
        y = mouseDragged.getY();
        graphicsContext.setFill(colorPicker.getValue());
        graphicsContext.fillOval(x, y, size,size);

    }

    /**
     * erases cnavas according to mouse dragged
     * @param mouseDragged
     */
    public void erase(MouseEvent mouseDragged) {
        x = mouseDragged.getX();
        y = mouseDragged.getY();
        try {
            graphicsContext.clearRect(x,y,size+3,size+3);
        }
        catch (NullPointerException e){

        }

    }
}

