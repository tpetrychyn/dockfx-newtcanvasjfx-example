import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.dockfx.DockNode;
import org.dockfx.DockPane;
import org.dockfx.DockPos;

public class App extends Application {

    public void start(Stage primaryStage) {
        primaryStage.setTitle("DockFX w/ NewtCanvasJFX Bug");

        // create a dock pane that will manage our dock nodes and handle the layout
        DockPane dockPane = new DockPane();


        // Create and place the NewtCanvasJFX node
        Group g = new Group();
        new Canvas().setup(g);
        DockNode canvasDock = new DockNode(g, "Canvas Dock");
        canvasDock.setPrefSize(200, 200);
        canvasDock.dock(dockPane, DockPos.TOP);


        // Create a textfield node beneath the canvas
        DockNode textDock = new DockNode(new TextField(), "Textfield Dock");
        textDock.setPrefSize(300, 100);
        textDock.dock(dockPane, DockPos.BOTTOM, canvasDock);


        // create a textarea node to the right of the textfield node
        DockNode textAreaDock = new DockNode(new TextArea(), "Textarea Dock");
        textAreaDock.setPrefSize(300, 100);
        textAreaDock.dock(dockPane, DockPos.RIGHT, textDock);



        primaryStage.setScene(new Scene(dockPane, 800, 500));
        primaryStage.sizeToScene();
        primaryStage.show();
        Application.setUserAgentStylesheet(Application.STYLESHEET_MODENA);
        DockPane.initializeDefaultUserAgentStylesheet();
    }
}
