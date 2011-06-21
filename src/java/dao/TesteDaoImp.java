package dao;

import model.Teste;
import utils.HibernateUtil;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author José Alexandre
 */
public class TesteDaoImp implements TesteDao {

    public void save(Teste teste) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        session.save(teste);
        t.commit();
    }
    public Teste getTeste(long id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        return (Teste) session.load(Teste.class, id);
    }
    public List<Teste> list() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        List lista = session.createQuery("from Teste").list();
        t.commit();
        return lista;
    }
    public void remove(Teste teste) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        session.delete(teste);
        t.commit();
    }
    public void update(Teste teste) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        session.update(teste);
        t.commit();
    }
}
