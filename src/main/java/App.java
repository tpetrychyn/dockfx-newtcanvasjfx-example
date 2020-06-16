import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class App extends Application {

    public void start(Stage primaryStage) {
        primaryStage.setTitle("DockFX w/ NewtCanvasJFX Bug");

        Group g = new Group();
        new Canvas().setup(g);

        VBox b = new VBox(g, new TextField());
        primaryStage.setScene(new Scene(b, 800, 500));
        primaryStage.sizeToScene();
        primaryStage.show();
    }
}
