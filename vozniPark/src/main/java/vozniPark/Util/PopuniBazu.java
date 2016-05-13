package vozniPark.Util;

import org.hibernate.Session;
import org.hibernate.Transaction;
import vozniPark.Model.Osoba;
import vozniPark.Model.Sef;
import vozniPark.Model.Vozac;

import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;

import static vozniPark.Controller.LoginController.getSecurePassword;

/**
 * Created by ajdin on 5/13/16.
 */

public class PopuniBazu {

    public static void DodajOsobe() {

        Session s = HibernateUtil.getSessionFactory().openSession();
        Transaction t = s.beginTransaction();
        Vozac o = new Vozac();
        o.setIme("Ajdin");
        o.setPrezime("Mujezinovic");
        o.setUsername("ajdinm");
        o.setPassword(getSecurePassword("am"));
        o.setAdresa("Ajdinova Adresa");
        s.save(o);

        Sef v =  new Sef();
        v.setIme("Armin");
        v.setPrezime("Nogo");
        v.setUsername("anogo");
        v.setPassword(getSecurePassword("an"));
        v.setAdresa("Arminova Adresa");

        s.save(v);
        t.commit();
    }
}
