package vozniPark.Controller;

/**
 * Created by ajdin on 5/13/16.
 */

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Session;

import org.hibernate.criterion.Restrictions;
import vozniPark.Model.Osoba;
import vozniPark.Util.HibernateUtil;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

@SuppressWarnings("ALL")
public class LoginController {

    private static final Logger logger = Logger.getLogger(LoginController.class);

    private Osoba korisnik;

    public LoginController () {
        korisnik = null;
    }

    public Osoba dajKorisnika() {
        return korisnik;
    }


    public boolean login(final String username, String password) {

        Session session = HibernateUtil.getSessionFactory().openSession();

        Criteria c  = session.createCriteria(Osoba.class);
        c.add(Restrictions.eq("username", username));
        List<Osoba> osobe = (List<Osoba>) c.list();

        if(osobe.size() == 1 && osobe.get(0).getPassword().equals(LoginController.getSecurePassword(password))) {
            korisnik = osobe.get(0);
            return true;
        }
        else {
            korisnik = null;
            return false;
        }


    }

    public static String getSecurePassword(String passwordToHash)
    {
        String generatedPassword = null;
        try {
            // Create MessageDigest instance for MD5
            MessageDigest md = MessageDigest.getInstance("MD5");
            //Add password bytes to digest
            byte[] bytes = md.digest(passwordToHash.getBytes());
            //This bytes[] has bytes in decimal format
            //Convert it to hexadecimal format
            StringBuilder sb = new StringBuilder();
            for(int i=0; i< bytes.length ;i++)
            {
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }
            //Get complete hashed password in hex format
            generatedPassword = sb.toString();
        }
        catch (NoSuchAlgorithmException e) {
            logger.info(e);
        }
        return generatedPassword;
    }
}
