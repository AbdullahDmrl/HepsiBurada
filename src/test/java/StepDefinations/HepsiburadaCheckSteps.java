package StepDefinations;

import Pages.DialogContent;
import Utils.BaseDriver;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class HepsiburadaCheckSteps {

    DialogContent dc=new DialogContent();

    @Given("^Navigate to hepsiburada and check correct website$")
    public void navigateToHepsiburadaCheckCorrectWebsite() {
        WebDriver driver= BaseDriver.getDriver();
        driver.get("http://www.hepsiburada.com/");
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        dc.findAndContainsText("myAccountText","Giriş Yap");
    }

    @When("^Enter username and password and click login button$")
    public void enterUsernameAndPasswordAndClickLoginButton() {
        dc.findAndClick("myAccount");
        dc.findAndClick("girisYap");
        dc.findAndSend("emailAddress", "kaankan@yahoo.com");
        dc.findAndSend("password", "Burdur5429");
        dc.findAndClick("buttonLogin");
    }

    @Then("^User should login successfully$")
    public void userShouldLoginSuccessfully() {
        dc.findAndContainsText("myAccountText","Hesabım");
    }


    @When("^Enter an item name as \"([^\"]*)\" and check results$")
    public void enterAnItemNameAsAndCheckResults(String searchItem)  {
        dc.findAndSend("searchInput", searchItem);
        dc.findAndClick("searchBtn");
        dc.findAndContainsText("searchResultsText","samsung ile ilgili");
    }

    @And("^Like second page fifth cell phone$")
    public void likeCellPhoneSecondPageFifthItem() {
        dc.findAndClick("telefonBtn");
        dc.findAndClick("ceptelefonBtn");
        dc.findAndClick("secondPageBtn");
        dc.listWebelementsSelect("secondPagProdList",5);
        dc.findAndClick("begenButton");
    }

    @Then("^Added list Pupup message should be displayed$")
    public void pupupMessageShouldBeDisplayed() {
        dc.findAndContainsText("listeEklediPopup","Ürün listenize eklendi.");
    }


    @And("^Go to liked page and check selected item$")
    public void goToLikedPageAndCheckSelectedItem() {
        dc.findAndClick("myAccount");
        dc.findAndClick("begendiklerim");
        dc.listContainsWebElement("begendiklerimList",dc.fifthPhoneName);
        System.out.println("Besinci ürün= "+dc.fifthPhoneName);
    }

    @When("^Add selected item to basket$")
    public void addSelectedItemToBasket() {
        dc.findAndClick("secButton");
        dc.selectElementFromLists("begendiklerimList",dc.fifthPhoneName);
        dc.findAndClick("sepeteEkleButton");
    }

    @Then("^Added basket Pupup message should be displayed$")
    public void addedBasketPupupMessageShouldBeDisplayed() {
        dc.findAndContainsText("sepEkpopUpText","Ürün sepete eklendi");
    }

    @When("^Go to basket and delete selected item$")
    public void goToBasketAndDeleteSelectedItem() {
        dc.findAndClick("sepetimButton");
        dc.findAndDelElmntfromList("sepetProductNames",dc.kaldirGarbages, dc.fifthPhoneName);
        dc.findAndClick("kaldirButton");
        dc.findAndClick("silButton");
    }

    @Then("^Deleted Pupup message should be displayed$")
    public void deletedPupupMessageShouldBeDisplayed() {
        dc.findAndContainsText("SepSilPupupText","Ürün sepetinizden silinmiştir");

    }

    @And("^Go to liked page and delete selected item$")
    public void goToLikedPageAndDeleteSelectedItem() {
        dc.findAndClick("kaanBtn");
        dc.findAndClick("begendiklerimTitle");
        dc.findAndClick("secButton");
        dc.selectElementFromLists("begendiklerimList",dc.fifthPhoneName);
        dc.findAndClick("deleteBtn");
        dc.findAndClick("confirmDelBtn");


    }
}
