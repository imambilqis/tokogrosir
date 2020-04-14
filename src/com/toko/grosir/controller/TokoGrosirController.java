package com.toko.grosir.controller;
import com.toko.grosir.config.HibernateUtil;
import com.toko.grosir.dao.TokoGrosirDao;
import com.toko.grosir.model.TokoGrosir;
import com.toko.grosir.model.TokoTableModel;
import com.toko.grosir.view.TokoGrosirTamp;
import java.util.List;
import javax.swing.JOptionPane;
// @author Imam Bil Qisthi

public class TokoGrosirController {
    private final TokoGrosirTamp tokoGrosirTamp;
    private List<TokoGrosir> listTokoGrosir;
    private TokoTableModel tokoTableModel;
    private final TokoGrosirDao tokoGrosirDao = HibernateUtil.getTokoGrosirDao();
    
    public TokoGrosirController(TokoGrosirTamp tokoGrosirTamp){
        this.tokoGrosirTamp = tokoGrosirTamp;
    }
    public void getAllData(){
        listTokoGrosir = tokoGrosirDao.getList();
        tokoTableModel = new TokoTableModel(listTokoGrosir);
        this.tokoGrosirTamp.getTblToko().setModel(tokoTableModel);
    }
    public void saveToko(){
        TokoGrosir toko= new TokoGrosir();
        
        toko.setKodebarang(this.tokoGrosirTamp.getTxtKode().getText());
        toko.setNama(this.tokoGrosirTamp.getTxtNama().getText());
        toko.setJenis(this.tokoGrosirTamp.getTxtJenis().getText());
        toko.setHarga(Integer.parseInt(this.tokoGrosirTamp.getTxtHarga().getText()));
        
        try{
            tokoGrosirDao.save(toko);
            JOptionPane.showMessageDialog(null,"Berhasil Menyimpan Data Barang","Succes",JOptionPane.INFORMATION_MESSAGE);
            clear();
            getAllData();
        }catch(Exception ex){
             JOptionPane.showMessageDialog(null,"Gagal Menyimpan Data Barang","Error",JOptionPane.ERROR_MESSAGE);
             clear();
        } 
    }
    public void updateToko(){
        TokoGrosir toko= new TokoGrosir();
        
        toko.setKodebarang(this.tokoGrosirTamp.getTxtKode().getText());
        toko.setNama(this.tokoGrosirTamp.getTxtNama().getText());
        toko.setJenis(this.tokoGrosirTamp.getTxtJenis().getText());
        toko.setHarga(Integer.parseInt(this.tokoGrosirTamp.getTxtHarga().getText()));
        
        try{
            tokoGrosirDao.update(toko);
            JOptionPane.showMessageDialog(null,"Berhasil Mengubah Data Barang","Succes",JOptionPane.INFORMATION_MESSAGE);
            clear();
            getAllData();
        }catch(Exception ex){
             JOptionPane.showMessageDialog(null,"Gagal Mengubah Data Barang","Error",JOptionPane.ERROR_MESSAGE);
             clear();
        }
    }
    public void deleteToko(){
        if(this.tokoGrosirTamp.getTxtKode().getText()== null){
            JOptionPane.showMessageDialog(null,"Pilih Terlebih Dahulu Data Yang Akan Dihapus","Error",JOptionPane.ERROR_MESSAGE);
        }else{
            TokoGrosir toko = new TokoGrosir();
            toko.setKodebarang(this.tokoGrosirTamp.getTxtKode().getText());
            int option =  JOptionPane.showConfirmDialog(null,"Data Akan Dihapus , Apakah Anda Yakin ?","Warning",
                    JOptionPane.YES_OPTION,JOptionPane.WARNING_MESSAGE);
            if(option == JOptionPane.YES_OPTION){
                try{
                    tokoGrosirDao.delete(toko);
                    JOptionPane.showMessageDialog(null,"Berhasil Menghapus Data Barang","Succes",JOptionPane.INFORMATION_MESSAGE);
                    clear();
                    getAllData();
                }catch(Exception ex){
                    JOptionPane.showMessageDialog(null,"Gagal Menghapus Data Barang","Error",JOptionPane.ERROR_MESSAGE);
                    clear();
                }
            }
        }
    }
    public void clear() {
        this.tokoGrosirTamp.getTxtKode().setText("");
        this.tokoGrosirTamp.getTxtNama().setText("");
        this.tokoGrosirTamp.getTxtJenis().setText("");
        this.tokoGrosirTamp.getTxtHarga().setText("");
    }
    public void getData(){
        int rowIndex = this.tokoGrosirTamp.getTblToko().getSelectedRow();
        this.tokoGrosirTamp.getTxtKode().setText(String.valueOf(this.tokoGrosirTamp.getTblToko().getValueAt(rowIndex, 0)));
        this.tokoGrosirTamp.getTxtNama().setText(String.valueOf(this.tokoGrosirTamp.getTblToko().getValueAt(rowIndex, 1)));
        this.tokoGrosirTamp.getTxtJenis().setText(String.valueOf(this.tokoGrosirTamp.getTblToko().getValueAt(rowIndex, 2)));
        this.tokoGrosirTamp.getTxtHarga().setText(String.valueOf(this.tokoGrosirTamp.getTblToko().getValueAt(rowIndex, 3)));
    }
    
}
