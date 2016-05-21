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
        //PopuniBazu.Izvrsi();
    	
    	UnosNovogVozaca unv=new UnosNovogVozaca();
    	unv.main(null);
    	/*Login login = new Login();
    	login.main();*/
    }
}
