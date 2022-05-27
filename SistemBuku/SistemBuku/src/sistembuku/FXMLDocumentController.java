
package sistembuku;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import sistemakademik.db.DBHandler;
import sistembuku.model.Buku;

public class FXMLDocumentController implements Initializable {
    
     @FXML
    private Button btnSave;

    @FXML
    private ComboBox<?> cbjenis;

    @FXML
    private DatePicker dpTanggalTerbit;

    @FXML
    private ToggleGroup penerbit;

    @FXML
    private Label label;

    @FXML
    private RadioButton rdErlangga;

    @FXML
    private RadioButton rdYudistira;

    @FXML
    private TextField tfid;

    @FXML
    private TextField tfNama;

    
    @FXML
    private void handleButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
//        label.setText("Hello "+tfNama.getText());
        System.out.println(tfid.getText());
        System.out.println(tfNama.getText());
        System.out.println(dpTanggalTerbit.getValue().toString());
        String Penerbit="";
        if (rdErlangga.isSelected())
           Penerbit=rdErlangga.getText();
        if (rdYudistira.isSelected())
           Penerbit=rdYudistira.getText();
        
        System.out.println(Penerbit);
        System.out.println(cbjenis.getValue().toString());
//        Buku(String npm, String nama, String tanggalLahir, String gender, String prodi)
        Buku bk = new Buku(tfid.getText(),tfNama.getText(),dpTanggalTerbit.getValue().toString(),
            Penerbit,cbjenis.getValue().toString());
        DBHandler dh = new DBHandler("MYSQL");
        dh.addBuku(bk);
        FXMLDataViewController view = new FXMLDataViewController();
        view.showDataBuku();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        // TODO
        ArrayList <String> list = new ArrayList<String>();
        list.add("Fiksi");
        list.add("Non Fiksi");
        ObservableList items = FXCollections.observableArrayList(list);
        cbjenis.setItems(items);
    }    
    
}
