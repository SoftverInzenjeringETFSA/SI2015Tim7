package vozniPark.Controller;

import junit.framework.TestCase;
import vozniPark.Model.Osoba;
import vozniPark.Model.Sef;

/**
 * Created by ajdin on 5/13/16.
 */
public class LoginControllerTest extends TestCase {

    public void testNeispravanLogin() {

        LoginController lg = new LoginController();

        boolean test = lg.login("nepostojeci", "nepostojeci123");

        assertEquals(false, test);
    }

    public void testNeispravanLoginKorisnik() {

        LoginController lg = new LoginController();
        lg.login("nepostojeci", "nepostojeci");

        Osoba test = lg.dajKorisnika();

        assertNull(null, test);
    }

    public void testIspravanLogin() {

        LoginController lg = new LoginController();

        boolean test = lg.login("ajdinm", "am");

        assertTrue(test);
    }

    public void testIspravanLoginKorisnik() {

        LoginController lg = new LoginController();
        lg.login("ajdinm", "am");
        Osoba o = lg.dajKorisnika();

        String test = lg.dajKorisnika().getUsername();

        assertTrue(test.equals("ajdinm"));
    }

    public void testIspravanLoginTip() {

        LoginController lg = new LoginController();
        lg.login("anogo", "an");
        Osoba o = lg.dajKorisnika();

        boolean test = lg.dajKorisnika() instanceof Sef;

        assertTrue(test);
    }
}
