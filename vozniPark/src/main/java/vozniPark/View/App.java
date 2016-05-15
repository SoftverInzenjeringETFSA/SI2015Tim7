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
    	//napraviti bazu tim_7 bez tabela, pa pokrenuti kod
        PopuniBazu.Izvrsi();
    	
    	Login login = new Login();
    	login.main();
    }
}
