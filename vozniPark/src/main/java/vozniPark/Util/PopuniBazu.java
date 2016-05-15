package vozniPark.Util;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;
import vozniPark.Model.*;

import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.sql.Date;

import static vozniPark.Controller.LoginController.getSecurePassword;

/**
 * Created by ajdin on 5/13/16.
 */

public class PopuniBazu {

    private PopuniBazu() {}

    @SuppressWarnings("deprecation")
    public static void Izvrsi() {

        try {
            Session s = HibernateUtil.getSessionFactory().openSession();
            Transaction t = s.beginTransaction();
            if(s.createCriteria(Osoba.class).list().size() == 0) {
                DodajPodatke();
            }
        }
        catch (Exception e) {
            DodajPodatke();
        }
    }

    private static void DodajPodatke() {
        Session s = HibernateUtil.getSessionFactory().openSession();
        Transaction t = s.beginTransaction();

        Vozac voz = new Vozac();
        voz.setIme("Ajdin");
        voz.setPrezime("Mujezinovic");
        voz.setUsername("ajdinm");
        voz.setPassword(getSecurePassword("am"));
        voz.setAdresa("Ajdinova Adresa");
        voz.setBrojTelefona("062061063");
        voz.setBrojVozacke("448750067");

        s.save(voz);

        Vozac voz1 = new Vozac();
        voz1.setIme("Dino");
        voz1.setPrezime("Mehmedovic");
        voz1.setUsername("dinom");
        voz1.setPassword(getSecurePassword("dm"));
        voz1.setAdresa("Dinina Adresa");
        voz1.setBrojTelefona("062665577");
        voz1.setBrojVozacke("873255861");

        s.save(voz1);

        Vozac voz2 = new Vozac();
        voz2.setIme("Mirnes");
        voz2.setPrezime("Peljto");
        voz2.setUsername("mirnesp");
        voz2.setPassword(getSecurePassword("mp"));
        voz2.setAdresa("Mirnesova Adresa");
        voz2.setBrojTelefona("062555444");
        voz2.setBrojVozacke("389944752");

        s.save(voz2);

        Sef sef =  new Sef();
        sef.setIme("Armin");
        sef.setPrezime("Nogo");
        sef.setUsername("anogo");
        sef.setPassword(getSecurePassword("an"));
        sef.setAdresa("Arminova Adresa");
        sef.setBrojTelefona("062987123");

        s.save(sef);


        Servisi servis = new Servisi();
        servis.setCijena(850);
        servis.setDatumOdlaska(new Date(2016-1900, 4, 4));
        servis.setDatumVracanja(new Date(2016-1900, 5, 5));
        servis.setOpis("Generalni servis");
        servis.setServisiranoKod("Automehanicar Hasan");
        s.save(servis);

        TocenjeGoriva tocenje = new TocenjeGoriva();
        tocenje.setCijena(40);
        tocenje.setKolicina(30);
        s.save(tocenje);

        TocenjeGoriva tocenje1 = new TocenjeGoriva();
        tocenje1.setCijena(40);
        tocenje1.setKolicina(32);
        s.save(tocenje1);

        TocenjeGoriva tocenje2 = new TocenjeGoriva();
        tocenje2.setCijena(20);
        tocenje2.setKolicina(15);
        s.save(tocenje2);

        Vozilo vozilo = new Vozilo();
        vozilo.setBrojPredjenihKilometara(814);
        vozilo.setBrojSaobracajneDozvole("445566778");
        vozilo.setBrojVlasnickeDozvole("112233445");
        vozilo.setDatumZadnjegServisa(new Date(2015-1900, 7, 5));
        vozilo.setGodinaProizvodnje(2001);
        vozilo.setIntervalServisaKilometri(2000);
        vozilo.setIntervalServisaMjeseci(7);
        vozilo.setNaziv("Fiat Punto");
        vozilo.setOpis("Plavi Fiat Punto, dvoja vrata, benzinac");
        vozilo.setProizvodjac("Fiat");
        vozilo.setRegistracija("A45-Z-458");
        vozilo.setStatus("Slobodan");
        vozilo.setZadnjiServisKilometri(0);
        vozilo.setOsnovneKarakteristike("");
        vozilo.getListaServisa().add(servis);
        vozilo.getListaTocenja().add(tocenje);
        vozilo.getListaTocenja().add(tocenje1);
        vozilo.getListaTocenja().add(tocenje2);

        s.save(vozilo);


        Servisi servis2 = new Servisi();
        servis2.setCijena(145);
        servis2.setDatumOdlaska(new Date(2016-1900, 2, 2));
        servis2.setDatumVracanja(new Date(2016-1900, 2, 6));
        servis2.setOpis("Zamjena filtera");
        servis2.setServisiranoKod("Servisi Sarajevo");
        s.save(servis2);

        TocenjeGoriva tocenje3 = new TocenjeGoriva();
        tocenje3.setCijena(20);
        tocenje3.setKolicina(14);
        s.save(tocenje3);

        TocenjeGoriva tocenje4 = new TocenjeGoriva();
        tocenje4.setCijena(50);
        tocenje4.setKolicina(39);
        s.save(tocenje4);

        TocenjeGoriva tocenje5 = new TocenjeGoriva();
        tocenje5.setCijena(20);
        tocenje5.setKolicina(15);
        s.save(tocenje5);

        Vozilo vozilo2 = new Vozilo();
        vozilo2.setBrojPredjenihKilometara(310);
        vozilo2.setBrojSaobracajneDozvole("123123887");
        vozilo2.setBrojVlasnickeDozvole("987987555");
        vozilo2.setDatumZadnjegServisa(new Date(2015-1900, 9, 11));
        vozilo2.setGodinaProizvodnje(2010);
        vozilo2.setIntervalServisaKilometri(1000);
        vozilo2.setIntervalServisaMjeseci(12);
        vozilo2.setNaziv("Skoda Octavia");
        vozilo2.setOpis("Bijela Skoda Octavia, karavan, 4 vrata");
        vozilo2.setProizvodjac("Skoda");
        vozilo2.setRegistracija("M65-G-448");
        vozilo2.setStatus("Slobodan");
        vozilo2.setZadnjiServisKilometri(100);
        vozilo2.setOsnovneKarakteristike("");
        vozilo2.getListaServisa().add(servis2);
        vozilo2.getListaTocenja().add(tocenje3);
        vozilo2.getListaTocenja().add(tocenje4);
        vozilo2.getListaTocenja().add(tocenje5);

        s.save(vozilo2);

        Voznje voznja = new Voznje();

        voznja.setDatumPreuzimanja(new Date(2016-1900, 1, 1));
        voznja.setDatumVracanja(new Date(2016-1900, 1, 3));
        voznja.setOpisUpotrebe("Prevoz putnika");
        voznja.setPredjeniKilometri(259);
        voznja.setTocenje(tocenje4);
        voznja.setVozac(voz2);
        voznja.setVozilo(vozilo2);

        s.save(voznja);

        Voznje voznja1 = new Voznje();

        voznja1.setDatumPreuzimanja(new Date(2016-1900, 1, 7));
        voznja1.setDatumVracanja(new Date(2016-1900, 1, 7));
        voznja1.setOpisUpotrebe("Dostava cvijeca");
        voznja1.setPredjeniKilometri(70);
        voznja1.setTocenje(tocenje3);
        voznja1.setVozac(voz2);
        voznja1.setVozilo(vozilo2);

        s.save(voznja1);

        Voznje voznja2 = new Voznje();

        voznja2.setDatumPreuzimanja(new Date(2016-1900, 1, 11));
        voznja2.setDatumVracanja(new Date(2016-1900, 1, 11));
        voznja2.setOpisUpotrebe("Prevoz putnika");
        voznja2.setPredjeniKilometri(170);
        voznja2.setTocenje(tocenje1);
        voznja2.setVozac(voz);
        voznja2.setVozilo(vozilo);

        s.save(voznja1);

        t.commit();
    }
}
