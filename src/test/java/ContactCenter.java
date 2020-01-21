import BaseFiles.TestBase;
import Pages.ContactCenterPage;
import Pages.MainPage;
import org.testng.annotations.Test;

public class ContactCenter extends TestBase {

    @Test
    public void ContactCenter(){
        MainPage mainPage= new MainPage();
        ContactCenterPage contactCenterPage= new ContactCenterPage();

        String tckn="11112222";

        mainPage.openMainPage()
                .contactCenterMenuSec();
        contactCenterPage.tcknGir(tckn)
                          .tcknAra()
                          .adDegistir()
                          .kaydetButonTikla()
                          .guncellemeMesajKontrol();
    }

}
