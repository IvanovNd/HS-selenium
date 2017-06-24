import HS.CardPO;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

/**
 * Created by Николай on 16.08.2016.
 */
public class MainTest {

    @Test
    public void testConfig() {
        SessionFactory sf = new Configuration().configure().buildSessionFactory();
        Session session = sf.openSession();
        session.beginTransaction();
        CardPO object = new CardPO();
        session.save(object);
        session.getTransaction().rollback();
        session.close();
    }
}