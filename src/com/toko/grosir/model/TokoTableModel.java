package com.toko.grosir.model;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class TokoTableModel extends AbstractTableModel {
private List<TokoGrosir> listTokoGrosir = new ArrayList();
    private final String HEADER[]={"Kode","Nama Barang","Jenis","Harga"};
    
    public TokoTableModel(List<TokoGrosir> listTokoGrosir){
        this.listTokoGrosir = listTokoGrosir;
    }
    @Override
    public int getRowCount() {
         return listTokoGrosir.size();
    }

    @Override
    public int getColumnCount() {
        return HEADER.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
       TokoGrosir toko = listTokoGrosir.get(rowIndex);
       
       switch (columnIndex){
           case 0:
               return toko.getKodebarang();
           case 1:
               return toko.getNama();
           case 2:
               return toko.getJenis();
           case 3:
               return toko.getHarga();
           default:
               return null;
       }}
    @Override
    public String getColumnName(int index){
        return HEADER[index];
    }
    
}
