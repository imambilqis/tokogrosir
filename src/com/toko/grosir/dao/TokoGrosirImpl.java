package com.toko.grosir.dao;
import com.toko.grosir.model.TokoGrosir;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
//@author ImamBilQisthi
public class TokoGrosirImpl implements TokoGrosirDao{
    private final SessionFactory sessionFactory;
    public TokoGrosirImpl(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }
    @Override
    public void save(TokoGrosir toko) {
       Session session = sessionFactory.openSession();
            try{
                session.beginTransaction();
                session.save(toko);
                session.getTransaction().commit();
            }catch(Exception ex){
                System.err.print("Tidak Bisa Menyimpan Barang");
                session.getTransaction().rollback();
            }finally{
                session.close();
            }
    }
    @Override
    public void delete(TokoGrosir toko) {
        Session session = sessionFactory.openSession();
            try{
                session.beginTransaction();
                session.delete(toko);
                session.getTransaction().commit();
            }catch(Exception ex){
                System.err.print("Tidak Bisa Menghapus Barang");
                session.getTransaction().rollback();
            }finally{
                session.close();
            } 
    }
    @Override
    public void update(TokoGrosir toko) {
        Session session = sessionFactory.openSession();
            try{
                session.beginTransaction();
                session.update(toko);
                session.getTransaction().commit();
            }catch(Exception ex){
                System.err.print("Tidak Bisa Mengubah Barang");
                session.getTransaction().rollback();
            }finally{
                session.close();
            } 
    }
    @Override
    public TokoGrosir get(String kodebarang) {
        Session session = sessionFactory.openSession();
            try{
                session.beginTransaction();
                TokoGrosir toko=(TokoGrosir) session.get(TokoGrosir.class,kodebarang);
                session.getTransaction().commit();
                return toko;
            }catch(Exception ex){
                System.err.print("Tidak Bisa Menampilkan Barang"+ex);
                session.getTransaction().rollback();
                return null;
            }finally{
                session.close();
            } 
    }
    @Override
    public List<TokoGrosir> getList() {
        Session session = sessionFactory.openSession();
            try{
                session.beginTransaction();
                List<TokoGrosir> listbarang  = session.createCriteria(TokoGrosir.class).list();
                session.getTransaction().commit();
                return listbarang;
            }catch(Exception ex){
                System.err.print("Tidak Bisa Menampilkan List Barang"+ex);
                session.getTransaction().rollback();
                return null;
            }finally{
                session.close();
            } 
    }
}