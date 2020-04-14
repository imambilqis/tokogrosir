package com.toko.grosir.dao;
import com.toko.grosir.model.TokoGrosir;
import java.util.List;
//@author ImamBilQisthi
public interface TokoGrosirDao {
    public void save(TokoGrosir toko);
    public void delete(TokoGrosir toko);
    public void update(TokoGrosir toko);
    public TokoGrosir get(String kodebarang);
    public List<TokoGrosir> getList();
}
