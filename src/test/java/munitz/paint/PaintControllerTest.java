package munitz.paint;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.ToggleButton;
import javafx.scene.input.MouseEvent;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.mockito.Mockito.*;

public class PaintControllerTest {
    private PaintCanvas paintCanvas;
    private GraphicsContext graphicsContext;
    private PaintController controller;
    private ColorPicker colorPicker;
    private MouseEvent mouseEvent;
    private ToggleButton erase;

    @BeforeClass
    public static void beforeClass() {

        com.sun.javafx.application.PlatformImpl.startup(()->{});
    }
    @Test
    public void onMouseDraggedDraw(){
        //given
        givenPaintController();

        //when
        controller.onMouseDragged(mouseEvent);
        doReturn(false).when(erase.isSelected());

        //then
        verify(paintCanvas).paint(mouseEvent,colorPicker);

    }
    @Test
    public void onMouseDraggedErase(){
        //given
        givenPaintController();
        //when
        controller.onMouseDragged(mouseEvent);
        doReturn(true).when(erase.isSelected());
        //then
        verify(paintCanvas).paint(mouseEvent,colorPicker);
    }
private void givenPaintController(){
        controller = new PaintController();
        paintCanvas = mock(PaintCanvas.class);
        colorPicker = mock(ColorPicker.class);
        graphicsContext = mock(GraphicsContext.class);
        mouseEvent = mock(MouseEvent.class);
        erase = mock(ToggleButton.class);
}

}
