package munitz.paint;

import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.mockito.Mockito.*;

public class PaintControllerTest {
    boolean erase;
    int size = 10;
    @BeforeClass
    public static void beforeClass() {
        com.sun.javafx.application.PlatformImpl.startup(()->{});
    }
    /**
    @Test
    public void onMouseDragged (){
        //given

        //boolean erase = mock(boolean.class);
        //int size = mock(int.class);
        int size = 10;
        boolean erase = false;
        //MouseEvent event = mock(MouseEvent.class);

        PaintController controller = new PaintController(erase,size);

        controller.paintCanvas = mock(PaintCanvas.class);

        //controller.colorPicker=mock(ColorPicker.class);
        doReturn("White").when(controller.colorPicker).getValue();

        controller.paint=mock(Button.class);

        controller.eraser= mock(Button.class);

        controller.brushSize= mock(TextField.class);
        doReturn("10").when(controller.brushSize).getText();


        //when
        controller.onMouseDragged(mock(MouseEvent.class));

        //verify
        verify(controller.paintCanvas).paint(any(MouseEvent.class,ColorPicker.class,size));


    }
     */
    @Test
    public void onMouseDragged(){
        //given
        PaintController controller = new PaintController(size);
        controller.paintCanvas = mock(PaintCanvas.class);
        controller.brushSize = mock(TextField.class);
        doReturn("10").when(controller.brushSize).getText();
        MouseEvent event = mock(MouseEvent.class);
        ColorPicker color = mock(ColorPicker.class);
        int size = Integer.parseInt(controller.brushSize.getText());

        //when
        controller.onMouseDragged(null);

        //then
        verify(controller.paintCanvas).paint(any(MouseEvent.class));



    }
    @Test
    public void onBrushSizeChanged(){

        //given
        PaintController controller = new PaintController(size);
        controller.paintCanvas = mock(PaintCanvas.class);
        controller.brushSize = mock(TextField.class);
        //controller.size = mock(Integer.class);
        doReturn("20").when(controller.brushSize).getText();



        //when
        controller.onBrushSizeChanged((mock(MouseEvent.class)));

        //then
        verify(controller.size
    }
}
