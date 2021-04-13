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
    private PaintController controller;
    private ColorPicker colorPicker;
    private MouseEvent mouseEvent;
    private ToggleButton erase;

    @BeforeClass
    public static void beforeClass() {
        com.sun.javafx.application.PlatformImpl.startup(()->{});
    }

    @Test
    public void onMouseDraggedPaint(){
        //given
        givenPaintController();
        erase.setSelected(false);
        doReturn(false).when(erase).isSelected();

        //when
        controller.onMouseDragged(mouseEvent);

        //then
        verify(paintCanvas).paint(mouseEvent,colorPicker);

    }
    @Test
    public void onMouseDraggedErase(){
        //given
        givenPaintController();
        erase.setSelected(true);
        doReturn(true).when(erase).isSelected();

        //when
        controller.onMouseDragged(mouseEvent);

        //then
        verify(paintCanvas).erase(mouseEvent);
    }

    private void givenPaintController(){
        controller = new PaintController();
        paintCanvas = mock(PaintCanvas.class);
        controller.paintCanvas = paintCanvas;
        colorPicker = mock(ColorPicker.class);
        controller.colorPicker = colorPicker;
        mouseEvent = mock(MouseEvent.class);
        erase = mock(ToggleButton.class);
        controller.erase = erase;
    }

}
