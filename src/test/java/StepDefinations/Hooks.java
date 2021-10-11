package StepDefinations;



import Utils.BaseDriver;
import Utils.ExcelUtility;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Hooks {

    @Before // her senaryodan önce
    public void before(Scenario scenario)
    {
        System.out.println("seneryo basladi");
        System.out.println("Seneryo Id="+scenario.getId());
        System.out.println("Seneryo name="+scenario.getName());
    }

    @After // her senaryodan sonra
    public void after(Scenario scenario)
    {
        System.out.println("Seneryo bitti");
        System.out.println("Seneryo sonucu= "+scenario.getStatus());
        System.out.println("Scenario is failed = "+scenario.isFailed());

        LocalDateTime date=LocalDateTime.now();
        DateTimeFormatter formatter=DateTimeFormatter.ofPattern("dd.MM.yyyy");

        if (scenario.isFailed()){
            TakesScreenshot tss=(TakesScreenshot) BaseDriver.getDriver();           // ekran gör alma degiskeni tanimlandi
            File screenShots=tss.getScreenshotAs(OutputType.FILE);                 // file olarak hafizada olusturuldu

           try {
               FileUtils.copyFile(screenShots,new File("target/FailedScreenShots/"+scenario.getId()+date.format(formatter)+".png"));

               // kayit yeri gösterildi, hafızadaki ekranDosyasi nı al bunu verdiğim yola ve isme kaydet.
               // dosya adını zamana bağlı hale getirdi


           } catch (IOException e) {
               e.printStackTrace();
           }
        }
        ExcelUtility.writeExcel("src/test/java/ApachePOIReport/ScenarioStatus.xlsx",scenario,BaseDriver.getDriver().getTitle(), date.format(formatter));

       BaseDriver.DriverQuit();
    }

}
