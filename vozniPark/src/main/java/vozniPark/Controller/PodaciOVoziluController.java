package vozniPark.Controller;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import vozniPark.Model.Vozilo;
import vozniPark.Util.HibernateUtil;

public class PodaciOVoziluController {

	@SuppressWarnings("unchecked")
	public Vozilo nadjiVoziloPoReg(String registracija) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		List<Vozilo> lista = session.createCriteria(Vozilo.class).add(Restrictions.like("registracija", registracija)).list();
		return lista.get(0);
	}
}
