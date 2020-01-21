package Pages;

import org.openqa.selenium.By;


public class ContactCenterPage extends MainPage {

    private static By tckn_TxtBx= By.xpath("//input[@name='tckn']");
    private static By name_TxtBx= By.xpath("//input[@placeholder='Ad']");
    private static By save_Btn= By.xpath("//button[text()='Kaydet']");
    private static By messagePopUp_Txt= By.xpath("//simple-snack-bar/span");


    public ContactCenterPage tcknGir(String identityNo){

        try {

            clickElement(tckn_TxtBx);
            Thread.sleep(1000);
            sendKeysToElement(tckn_TxtBx,identityNo);
            reporter.Report_Info(identityNo+" TCKN olarak alana girilmistir.");

        }catch (Exception e){
            reporter.Report_Fail(e.getMessage());
        }
        return this;
    }

    public ContactCenterPage tcknAra(){
        pressEnter();
        checkPageIsReady();
        return this;
    }

    public ContactCenterPage adDegistir(){

        try {
            String name= randomAlphaNumeric(6)+ " "+ randomAlphaNumeric(4);
            waitElementWithThreadSleep(name_TxtBx,5);
            sendKeysToElement(name_TxtBx,name);
            reporter.Report_Info("Ad "+name+" olarak degistirilmistir.");

        }catch (Exception e){
            reporter.Report_Fail(e.getMessage());
        }
        return this;
    }

    public ContactCenterPage kaydetButonTikla(){

        try {
            waitElementWithThreadSleep(save_Btn,5);
            clickElement(save_Btn);
            reporter.Report_Info("Kaydet butonuna tiklanmistir.");

        }catch (Exception e){
            reporter.Report_Fail(e.getMessage());
        }
        return this;
    }


    public ContactCenterPage guncellemeMesajKontrol(){

        try {

            String message= "Kayıt yapılmıştır.";
            waitElementWithThreadSleep(messagePopUp_Txt,5);
            String getData= getData(messagePopUp_Txt);

            if (getData.contains(message)){
                reporter.Report_Pass("Guncelleme kaydedilmistir. Ekranda alinan Mesaj: "
                        +getData);
            }else{
                reporter.Report_Fail("Guncelleme kaydedilirken hata alinmistir! ");
            }

        }catch (Exception e){
            reporter.Report_Fail(e.getMessage());
        }
        return this;
    }









}
