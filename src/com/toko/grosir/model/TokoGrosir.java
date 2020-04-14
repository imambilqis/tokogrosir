package com.toko.grosir.model;
//@author ImamBilQisthi
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name="tb_toko")
public class TokoGrosir implements Serializable {
    @Id
    @Column (name="kodebarang",length=5)
    private String kodebarang;
    @Column (name="nama",length=20)
    private String nama;
    @Column (name="jenis",length=10)
    private String jenis;
    @Column (name="harga")
    private int harga;

    /**
     * @return the kodebarang
     */
    public String getKodebarang() {
        return kodebarang;
    }

    /**
     * @param kodebarang the kodebarang to set
     */
    public void setKodebarang(String kodebarang) {
        this.kodebarang = kodebarang;
    }

    /**
     * @return the nama
     */
    public String getNama() {
        return nama;
    }

    /**
     * @param nama the nama to set
     */
    public void setNama(String nama) {
        this.nama = nama;
    }

    /**
     * @return the jenis
     */
    public String getJenis() {
        return jenis;
    }

    /**
     * @param jenis the jenis to set
     */
    public void setJenis(String jenis) {
        this.jenis = jenis;
    }
    /**
     * @return the harga
     */
    public int getHarga() {
        return harga;
    }

    /**
     * @param harga the harga to set
     */
    public void setHarga(int harga) {
        this.harga = harga;
    }
    
}

