
package sistembuku;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.property.StringProperty;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import sistemakademik.db.DBHandler;
import sistembuku.model.BukuProperty;

public class FXMLDataViewController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private TableView<BukuProperty> tblBuku;

    @FXML
    private TableColumn<BukuProperty, String> colId;

    @FXML
    private TableColumn<BukuProperty, String> colNama;

    @FXML
    private TableColumn<BukuProperty, String> colTglTerbit;

    @FXML
    private TableColumn<BukuProperty, String> colPenerbit;

    @FXML
    private TableColumn<BukuProperty, String> colJenis;

    @FXML
    private MenuItem menuAddData;

    @FXML
    private MenuItem menuDeleteData;

    @FXML
    void viewAddDataForm(ActionEvent event) throws IOException {
        Stage modal = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        Scene scene = new Scene(root);
        modal.setScene(scene);
//        modal.initOwner(((Node)event.getSource()).getScene().getWindow() );
        modal.initModality(Modality.APPLICATION_MODAL);
        modal.showAndWait();
    }

    @FXML
    void deleteDataBuku(ActionEvent event) {
        BukuProperty bk = tblBuku.getSelectionModel().getSelectedItem();
        DBHandler dh = new DBHandler("MYSQL");
        dh.deleteBuku(bk);
        showDataBuku();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        showDataBuku();

        tblBuku.getSelectionModel().selectedIndexProperty().addListener(listener -> {
//            JOptionPane.showMessageDialog(null, "Table Diklik!");
            menuDeleteData.setDisable(false);
        });
    }

    public void showDataBuku() {
        DBHandler dh = new DBHandler("MYSQL");
        ObservableList<BukuProperty> data = dh.getbuku();
        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colNama.setCellValueFactory(new PropertyValueFactory<>("nama"));
        colTglTerbit.setCellValueFactory(new PropertyValueFactory<>("tglterbit"));
        colPenerbit.setCellValueFactory(new PropertyValueFactory<>("penerbit"));
        colJenis.setCellValueFactory(new PropertyValueFactory<>("jenis"));
        tblBuku.setItems(null);
        tblBuku.setItems(data);
    }
}
