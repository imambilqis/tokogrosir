package com.toko.grosir.config;

import com.toko.grosir.dao.TokoGrosirDao;
import com.toko.grosir.dao.TokoGrosirImpl;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
    private static final SessionFactory SESSION_FACTORY;
    private static final TokoGrosirDao TOKOGROSIR_DAO;
    
    static{
        try{
            SESSION_FACTORY = new Configuration().configure().buildSessionFactory();
            TOKOGROSIR_DAO = new TokoGrosirImpl(SESSION_FACTORY);
        }catch(Throwable ex){
            System.err.println("Initial SessionFactory Creation Failed : "+ex);
            throw new ExceptionInInitializerError(ex);
        }
    }
    public static SessionFactory getSesssionFactory(){
        return SESSION_FACTORY;
    }
    public static TokoGrosirDao getTokoGrosirDao(){
        return TOKOGROSIR_DAO;
    }
    
}
