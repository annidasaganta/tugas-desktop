
package sistembuku.model;


import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class BukuProperty {
    private StringProperty id;
    private StringProperty nama;
    private StringProperty tanggalterbit;
    private StringProperty penerbit;
    private StringProperty jenis;

    public BukuProperty(String id, String  nama, String tanggalterbit, String penerbit, String jenis) {
        this.id = new SimpleStringProperty(id);
        this.nama = new SimpleStringProperty(nama);
        this.tanggalterbit = new SimpleStringProperty(tanggalterbit);
        this.penerbit = new SimpleStringProperty(penerbit);
        this.jenis = new SimpleStringProperty(jenis);
    }
    public BukuProperty(Buku bk){
        this.id = new SimpleStringProperty(bk.getId());
        this.nama = new SimpleStringProperty(bk.getNama());
        this.tanggalterbit = new SimpleStringProperty(bk.getTanggalterbit());
        this.penerbit = new SimpleStringProperty(bk.getPenerbit());
        this.jenis = new SimpleStringProperty(bk.getJenis());
    }
    public StringProperty getjenisProperty() {
        return jenis;
    }

    public void setjenis(String jenis) {
        this.jenis = new SimpleStringProperty(jenis);
    }

    public StringProperty getidProperty() {
        return id;
    }

    public void setid(String id) {
        this.id = new SimpleStringProperty(id);
    }

    public StringProperty getNamaProperty() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = new SimpleStringProperty(nama);
    }

    public StringProperty getTanggalterbitProperty() {
        return tanggalterbit;
    }

    public void setTanggalterbit(String tanggalterbit) {
        this.tanggalterbit = new SimpleStringProperty(tanggalterbit);
    }

    public StringProperty getpenerbitProperty() {
        return penerbit;
    }

    public void setPenerbit(String penerbit) {
        this.penerbit = new SimpleStringProperty(penerbit);
    }

    public String getid() {
        return id.get();
    }

    public String getNama() {
        return nama.get();
    }

    public String getTanggalterbit() {
        return tanggalterbit.get();
    }

    public String getpenerbit() {
        return penerbit.get();
    }

    public String getjenis() {
        return jenis.get();
    }
    
}
