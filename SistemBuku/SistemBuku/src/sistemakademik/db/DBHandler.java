
package sistemakademik.db;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import sistembuku.model.Buku;
import sistembuku.model.BukuProperty;

public class DBHandler {
    public final Connection conn;

    public DBHandler(String driver) {
        this.conn = DBHelper.getConnection(driver);
    }
    public void addBuku(Buku bk){
        String insertBk = "INSERT INTO `buku`(`id`, `nama`, `tgl_terbit`,`penerbit`,`jenis`)"
                + "VALUES (?,?,?,?,?)";
        try {
            PreparedStatement stmtInsert = conn.prepareStatement(insertBk);
            stmtInsert.setString(1, bk.getId());
            stmtInsert.setString(2, bk.getNama());
            stmtInsert.setString(3, bk.getTanggalterbit());
            stmtInsert.setString(4, bk.getPenerbit());
            stmtInsert.setString(5, bk.getJenis());
            stmtInsert.execute();
        } catch (SQLException ex) {
            Logger.getLogger(DBHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public ObservableList<BukuProperty> getbuku(){
        ObservableList<BukuProperty> data = FXCollections.observableArrayList();
        
        String sql = "SELECT id, nama, tgl_terbit, penerbit, jenis FROM `buku` ORDER BY id";
        
        try {
            ResultSet rs = conn.createStatement().executeQuery(sql);
            while (rs.next()){
                BukuProperty bk = new BukuProperty(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5));
                data.add(bk);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return data;
    }
    
    public void deleteBuku(BukuProperty bk){
        String deleteBk = "DELETE FROM buku WHERE `buku`.`id` = ?";
        try {
            PreparedStatement stmtDelete = conn.prepareStatement(deleteBk);
            stmtDelete.setString(1, bk.getid());
            stmtDelete.execute();
        } catch (SQLException ex) {
            Logger.getLogger(DBHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
