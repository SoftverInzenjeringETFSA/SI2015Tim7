package vozniPark.View;

import vozniPark.Controller.LoginController;
import vozniPark.Util.PopuniBazu;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	//napraviti bazu tim_7 bez tabela, pa pokrenuti sljedecu liniju koda
    	//samo jednom izvrsiti da se formiraju tabele i popuni baza podataka
        //PopuniBazu.Izvrsi();
    	/*primjer unosa odredjenog objekta u bazu
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
        
        session.close();*/
    	
    	Login login = new Login();
    	login.main();
    	//OdjavljivanjePreuzetogVozila odjava = new OdjavljivanjePreuzetogVozila();
    	//odjava.main(null);
    	//VozacHomePage vhp = new VozacHomePage();
    	//vhp.main(null);
    }
}
