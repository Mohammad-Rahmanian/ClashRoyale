import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

/**
 * The type Main.
 */
public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("View/login.fxml"));
        Image icon = new Image(getClass().getResourceAsStream("/photos/icon.jpg"));
        primaryStage.getIcons().add(icon);
        primaryStage.setTitle("Clash Royale");
        primaryStage.setResizable(false);
        primaryStage.setScene(new Scene(root, 800, 460));
        primaryStage.show();
    }

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}
