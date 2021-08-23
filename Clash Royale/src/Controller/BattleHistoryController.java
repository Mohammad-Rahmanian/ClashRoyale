package Controller;

import Model.Battle;
import Model.PlayerProfile;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * The type Battle history controller.
 *
 * @author Mohammad Rahmanian - Mahmood Saneian.
 * @version 1.0
 */
public class BattleHistoryController {
    @FXML
    private ListView<Battle> battlesListView;

    private final ObservableList<Battle> battles = FXCollections.observableArrayList();

    private PlayerProfile playerProfile;

    public void init() {
        battles.setAll(playerProfile.getBattles());
        battlesListView.setItems(battles);
    }

    public void setPlayerProfile(PlayerProfile playerProfile) {
        this.playerProfile = playerProfile;
    }

    @FXML
    void backToMenu(ActionEvent event) {
        Stage stage = (Stage) battlesListView.getScene().getWindow();
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../View/Menu.fxml"));
            Parent root = loader.load();
            MenuController menuController = loader.getController();
            menuController.setPlayerProfile(playerProfile);
            menuController.init();
            stage.setScene(new Scene(root));
            stage.setTitle("Clash Royale");
            stage.setResizable(false);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
