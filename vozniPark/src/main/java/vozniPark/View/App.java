package vozniPark.View;

import org.hibernate.Session;
import org.hibernate.Transaction;

import vozniPark.Model.Sef;
import vozniPark.Util.HibernateUtil;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        //System.out.println( "Hello World!" );
    	Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        Sef s = new Sef();
        s.setAdresa("Hamdije");
        s.setBrojTelefona("062");
        s.setIme("Armin");
        s.setPassword("meho");
        s.setPrezime("Nogo");
        s.setUsername("anogo1");
        session.save(s);
        t.commit();
        
        session.close();
    }
}
