
package sistembuku.model;

public class Buku {
    private String id;
    private String nama;
    private String tanggalterbit;
    private String penerbit;
    private String jenis;

    public Buku(String id, String nama, String tanggalterbit, String penerbit, String jenis) {
        this.id = id;
        this.nama = nama;
        this.tanggalterbit = tanggalterbit;
        this.penerbit = penerbit;
        this.jenis = jenis;
    }
    

    public void setjenis(String jenis) {
        this.jenis = jenis;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getTanggalterbit() {
        return tanggalterbit;
    }

    public void setTanggalterbit(String tanggalterbit) {
        this.tanggalterbit = tanggalterbit;
    }

    public void setpenerbit(String penerbit) {
        this.penerbit = penerbit;
    }

    public String getJenis() {
        return jenis;
    }

    public String getPenerbit() {
        return penerbit;
    }
    
}
