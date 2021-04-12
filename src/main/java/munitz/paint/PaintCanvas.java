package munitz.paint;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ColorPicker;
import javafx.scene.input.MouseEvent;


public class PaintCanvas extends Canvas {
    double x;
    double y;
    GraphicsContext graphicsContext;
    public void paint (MouseEvent mouseDragged, ColorPicker colorPicker, int size) {
        graphicsContext = getGraphicsContext2D();
        x = mouseDragged.getX();
        y = mouseDragged.getY();
        graphicsContext.setFill(colorPicker.getValue());
        graphicsContext.fillOval(x, y, size,size);

    }

    public void erase(MouseEvent mouseDragged,int size) {
        x = mouseDragged.getX();
        y = mouseDragged.getY();
        try {
            graphicsContext.clearRect(x,y,size,size);
        }
        catch (NullPointerException e){

        }

    }
}

